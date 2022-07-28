package com.et.clientes.backend.dao;

import com.et.clientes.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
}
