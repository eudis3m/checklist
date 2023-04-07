package br.com.patio.projeto.helper;

import br.com.patio.projeto.entity.UsuarioEntity;
import br.com.patio.projeto.rest.api.response.UsuarioLogado;

public final class LoginHelper {

    public static UsuarioLogado fromUsuario(UsuarioEntity usuario) {
        UsuarioLogado usuarioLogado = new UsuarioLogado();
        usuarioLogado.setSenha(usuario.getDSSenha());
        usuarioLogado.setLogin(usuario.getNMUsuario());
        return usuarioLogado;
    }

}
