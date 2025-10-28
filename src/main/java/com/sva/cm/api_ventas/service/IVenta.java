package com.sva.cm.api_ventas.service;


import com.sva.cm.api_ventas.model.dtos.VentaCompletaRequest;
import com.sva.cm.api_ventas.model.entity.Cliente;
import com.sva.cm.api_ventas.model.entity.Venta;

import java.util.List;

public interface IVenta {
    Venta save(Venta venta);

    Venta findById(Integer id);

    void delete(Venta venta);

    //traer todos los uduarios
    List<Venta> findAll();

    //update
    Venta update(Venta venta);

    //encontrar ventas por vendedor
    List<Venta> findByVendedorId(Integer vendedorId);

    //metodo para  crear venta completa
    Venta crearVentaCompleta(VentaCompletaRequest request);
}
