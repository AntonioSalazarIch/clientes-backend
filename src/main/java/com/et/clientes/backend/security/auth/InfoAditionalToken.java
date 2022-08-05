package com.et.clientes.backend.security.auth;

import com.et.clientes.backend.entity.Usuario;
import com.et.clientes.backend.interfaces.IUsuarioService;
import com.et.clientes.backend.security.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAditionalToken implements TokenEnhancer {

    @Autowired
    private IUsuarioService userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = new HashMap<>();
        Usuario usuario = userService.findByUsername( authentication.getName() );
        info.put( "info_adicional", "Hola que tal: ".concat( authentication.getName() ) );
        info.put( "nombre", usuario.getNombre() );
        info.put( "apellido", usuario.getApellido() );
        info.put( "email", usuario.getEmail() );

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation( info );
        return accessToken;
    }
}
