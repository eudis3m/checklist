package br.com.patio.projeto.rest.api;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.patio.projeto.rest.api.request.LoginRequest;
import br.com.patio.projeto.rest.api.response.UsuarioLogado;


public interface LoginAPI {
 
	@RequestMapping( path = "/login", method = RequestMethod.POST )
	ResponseEntity<UsuarioLogado> login(@RequestBody @Valid LoginRequest loginRequest, HttpServletResponse response);


}
