package com.example.Inventario_final.Services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Inventario_final.Models.MostrarProductoDTO;
import com.example.Inventario_final.Models.Producto;
import com.example.Inventario_final.Repository.ProductoRepository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
///// METODO PARA TRAER EL SP DE PRODUCTOS POR CATEGRIA Y PRODUCTO
    public List<MostrarProductoDTO> ObtenerProductos(String nombreProducto, String nombreCategoria) {
        StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("Producto.ObtenerProductos");
        
        // Setear parámetros
        storedProcedure.setParameter("nombreProducto", nombreProducto);
        storedProcedure.setParameter("nombreCategoria", nombreCategoria);

        // Ejecutar el procedimiento
        List<Object[]> results = storedProcedure.getResultList();
        List<MostrarProductoDTO> productos = new ArrayList<>();

        // Mapear resultados a MostrarProductoDTO
        for (Object[] result : results) {
            Integer idProducto = (Integer) result[0];  // Asegúrate de que este índice coincide
            String nombre = (String) result[1];         // Asegúrate de que este índice coincide
            String categoria = (String) result[2];      // Asegúrate de que este índice coincide
            BigDecimal precio = (BigDecimal) result[3]; // Asegúrate de que este índice coincide
            Integer cantidad = (Integer) result[4];     // Asegúrate de que este índice coincide

            productos.add(new MostrarProductoDTO(idProducto, nombre, categoria, precio, cantidad));
        }

        return productos; // Retornar la lista de DTOs
    }
    
///////////////// METODO PARA TRAER TODOS LOS PRODUCTOS CON SP
    public List<MostrarProductoDTO> ObtenerProductosTotal() {  // Eliminar los parámetros, ya que no se usan
        StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("Producto.ObtenerProductosTotal");

        // Ejecutar el procedimiento almacenado
        List<Object[]> results = storedProcedure.getResultList();
        List<MostrarProductoDTO> productos = new ArrayList<>();

        // Mapear resultados a MostrarProductoDTO
        for (Object[] result : results) {
            Integer idProducto = (Integer) result[0];  // Asegúrate de que este índice coincide
            String nombre = (String) result[1];         // Asegúrate de que este índice coincide
            String categoria = (String) result[2];      // Asegúrate de que este índice coincide
            BigDecimal precio = (BigDecimal) result[3]; // Asegúrate de que este índice coincide
            Integer cantidad = (Integer) result[4];     // Asegúrate de que este índice coincide

            productos.add(new MostrarProductoDTO(idProducto, nombre, categoria, precio, cantidad));
        }

        return productos; // Retornar la lista de DTOs
    }

       
        
        public List<Producto> getAllProducto(){
    		return productoRepository.findAll();
    	}
        
      
    }

