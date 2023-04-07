package br.com.patio.projeto.business.calculadiaria;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

import org.exolab.castor.types.DateTime;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;


@Component
public class CalculaDiaria {
	//@Bean
	public  int getDataAtual(String datainicio,String datafinal){
		SimpleDateFormat converte = new SimpleDateFormat("yyyy-mm-dd");
	    /*	 GregorianCalendar gc = new GregorianCalendar(); 
         gc.setTime(datainicio);
         GregorianCalendar gc1 = new GregorianCalendar();
         gc1.setTimeZone(datafinal);
         String dini = converte.format(datainicio);
         String dfin = converte.format(datafinal);*/
         
         String dini = datainicio;
         String dfin = datafinal;
         
         int[] dat1 = new int[3];
         int[] dat2 = new int[3];
         int dias = 0;
         //Desmembra dia, mes e ano das datas;
         dat1[0] = Integer.parseInt(dini.substring(8,10)); //dia;
         dat1[1] = Integer.parseInt(dini.substring(5,7)); //mes;
         dat1[2] = Integer.parseInt(dini.substring(0,4)); //ano;
         dat2[0] = Integer.parseInt(dfin.substring(8,10)); //dia;
         dat2[1] = Integer.parseInt(dfin.substring(5, 7)); //mes;
         dat2[2] = Integer.parseInt(dfin.substring(0, 4)); //ano;
         int m1 = getDaysMonth(dat1[1], dat1[2]);
         int m2 = getDaysMonth(dat2[1], dat2[2]);
         if (dat2[2] == dat1[2]) { // Calculo para o mesmo ano;
             if (dat1[1] == dat2[1]) {
                 dias = dat2[0] - dat1[0];
             } else {
                 int diasMes1 = (m1 - dat1[0]) + 1; 	// numero de dias do primeiro mes (do dia x at� o dia 30);
                 int diasMes2 = m2 - (m2 - dat2[0]);	// numero de dias do ultimo mes (do dia 1 at� o dia x);
                 int interMeses = (dat2[1] - dat1[1]);	// quantidade de meses entre o primeiro e o ultimo mes;
                 if (interMeses == 0) {
                     dias = diasMes1 + diasMes2;
                 } else {
                     for (int i = 1; i < interMeses; i++) {
                         dias += getDaysMonth(dat1[1] + i, dat1[2]);
                     }
                     dias += (diasMes1 + diasMes2);
                 }
             }
         } else {//Calculo para anos diferentes
             int mesesAno1 = 12 - dat1[1];	    	//Numero de Meses ate o fim do ano (O Mes1 n�o est� inclu�do);
             int diasMes1 = m1 - dat1[0];		//Numero de dias do Mes1(inicial);
             for (int i = 0; i < mesesAno1; i++) {
                 dias += getDaysMonth(dat1[1] + i, dat1[2]);
             }
             dias += diasMes1;
             int diasMes2 = m2 - (m2 - dat2[0]);	    //Numero de dias do ultimo mes do periodo;
             int mesesAno2 = dat2[1] - 1;	            //Numero de meses do mes 1 ate o mes x do novo ano;
             for (int i = 0; i < mesesAno2; i++) {
                 dias += getDaysMonth(dat2[1], dat2[2]);
             }
             dias += diasMes2;
             if (dat2[2] - dat1[2] > 1) {
                 dias += 365 * (dat2[2] - dat1[2] - 1);    // quantidade de anos entre o primeiro e o ultimo ano;
             }
         }
         return dias;
	}

	/*public void calcula(double diaValor) {
		if(jRadioButton1.isSelected()) {
			double gui = 178.83;
			double diaria = 32.51;
			
		}
	}*/
	// @Bean
	 public  int getDaysMonth(int month, int year) {
	        int[] mes = new int[12];
	        mes[0] = 31;
	        if (yearIsBisext(year)) {
	            mes[1] = 29;
	        } else {
	            mes[1] = 28;
	        }
	        mes[2] = 31;
	        mes[3] = 30;
	        mes[4] = 31;
	        mes[5] = 30;
	        mes[6] = 31;
	        mes[7] = 31;
	        mes[8] = 30;
	        mes[9] = 31;
	        mes[10] = 30;
	        mes[11] = 31;
	        return mes[month - 1];
	    }
	// @Bean	
public  boolean yearIsBisext(int year) {
    boolean retorno;
    if (year % 4 == 0) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } else {
            retorno = true;
        }
    } else {
        retorno = false;
    }
    return retorno;
}
    
	

}
