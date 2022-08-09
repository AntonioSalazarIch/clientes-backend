package com.et.clientes.backend.security.model.interfaces;

import java.util.List;

public interface IPermissionService {

    public List<Object> getPermissionsByUser( Long id );
}
