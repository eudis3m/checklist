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
import org.apache.commons.mail.EmailException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.jasper.JasperException;
import org.apache.jasper.el.JasperELResolver;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.integration.ftp.session.FtpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.annotation.RequestScope;

import javax.inject.Inject;
import javax.persistence.*;

import br.com.patio.projeto.business.email.RelatorioEmail;
import br.com.patio.projeto.business.imagem.CarregaImagem;
import br.com.patio.projeto.business.pasta.Compactador;
import br.com.patio.projeto.business.pasta.GeraPasta;
import br.com.patio.projeto.data.repository.CheckListAutomovelRepository;
import br.com.patio.projeto.data.repository.RetiraVeiculoRepository;
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
			 if(resultemail.getCaminhao() == "Sim") {
			    String path =  gerapasta.Pasta(resultemail.getEmpresa(), resultemail.getVeiculo(), placa);
		        List<CheckListAutomovelEntity> resultchecklist = checklistRepository.findByList(placa);
		        List<RetiraVeiculoEntity> resulttermo = retiraveiculoRepository.findByRetiraVeiculo(placa);
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
   	        FileInputStream inputStream = new FileInputStream(pdfExport);
   	        String remoteFile = path+"/CheckListAutomovel.pdf";
   	        String remoteFileDownloadPDF = path+"/CheckListAutomovel.pdf";
   	        String remoteFileDownloadFoto = path+"/foto";
   	        String remoteFileDownloadFoto_2 = path+"/foto_2";
   	        String remoteFileDownloadFoto_3 = path+"/foto_3";
   	        String remoteFileDownloadFoto_4 = path+"/foto_4";
   	        String remoteFileDownloadFoto_5 = path+"/foto_5";
   	       /* connect.storeFile(remoteFile,inputStream);
   	        connect.retrieveFileStream(remoteFileDownloadPDF);
   	        connect.retrieveFileStream(remoteFileDownloadFoto);
   	        connect.retrieveFileStream(remoteFileDownloadFoto_2);
   	        connect.retrieveFileStream(remoteFileDownloadFoto_3);
   	        connect.retrieveFileStream(remoteFileDownloadFoto_4);
   	        connect.retrieveFileStream(remoteFileDownloadFoto_5);*/
   	        String foto = "api-"+resultemail.getPlaca()+".zip";
   	     String pathZip =  gerapasta.PastaZip(path);
	        File zip =  compactador.compactarParaZip(pathZip
	       	        , path+"/CheckListAutomovel.pdf");
   	    	relatorioemail.sendSimpleMessage(email,pdfExport, resultemail.getPlaca(), zip);
   	    	File fileZip = new File(path+"/CheckListAutomovel.pdf");
   	    	FileDto pdf = new FileDto();
   	    	pdf.setDownload(fileZip);
	       
		       return fileZip;
			 }
			 else {
				 String path =  gerapasta.Pasta(resultemail.getEmpresa(), resultemail.getVeiculo(), placa);
			        List<CheckListAutomovelEntity> resultchecklist = checklistRepository.findByList(placa);
			        List<RetiraVeiculoEntity> resulttermo = retiraveiculoRepository.findByRetiraVeiculo(placa);
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
	    	        FileInputStream inputStream = new FileInputStream(path+"/CheckListAutomovel.pdf");
	    	        String remoteFile = path+"/CheckListAutomovel.pdf";
	    	        String remoteFileDownloadPDF = path+"/CheckListAutomovel.pdf";
	    	        String remoteFileDownloadFoto = path+"/foto";
	    	        String remoteFileDownloadFoto_2 = path+"/foto_2";
	    	        String remoteFileDownloadFoto_3 = path+"/foto_3";
	    	        String remoteFileDownloadFoto_4 = path+"/foto_4";
	    	        String remoteFileDownloadFoto_5 = path+"/foto_5";
	    	        /*connect.storeFile(remoteFile,inputStream);
	    	        connect.retrieveFileStream(remoteFileDownloadPDF);
	    	        connect.retrieveFileStream(remoteFileDownloadFoto);
	    	        connect.retrieveFileStream(remoteFileDownloadFoto_2);
	    	        connect.retrieveFileStream(remoteFileDownloadFoto_3);
	    	        connect.retrieveFileStream(remoteFileDownloadFoto_4);
	    	        connect.retrieveFileStream(remoteFileDownloadFoto_5);*/
	    	        String foto = "api-"+resultemail.getPlaca()+".zip";
	    	        String pathZip =  gerapasta.PastaZip(path);
	    	        File zip =  compactador.compactarParaZip(pathZip
	    	       	        , path+"/CheckListAutomovel.pdf");
	    	    	relatorioemail.sendSimpleMessage(email,path+"/CheckListAutomovel.pdf", resultemail.getPlaca(), zip);
	    	    	File fileZip = new File(path+"/CheckListAutomovel.pdf");
	    	    	FileDto pdf = new FileDto();
	    	    	pdf.setDownload(fileZip);
	    		       
	 		       return fileZip;
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
	 if(resultemail.getCaminhao() == null) {
	    String path =  gerapasta.Pasta(resultemail.getEmpresa(), resultemail.getVeiculo(), placa);
        List<CheckListAutomovelEntity> resultchecklist = checklistRepository.findByList(placa);
        List<RetiraVeiculoEntity> resulttermo = retiraveiculoRepository.findByRetiraVeiculo(placa);
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
   	        FileInputStream inputStream = new FileInputStream(pdfExport);
   	        String remoteFile = path+"/CheckListAutomovel.pdf";
   	        String remoteFileDownloadPDF = path+"/CheckListAutomovel.pdf";
   	        String remoteFileDownloadFoto = path+"/foto";
   	        String remoteFileDownloadFoto_2 = path+"/foto_2";
   	        String remoteFileDownloadFoto_3 = path+"/foto_3";
   	        String remoteFileDownloadFoto_4 = path+"/foto_4";
   	        String remoteFileDownloadFoto_5 = path+"/foto_5";
   	        /*connect.storeFile(remoteFile,inputStream);
   	        connect.retrieveFileStream(remoteFileDownloadPDF);
   	        connect.retrieveFileStream(remoteFileDownloadFoto);
   	        connect.retrieveFileStream(remoteFileDownloadFoto_2);
   	        connect.retrieveFileStream(remoteFileDownloadFoto_3);
   	        connect.retrieveFileStream(remoteFileDownloadFoto_4);
   	        connect.retrieveFileStream(remoteFileDownloadFoto_5);*/
   	        String foto = "api-"+resultemail.getPlaca()+".zip";
   	     String pathZip =  gerapasta.PastaZip(path);
	        File zip =  compactador.compactarParaZip(pathZip
	       	        , path+"/CheckListAutomovel.pdf");
   	    	File fileZip = new File(path+"/CheckListAutomovel.pdf");
   	    	FileDto pdf = new FileDto();
   	    	pdf.setDownload(fileZip);
	       
	       return fileZip;
	 }
	 else {
		 String path =  gerapasta.Pasta(resultemail.getEmpresa(), resultemail.getVeiculo(), placa);
	        List<CheckListAutomovelEntity> resultchecklist = checklistRepository.findByList(placa);
	        List<RetiraVeiculoEntity> resulttermo = retiraveiculoRepository.findByRetiraVeiculo(placa);
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
	    	        FileInputStream inputStream = new FileInputStream(pdfExport);
	    	        String remoteFile = path+"/CheckListAutomovel.pdf";
	    	        String remoteFileDownloadPDF = path+"/CheckListAutomovel.pdf";
	    	        String remoteFileDownloadFoto = path+"/foto";
	    	        String remoteFileDownloadFoto_2 = path+"/foto_2";
	    	        String remoteFileDownloadFoto_3 = path+"/foto_3";
	    	        String remoteFileDownloadFoto_4 = path+"/foto_4";
	    	        String remoteFileDownloadFoto_5 = path+"/foto_5";
	    	        /*connect.storeFile(remoteFile,inputStream);
	    	        connect.retrieveFileStream(remoteFileDownloadPDF);
	    	        connect.retrieveFileStream(remoteFileDownloadFoto);
	    	        connect.retrieveFileStream(remoteFileDownloadFoto_2);
	    	        connect.retrieveFileStream(remoteFileDownloadFoto_3);
	    	        connect.retrieveFileStream(remoteFileDownloadFoto_4);
	    	        connect.retrieveFileStream(remoteFileDownloadFoto_5);*/
	    	        String foto = "api-"+resultemail.getPlaca()+".zip";
	    	        String pathZip =  gerapasta.PastaZip(path);
	    	        File zip =  compactador.compactarParaZip(pathZip
	    	       	        , path+"/CheckListAutomovel.pdf");
	    	    	File fileZip = new File(path+"/CheckListAutomovel.pdf");
	    	    	FileDto pdf = new FileDto();
	    	    	pdf.setDownload(fileZip);
		       
		       return fileZip;
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
    

	public CheckListAutomovelEntity create(CheckListAutomovelEntity obj) throws Exception {
		// CheckListAutomovelEntity placa =  checklistRepository.findByPlaca(obj.getPlaca());
		if(obj != null) {
			carregaimagem.ReadImageAsByteArray(obj.getFoto(), obj.getFoto_2(),
					obj.getFoto_3(), obj.getFoto_4(), obj.getFoto_5(),obj.getEmpresa(), obj.getVeiculo(), obj.getPlaca());

			CheckListAutomovelEntity resultSave = checklistRepository.save(obj);
			return resultSave;
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