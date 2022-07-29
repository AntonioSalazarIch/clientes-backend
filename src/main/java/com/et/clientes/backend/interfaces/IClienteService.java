package com.et.clientes.backend.interfaces;

import com.et.clientes.backend.dao.IClienteDao;
import com.et.clientes.backend.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClienteService {

    public ResponseEntity<?> findAll();

    public ResponseEntity<?> findById( Long id );

    public ResponseEntity<?> create( Cliente cliente );

    public ResponseEntity<?> update( Cliente cliente, Long id );

    public ResponseEntity<?> deleteById(Long id );
}
