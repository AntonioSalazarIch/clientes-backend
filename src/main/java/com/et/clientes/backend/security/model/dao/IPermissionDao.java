package com.et.clientes.backend.security.model.dao;

import com.et.clientes.backend.security.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPermissionDao extends JpaRepository<Permission, Long> {

    @Query(
            value = "select p.name_permission \n" +
                    "from users_roles ur, roles_permissions rp , permissions p \n" +
                    "where ur.user_id = ?\n" +
                    "and rp.role_id = ur.role_id\n" +
                    "and rp.permission_id = p.id  ",
            nativeQuery = true )
    List<Object> getPermissionsByUser( Long id );

}
