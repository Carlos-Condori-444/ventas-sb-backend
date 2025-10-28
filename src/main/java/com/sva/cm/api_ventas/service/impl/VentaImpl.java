package com.sva.cm.api_ventas.service.impl;


import com.sva.cm.api_ventas.model.dao.ClienteDao;
import com.sva.cm.api_ventas.model.dao.UsuarioDao;
import com.sva.cm.api_ventas.model.dao.VentaDao;

import com.sva.cm.api_ventas.model.dtos.ClienteVenta;
import com.sva.cm.api_ventas.model.dtos.VentaCompletaRequest;
import com.sva.cm.api_ventas.model.entity.Cliente;
import com.sva.cm.api_ventas.model.entity.Usuario;
import com.sva.cm.api_ventas.model.entity.Venta;
import com.sva.cm.api_ventas.service.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VentaImpl implements IVenta {
    @Autowired
    private VentaDao ventaDao;

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private UsuarioDao usuarioDao;

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

    @Transactional
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
    //encontrar ventas por vendedor
    @Transactional
    @Override
    public List<Venta> findByVendedorId(Integer vendedorId) {
        return ventaDao.findByVendedorId(vendedorId);
    }
    //metodo para  crear venta completa
    @Transactional
    @Override
    public Venta crearVentaCompleta(VentaCompletaRequest request) {
        // 1. Manejar el cliente (nuevo o existente)
        Cliente cliente;
        if (Boolean.TRUE.equals(request.getClienteNuevo())) {
            // Crear nuevo cliente
            ClienteVenta clienteDto = request.getCliente();

            // Verificar si el DNI ya existe
            Cliente clienteExistente = clienteDao.findByDni(clienteDto.getDni());
            if (clienteExistente != null) {
                throw new RuntimeException("El cliente con DNI " + clienteDto.getDni() + " ya existe");
            }

            cliente = new Cliente();
            cliente.setNombres(clienteDto.getNombres());
            cliente.setApellidos(clienteDto.getApellidos());
            cliente.setDni(clienteDto.getDni());
            cliente.setDireccion(clienteDto.getDireccion());
            cliente.setReferencia(clienteDto.getReferencia());
            cliente.setDistrito(clienteDto.getDistrito());
            cliente.setCelular(clienteDto.getCelular());
            cliente.setCorreo(clienteDto.getCorreo());

            // Asignar el vendedor como creador
            Usuario vendedor = usuarioDao.findById(request.getVendedorId())
                    .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
            cliente.setCreadoPor(vendedor);

            cliente = clienteDao.save(cliente);
        } else {
            // Usar cliente existente
            cliente = clienteDao.findById(request.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        }

        // 2. Crear la venta
        Venta venta = new Venta();
        venta.setCliente(cliente);

        Usuario vendedor = usuarioDao.findById(request.getVendedorId())
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
        venta.setVendedor(vendedor);

        venta.setPlanContratado(request.getPlanContratado());
        venta.setVelocidad(request.getVelocidad());
        venta.setPrecio(request.getPrecio());
        venta.setObservaciones(request.getObservaciones());

        // Calcular comisión (10% del precio como ejemplo)
        if (request.getPrecio() != null) {
            BigDecimal precio = request.getPrecio();
            BigDecimal comision = precio.multiply(new BigDecimal("0.10"));
            venta.setComisionVendedor(comision);
        }

        return ventaDao.save(venta);
    }
}
