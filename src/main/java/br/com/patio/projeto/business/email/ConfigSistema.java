/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.patio.projeto.business.email;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rafael
 */
@Service
@Transactional
public class ConfigSistema {
    
    public void gravarCaminho(String caminhoBackup, String caminhoImagens, String EmailRelatoriosDiarios){
        FileWriter file;
        
        try {
            file = new FileWriter("C:\\Users\\eudis\\eclipse-workspace\\Patio_Spring\\Relatorios\\CheckList.pdf");
            PrintWriter gravarCaminhos = new PrintWriter(file);

            gravarCaminhos.print("1-" + caminhoBackup + "\r\n");
            gravarCaminhos.print("2-" + caminhoImagens + "\r\n");
            gravarCaminhos.print("3-" + EmailRelatoriosDiarios + "\r\n");
            file.close();             
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar informações " + ex);
        }
    }
    
    public String caminhoConfig(String op) throws IOException{
        String caminho = null;
        String src = "C:\\Users\\eudis\\eclipse-workspace\\Patio_Spring\\Relatorios\\CheckList.pdf"; //Caminho do arquivo config
        
        try {
            FileReader arq = new FileReader(src);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            
            while(linha != null){
                if(op.equals(linha.substring(0, 1))){
                    caminho = linha.substring(2);
                }
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Erro " + ex);
        }
        return caminho;
    }
    
}
