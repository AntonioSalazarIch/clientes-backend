package com.et.clientes.backend.implement;

import com.et.clientes.backend.dao.IClienteDao;
import com.et.clientes.backend.entity.Cliente;
import com.et.clientes.backend.exceptions.RecordNotFoundException;
import com.et.clientes.backend.interfaces.IClienteService;
import com.et.clientes.backend.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.et.clientes.backend.utils.Constants.*;

@Service
public class ClienteImpl implements IClienteService {
    @Autowired
    private IClienteDao clienteDao;
    @Autowired
    ApiResponse apiResponse;
    @Override
    @Transactional( readOnly = true )
    public ResponseEntity<?> findAll(){

        String successsMessage = RECORDS_FOUND;
        String errorMessage = TABLE_NOT_FOUND + ": " + CLIENTES;
        if( !clienteDao.findAll().isEmpty() ){
            return  apiResponse.responseSuccess( successsMessage, clienteDao.findAll() );
        } else{
            throw new RecordNotFoundException( errorMessage );
        }
    }

    @Override
    public ResponseEntity<?> findById( Long id ) {

        String successsMessage = RECORDS_FOUND;
        String errorMessage = CLIENTES_NOT_FOUND + ": " + id;
        return apiResponse.responseSuccess(
                successsMessage,
                clienteDao.findById( id ).orElseThrow( () -> new RecordNotFoundException( errorMessage )
                )
        );
    }

    @Override
    public ResponseEntity<?> create( Cliente cliente ) {
        return apiResponse.responseCreate( RECORD_CREATED, clienteDao.save( cliente ) );
    }

    @Override
    public ResponseEntity<?> update( Cliente cliente, Long id ) {

        String successsMessage = RECORDS_FOUND;
        String errorMessage = TABLE_NOT_FOUND + ": " + CLIENTES;

        Cliente clienteActual = clienteDao.findById( id ).orElseThrow( () -> new RecordNotFoundException( errorMessage ) );
        clienteActual.setNombre( cliente.getNombre() );
        clienteActual.setApellido( cliente.getApellido() );
        clienteActual.setEmail( cliente.getEmail() );

        return apiResponse.responseSuccess( successsMessage, clienteActual );
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        String successsMessage = RECORDS_FOUND;
        String errorMessage = CLIENTES_NOT_FOUND + ": " + id;

        Cliente clienteActual = clienteDao.findById( id ).orElseThrow( () -> new RecordNotFoundException( errorMessage ) );
        clienteDao.deleteById( id );
        return apiResponse.responseSuccess( successsMessage, clienteActual );
    }
}
