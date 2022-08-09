package com.et.clientes.backend.security.model.implement;

import com.et.clientes.backend.dao.IUsuarioDao;
import com.et.clientes.backend.entity.Usuario;
import com.et.clientes.backend.interfaces.IUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.et.clientes.backend.security.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserDetailsService, IUsuarioService {

    private Logger logger = LoggerFactory.getLogger( User.class );
    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional( readOnly = true )
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {

        User user = usuarioDao.findByUsername( username );

        if( user == null ){
            logger.error( "Error en el login: no existe el usuario '" + user + "' en el sistema!" );
            throw new UsernameNotFoundException( "Error en el login: no existe el usuario '" + user + "' en el sistema!" );
        }
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map( role -> new SimpleGrantedAuthority( role.getNameRole() ) )
                .peek( authority -> logger.info( "Role: " + authority.getAuthority() ) )
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                true,
                true,
                true,
                authorities );
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioDao.findByUsername( username );
    }
}
