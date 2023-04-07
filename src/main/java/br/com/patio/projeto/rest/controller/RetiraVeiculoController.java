package br.com.patio.projeto.rest.controller;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.patio.projeto.business.service.RetiraVeiculoService;
import br.com.patio.projeto.dto.FileDto;
import br.com.patio.projeto.entity.CheckListAutomovelEntity;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;
import br.com.patio.projeto.rest.api.RetiraVeiculoAPI;
import br.com.patio.projeto.rest.api.utils.APIControllersUtils;
import net.sf.jasperreports.engine.JRException;

@RestController
public class RetiraVeiculoController implements RetiraVeiculoAPI{
	
	@Autowired
	RetiraVeiculoService retiraveiculoservice;

	@Override
	public ResponseEntity<RetiraVeiculoEntity> save(RetiraVeiculoEntity obj) throws Exception {
		RetiraVeiculoEntity objEntityNew =  retiraveiculoservice.create(obj);
		
		URI uri = APIControllersUtils.generateURIByOid((Long) objEntityNew.getOid());
		
		return ResponseEntity.created(uri).body(objEntityNew);
	}
	
	@Override
	public ResponseEntity<File> findByRelatorio(@PathVariable("placa")String placa, String email) throws JRException, SQLException, IOException{
		File objEntity = retiraveiculoservice.findByRelatorio(placa, email);
	return ResponseEntity.ok().body(objEntity);}

	@Override
	public ResponseEntity<RetiraVeiculoEntity> update(RetiraVeiculoEntity obj) throws Exception {
		RetiraVeiculoEntity objUpdated = retiraveiculoservice.update(obj);
		return ResponseEntity.ok().body(objUpdated);
	}

	@Override
	public ResponseEntity<RetiraVeiculoEntity> delete(Long oid) throws Exception {
		RetiraVeiculoEntity objUpdated = retiraveiculoservice.findById(oid);
		if(objUpdated != null) {
		retiraveiculoservice.delete(oid);
		return ResponseEntity.noContent().build();
		}
		return null;
	}

	@Override
	public ResponseEntity<RetiraVeiculoEntity> findById(Long oid) throws Exception {
		RetiraVeiculoEntity objEntity = retiraveiculoservice.findById(oid);
		return ResponseEntity.ok().body(objEntity);
	}

	@Override
	public ResponseEntity<Object> findByPlacaVeiculo(String placa)  throws ParseException, SQLException {
		Object objEntity = retiraveiculoservice.findByPlacaVeiculo(placa);
		return ResponseEntity.ok().body(objEntity);
	}
	
	@Override
	public ResponseEntity<Object> findByPlacaMotocicleta(String placa)  throws ParseException, SQLException {
		Object objEntity = retiraveiculoservice.findByPlacaMotocicleta(placa);
		return ResponseEntity.ok().body(objEntity);
	}

	@Override
	public ResponseEntity<Object> findByPlaca(String placa)  throws ParseException, SQLException {
		Object objEntity = retiraveiculoservice.findByPlaca(placa);
		return ResponseEntity.ok().body(objEntity);
	}

}
