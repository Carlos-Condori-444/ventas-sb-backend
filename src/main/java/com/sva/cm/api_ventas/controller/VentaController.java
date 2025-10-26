package com.sva.cm.api_ventas.controller;

import com.sva.cm.api_ventas.model.entity.Venta;
import com.sva.cm.api_ventas.service.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VentaController {

    @Autowired
    private IVenta ventaService;

    @PostMapping("venta")
    @ResponseStatus(HttpStatus.CREATED)
    public Venta create(@RequestBody Venta venta){
        return ventaService.save(venta);
    }

    @PutMapping("venta")
    @ResponseStatus(HttpStatus.CREATED)
    public Venta update(@RequestBody Venta venta){
        return ventaService.update(venta);
    }

    @DeleteMapping("venta/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        Venta ventaDelete = ventaService.findById(id);
        ventaService.delete(ventaDelete);
    }

    @GetMapping("venta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Venta showById(@PathVariable Integer id){
        return ventaService.findById(id);
    }

    // Todos las Ventas
    @GetMapping("ventas")
    @ResponseStatus(HttpStatus.OK)
    public List<Venta> findAll(){
        return ventaService.findAll();
    }
}
