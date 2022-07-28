package com.et.clientes.backend.controller;

import com.et.clientes.backend.entity.Cliente;
import com.et.clientes.backend.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = { "http://localhost:4200" } )
@RestController
@RequestMapping( "/api" )
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping( "/clientes" )
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @GetMapping( "/clientes/{id}" )
    public Cliente findById( @PathVariable Long id ){
        return clienteService.findById( id );
    }

    @PostMapping( "/clientes" )
    @ResponseStatus( HttpStatus.CREATED )
    public Cliente create( @RequestBody Cliente cliente ){
        return clienteService.create( cliente );
    }

    @PutMapping( "/clientes/{id}" )
    @ResponseStatus( HttpStatus.OK )
    public Cliente create( @RequestBody Cliente cliente, @PathVariable Long id ){
        return clienteService.update( cliente, id );
    }

    @DeleteMapping( "/clientes/{id}" )
    public void deleteById( @PathVariable Long id ){
        clienteService.deleteById( id );
    }
}
