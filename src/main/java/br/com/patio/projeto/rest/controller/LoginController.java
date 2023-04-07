package br.com.patio.projeto.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patio.projeto.business.service.LoginService;
import br.com.patio.projeto.rest.api.LoginAPI;
import br.com.patio.projeto.rest.api.request.LoginRequest;
import br.com.patio.projeto.rest.api.response.UsuarioLogado;
import br.com.patio.projeto.security.TokenAuthenticationService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public  class LoginController  implements LoginAPI {

    @Autowired
    private LoginService loginService;
  
    @Override
    public ResponseEntity<UsuarioLogado> login(@RequestBody @Valid LoginRequest loginRequest, HttpServletResponse response) {
       UsuarioLogado usuarioLogado = loginService.login(loginRequest.getLogin(), loginRequest.getSenha());
        if(usuarioLogado != null) {
        	usuarioLogado.setToken(TokenAuthenticationService.getToken(usuarioLogado));
        	TokenAuthenticationService.addAuthentication(response, usuarioLogado);
        }
        return ResponseEntity.ok().body(usuarioLogado);
    }

}