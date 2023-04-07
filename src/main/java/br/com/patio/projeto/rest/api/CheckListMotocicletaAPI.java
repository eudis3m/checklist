package br.com.patio.projeto.rest.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.patio.projeto.entity.CheckListMotocicletaEntity;



@RequestMapping(value = "/checklistMotocicleta")
public interface CheckListMotocicletaAPI<T extends CheckListMotocicletaEntity>  {


   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   ResponseEntity<List<CheckListMotocicletaEntity>> save( @RequestBody CheckListMotocicletaEntity obj) throws Exception;

   @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   ResponseEntity<List<CheckListMotocicletaEntity>> update(@RequestBody CheckListMotocicletaEntity obj) throws Exception;

   @DeleteMapping(value="/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
   ResponseEntity<List<CheckListMotocicletaEntity>> delete(@PathVariable Long id) throws Exception;

   @GetMapping(value="/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.OK)
   ResponseEntity<List<CheckListMotocicletaEntity>> findById(@PathVariable("oid") Long id) throws Exception;
	
	@GetMapping(value="/email/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	 ResponseEntity<String> findByPlacaAndEmail(@PathVariable("placa") String placa , String email) throws Exception;
	
	@GetMapping(value="/placa/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	 ResponseEntity<String> findByPlaca(@PathVariable("placa") String placa) throws Exception;
	
	
}