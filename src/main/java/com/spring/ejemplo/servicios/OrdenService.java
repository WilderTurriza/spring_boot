package com.spring.ejemplo.servicios;

import com.spring.ejemplo.Rutas;
import com.spring.ejemplo.modelos.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {

    private final Logger logger = LoggerFactory.getLogger(Rutas.class);

    public void guardarOrden(List<Producto> productos){
        System.out.println("Guardando en la base de datos...");

        productos.forEach(producto -> logger.info("Producto: {}\nPrecio: {}",producto.nombre,producto.precio));
    }
}
