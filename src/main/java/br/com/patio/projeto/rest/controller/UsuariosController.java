package br.com.patio.projeto.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.patio.projeto.business.service.UsuarioService;
import br.com.patio.projeto.entity.UsuarioEntity;
//import br.com.patio.projeto.dto.UsuarioTabelaDTO;
//import br.com.patio.projeto.entity.EmpresaEntity;
import br.com.patio.projeto.entity.UsuarioEntity;
import br.com.patio.projeto.rest.api.UsuariosAPI;
import br.com.patio.projeto.rest.api.utils.APIControllersUtils;
import br.com.patio.projeto.util.ProjetosControllerUtils;

@RestController
public class UsuariosController  implements UsuariosAPI {

	@Autowired
	private UsuarioService usuarioService;
	

	@Override
	public ResponseEntity<List<UsuarioEntity>> findByDslogin(@PathVariable("dsLogin") String dsLogin) throws Exception {
		return ResponseEntity.ok().body(usuarioService.findByDslogin(dsLogin));
	}

	@Override
	public ResponseEntity<List<UsuarioEntity>> findByNrCpf(@PathVariable("nrcnpj") String nrcnpj) throws Exception {
		return ResponseEntity.ok().body(usuarioService.findByNrcpf(nrcnpj));
	}

	@Override
	public ResponseEntity<UsuarioEntity> save(UsuarioEntity obj) throws Exception {
		UsuarioEntity objEntityNew =  usuarioService.create(obj);
		
		URI uri = APIControllersUtils.generateURIByOid((Long) objEntityNew.getOid());
		
		return ResponseEntity.created(uri).body(objEntityNew);
	}

	@Override
	public ResponseEntity<UsuarioEntity> update(UsuarioEntity obj) throws Exception {
		UsuarioEntity objUpdated = usuarioService.update(obj);
		return ResponseEntity.ok().body(objUpdated);
	}

	@Override
	public ResponseEntity<UsuarioEntity> delete(Long oid) throws Exception {
		UsuarioEntity objUpdated = usuarioService.findById(oid);
		if(objUpdated != null) {
			usuarioService.delete(oid);
		return ResponseEntity.noContent().build();
		}
		return null;
	}

	@Override
	public ResponseEntity<UsuarioEntity> findById(Long oid) throws Exception {
		UsuarioEntity objEntity = usuarioService.findById(oid);
		return ResponseEntity.ok().body(objEntity);
	}

}