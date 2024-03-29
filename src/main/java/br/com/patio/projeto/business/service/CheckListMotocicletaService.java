package br.com.patio.projeto.business.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
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

import org.apache.commons.mail.EmailException;
import org.apache.commons.net.ftp.FTPClient;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.annotation.RequestScope;

import com.itextpdf.text.pdf.codec.Base64.InputStream;

import javax.inject.Inject;
import javax.persistence.*;

import br.com.patio.projeto.business.email.RelatorioEmail;
import br.com.patio.projeto.business.imagem.CarregaImagem;
import br.com.patio.projeto.business.pasta.Compactador;
import br.com.patio.projeto.business.pasta.GeraPasta;
import br.com.patio.projeto.data.repository.CheckListMotocicletaRepository;
import br.com.patio.projeto.data.repository.RetiraVeiculoRepository;
import br.com.patio.projeto.dto.FileDto;
import br.com.patio.projeto.entity.CheckListMotocicletaEntity;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;
import br.com.patio.projeto.exceptionhandlers.exceptions.EmptyElementException;
import br.com.patio.projeto.exceptionhandlers.exceptions.NotFoundElementException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;
import net.sf.jasperreports.view.JasperViewer;


@Service
@Transactional
public  class  CheckListMotocicletaService {


	
	@Autowired
	private CheckListMotocicletaRepository  checklistRepository;
	
	@Autowired
	private RetiraVeiculoRepository  retiraveiculoRepository;
	
	@Autowired
	private RelatorioEmail relatorioemail;
	
	 @Autowired
	 private Compactador compactador;
	
	@Autowired
	 private CarregaImagem  carregaimagem;

	 @Autowired
	 private ResourceLoader resourceLoader;
	 
	 @Autowired
		private GeraPasta gerapasta;

	//protected abstract T validateEntity(T obj) throws Exception;
	
	protected Boolean checkNullabilityOfTheEntityAndId(CheckListMotocicletaEntity obj) {
		return obj != null && obj.getOid() != null && obj.getOid().longValue() > 0L;
	}
	
	protected Boolean checkNullabilityOfId(Long oid) {
		return oid != null && oid.longValue() > 0L;
	}
	@SuppressWarnings("unchecked")
	protected String getGenericName()
    {
        return ((Class<CheckListMotocicletaEntity>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
    }

	
  
	public File findByPlacaAndEmail(String placa, String email) throws JRException, SQLException, IOException {
		        CheckListMotocicletaEntity resultemail = checklistRepository.findByPlaca(placa);
		       // FTPClient connect = gerapasta.fTPClient();
		try {
			 String path =  gerapasta.Pasta(resultemail.getEmpresa(), resultemail.getVeiculo(), placa);
		        List<CheckListMotocicletaEntity> resultchecklist = checklistRepository.findByList(placa);
		        List<RetiraVeiculoEntity> resulttermo = retiraveiculoRepository.findByRetiraMotocicleta(placa);
		        if(resulttermo != null) {
                Map<String, Object> parameters = new HashMap<>();
                 parameters.put("$P{Placa}", placa);
               JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
               JRBeanCollectionDataSource datatermo = new JRBeanCollectionDataSource(resulttermo);
               String checklist = resourceLoader.getResource("classpath:CheckListMotocicleta.jrxml").getURI().getPath();
                String termo = resourceLoader.getResource("classpath:Termo_motocicleta.jrxml").getURI().getPath();
               JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
                JasperReport jasperTermo = JasperCompileManager.compileReport(termo);
 
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
                JRPrintPage paginasGerada =  JasperFillManager.fillReport(jasperTermo, 
                		parameters,datatermo).getPages().get(0);
    	        	 jasperPrint.addPage(1,paginasGerada );
    	        	 JasperExportManager.exportReportToPdfFile(jasperPrint,
    	        			 path +"\\CheckListMotocicleta.pdf" );
    			 String pdfExport = new ClassPathResource("CheckListMotocicleta.pdf").getPath();
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
	               String checklist = resourceLoader.getResource("classpath:CheckListMotocicleta.jrxml").getURI().getPath();
	               JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);	 
	                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
	    	        	 JasperExportManager.exportReportToPdfFile(jasperPrint,
	    	        			 path +"\\CheckListMotocicleta.pdf" );
	    			 String pdfExport = new ClassPathResource("CheckListMotocicleta.pdf").getPath();
	       	        File inputStream = new File(pdfExport);
					relatorioemail.sendSimpleMessage(email,pdfExport, resultemail.getPlaca());
					FileDto pdf = new FileDto();
					pdf.setDownload(pdfExport);

					return inputStream;
		        }
		
	     } catch (Exception e) {
		       // TODO Auto-generated catch block
		      e.printStackTrace();
	         }
     return null;
	}
	
	public File findByPlaca(String placa) throws JRException, SQLException, IOException {
        CheckListMotocicletaEntity resultemail = checklistRepository.findByPlaca(placa);
try {
	 String path =  gerapasta.Pasta(resultemail.getEmpresa(), resultemail.getVeiculo(), placa);
        List<CheckListMotocicletaEntity> resultchecklist = checklistRepository.findByList(placa);
        List<RetiraVeiculoEntity> resulttermo = retiraveiculoRepository.findByRetiraMotocicleta(placa);
        if(resulttermo != null) {
        Map<String, Object> parameters = new HashMap<>();
         parameters.put("$P{Placa}", placa);
       JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
       JRBeanCollectionDataSource datatermo = new JRBeanCollectionDataSource(resulttermo);
       String checklist = resourceLoader.getResource("classpath:CheckListMotocicleta.jrxml").getURI().getPath();
        String termo = resourceLoader.getResource("classpath:Termo_motocicleta.jrxml").getURI().getPath();
       JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
        JasperReport jasperTermo = JasperCompileManager.compileReport(termo);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
        JRPrintPage paginasGerada =  JasperFillManager.fillReport(jasperTermo, 
        		parameters,datatermo).getPages().get(0);
        	 jasperPrint.addPage(1,paginasGerada );
        	 JasperExportManager.exportReportToPdfFile(jasperPrint,
        			 path );
		 String pdfExport = new ClassPathResource("CheckListMotocicleta.pdf").getPath();
	        File inputStream = new File(pdfExport);
			FileDto pdf = new FileDto();
			pdf.setDownload(pdfExport);

			return inputStream;}
        else {
        	 Map<String, Object> parameters = new HashMap<>();
             parameters.put("$P{Placa}", placa);
           JRBeanCollectionDataSource datachecklist = new JRBeanCollectionDataSource(resultchecklist);
           JRBeanCollectionDataSource datatermo = new JRBeanCollectionDataSource(resulttermo);
           String checklist = resourceLoader.getResource("classpath:CheckListMotocicleta.jrxml").getURI().getPath();
           JasperReport jasperChecklist = JasperCompileManager.compileReport(checklist);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperChecklist, parameters,datachecklist);
            	 JasperExportManager.exportReportToPdfFile(jasperPrint,
            			 path );
    		 String pdfExport = new ClassPathResource("CheckListMotocicleta.pdf").getPath();
    	        File inputStream = new File(pdfExport);
			FileDto pdf = new FileDto();
			pdf.setDownload(pdfExport);

			return inputStream;
        }

 } catch (Exception e) {
       // TODO Auto-generated catch block
      e.printStackTrace();
     }
return null;
}
	
	//@Override
	public CheckListMotocicletaEntity findById(Long oid) throws Exception {
		if(checkNullabilityOfId(oid)) {
			Optional<CheckListMotocicletaEntity> obj = checklistRepository.findById(oid);
			return obj.orElseThrow(() -> new NotFoundElementException(getGenericName() + " com identificador único = " + oid + " não encontrado! "));
			//return obj;
		}
		//throw new NotFoundException(getGenericName() + " com identificador único = " + id + " não encontrado! ");
		throw new NotFoundElementException(getGenericName() + " com identificador único = " + oid + " não encontrado! ");
	}
	
	//@Override
	public CheckListMotocicletaEntity create(CheckListMotocicletaEntity obj) throws Exception {
		// CheckListMotocicletaEntity placa =  checklistRepository.findByPlaca(obj.getPlaca());
		if(obj != null) {
			//obj.setOid(null);
//			obj = prepareAudit(obj);
			carregaimagem.ReadImageAsByteArray(obj.getFoto(), 
					 obj.getFoto_2(),
					 obj.getFoto_3(), obj.getFoto_4(), obj.getFoto_5(),
					 obj.getFoto_6(),  obj.getFoto_7(), obj.getFoto_8(),
					 obj.getEmpresa(), obj.getVeiculo(), obj.getPlaca());
			//obj = validateEntity(obj);
			 CheckListMotocicletaEntity resultSave = checklistRepository.save(obj);
			/*checklistRepository.inseriMotocicleta(
					obj.getTanque() , obj.getProtecao_frontal(), obj.getRetrovisor_dir() , obj.getRetrovisor_esq(), obj.getFarol(), obj.getBanco(), obj.getPneu_dianteiro(),
					obj.getPneu_traseiro(), obj.getBengala() , obj.getFreio(), obj.getCarenagem_dir(), obj.getCarenagem_esq(), obj.getSuporte_placa(), obj.getMotor(), obj.getFarolete(), obj.getSeta_dir(), obj.getSeta_esq(), obj.getEscapamento(),
					obj.getRoda_traseira(), obj.getRoda_dianteira(), obj.getObservacao(), obj.getSolicitante(), obj.getProprietario(), obj.getVeiculo(), obj.getChassi(), obj.getLocal(), obj.getAtravesDE(), obj.getTelefone(), obj.getEntrada(),
			        obj.getRenavam(), obj.getBairro(), obj.getGuincho(), obj.getCpf_cnpj(), obj.getCor(), obj.getProduto(), obj.getCidade(), obj.getPlaca(), obj.getUf(), obj.getDocumento(), obj.getBagagito(), obj.getRetrovisor_eletrico(),
			        obj.getRetrovisor_comum(), obj.getFarois_auxiliares(), obj.getRodas_comum(), obj.getRodas_de_liga(), obj.getRadio_toca_cds(), obj.getAmplificador(), obj.getMata_cachorro(),
			        obj.getBuzinas(), obj.getBateria(), obj.getAlarme(), obj.getEmpresa(), obj.getMotocicleta(),
			        obj.getCombustivel(), obj.getPneus_status(), obj.getAssinatura_vistoriador(), obj.getAssinatura_policial()
			);*/
			return obj;
		}
		throw new EmptyElementException(getGenericName() + " não pode ser inserido se vazio.");
	}

	//@Override
	public CheckListMotocicletaEntity update(CheckListMotocicletaEntity obj) throws Exception {
		if(checkNullabilityOfTheEntityAndId(obj)) {
//			obj = prepareAudit(obj);
			//CheckListMotocicletaEntity old =  findById(obj.getOid());
		//obj = validateEntity(old);
			
			CheckListMotocicletaEntity address = checklistRepository.save(obj);
			return address;
		}
		throw new EmptyElementException(getGenericName() + " não pode ser atualizado se vazio.");
	}

	//@Override
	public void delete(Long oid) throws Exception {
		CheckListMotocicletaEntity address = findById(oid);
		//address.setIdAtivo("N");
	   checklistRepository.delete(address);
	}



}