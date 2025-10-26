package com.sva.cm.api_ventas.service.impl;

import com.sva.cm.api_ventas.model.dao.ClienteDao;
import com.sva.cm.api_ventas.model.entity.Cliente;
import com.sva.cm.api_ventas.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClienteImpl implements ICliente {

    @Autowired
    private ClienteDao ClienteDao;

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return ClienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return ClienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        ClienteDao.delete(cliente);
    }

    //traer todos los clientes
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) ClienteDao.findAll();
    }

    @Override
    public Cliente update(Cliente cliente) {
        if (cliente.getId() == null) {
            throw new RuntimeException("ID es requerido para actualizar cliente");
        }

        Cliente clienteExistente = ClienteDao.findById(cliente.getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + cliente.getId()));

        // Actualizar solo campos modificables
        clienteExistente.setNombres(cliente.getNombres());
        clienteExistente.setApellidos(cliente.getApellidos());
        clienteExistente.setDni(cliente.getDni());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setReferencia(cliente.getReferencia());
        clienteExistente.setDistrito(cliente.getDistrito());
        clienteExistente.setCelular(cliente.getCelular());
        clienteExistente.setCorreo(cliente.getCorreo());

        // NO actualizar creadoPor ni creadoEn - se mantienen los originales
        // actualizadoEn se actualizará por el trigger

        return ClienteDao.save(clienteExistente);
    }

}
