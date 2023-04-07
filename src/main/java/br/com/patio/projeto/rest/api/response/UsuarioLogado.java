package br.com.patio.projeto.rest.api.response;

import java.io.Serializable;

import br.com.patio.projeto.util.JsonParseable;


public class UsuarioLogado implements Serializable, JsonParseable {

    private static final long serialVersionUID = 1L;

    private String token;

    private String  senha;

    private String login;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}
