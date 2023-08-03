package br.com.patio.projeto.rest.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.patio.projeto.business.service.CheckListAutomovelService;
import br.com.patio.projeto.dto.CheckListAutomovelTabelaDTO;
import br.com.patio.projeto.dto.FileDto;
import br.com.patio.projeto.entity.CheckListAutomovelEntity;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;
import br.com.patio.projeto.rest.api.CheckListAutomovelAPI;
import br.com.patio.projeto.rest.api.utils.APIControllersUtils;
import net.sf.jasperreports.engine.JRException;


@RestController
public class CheckListAutomovelController implements CheckListAutomovelAPI{

	
	
	@Autowired
	private CheckListAutomovelService checkListserviceimp;
	 

	@Override
	public ResponseEntity<File> findByPlacaAndEmail(@PathVariable("placa")String placa , String email) throws JRException, SQLException, IOException{
		File objEntity = checkListserviceimp.findByPlacaAndEmail(placa,email);
	return ResponseEntity.ok().body(objEntity);}
	
	@Override
	public ResponseEntity<File> findByPlaca(@PathVariable("placa")String placa) throws JRException, SQLException, IOException{
		File objEntity = checkListserviceimp.findByPlaca(placa);
	return ResponseEntity.ok().body(objEntity);}
	
	@Override
	public ResponseEntity<CheckListAutomovelEntity> findById(@PathVariable("oid") Long oid) throws Exception {
		CheckListAutomovelEntity objEntity = checkListserviceimp.findById(oid);
		return ResponseEntity.ok().body(objEntity);		
	}



	/*@Override
	public ResponseEntity<CheckListAutomovelEntity> save(CheckListAutomovelEntity  obj, byte[] foto,
			byte[] foto_2, byte[] foto_3, byte[] foto_4, byte[] foto_5) throws Exception {
		CheckListAutomovelEntity objEntityNew =  checkListserviceimp.create(obj, foto,
				foto_2,
				foto_3,foto_4, foto_5);
		
		URI uri = APIControllersUtils.generateURIByOid((Long) objEntityNew.getOid());
		
		return ResponseEntity.created(uri).body(objEntityNew);
	}*/
    
	/*public CheckListAutomovelEntity save(CheckListAutomovelEntity obj,
			String foto, String foto_2, String foto_3, String foto_4, String foto_5, String foto_6
			   , String foto_7, String foto_8) throws Exception {
		CheckListAutomovelEntity objEntityNew =  checkListserviceimp.create(obj,foto,foto_2, foto_3, foto_4, 
				foto_5,foto_6
				   , foto_7, foto_8);
		
		//URI uri = APIControllersUtils.generateURIByOid((Long) objEntityNew.getOid());
		
		return objEntityNew;
	}*/
	
	public ResponseEntity  save(CheckListAutomovelEntity obj) throws Exception {
		CheckListAutomovelEntity objEntityNew =  checkListserviceimp.create(obj);
		
		//URI uri = APIControllersUtils.generateURIByOid((Long) objEntityNew.getOid());
		
		return ResponseEntity.ok().body(objEntityNew);
	}
	
	@Override
	public ResponseEntity<CheckListAutomovelEntity> update(CheckListAutomovelEntity  obj) throws Exception {
		CheckListAutomovelEntity objUpdated = checkListserviceimp.update(obj);
		return ResponseEntity.ok().body(objUpdated);
	}

	
	@Override
	public ResponseEntity<CheckListAutomovelEntity> delete(@PathVariable Long oid) throws Exception {
		CheckListAutomovelEntity objUpdated = checkListserviceimp.findById(oid);
		if(objUpdated != null) {
		checkListserviceimp.delete(oid);
		return ResponseEntity.noContent().build();
		}
		return null;
	}

	
	
}