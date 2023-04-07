package br.com.patio.projeto.business.pasta;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Component;

@Component
public class Compactador {

   //Constantes
   static final int TAMANHO_BUFFER = 4096; // 4kb

   //método para compactar arquivo
   public  File compactarParaZip(String arqSaida,String arqEntrada)
throws IOException{
       int cont;
       byte[] dados = new byte[TAMANHO_BUFFER];

       BufferedInputStream origem = null;
       FileInputStream streamDeEntrada = null;
       FileOutputStream destino = null;
       ZipOutputStream saida = null;
       ZipEntry entry = null;
       File result = null;

       try {
            destino = new FileOutputStream(new File(arqSaida+"\\zip.zip"));
            saida = new ZipOutputStream(new BufferedOutputStream(destino));
            File file = new File(arqEntrada);
            streamDeEntrada = new FileInputStream(file);
             origem = new BufferedInputStream(streamDeEntrada, TAMANHO_BUFFER);
            entry = new ZipEntry(file.getName());
            saida.putNextEntry(entry);
            

            while((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
            	 saida.write(dados, 0, cont);
            	  result = new File(arqSaida+"\\zip.zip");
            return result;
            }
            origem.close();
            saida.close();
        } catch(IOException e) {
            throw new IOException(e.getMessage());
        }
       return result;
   }
}