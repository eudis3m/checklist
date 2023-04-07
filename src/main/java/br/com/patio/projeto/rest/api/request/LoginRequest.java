package br.com.patio.projeto.rest.api.request;

import java.io.Serializable;

import br.com.patio.projeto.util.JsonParseable;

public class LoginRequest implements Serializable, JsonParseable {

    private static final long serialVersionUID = 1L;

  
    private String login;

  
    private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
