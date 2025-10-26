package com.sva.cm.api_ventas.service.impl;


import com.sva.cm.api_ventas.model.dao.VentaDao;

import com.sva.cm.api_ventas.model.entity.Venta;
import com.sva.cm.api_ventas.service.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaImpl implements IVenta {
    @Autowired
    private VentaDao ventaDao;

    @Transactional
    @Override
    public Venta save(Venta venta) {
        return ventaDao.save(venta);
    }

    @Transactional(readOnly = true)
    @Override
    public Venta findById(Integer id) {
        return ventaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Venta venta) {
        ventaDao.delete(venta);
    }

    //traer todos los usuarios
    @Transactional(readOnly = true)
    @Override
    public List<Venta> findAll() {
        return (List<Venta>) ventaDao.findAll();
    }

    @Override
    public Venta update(Venta venta) {
        if (venta.getId() == null) {
            throw new RuntimeException("ID es requerido para actualizar venta");
        }

        Venta ventaExistente = ventaDao.findById(venta.getId())
                .orElseThrow(() -> new RuntimeException("Venta no encontrado con ID: " + venta.getId()));

        // Actualizar solo campos modificables
        ventaExistente.setCliente(venta.getCliente());
        ventaExistente.setVendedor(venta.getVendedor());
        ventaExistente.setPlanContratado(venta.getPlanContratado());
        ventaExistente.setVelocidad(venta.getVelocidad());
        ventaExistente.setPrecio(venta.getPrecio());
        ventaExistente.setComisionVendedor(venta.getComisionVendedor());
        ventaExistente.setObservaciones(venta.getObservaciones());
        ventaExistente.setEstado(venta.getEstado());
        ventaExistente.setFechaConcrecion(venta.getFechaConcrecion());
        ventaExistente.setFechaCancelacion(venta.getFechaCancelacion());
        ventaExistente.setMotivoCancelacion(venta.getMotivoCancelacion());
        ventaExistente.setCanceladoPor(venta.getCanceladoPor());

        // NO actualizar fechaVenta, creadoEn - se mantienen los originales
        // actualizadoEn se actualizará por el trigger

        return ventaDao.save(ventaExistente);
    }
}
