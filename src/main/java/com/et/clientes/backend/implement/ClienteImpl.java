package com.et.clientes.backend.implement;

import com.et.clientes.backend.dao.IClienteDao;
import com.et.clientes.backend.entity.Cliente;
import com.et.clientes.backend.entity.Region;
import com.et.clientes.backend.exceptions.RecordNotFoundException;
import com.et.clientes.backend.interfaces.IClienteService;
import com.et.clientes.backend.interfaces.IUploadFile;
import com.et.clientes.backend.payload.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import static com.et.clientes.backend.utils.Constants.*;

@Service
public class ClienteImpl implements IClienteService {
    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IUploadFile uploadFile;
    @Autowired
    ApiResponse apiResponse;

    private final Logger log = LoggerFactory.getLogger( ClienteImpl.class );
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
    @Transactional( readOnly = true )
    public Page findAll(Pageable pageable) {
        return clienteDao.findAll( pageable );
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
        clienteActual.setRegion( cliente.getRegion() );

        clienteDao.save( clienteActual );
        return apiResponse.responseSuccess( successsMessage, clienteActual );
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        String successsMessage = RECORDS_FOUND;
        String errorMessage = CLIENTES_NOT_FOUND + ": " + id;

        Cliente clienteActual = clienteDao.findById( id ).orElseThrow( () -> new RecordNotFoundException( errorMessage ) );

        String nombreFotoAnterior = clienteActual.getFoto();
        uploadFile.eliminar( nombreFotoAnterior );
        clienteDao.deleteById( id );
        return apiResponse.responseSuccess( successsMessage, clienteActual );
    }

    @Override
    public ResponseEntity<?> upload( MultipartFile archivo, Long id ) {
        String successsMessage = "Imagen subida correctamente";
        String errorMessage = CLIENTES_NOT_FOUND + ": " + id;
        Cliente cliente = clienteDao.findById( id ).orElseThrow( () -> new RecordNotFoundException( errorMessage ) );

        if( !archivo.isEmpty() ){
            String nombreArchivo = null;
            try {
               uploadFile.copiar( archivo );
            } catch (IOException e) {
                return apiResponse.responseError(
                        e.getCause().getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        500,
                        nombreArchivo,
                        true );
            }

            String nombreFotoAnterior = cliente.getFoto();

            uploadFile.eliminar( nombreFotoAnterior );

            cliente.setFoto( nombreArchivo );
            clienteDao.save( cliente );
        }
        return apiResponse.responseSuccess( successsMessage, cliente );
    }

    @Override
    public ResponseEntity<Resource> verFoto(String nombreFoto) {

        Resource recurso = null;
        try {
            uploadFile.cargar( nombreFoto );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"" );
        return new ResponseEntity<Resource>( recurso, cabecera, HttpStatus.OK );
    }

    @Override
    @Transactional( readOnly = true )
    public List<Region> findAllRegiones() {
        return clienteDao.findAllRegiones();
    }
}
