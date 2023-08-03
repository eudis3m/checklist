package br.com.patio.projeto.business.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.ParameterizedType;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.ZipOutputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.sf.jasperreports.engine.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.patio.projeto.business.email.RelatorioEmail;
import br.com.patio.projeto.business.imagem.CarregaImagem;
import br.com.patio.projeto.business.pasta.Compactador;
import br.com.patio.projeto.business.pasta.GeraPasta;
import br.com.patio.projeto.data.repository.CheckListAutomovelRepository;
import br.com.patio.projeto.data.repository.RetiraVeiculoRepository;
import br.com.patio.projeto.dto.CheckListAutomovelTabelaDTO;
import br.com.patio.projeto.dto.FileDto;
import br.com.patio.projeto.entity.CheckListAutomovelEntity;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;
import br.com.patio.projeto.exceptionhandlers.exceptions.EmptyElementException;
import br.com.patio.projeto.exceptionhandlers.exceptions.NotFoundElementException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;
import net.sf.jasperreports.view.JasperViewer;


@Service
@Transactional
public  class  CheckListAutomovelService {


	
	@Autowired
	private CheckListAutomovelRepository  checklistRepository;
	
	@Autowired
	private RetiraVeiculoRepository  retiraveiculoRepository;
	
	@Autowired
	private RelatorioEmail relatorioemail;
	

	@Autowired
	private GeraPasta gerapasta;
	
	 @Autowired
	 private Compactador compactador;
	
	 @Autowired
	 private ResourceLoader resourceLoader;
	 
	 @Autowired
	 private CarregaImagem  carregaimagem;

	//protected abstract T validateEntity(T obj) throws Exception;
	
	protected Boolean checkNullabilityOfTheEntityAndId(CheckListAutomovelEntity obj) {
		return obj != null && obj.getOid() != null && obj.getOid().longValue() > 0L;
	}
	
	protected Boolean checkNullabilityOfId(Long oid) {
		return oid != null && oid.longValue() > 0L;
	}
	@SuppressWarnings("unchecked")
	protected String getGenericName()
    {
        return ((Class<CheckListAutomovelEntity>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
    }

	
  
	public File findByPlacaAndEmail(String placa, String email) throws JRException, SQLException, IOException {
		        CheckListAutomovelEntity resultemail = checklistRepository.findByPlaca(placa);
		       // FTPClient connect = gerapasta.fTPClient();
		        
		try {	    
			 if(resultemail.getCaminhao() != "Sim") {
			    String path =  gerapasta.Pasta(resultemail.getEmpresa(), resultemail.getVeiculo(), placa);
		        List<CheckListAutomovelEntity> resultchecklist = checklistRepository.findByList(placa);
		        List<RetiraVeiculoEntity> resulttermo = retiraveiculoRepository.findByRetiraVeiculo(placa);
		        if(resulttermo != null) {
                Map<String, Object> parameters = new HashMap<>();
                 parameters.put("$P{Placa}", placa);
               JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
               JRBeanCollectionDataSource datatermo = new JRBeanCollectionDataSource(resulttermo);
               String checklist = resourceLoader.getResource("classpath:CheckListAutomovel.jrxml").getURI().getPath();
                String termo = resourceLoader.getResource("classpath:Termo_automovel.jrxml").getURI().getPath();
               JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
                JasperReport jasperTermo = JasperCompileManager.compileReport(termo);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
                JRPrintPage paginasGerada =  JasperFillManager.fillReport(jasperTermo, 
                		parameters,datatermo).getPages().get(0);
            	JasperExportManager.exportReportToPdfFile(jasperPrint,
            			path+"/CheckListAutomovel.pdf");
			 String pdfExport = path+"/CheckListAutomovel.pdf";
   	        File inputStream = new File(pdfExport);


   	    	relatorioemail.sendSimpleMessage(email,pdfExport, resultemail.getPlaca());
   	    	FileDto pdf = new FileDto();
   	    	pdf.setDownload(pdfExport);
	       
		       return inputStream;}
		   else {
		        	 Map<String, Object> parameters = new HashMap<>();
	                 parameters.put("$P{Placa}", placa);
	               JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
	               String checklist = resourceLoader.getResource("classpath:CheckListAutomovel.jrxml").getURI().getPath();
	                String termo = resourceLoader.getResource("classpath:Termo_automovel.jrxml").getURI().getPath();
	               JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
	                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
	            	JasperExportManager.exportReportToPdfFile(jasperPrint,
	            			path+"/CheckListAutomovel.pdf");
				 String pdfExport = path+"/CheckListAutomovel.pdf";
					File inputStream = new File(pdfExport);
					relatorioemail.sendSimpleMessage(email,pdfExport, resultemail.getPlaca());
					FileDto pdf = new FileDto();
					pdf.setDownload(pdfExport);

					return inputStream;
		        }
			 }
			 else {
				 String path =  gerapasta.Pasta(resultemail.getEmpresa(), resultemail.getVeiculo(), placa);
			        List<CheckListAutomovelEntity> resultchecklist = checklistRepository.findByList(placa);
			        List<RetiraVeiculoEntity> resulttermo = retiraveiculoRepository.findByRetiraVeiculo(placa);
			        if(resulttermo != null) {
	                Map<String, Object> parameters = new HashMap<>();
	                 parameters.put("$P{Placa}", placa);
	               JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
	               JRBeanCollectionDataSource datatermo = new JRBeanCollectionDataSource(resulttermo);
	               String checklist = resourceLoader.getResource("classpath:CheckListCaminhao.jrxml").getURI().getPath();
	                String termo = resourceLoader.getResource("classpath:Termo_caminhao.jrxml").getURI().getPath();
	               JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
	                JasperReport jasperTermo = JasperCompileManager.compileReport(termo);	 
	                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
	                JRPrintPage paginasGerada =  JasperFillManager.fillReport(jasperTermo, 
	                		parameters,datatermo).getPages().get(0);
	    	        	 jasperPrint.addPage(1,paginasGerada );
					JasperExportManager.exportReportToPdfFile(jasperPrint,
							path+"/CheckListAutomovel.pdf");
				    String pdfExport = path+"/CheckListAutomovel.pdf";
						File inputStream = new File(pdfExport);
						relatorioemail.sendSimpleMessage(email,pdfExport, resultemail.getPlaca());
						FileDto pdf = new FileDto();
						pdf.setDownload(pdfExport);

						return inputStream;}
			        else {
			        	Map<String, Object> parameters = new HashMap<>();
		                 parameters.put("$P{Placa}", placa);
		               JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
		               JRBeanCollectionDataSource datatermo = new JRBeanCollectionDataSource(resulttermo);
		               String checklist = resourceLoader.getResource("classpath:CheckListCaminhao.jrxml").getURI().getPath();
		                String termo = resourceLoader.getResource("classpath:Termo_caminhao.jrxml").getURI().getPath();
		               JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
		                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);	                
						JasperExportManager.exportReportToPdfFile(jasperPrint,
								path+"/CheckListAutomovel.pdf");
					    String pdfExport = path+"/CheckListAutomovel.pdf";
						File inputStream = new File(pdfExport);
						relatorioemail.sendSimpleMessage(email,pdfExport, resultemail.getPlaca());
						FileDto pdf = new FileDto();
						pdf.setDownload(pdfExport);

						return inputStream;
			        	
			        }
			 }
	     } catch (Exception e) {
		       // TODO Auto-generated catch block
		      e.printStackTrace();
	         }
     return null;
	}
	
	public File findByPlaca(String placa) throws JRException, SQLException, IOException {
        CheckListAutomovelEntity resultemail = checklistRepository.findByPlaca(placa);
        //FTPClient connect = gerapasta.fTPClient();
try {	    
	 if(resultemail.getCaminhao() != "Sim") {
	    String path =  gerapasta.Pasta(resultemail.getEmpresa(), resultemail.getVeiculo(), placa);
        List<CheckListAutomovelEntity> resultchecklist = checklistRepository.findByList(placa);
        List<RetiraVeiculoEntity> resulttermo = retiraveiculoRepository.findByRetiraVeiculo(placa);
        if(resulttermo != null) {
        Map<String, Object> parameters = new HashMap<>();
         parameters.put("$P{Placa}", placa);
       JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
       JRBeanCollectionDataSource datatermo = new JRBeanCollectionDataSource(resulttermo);
       String checklist = resourceLoader.getResource("classpath:CheckListAutomovel.jrxml").getURI().getPath();
        String termo = resourceLoader.getResource("classpath:Termo_automovel.jrxml").getURI().getPath();
       JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
        JasperReport jasperTermo = JasperCompileManager.compileReport(termo);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
        JRPrintPage paginasGerada =  JasperFillManager.fillReport(jasperTermo, 
        		parameters,datatermo).getPages().get(0);
        	 jasperPrint.addPage(1,paginasGerada );
        		JasperExportManager.exportReportToPdfFile(jasperPrint,
        				path+"/CheckListAutomovel.pdf");
			 String pdfExport = path+"/CheckListAutomovel.pdf";
			File inputStream = new File(pdfExport);
			FileDto pdf = new FileDto();
			pdf.setDownload(pdfExport);

			return inputStream;
	     }
        else {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("$P{Placa}", placa);
          JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
          JRBeanCollectionDataSource datatermo = new JRBeanCollectionDataSource(resulttermo);
          String checklist = resourceLoader.getResource("classpath:CheckListAutomovel.jrxml").getURI().getPath();
           String termo = resourceLoader.getResource("classpath:Termo_automovel.jrxml").getURI().getPath();
          JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
           JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
           		JasperExportManager.exportReportToPdfFile(jasperPrint,
           				path+"/CheckListAutomovel.pdf");
   			 String pdfExport = path+"/CheckListAutomovel.pdf";
			File inputStream = new File(pdfExport);
			FileDto pdf = new FileDto();
			pdf.setDownload(pdfExport);

			return inputStream;
        	
        }
	 }
	 else {
		 String path =  gerapasta.Pasta(resultemail.getEmpresa(), resultemail.getVeiculo(), placa);
	        List<CheckListAutomovelEntity> resultchecklist = checklistRepository.findByList(placa);
	        List<RetiraVeiculoEntity> resulttermo = retiraveiculoRepository.findByRetiraVeiculo(placa);
	        if(resulttermo != null) {
	        Map<String, Object> parameters = new HashMap<>();
	         parameters.put("$P{Placa}", placa);
	       JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
	       JRBeanCollectionDataSource datatermo = new JRBeanCollectionDataSource(resulttermo);
	       String checklist = resourceLoader.getResource("classpath:CheckListCaminhao.jrxml").getURI().getPath();
	        String termo = resourceLoader.getResource("classpath:Termo_caminhao.jrxml").getURI().getPath();
	       JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
	        JasperReport jasperTermo = JasperCompileManager.compileReport(termo);
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
	        JRPrintPage paginasGerada =  JasperFillManager.fillReport(jasperTermo, 
	        		parameters,datatermo).getPages().get(0);
	        	 jasperPrint.addPage(1,paginasGerada );
	        		JasperExportManager.exportReportToPdfFile(jasperPrint,
	        				path+"/CheckListAutomovel.pdf" );
				 String pdfExport = path+"/CheckListAutomovel.pdf";

				File inputStream = new File(pdfExport);
				FileDto pdf = new FileDto();
				pdf.setDownload(pdfExport);

				return inputStream;}
	        else {
	        	  Map<String, Object> parameters = new HashMap<>();
	 	         parameters.put("$P{Placa}", placa);
	 	       JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
	 	       JRBeanCollectionDataSource datatermo = new JRBeanCollectionDataSource(resulttermo);
	 	       String checklist = resourceLoader.getResource("classpath:CheckListCaminhao.jrxml").getURI().getPath();
	 	       JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
	 	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
	 	        		JasperExportManager.exportReportToPdfFile(jasperPrint,
	 	        				path+"/CheckListAutomovel.pdf" );
	 				 String pdfExport = path+"/CheckListAutomovel.pdf";
				File inputStream = new File(pdfExport);
				FileDto pdf = new FileDto();
				pdf.setDownload(pdfExport);

				return inputStream;
	        	
	        }
	 }
 } catch (Exception e) {
       // TODO Auto-generated catch block
      e.printStackTrace();
     }
return null;
}
	
	//@Override
	public CheckListAutomovelEntity findById(Long oid) throws Exception {
		if(checkNullabilityOfId(oid)) {
			Optional<CheckListAutomovelEntity> obj = checklistRepository.findById(oid);
			return obj.orElseThrow(() -> new NotFoundElementException(getGenericName() + " com identificador único = " + oid + " não encontrado! "));
			//return obj;
		}
		//throw new NotFoundException(getGenericName() + " com identificador único = " + id + " não encontrado! ");
		throw new NotFoundElementException(getGenericName() + " com identificador único = " + oid + " não encontrado! ");
	}
	
	/*@Override
	public CheckListAutomovelEntity create(CheckListAutomovelEntity obj, byte[] foto,
			byte[] foto_2, byte[] foto_3, byte[] foto_4, byte[] foto_5) throws Exception {
		if(obj != null) {
			//obj.setOid(null);
            //obj = prepareAudit(obj);
			carregaimagem.ReadImageAsByteArray(foto,  foto_2,
					foto_3,foto_4, foto_5,obj.getEmpresa(), obj.getVeiculo(), obj.getPlaca());
			CheckListAutomovelEntity resultSave = checklistRepository.save(obj);
			return resultSave;
		}
		throw new EmptyElementException(getGenericName() + " não pode ser inserido se vazio.");
	}*/
    

	/*public CheckListAutomovelEntity create(CheckListAutomovelEntity obj,
			String foto, String foto_2, String foto_3, String foto_4, String foto_5, String foto_6
			   , String foto_7, String foto_8) throws Exception {*/
		public CheckListAutomovelEntity create(CheckListAutomovelEntity obj
				)throws Exception {
		// CheckListAutomovelEntity placa =  checklistRepository.findByPlaca(obj.getPlaca());
		if(obj != null) {
			carregaimagem.ReadImageAsByteArray(obj.getFoto(), obj.getFoto_2(),
					obj.getFoto_3(), obj.getFoto_4(), obj.getFoto_5(),
					 obj.getFoto_6() , obj.getFoto_7(), obj.getFoto_8(),
					obj.getEmpresa(), obj.getVeiculo(), obj.getPlaca());
			
			/*int capo = obj.getCapo(); 
			int parabra = obj.getParabrisa();
			int retrovor_dir = obj.getRetrovisor_dir();
			int farol_dir = obj.getFarol_dir(); int lateral_tras = obj.getLateral_tras(); int vidro_tras_esq = obj.getVidro_tras_esq();  int porta_tras_esq = obj.getPorta_tras_esq();
			int vidro_diant_esq = obj.getVidro_diant_esq(); int porta_diant_esq = obj.getPorta_diant_esq(); int farol_esq = obj.getFarol_esq();
			int retrovor_esq = obj.getRetrovisor_esq(); int seta_esq = obj.getSeta_esq(); int seta_dir = obj.getSeta_dir(); 
			 int para_choque =  obj.getPara_choque(); int farolete_dir = obj.getFarolete_dir();  int farolete_esq = obj.getFarolete_esq(); int vidro_tras = obj.getVidro_tras(); int traseira = obj.getTraseira();
			 int tam_porta_malas = obj.getTam_porta_malas(); int vidro_tras2 = obj.getVidro_tras2(); int teto = obj.getTeto(); int capo2 = obj.getCapo2();  int roda_tras_esq = obj.getRoda_tras_esq();
			 int roda_diant_esq = obj.getRoda_diant_esq();  int lateral_diant_esq = obj.getLateral_diant_esq(); String observacao = obj.getObservacao(); String solicitante = obj.getSolicitante();
			 String proprietario = obj.getProprietario();  String veiculo =  obj.getVeiculo(); String chassi =obj.getChassi(); String local = obj.getLocal(); String atravesDE = obj.getAtravesDE(); String telefone = obj.getTelefone();
			 String entrada = obj.getEntrada(); String renavam = obj.getRenavam(); String bairro = obj.getBairro(); String guincho = obj.getGuincho(); String cpf_cnpj = obj.getCpf_cnpj(); String cor = obj.getCor(); String produto = obj.getProduto();
			 String cidade = obj.getCidade();  String placa = obj.getPlaca(); String uf = obj.getUf(); String documento = obj.getDocumento(); String bagagito = obj.getBagagito(); String retrovor_eletrico = obj.getRetrovisor_eletrico();
			 String retrovor_comum = obj.getRetrovisor_comum();  String borrachao_lateral = obj.getBorrachao_lateral(); String break_light = obj.getBreak_light(); String faro_auxiliares = obj.getFarois_auxiliares();
			 String rodas_comum = obj.getRodas_comum(); String rodas_de_liga = obj.getRodas_de_liga(); String radio_toca_cds = obj.getRadio_toca_cds(); String amplificador = obj.getAmplificador(); String banco_dianteiro = obj.getBanco_dianteiro();
			 String banco_traseiro = obj.getBanco_traseiro(); String tapetes = obj.getTapetes(); String protetor_carter = obj.getProtetor_carter(); String extintor = obj.getExtintor(); String triangulo = obj.getTriangulo(); String console_interno = obj.getConsole_interno();
			 String buzinas = obj.getBuzinas(); String bateria = obj.getBateria(); String macaco = obj.getMacaco(); String chave_de_roda = obj.getChave_de_roda(); String calotas = obj.getCalotas(); String alarme = obj.getAlarme(); String automovel = obj.getAutomovel();
			 String empresa = obj.getEmpresa(); int vidro_diant_dir = obj.getVidro_diant_dir(); int bau_dir = obj.getBau_dir(); int tanque = obj.getTanque(); int roda_tras_dir = obj.getRoda_tras_dir();
			 int bau_esq = obj.getBau_esq();  String caminhao = obj.getCaminhao(); String combustivel = obj.getCombustivel(); String pneus = obj.getPneus(); byte[] assinatura_vtoriador =  obj.getAssinatura_vistoriador();
			 byte[] assinatura_policial = obj.getAssinatura_policial();*/

			CheckListAutomovelEntity resultSave = checklistRepository.save(obj);
			/*checklistRepository.inseriVeiculo(capo, parabra, retrovor_dir,
					 farol_dir, lateral_tras, vidro_tras_esq, porta_tras_esq, vidro_diant_esq,
					 porta_diant_esq, farol_esq, retrovor_esq, seta_esq, seta_dir,
					 para_choque, farolete_dir, farolete_esq, vidro_tras, traseira,
					 tam_porta_malas, vidro_tras2, teto, capo2, roda_tras_esq,
					 roda_diant_esq, lateral_diant_esq, observacao, solicitante,
					 proprietario, veiculo, chassi, local, atravesDE, telefone,
					 entrada, renavam, bairro,guincho, cpf_cnpj, cor, produto,
					 cidade, placa, uf, documento, bagagito, retrovor_eletrico,
					 retrovor_comum, borrachao_lateral, break_light, faro_auxiliares,
					 rodas_comum, rodas_de_liga, radio_toca_cds, amplificador, banco_dianteiro,
					 banco_traseiro, tapetes, protetor_carter, extintor, triangulo, console_interno,
					 buzinas, bateria, macaco, chave_de_roda, calotas, alarme, automovel,
					 empresa, vidro_diant_dir, bau_dir, tanque, roda_tras_dir,
					 bau_esq, caminhao, combustivel, pneus, assinatura_vtoriador,
					 assinatura_policial);*/

			return obj;
		}
		throw new EmptyElementException(getGenericName() + " não pode ser inserido se vazio.");
	}
	
	//@Override
	public CheckListAutomovelEntity update(CheckListAutomovelEntity obj) throws Exception {
		if(checkNullabilityOfTheEntityAndId(obj)) {
//			obj = prepareAudit(obj);
			//CheckListAutomovelEntity old =  findById(obj.getOid());
		//obj = validateEntity(old);
			
			CheckListAutomovelEntity address = checklistRepository.save(obj);
			return address;
		}
		throw new EmptyElementException(getGenericName() + " não pode ser atualizado se vazio.");
	}

	//@Override
	public void delete(Long oid) throws Exception {
		CheckListAutomovelEntity address = findById(oid);
		//address.setIdAtivo("N");
	   checklistRepository.delete(address);
	}



}