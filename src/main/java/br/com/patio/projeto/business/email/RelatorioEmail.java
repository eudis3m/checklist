package br.com.patio.projeto.business.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Properties;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.patio.projeto.entity.CheckListAutomovelEntity;


@Component
public class RelatorioEmail  {
	  public String from = "eudisgomes@yahoo.com.br";
	    public String to = getTo();
	    public String senhaMail = "189sud36";
	    //@Autowired
	    private JavaMailSender emailSender = getJavaMailSender();
	
	    
	    LocalDate hoje = LocalDate.now();
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
	    public RelatorioEmail() throws IOException{
	        ConfigSistema cam = new ConfigSistema();
	      // this.to = cam.caminhoConfig("3");
	    }

	    @Bean
	    public JavaMailSender getJavaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.mail.yahoo.com");
	        mailSender.setPort(587);
	        
	        mailSender.setUsername(from);
	        mailSender.setPassword(senhaMail);
	        
	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.ssl.trust", "*");
	        props.put("mail.debug", "true");
	        props.put("mail.user", from);
	        props.put("mail.password", senhaMail);
	        
	        return mailSender;
	    }
	    
	    public void sendSimpleMessage(String  para , String src, String placa) throws Exception {
	    	 try {
	    		 /* File  a = new File(foto + "/" + "foto");
	    		  File  b = new File(foto + "/" + "foto_2");
	    		  File  c = new File(foto + "/" + "foto_3");
	    		  File  d = new File(foto + "/" + "foto_4");
	    		  File  e = new File(foto + "/" + "foto_5");*/
	    	      
	    		 Properties props = new Properties();
	             props.setProperty("mail.smtp.user", from);
	             props.setProperty("mail.smtp.host","smtp.mail.yahoo.com" );
	             props.setProperty("mail.smtp.auth", "true");
	             Autenticacao auth = new Autenticacao(from,senhaMail);
	             Session sessao = Session.getInstance(props,auth);
	             MimeMessage m = new MimeMessage(sessao);
	            
	             m.setFrom(new InternetAddress(from));
	             Address[] to = new InternetAddress[] {new InternetAddress(para)};
	             m.setRecipients(Message.RecipientType.TO, to);
	             m.setSubject("Checklist Veiculo:" + placa);
	             m.setSentDate(new java.util.Date());
	             m.setText("Checklist Veiculo:" + placa);
	  
	           /*  if(a.exists() ==  true) {
	             Multipart corpo = new MimeMultipart();
	             InternetHeaders headers = new InternetHeaders();
	             headers.addHeader("Content-Type", src);
	             MimeBodyPart partPhoto = new MimeBodyPart();
	             partPhoto.attachFile(src);
	             partPhoto.setFileName("Checklist.pdf");   
	             
	             InternetHeaders fotoHeaders = new InternetHeaders();
	             fotoHeaders.addHeader("Content-Type", foto + "/" + "foto");
	             MimeBodyPart photo = new MimeBodyPart();
	             photo.attachFile(foto + "/" + "foto");
	             photo.setFileName("foto.png"); 
	             
	             if(b.exists() == true) {
	             InternetHeaders foto_2Headers = new InternetHeaders();
	             foto_2Headers.addHeader("Content-Type", foto + "/" + "foto_2");
	             MimeBodyPart photo_2 = new MimeBodyPart();
	             photo_2.attachFile(foto + "/" + "foto_2");
	             photo_2.setFileName("foto_2.png");
	             
	             if(c.exists() == true) {
	             InternetHeaders foto_3Headers = new InternetHeaders();
	             foto_3Headers.addHeader("Content-Type", foto + "/" + "foto_3");
	             MimeBodyPart photo_3 = new MimeBodyPart();
	             photo_3.attachFile(foto + "/" + "foto_3");
	             photo_3.setFileName("foto_3.png");
	             
	             
	             if(d.exists() == true) {
	             InternetHeaders foto_4Headers = new InternetHeaders();
	             foto_4Headers.addHeader("Content-Type", foto + "/" + "foto_4");
	             MimeBodyPart photo_4 = new MimeBodyPart();
	             photo_4.attachFile(foto + "/" + "foto_4");
	             photo_4.setFileName("foto_4.png");  
	             
	             if(e.exists() == true) {
	             InternetHeaders foto_5Headers = new InternetHeaders();
	             foto_5Headers.addHeader("Content-Type", foto + "/" + "foto_5");
	             MimeBodyPart photo_5 = new MimeBodyPart();
	             photo_5.attachFile(foto + "/" + "foto_5");
	             photo_5.setFileName("foto_5.png");  

	             corpo.addBodyPart(partPhoto);
	             corpo.addBodyPart(photo);
	             corpo.addBodyPart(photo_2);
	             corpo.addBodyPart(photo_3);
	             corpo.addBodyPart(photo_4);
	             corpo.addBodyPart(photo_5);
	             m.setContent(corpo);
	             emailSender.send(m);
	             }
	             }
	             }
	             }
	             }*/
	             
	             Multipart corpo = new MimeMultipart();
	             InternetHeaders headers = new InternetHeaders();
	             headers.addHeader("Content-Type", src);
	             MimeBodyPart partPhoto = new MimeBodyPart();
	             partPhoto.attachFile(src);
	             partPhoto.setFileName("Checklist.pdf");
	             
	             corpo.addBodyPart(partPhoto);
	             m.setContent(corpo);
	             emailSender.send(m);
	    	 }
               catch(Exception e) {
        	    e.getMessage();
             }
	    	/* MultiPartEmail email = new MultiPartEmail();
		        
		        EmailAttachment attachment = new EmailAttachment();
		        attachment.setPath(src);
		        attachment.setDisposition(EmailAttachment.ATTACHMENT);
		        attachment.setDescription("Relatorio diario");
		        attachment.setName(hoje.format(formato)+".pdf");

		        email.attach(attachment);
	    	        
	    	        try {
	    	        SimpleMailMessage message = new SimpleMailMessage(); 
	    	        message.setFrom(from);
	    	        message.setTo(to); 
	    	        message.setSubject("Relatorio Diario - " + hoje.format(formato)); 
	    	        message.setText("Relatario diario do seu estoque.");

	    	        emailSender.send(message);
	    	        }
	    	        catch(Exception e) {
	    	        	e.getMessage();
	    	        }
	    	        */
	    	    }
   
    public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
