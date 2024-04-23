package com.spring.ejemplo;

import com.spring.ejemplo.modelos.Producto;
import com.spring.ejemplo.servicios.OrdenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Rutas {

    //private final Logger logger = LoggerFactory.getLogger(Rutas.class);

    private OrdenService ordenService;

    public Rutas (OrdenService ordenService){
        this.ordenService = ordenService;
    }

    @GetMapping("/productos/{id}")
    public Producto getProductos(@PathVariable int id){

        Producto camiseta = new Producto(1,"Camiseta", 20);
        Producto pantalones = new Producto(2,"Pantalones", 35);
        Producto zapatos = new Producto(3,"Zapatos", 50);

        List<Producto> productos = List.of(camiseta,pantalones,zapatos);

        for (Producto producto : productos) {
            if (producto.id==id) {
                return producto;
            }
        }
        return null;
    }



    @PostMapping("/orden")
    public String crearOrden(@RequestBody List<Producto> productos){
        ordenService.guardarOrden(productos);
        return "Productos guardados";
    }
}
