package com.et.clientes.backend.security.model.controller;

import com.et.clientes.backend.security.model.implement.PermissionImpl;
import com.et.clientes.backend.security.model.interfaces.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/api")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @GetMapping( "/permissions/{id}" )
    public List<Object> getPermissionByUser( @PathVariable Long id ){
        return permissionService.getPermissionsByUser( id );
    }
}
