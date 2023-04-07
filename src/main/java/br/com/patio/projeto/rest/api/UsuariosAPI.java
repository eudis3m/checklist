package br.com.patio.projeto.rest.api;

import java.util.List;

import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
//import br.com.ibrowse.projeto.dto.UsuarioTabelaDTO;
import br.com.patio.projeto.entity.UsuarioEntity;
import br.com.patio.projeto.rest.api.utils.APIControllersUtils;
import br.com.patio.projeto.entity.RetiraVeiculoEntity;
import br.com.patio.projeto.entity.UsuarioEntity;


@RequestMapping(value = "/usuarios")
public interface UsuariosAPI<T extends UsuarioEntity>  {

	
	   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<UsuarioEntity>> save( @RequestBody UsuarioEntity obj) throws Exception;

	   @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<UsuarioEntity>> update(@RequestBody UsuarioEntity obj) throws Exception;

	   @DeleteMapping(value="/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<UsuarioEntity>> delete(@PathVariable Long id) throws Exception;

	   @GetMapping(value="/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
	   @ResponseStatus(HttpStatus.OK)
	   ResponseEntity<List<UsuarioEntity>> findById(@PathVariable("oid") Long id) throws Exception;
	
	   @GetMapping(value="/dsLogin/{dsLogin}", produces = MediaType.APPLICATION_JSON_VALUE)
	   @ResponseStatus(HttpStatus.OK)
	   ResponseEntity<List<UsuarioEntity>> findByDslogin(@PathVariable("dsLogin") String dslogin) throws Exception;
	
	   @GetMapping(value="/nrcpf/{nrcpf}", produces = MediaType.APPLICATION_JSON_VALUE)
	   @ResponseStatus(HttpStatus.OK)
	   ResponseEntity<List<UsuarioEntity>> findByNrCpf(@PathVariable("nrcpf") String nrcpf) throws Exception;
	
	
	
}