package com.et.clientes.backend.dao;

import com.et.clientes.backend.entity.Usuario;
import com.et.clientes.backend.security.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username );
}
