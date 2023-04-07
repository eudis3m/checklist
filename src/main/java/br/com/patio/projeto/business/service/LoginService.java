 package br.com.patio.projeto.business.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.patio.projeto.data.repository.UsuarioRepository;
import br.com.patio.projeto.entity.UsuarioEntity;
import br.com.patio.projeto.helper.LoginHelper;
import br.com.patio.projeto.rest.api.response.UsuarioLogado;




@Service("loginService")
public class LoginService {

	@Autowired
	private UsuarioRepository usuarioRepository ;
	
	@Autowired
	public LoginService(UsuarioRepository usuarioRepository ) {
			this.usuarioRepository = usuarioRepository;
		};
	


	public UsuarioLogado login(String login, String senha) {

    	UsuarioEntity usuario = usuarioRepository.findByDsLoginAndDssenha(login, senha);
         if (usuario != null) {
        	 usuario.setDsLogin(login);
           	 usuario.setDSSenha(senha);
             UsuarioLogado usuarioLogado = LoginHelper.fromUsuario(usuario);
             return usuarioLogado;
         }
         return null;
     }




}
