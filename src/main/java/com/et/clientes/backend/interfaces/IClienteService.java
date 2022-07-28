package com.et.clientes.backend.interfaces;

import com.et.clientes.backend.dao.IClienteDao;
import com.et.clientes.backend.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();

    public Cliente findById( Long id );

    public Cliente create( Cliente cliente );

    public Cliente update( Cliente cliente, Long id );

    public void deleteById(Long id );
}
