package com.sva.cm.api_ventas.service;

import com.sva.cm.api_ventas.model.entity.Cliente;
import com.sva.cm.api_ventas.model.entity.Usuario;

import java.util.List;

public interface ICliente {

    Cliente save(Cliente cliente);

    Cliente findById(Integer id);

    void delete(Cliente cliente);

    List<Cliente> findAll();

    //update
    Cliente update(Cliente cliente);
}
