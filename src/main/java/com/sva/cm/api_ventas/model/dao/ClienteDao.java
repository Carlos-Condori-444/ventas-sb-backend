package com.sva.cm.api_ventas.model.dao;

import com.sva.cm.api_ventas.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente,Integer> {

    Cliente findByDni(String dni);
}
