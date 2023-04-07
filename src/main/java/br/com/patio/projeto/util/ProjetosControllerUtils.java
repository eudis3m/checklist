package br.com.patio.projeto.util;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ProjetosControllerUtils {

	private ProjetosControllerUtils() {
	}
	
	public static URI generateURIByOid(Long oid) {
		URI uri = ServletUriComponentsBuilder
			      .fromCurrentRequest()
			      .path("/{id}")
			      .buildAndExpand(oid)
			      .toUri();
		return uri;

	}

}
