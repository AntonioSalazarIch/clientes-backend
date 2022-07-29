package com.et.clientes.backend.payload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ApiResponse {

    public ResponseEntity<Object> responseSuccess( String message, Object object ){
        Map<String, Object> response = new HashMap<>();
        response.put( "error", false );
        response.put( "message", message );
        response.put( "status", HttpStatus.OK );
        response.put( "code", HttpStatus.OK.value() );
        response.put( "data", object );
        return new ResponseEntity<>( response, HttpStatus.OK );
    }

    public ResponseEntity<Object> responseCreate( String message, Object object ){
        Map<String, Object> response = new HashMap<>();
        response.put( "error", false );
        response.put( "message", message );
        response.put( "status", HttpStatus.CREATED );
        response.put( "code", HttpStatus.CREATED.value() );
        response.put( "data", object );
        return new ResponseEntity<>( response, HttpStatus.CREATED );
    }

    public ResponseEntity<Object> responseError( String message, HttpStatus status, int code, Object object, boolean error ){
        Map<String, Object> response = new HashMap<>();
        response.put( "error", error );
        response.put( "message", message );
        response.put( "status", status );
        response.put( "code", code );
        response.put( "data", object );
        return new ResponseEntity<>( response, status );
    }

}
