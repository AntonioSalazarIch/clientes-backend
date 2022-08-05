package com.et.clientes.backend.interfaces;

import com.et.clientes.backend.dao.IClienteDao;
import com.et.clientes.backend.entity.Cliente;
import com.et.clientes.backend.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IClienteService {

    public ResponseEntity<?> findAll();

    public Page findAll( Pageable pageable );

    public ResponseEntity<?> findById( Long id );

    public ResponseEntity<?> create( Cliente cliente );

    public ResponseEntity<?> update( Cliente cliente, Long id );

    public ResponseEntity<?> deleteById( Long id );

    public ResponseEntity<?> upload( MultipartFile archivo, Long id );
    public ResponseEntity<?> verFoto( String nombreFoto );

    public List<Region> findAllRegiones();
}
