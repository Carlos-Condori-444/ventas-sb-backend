package com.sva.cm.api_ventas.model.dao;

import com.sva.cm.api_ventas.model.entity.Venta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VentaDao  extends CrudRepository<Venta,Integer> {

    List<Venta> findByVendedorId(Integer vendedorId);

}
