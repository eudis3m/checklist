package br.com.patio.projeto.rest.api.utils;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class APIControllersUtils {

	// Implementacao de construtor privado para impedir instancia dessa classe.
	private APIControllersUtils() {	}
	
	private static final String IDENTIFY_ELEMENT_FORMAT = "/{id}";
	
	/*
	 * Metodo que gera o location para resultados dos controladores.
	 */
	public static URI generateURIByOid(Long identify) {
		URI uri = ServletUriComponentsBuilder
			      .fromCurrentRequest()
			      .path(IDENTIFY_ELEMENT_FORMAT)
			      .buildAndExpand(identify)
			      .toUri();
		return uri;
	}
	
	public static final String DEFINITION_PAGE = "page";
	public static final String DEFINITION_LINES_PER_PAGE = "linesPerPage";
	public static final String DEFINITION_ORDER_BY = "orderBy";
	public static final String DEFINITION_DIRECTION = "direction";
	public static final String DEFINITION_FIELD = "field";
	public static final String  DEFINITION_USUARIO ="/{nmusuario}";

	public static final String DEFAULT_LINES_PER_PAGES = "24";
	public static final String DEFAULT_PAGE = "0";
	public static final String DEFAULT_ORDER_BY = "id";
	public static final String DEFAULT_DIRECTION = "ASC";
	public static final String DEFAULT_FIELD = "";
}
