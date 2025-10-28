package com.sva.cm.api_ventas.model.dtos;

import java.math.BigDecimal;

public class VentaCompletaRequest {
    // Datos del cliente (nuevo o existente)
    private ClienteVenta cliente;
    private Boolean clienteNuevo; // true si es nuevo cliente, false si existe

    // Datos de la venta
    private Integer vendedorId;
    private String planContratado;
    private String velocidad;
    private BigDecimal precio;
    private String observaciones;

    public ClienteVenta getCliente() {
        return cliente;
    }
    public void setCliente(ClienteVenta cliente) {
        this.cliente = cliente;
    }
    public Boolean getClienteNuevo() {
        return clienteNuevo;
    }
    public void setClienteNuevo(Boolean clienteNuevo) {
        this.clienteNuevo = clienteNuevo;
    }
    public Integer getVendedorId() {
        return vendedorId;
    }
    public void setVendedorId(Integer vendedorId) {
        this.vendedorId = vendedorId;
    }
    public String getPlanContratado() {
        return planContratado;
    }
    public void setPlanContratado(String planContratado) {
        this.planContratado = planContratado;
    }
    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
