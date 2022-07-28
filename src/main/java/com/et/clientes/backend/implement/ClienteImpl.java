package com.et.clientes.backend.implement;

import com.et.clientes.backend.dao.IClienteDao;
import com.et.clientes.backend.entity.Cliente;
import com.et.clientes.backend.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteImpl implements IClienteService {
    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional( readOnly = true )
    public List<Cliente> findAll(){
        return clienteDao.findAll();
    }

    @Override
    public Cliente findById( Long id ) {
        return clienteDao.findById( id ).orElse( null );
    }

    @Override
    public Cliente create( Cliente cliente ) {
        return clienteDao.save( cliente );
    }

    @Override
    public Cliente update( Cliente cliente, Long id ) {

        Cliente clienteActual = findById( id );
        clienteActual.setNombre( cliente.getNombre() );
        clienteActual.setApellido( cliente.getApellido() );
        clienteActual.setEmail( cliente.getEmail() );

        return clienteDao.save( clienteActual );
    }

    @Override
    public void deleteById(Long id) {
        clienteDao.deleteById( id );
    }
}
