package com.et.clientes.backend.interfaces;

import com.et.clientes.backend.entity.Usuario;
import com.et.clientes.backend.security.model.entity.User;

public interface IUsuarioService {

    public Usuario findByUsername(String username );
}
