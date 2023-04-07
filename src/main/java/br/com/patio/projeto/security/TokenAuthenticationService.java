package br.com.patio.projeto.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.patio.projeto.rest.api.response.UsuarioLogado;
import br.com.patio.projeto.util.JacksonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collections;
import java.util.Date;

public class TokenAuthenticationService {

    private static final String SECRET = "H7OhxeHtIss8q1MCbyK8-yEb1qtniN8Ic2US1vmkt-k5ZeNihHojn6xwFMwAkp9a";

    // EXPIRATION_TIME = 10 dias
    public static final long EXPIRATION_TIME = 860_000_000;
    public static final String TOKEN_PREFIX = "Bearer";

    public static String getToken(UsuarioLogado usuarioLogado) {
        String JWT = Jwts.builder()
                .setSubject(usuarioLogado.toJson())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        return JWT;
    }

    public static void addAuthentication(HttpServletResponse response, UsuarioLogado usuarioLogado) {
        response.addHeader(HttpHeaders.AUTHORIZATION, TOKEN_PREFIX + " " + getToken(usuarioLogado));
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null) {
            UsuarioLogado user = null;
            try {
                String json = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody()
                        .getSubject();
                user = JacksonUtils.parseJson(json, UsuarioLogado.class);
            } catch (Exception e) {
                // TODO logar execeção
            }

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
        }
        return null;
    }

}