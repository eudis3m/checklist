package br.com.patio.projeto.business.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;

import org.exolab.castor.types.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.lowagie.text.Image;

import br.com.patio.projeto.business.calculadiaria.CalculaDiaria;
import br.com.patio.projeto.business.imagem.CarregaImagem;
import br.com.patio.projeto.data.repository.CheckListAutomovelRepository;
import br.com.patio.projeto.data.repository.CheckListMotocicletaRepository;
import br.com.patio.projeto.data.repository.RetiraVeiculoRepository;
import br.com.patio.projeto.dto.FileDto;
import br.com.patio.projeto.entity.CheckListAutomovelEntity;
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


@Service
@Transactional
public class RetiraVeiculoService {

	@Autowired
	private RetiraVeiculoRepository  retiraveiculoRepository;
	
	@Autowired
	private CheckListAutomovelRepository  checklistAutomovelRepository;
	
	@Autowired
	private CheckListAutomovelService  checklistservice;
	
	@Autowired
	private CheckListMotocicletaRepository  checklistMotocicletaRepository;
	
	@Autowired
	private CheckListMotocicletaService  checklistMotocicletaService;
	
	@Autowired
	private CarregaImagem  carregaimagem;
	
    @Autowired(required=true)
    private CalculaDiaria calculadiaria;
	
	//protected abstract T validateEntity(T obj) throws Exception;
	
	protected Boolean checkNullabilityOfTheEntityAndId(RetiraVeiculoEntity  obj) {
		return obj != null && obj.getOid() != null && obj.getOid().longValue() > 0L;
	}
	
	public File findByRelatorio(String placa, String email) throws JRException, SQLException, IOException {
        CheckListMotocicletaEntity resultMotocicleta = checklistMotocicletaRepository.findByPlaca(placa);
		CheckListAutomovelEntity resultAutomovel = checklistAutomovelRepository.findByPlaca(placa);
        if(resultMotocicleta!= null) {
    	   if(email != null) {
    		   return checklistMotocicletaService.findByPlacaAndEmail(placa, email);
    	   }
    	   else {
    		   return checklistMotocicletaService.findByPlaca(placa);
    	   }
        }
         if(resultAutomovel != null) {
        	 if(email != null) {
      		   return checklistservice.findByPlacaAndEmail(placa, email);
      	   }
      	   else {
      		   return checklistservice.findByPlaca(placa);
      	   }
        }
      return null;
     }
	
	protected Boolean checkNullabilityOfId(Long oid) {
		return oid != null && oid.longValue() > 0L;
	}
	@SuppressWarnings("unchecked")
	protected String getGenericName()
   {
       return ((Class<RetiraVeiculoEntity >) ((ParameterizedType) getClass()
               .getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
   }


	public Object findByPlacaVeiculo(String placa) throws ParseException{
		Object result = retiraveiculoRepository.findByPlaca(placa);
		String test = "null";
        if(result != null) {
    		   return test;
        }
        else {
        	Object resultAutomovel = checklistAutomovelRepository.findByPlaca(placa);
 		  if( resultAutomovel != null) {
 			 return  resultAutomovel;
 		  }
 		  else {
 			//return this.findByPlacaMotocicleta(placa);
 			 return test;
 		  }
        }
	}
	
	public Object findByPlacaMotocicleta(String placa) throws ParseException{
		Object result = retiraveiculoRepository.findByPlaca(placa);
		String test = "null";
        if(result != null) {
    		   return test;
        }
        else {
        	Object resultMotocicleta = checklistMotocicletaRepository.findByPlaca(placa);
 		  if( resultMotocicleta != null) {
 			 return  resultMotocicleta;
 		  }
 		  else {
 			 return test;
 		  }
 	   }

	}
	
	public Object findByPlaca(String placa) throws ParseException{
		Object result = retiraveiculoRepository.findByPlaca(placa);
		String test = "null";
        if(result != null) {
    		   return result;
        }
        else {
 			 return null;
 		  }

	}
	
	//@Override
	public RetiraVeiculoEntity  findById(Long oid) throws Exception {
		if(checkNullabilityOfId(oid)) {
			Optional<RetiraVeiculoEntity> obj = retiraveiculoRepository.findById(oid);
			return obj.orElseThrow(() -> new NotFoundElementException(getGenericName() + " com identificador único = " + oid + " não encontrado! "));
	
		}
		throw new NotFoundElementException(getGenericName() + " com identificador único = " + oid + " não encontrado! ");
	}
	
	//@Override
	public RetiraVeiculoEntity  create(RetiraVeiculoEntity  obj) throws ParseException  {
		  Object placaVeiculo = findByPlaca(obj.getPlaca());
		if(obj.getTotal() == null && placaVeiculo == null) {
			 CheckListAutomovelEntity rs =   checklistAutomovelRepository.findByPlaca(obj.getPlaca());
			 CheckListMotocicletaEntity rm =   checklistMotocicletaRepository.findByPlaca(obj.getPlaca());
			 
          if (rs != null) {
			 String dini = rs.getEntrada();
			 String dfin = obj.getSaida();
			 String guincho = rs.getGuincho();
			 String caminhao = rs.getCaminhao();
			// Blob assinatura = carregaimagem.ReadImageAsByteArray(filename, rs.getEmpresa(), rs.getVeiculo(), rs.getPlaca());
			 //obj.setAssinatura(assinatura);
		     Double  total;
			 int  diaria = calculadiaria.getDataAtual(dini,dfin) ;
		if(guincho.equals("Sim") && caminhao == null) {
			 total = (Double) (diaria*50.37 +  277.03);
			 obj.setTotal(total);
			 obj.setDiaria(diaria);
			 RetiraVeiculoEntity  resultSave = retiraveiculoRepository.save(obj);
				return resultSave;
		}
	    if (guincho.equals("Não") && caminhao == null)  {
			total = (Double) (diaria*50.37 + 1);
			obj.setTotal(total);
			obj.setDiaria(diaria);
			RetiraVeiculoEntity  resultSave = retiraveiculoRepository.save(obj);
			return resultSave;
		}
		if(guincho.equals("Sim") && caminhao != null) {
			 total = (Double) (diaria*60.44 +  367.69);
			 obj.setTotal(total);
			 obj.setDiaria(diaria);
			 RetiraVeiculoEntity  resultSave = retiraveiculoRepository.save(obj);
				return resultSave;
		}
		if (guincho.equals("Não") && caminhao != null)  {
			total = (Double) (diaria*60.44 + 1);
			obj.setTotal(total);
			obj.setDiaria(diaria);
			RetiraVeiculoEntity  resultSave = retiraveiculoRepository.save(obj);
			return resultSave;
		}
		
          }
          if (rm != null) {
 			 String dini = rm.getEntrada();
 			 String dfin = obj.getSaida();
 			//findBySaida(obj.getPlaca(),dfin);
 			//obj.setOid(null);
 			 String guincho = rm.getGuincho();
 		     Double  total;
 			 int  diaria = calculadiaria.getDataAtual(dini,dfin) ;
 		if(guincho.equals("Sim")) {
 			 total = (Double) (diaria*30.22 + 176.29);
 			 obj.setTotal(total);
 			 obj.setDiaria(diaria);
 			 RetiraVeiculoEntity  resultSave = retiraveiculoRepository.save(obj);
 				return resultSave;
 		}
 		else {
 			total = (Double) (diaria*30.22 + 1);
 			obj.setTotal(total);
 			obj.setDiaria(diaria);
 			RetiraVeiculoEntity  resultSave = retiraveiculoRepository.save(obj);
 			return resultSave;
 		}
           }
//			obj = prepareAudit(obj);
			//obj = validateEntity(obj);
			
		}
		throw new EmptyElementException(getGenericName() + " não pode ser inserido se vazio.");
	}

	//@Override
	public RetiraVeiculoEntity  update(RetiraVeiculoEntity  obj) throws Exception {
		if(checkNullabilityOfTheEntityAndId(obj)) {
//			obj = prepareAudit(obj);
			RetiraVeiculoEntity  old =  findById(obj.getOid());
		//obj = validateEntity(old);
			
			RetiraVeiculoEntity  address = retiraveiculoRepository.save(old);
			return address;
		}
		throw new EmptyElementException(getGenericName() + " não pode ser atualizado se vazio.");
	}

	//@Override
	public void delete(Long oid) throws Exception {
		RetiraVeiculoEntity  address = findById(oid);
		address.setIdAtivo("N");
		retiraveiculoRepository.delete(address);
	  
	}


}
