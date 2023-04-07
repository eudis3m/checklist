package br.com.patio.projeto.rest.api;

import java.text.DateFormat;
import java.util.Date;
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

import br.com.patio.projeto.entity.RetiraVeiculoEntity;

@RequestMapping(value = "/retiraveiculo")
public interface RetiraVeiculoAPI<T extends RetiraVeiculoEntity>  {


	   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<RetiraVeiculoEntity>> save( @RequestBody RetiraVeiculoEntity obj) throws Exception;

	   @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<RetiraVeiculoEntity>> update(@RequestBody RetiraVeiculoEntity obj) throws Exception;

	   @DeleteMapping(value="/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<RetiraVeiculoEntity>> delete(@PathVariable Long id) throws Exception;

	   @GetMapping(value="/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
	   @ResponseStatus(HttpStatus.OK)
	   ResponseEntity<List<RetiraVeiculoEntity>> findById(@PathVariable("oid") Long id) throws Exception;
		
		@GetMapping(value="/consultaVeiculo/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		 ResponseEntity<RetiraVeiculoEntity> findByPlacaVeiculo(@PathVariable("placa") String placa) throws Exception;
		
		@GetMapping(value="/consulta/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		 ResponseEntity<RetiraVeiculoEntity> findByPlaca(@PathVariable("placa") String placa) throws Exception;
		
		@GetMapping(value="/consultaMotocicleta/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		 ResponseEntity<RetiraVeiculoEntity> findByPlacaMotocicleta(@PathVariable("placa") String placa) throws Exception;
		
		@GetMapping(value="/relatorio/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		 ResponseEntity<String> findByRelatorio(@PathVariable("placa") String placa, String email) throws Exception;
		

		
		
	}
