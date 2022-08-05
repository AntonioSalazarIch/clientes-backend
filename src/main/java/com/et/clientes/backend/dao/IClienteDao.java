package com.et.clientes.backend.dao;

import com.et.clientes.backend.entity.Cliente;
import com.et.clientes.backend.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
    @Query( "from Region" )
    public List<Region> findAllRegiones();
}
