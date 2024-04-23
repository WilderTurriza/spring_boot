package com.spring.ejemplo;

import com.spring.ejemplo.modelos.Producto;
import com.spring.ejemplo.servicios.OrdenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Rutas {

    //private final Logger logger = LoggerFactory.getLogger(Rutas.class);

    private final OrdenService ordenService;

    public Rutas (OrdenService ordenService){
        this.ordenService = ordenService;
    }

    @GetMapping("/productos/{id}")
    public Producto getProductos(@PathVariable int id){

        Map<Integer, Producto> productos = new HashMap<>();
        productos.put(1, new Producto(1,"Camiseta", 20));
        productos.put(2, new Producto(2,"Pantalones", 35));
        productos.put(3, new Producto(3,"Zapatos", 50));

        return productos.getOrDefault(id,null);
    }



    @PostMapping("/orden")
    public String crearOrden(@RequestBody List<Producto> productos){
        ordenService.guardarOrden(productos);
        return "Productos guardados";
    }
}
