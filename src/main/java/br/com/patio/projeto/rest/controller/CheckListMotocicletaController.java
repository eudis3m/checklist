package br.com.patio.projeto.rest.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.patio.projeto.business.service.CheckListMotocicletaService;
import br.com.patio.projeto.dto.FileDto;
import br.com.patio.projeto.entity.CheckListMotocicletaEntity;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;
import br.com.patio.projeto.rest.api.CheckListMotocicletaAPI;
import br.com.patio.projeto.rest.api.utils.APIControllersUtils;
import net.sf.jasperreports.engine.JRException;


@RestController
public class CheckListMotocicletaController implements CheckListMotocicletaAPI{

	
	
	@Autowired
	private CheckListMotocicletaService checkListserviceimp;
	 

	@Override
	public ResponseEntity<File> findByPlacaAndEmail(@PathVariable("placa")String placa , String email) throws JRException, SQLException, IOException{
		File objEntity = checkListserviceimp.findByPlacaAndEmail(placa,email);
	return ResponseEntity.ok().body(objEntity);}
	
	@Override
	public ResponseEntity<File> findByPlaca(@PathVariable("placa")String placa) throws JRException, SQLException, IOException{
		File objEntity = checkListserviceimp.findByPlaca(placa);
	return ResponseEntity.ok().body(objEntity);}
	
	@Override
	public ResponseEntity<CheckListMotocicletaEntity> findById(@PathVariable("oid") Long oid) throws Exception {
		CheckListMotocicletaEntity objEntity = checkListserviceimp.findById(oid);
		return ResponseEntity.ok().body(objEntity);		
	}



	@Override
	public ResponseEntity<CheckListMotocicletaEntity> save(CheckListMotocicletaEntity  obj) throws Exception {
		CheckListMotocicletaEntity objEntityNew =  checkListserviceimp.create(obj);
		
		URI uri = APIControllersUtils.generateURIByOid((Long) objEntityNew.getOid());
		
		return ResponseEntity.created(uri).body(objEntityNew);
	}

	@Override
	public ResponseEntity<CheckListMotocicletaEntity> update(CheckListMotocicletaEntity  obj) throws Exception {
		CheckListMotocicletaEntity objUpdated = checkListserviceimp.update(obj);
		return ResponseEntity.ok().body(objUpdated);
	}

	
	@Override
	public ResponseEntity<CheckListMotocicletaEntity> delete(@PathVariable Long oid) throws Exception {
		CheckListMotocicletaEntity objUpdated = checkListserviceimp.findById(oid);
		if(objUpdated != null) {
		checkListserviceimp.delete(oid);
		return ResponseEntity.noContent().build();
		}
		return null;
	}

	
}