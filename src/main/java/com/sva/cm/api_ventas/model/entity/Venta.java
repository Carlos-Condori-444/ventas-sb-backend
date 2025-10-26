package com.sva.cm.api_ventas.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ventas")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Usuario vendedor;

    @Column(name = "plan_contratado", nullable = false, length = 100)
    private String planContratado;

    @Column(length = 50)
    private String velocidad;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "comision_vendedor", precision = 10, scale = 2)
    private BigDecimal comisionVendedor;

    private String observaciones;

    @Enumerated(EnumType.STRING)
    private EstadoVenta estado = EstadoVenta.pendiente;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta = LocalDateTime.now();

    @Column(name = "fecha_concrecion")
    private LocalDateTime fechaConcrecion;

    @Column(name = "fecha_cancelacion")
    private LocalDateTime fechaCancelacion;

    @Column(name = "motivo_cancelacion")
    private String motivoCancelacion;

    @ManyToOne
    @JoinColumn(name = "cancelado_por")
    private Usuario canceladoPor;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();

    @Column(name = "actualizado_en")
    private LocalDateTime actualizadoEn; //hacer triger

    // Enumerado para estado de venta
    public enum EstadoVenta {
        pendiente, concretada, cancelada, no_concretada
    }

    //getter and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
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

    public BigDecimal getComisionVendedor() {
        return comisionVendedor;
    }

    public void setComisionVendedor(BigDecimal comisionVendedor) {
        this.comisionVendedor = comisionVendedor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoVenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoVenta estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public LocalDateTime getFechaConcrecion() {
        return fechaConcrecion;
    }

    public void setFechaConcrecion(LocalDateTime fechaConcrecion) {
        this.fechaConcrecion = fechaConcrecion;
    }

    public LocalDateTime getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(LocalDateTime fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }

    public void setMotivoCancelacion(String motivoCancelacion) {
        this.motivoCancelacion = motivoCancelacion;
    }

    public Usuario getCanceladoPor() {
        return canceladoPor;
    }

    public void setCanceladoPor(Usuario canceladoPor) {
        this.canceladoPor = canceladoPor;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", planContratado='" + planContratado + '\'' +
                ", velocidad='" + velocidad + '\'' +
                ", precio=" + precio +
                ", comisionVendedor=" + comisionVendedor +
                ", observaciones='" + observaciones + '\'' +
                ", estado=" + estado +
                ", fechaVenta=" + fechaVenta +
                ", fechaConcrecion=" + fechaConcrecion +
                ", fechaCancelacion=" + fechaCancelacion +
                ", motivoCancelacion='" + motivoCancelacion + '\'' +
                ", canceladoPor=" + canceladoPor +
                ", creadoEn=" + creadoEn +
                ", actualizadoEn=" + actualizadoEn +
                '}';
    }
}
