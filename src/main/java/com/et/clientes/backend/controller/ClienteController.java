package com.et.clientes.backend.controller;

import com.et.clientes.backend.entity.Cliente;
import com.et.clientes.backend.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Class Cliente controller.
 */
@CrossOrigin( origins = { "http://localhost:4200" } )
@RestController
@RequestMapping( "/api" )
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @GetMapping( "/clientes" )
    public ResponseEntity<?> findAll(){
        return clienteService.findAll();
    }

    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping( "/clientes/{id}" )
    public ResponseEntity<?> findById( @PathVariable Long id ){
        return clienteService.findById( id );
    }

    /**
     * Create response entity.
     *
     * @param cliente the cliente
     * @return the response entity
     */
    @PostMapping( "/clientes" )
    @ResponseStatus( HttpStatus.CREATED )
    public ResponseEntity<?> create( @RequestBody Cliente cliente ){
        return clienteService.create( cliente );
    }

    /**
     * Create response entity.
     *
     * @param cliente the cliente
     * @param id      the id
     * @return the response entity
     */
    @PutMapping( "/clientes/{id}" )
    @ResponseStatus( HttpStatus.OK )
    public ResponseEntity<?> create( @RequestBody Cliente cliente, @PathVariable Long id ){
        return clienteService.update( cliente, id );
    }

    /**
     * Delete by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping( "/clientes/{id}" )
    public ResponseEntity<?> deleteById( @PathVariable Long id ){
        return clienteService.deleteById( id );
    }
}
