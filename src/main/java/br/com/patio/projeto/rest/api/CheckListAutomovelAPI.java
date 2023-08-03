package br.com.patio.projeto.rest.api;

import java.util.List;

import org.springframework.data.repository.query.Param;
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

import br.com.patio.projeto.dto.CheckListAutomovelTabelaDTO;
import br.com.patio.projeto.entity.CheckListAutomovelEntity;




@RequestMapping(value = "/checklist")
public interface CheckListAutomovelAPI<T extends CheckListAutomovelEntity>  {


   /*@PostMapping(value = "/save")
   CheckListAutomovelEntity save(@RequestBody CheckListAutomovelEntity obj,
		   @Param(value = "foto")String foto,   @Param(value = "foto_2") String foto_2, @Param(value = "foto_3") String foto_3,
		   @Param(value = "foto_4") String foto_4, @Param(value = "foto_5") String foto_5, @Param(value = "foto_6") String foto_6
		   , @Param(value = "foto_7") String foto_7, @Param(value = "foto_8") String foto_8) throws Exception;*/
   

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE) 
   ResponseEntity<List<CheckListAutomovelEntity>> save( @RequestBody CheckListAutomovelEntity obj) throws Exception;


   @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   ResponseEntity<List<CheckListAutomovelEntity>> update(@RequestBody CheckListAutomovelEntity obj) throws Exception;

   @DeleteMapping(value="/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
   ResponseEntity<List<CheckListAutomovelEntity>> delete(@PathVariable Long id) throws Exception;

   @GetMapping(value="/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.OK)
   ResponseEntity<List<CheckListAutomovelEntity>> findById(@PathVariable("oid") Long id) throws Exception;
	
	@GetMapping(value="/email/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	 ResponseEntity<String> findByPlacaAndEmail(@PathVariable("placa") String placa , String email) throws Exception;
	
	
	@GetMapping(value="/placa/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	 ResponseEntity<String> findByPlaca(@PathVariable("placa") String placa) throws Exception;
	
	
}