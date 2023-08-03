package br.com.patio.projeto.business.pasta;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPCmd;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.file.remote.RemoteFileTemplate;
import org.springframework.integration.ftp.session.FtpRemoteFileTemplate;
import org.springframework.integration.ftp.session.FtpSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;




@Service
@Log4j2
@Configuration
public class GeraPasta {
	private final InetAddress InetAddress = null;
	private String path = null;
	private final long cont = 1;
	//private FtpRemoteFileTemplate template;
	@Value("${ftp.username}")
	private String username;
    @Value("${ftp.password}") 
    private String pw;
    @Value("${ftp.host}") 
    private String host;
    @Value("${ftp.port}") 
    private int port;
	
	
   /* public InitializingBean initializingBean(String empresa,String veiculo, String placa) {
        RemoteFileTemplate<FTPFile> template = null;
		return () -> template
                .execute(session -> {
                	if(placa != null) {
                	//path = "ftp://172.17.0.2/ftp/eudis3m/Relatorios/"+empresa+"/"+veiculo+"-"+placa;
                		path = "C:\\Users\\eudis.junior\\Desktop\\pessoal_git\\checklist\\Relatorios\\"+empresa+"\\"+veiculo+"-"+placa;
                    File file = new File(path);
                    try (FileOutputStream fout = new FileOutputStream(file)) {
                    	 if(file.mkdir()) { 
         			        System.out.println("Diretorio criado");
         			    } else {
         			        System.out.println("Diretorio não foi criado");
         			    }
                    }
                    //log.info("read " + file.getAbsolutePath());
                    //return path;
                	}
                	 return path;
                });
    }
    */

    

	

	public String Pasta(String empresa,String veiculo, String placa) throws IOException {
	   //FTPClient connect = fTPClient();
	   //FtpSession session = new FtpSession(connect);
		if(placa != null) {
			//path = "/ftp/alpineftp/Relatorios/"+empresa+"/"+veiculo+"-"+placa;
			path = "B://git//checklist//Relatorios//"+empresa+"//"+veiculo+"-"+placa;
			 File local = new File(path);
			try{
		
			    if(local.mkdir()) { 
			        System.out.println("Diretorio criado");
			    } else {
			        System.out.println("Diretorio não foi criado");
			    }
				//}
			} catch(Exception e){
			    e.printStackTrace();
			} 
		}
		
		return path;
	}
	
	public String PastaZip(String zip) throws IOException {
		
			if(zip != null) {
				
				path = zip+"\\zip";
				 File local = new File(path);
				try{
	
					if(local.mkdir()) { 
				        System.out.println("Diretorio criado");
				    } else {
				        System.out.println("Diretorio não foi criado");
				    }
					//}
				} catch(Exception e){
				    e.printStackTrace();
				} 
			}
			
			return path;
		}
	
	//@Bean
    public FTPClient  fTPClient() throws IOException {  	
		FTPClient  fTPClient = new FTPClient();
        fTPClient.connect(host, port);
    	fTPClient.user(username);
    	fTPClient.pass(pw);
    	if(fTPClient.isConnected()) {
    	String result = fTPClient.getReplyString();
    	return fTPClient;
    	}
    	else {
    	return fTPClient;
    	}
    }

}
