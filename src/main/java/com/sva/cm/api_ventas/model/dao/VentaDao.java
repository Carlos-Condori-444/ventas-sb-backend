package com.sva.cm.api_ventas.model.dao;

import com.sva.cm.api_ventas.model.entity.Venta;
import org.springframework.data.repository.CrudRepository;

public interface VentaDao  extends CrudRepository<Venta,Integer> {

}
