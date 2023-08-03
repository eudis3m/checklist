package br.com.patio.projeto.business.imagem;

import java.awt.Image;
import org.springframework.stereotype.Component;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Base64;

import javax.imageio.ImageIO;




import br.com.patio.projeto.business.pasta.GeraPasta;
import br.com.patio.projeto.entity.CheckListAutomovelEntity;


@Component
public class CarregaImagem {


	 
	public void ReadImageAsByteArray ( byte [] filename,
			byte [] filename_2,byte [] filename_3, byte [] filename_4, 
			byte [] filename_5,
            byte [] filename_6, byte [] filename_7, byte [] filename_8,
            String empresa,String veiculo , String placa) throws IOException{

        GeraPasta gerapasta = new GeraPasta();
        byte []buffer = new byte[1024]; 
        CheckListAutomovelEntity obj;
       // FTPClient connect = gerapasta.fTPClient();
        String path =  gerapasta.Pasta(empresa, veiculo, placa);
        BufferedImage img = null;
        BufferedImage img_2 = null;
        BufferedImage img_3 = null;
        BufferedImage img_4 = null;
        BufferedImage img_5 = null;
        BufferedImage img_6 = null;
        BufferedImage img_7 = null;
        BufferedImage img_8 = null;
        if (filename != null) {    
        img = ImageIO.read(new ByteArrayInputStream(filename));
            //ImageIO.write(img, "jpg", new File(new ClassPathResource("foto").getURI().getPath()));
        ImageIO.write(img, "jpg", new File(path+"/foto"));
        String remoteFile = path+"/foto";
        //FileInputStream inputStream = new FileInputStream(new ClassPathResource("foto").getURI().getPath());
        //connect.storeFile(remoteFile,inputStream);
      
        }
 
        if(filename_2 != null) {
        img_2 = ImageIO.read(new ByteArrayInputStream(filename_2));
            //ImageIO.write(img_2, "jpg", new File(new ClassPathResource("foto_2").getURI().getPath()));
        ImageIO.write(img_2, "jpg", new File(path+"/foto_2"));
        String remoteFile = path+"/foto_2";
        //FileInputStream inputStream = new FileInputStream(new ClassPathResource("foto_2").getURI().getPath());
        //connect.storeFile(remoteFile,inputStream);
        }
        if(filename_3 != null) {
        img_3 = ImageIO.read(new ByteArrayInputStream(filename_3));
            //ImageIO.write(img_3, "jpg", new File(new ClassPathResource("foto_3").getURI().getPath()));
        ImageIO.write(img_3, "jpg", new File(path+"/foto_3"));
        String remoteFile = path+"/foto_3";
        //FileInputStream inputStream = new FileInputStream(new ClassPathResource("foto_3").getURI().getPath());
        //connect.storeFile(remoteFile,inputStream);
        }
        if(filename_4 != null) {
        img_4 = ImageIO.read(new ByteArrayInputStream(filename_4));
            //ImageIO.write(img_4, "jpg", new File(new ClassPathResource("foto_4").getURI().getPath()));
        ImageIO.write(img_4, "jpg", new File(path+"/foto_4"));
        String remoteFile = path+"/foto_4";
        //FileInputStream inputStream = new FileInputStream(new ClassPathResource("foto_4").getURI().getPath());
        //connect.storeFile(remoteFile,inputStream);
        }
        if(filename_5 != null) {
        img_5 = ImageIO.read(new ByteArrayInputStream(filename_5));
            //ImageIO.write(img_5, "jpg", new File(new ClassPathResource("foto_5").getURI().getPath()));
        ImageIO.write(img_5, "jpg", new File( path+"/foto_5"));
        String remoteFile = path+"/foto_5";
        //FileInputStream inputStream = new FileInputStream(new ClassPathResource("foto_5").getURI().getPath());
        //connect.storeFile(remoteFile,inputStream);
        }
       if(filename_6 != null) {
           img_6 = ImageIO.read(new ByteArrayInputStream(filename_6));
           //ImageIO.write(img_6, "jpg", new File(new ClassPathResource("foto_6").getURI().getPath()));
           ImageIO.write(img_6, "jpg", new File( path+"/foto_6"));
           String remoteFile = path+"/foto_6";
           //FileInputStream inputStream = new FileInputStream(new ClassPathResource("foto_6").getURI().getPath());
            //connect.storeFile(remoteFile,inputStream);
       }
       if(filename_7 != null) {
          img_7 = ImageIO.read(new ByteArrayInputStream(filename_7));
           //ImageIO.write(img_7, "jpg", new File(new ClassPathResource("foto_7").getURI().getPath()));
          ImageIO.write(img_7, "jpg", new File( path+"/foto_7"));
          String remoteFile = path+"/foto_7";
          //FileInputStream inputStream = new FileInputStream(new ClassPathResource("foto_7").getURI().getPath());
          //connect.storeFile(remoteFile,inputStream);
       }
      if(filename_8 != null) {
         img_8 = ImageIO.read(new ByteArrayInputStream(filename_8));
          //ImageIO.write(img_8, "jpg", new File(new ClassPathResource("foto_8").getURI().getPath()));
         ImageIO.write(img_8, "jpg", new File( path+"/foto_8"));
         String remoteFile = path+"/foto_8";
         //FileInputStream inputStream = new FileInputStream(new ClassPathResource("foto_8").getURI().getPath());
         //connect.storeFile(remoteFile,inputStream);
      }
        
        else {
        	gerapasta.Pasta(empresa, veiculo, placa);
    
        }
     /*  InputStream is = this.getClass().getResourceAsStream( filename.toString());
        
        while (is.read( buffer ) != -1)  {
            out.write( buffer );
        }
        return out.toByteArray();*/
    }    
}
