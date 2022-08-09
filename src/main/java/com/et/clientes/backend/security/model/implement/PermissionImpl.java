package com.et.clientes.backend.security.model.implement;

import com.et.clientes.backend.security.model.dao.IPermissionDao;
import com.et.clientes.backend.security.model.interfaces.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Object> getPermissionsByUser( Long id ) {
        return permissionDao.getPermissionsByUser( id );
    }
}
