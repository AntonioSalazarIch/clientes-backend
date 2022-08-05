package com.et.clientes.backend.controller;

import com.et.clientes.backend.entity.Cliente;
import com.et.clientes.backend.entity.Region;
import com.et.clientes.backend.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @GetMapping( "/clientes/page/{page}" )
    public Page<Cliente> findAll( @PathVariable Integer page ){

        Pageable pageable = PageRequest.of( page, 4 );
        return clienteService.findAll( pageable );
    }

    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @Secured( { "ROLE_ADMIN", "ROLE_USER" } )
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
    @Secured( { "ROLE_ADMIN" } )
    @PostMapping( "/clientes" )
    @ResponseStatus( HttpStatus.CREATED )
    public ResponseEntity<?> create( @Valid @RequestBody Cliente cliente, BindingResult result ){

        Map<String, Object> response = new HashMap<>();
        if( result.hasErrors() ){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map( err -> "El campo '" + err.getField() +"' " + err.getDefaultMessage() )
                    .collect(Collectors.toList());
            response.put( "errors", errors );
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.BAD_REQUEST );
        }
        try{
            return clienteService.create( cliente );
        } catch ( DataAccessException e ) {
            response.put( "mensaje", "Error al realizar el insert en la base de datos" );
            response.put( "error", e.getMessage().concat(": " ).concat( e.getMostSpecificCause().getMessage() )  );
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    /**
     * Create response entity.
     *
     * @param cliente the cliente
     * @param id      the id
     * @return the response entity
     */
    @Secured( { "ROLE_ADMIN" } )
    @PutMapping( "/clientes/{id}" )
    @ResponseStatus( HttpStatus.OK )
    public ResponseEntity<?> update( @Valid @RequestBody Cliente cliente, @PathVariable Long id, BindingResult result ){

        Map<String, Object> response = new HashMap<>();
        if( result.hasErrors() ){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map( err -> "El campo '" + err.getField() +"' " + err.getDefaultMessage() )
                    .collect(Collectors.toList());
            response.put( "errors", errors );
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.BAD_REQUEST );
        }
        try{
            return clienteService.update( cliente, id );
        } catch ( DataAccessException e ) {
            response.put( "mensaje", "Error al realizar el update en la base de datos" );
            response.put( "error", e.getMessage().concat(": " ).concat( e.getMostSpecificCause().getMessage() )  );
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    /**
     * Delete by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @Secured( { "ROLE_ADMIN" } )
    @DeleteMapping( "/clientes/{id}" )
    public ResponseEntity<?> deleteById( @PathVariable Long id ){
        return clienteService.deleteById( id );
    }

    @Secured( { "ROLE_ADMIN", "ROLE_USER" } )
    @PostMapping( "/clientes/upload" )
    public ResponseEntity<?> upload(@RequestParam( "archivo" ) MultipartFile archivo, @RequestParam( "id" ) Long id ) {
        return clienteService.upload( archivo, id );
    }

    @GetMapping( "/clientes/uploads/img/{nombreFoto:.+}" )
    public ResponseEntity<?> verFoto( @PathVariable String nombreFoto ) {

        return clienteService.verFoto( nombreFoto );
    }

    @GetMapping( "/clientes/regiones" )
    public List<Region> listarRegiones() {
        return clienteService.findAllRegiones();
    }
}
