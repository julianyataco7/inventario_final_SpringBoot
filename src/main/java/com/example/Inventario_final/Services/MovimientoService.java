package com.example.Inventario_final.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inventario_final.Models.MostrarMovimientoDTO;
import com.example.Inventario_final.Models.Movimiento;
import com.example.Inventario_final.Repository.MovimientoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class MovimientoService {
	
	@Autowired
	private MovimientoRepository  movimientoRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public Movimiento insertarMovimiento(Movimiento movimiento) {
        
		try {
            return movimientoRepository.save(movimiento);
        } catch (Exception e) {
            // Loguear el error
            System.err.println("Error al insertar movimiento: " + e.getMessage());
            throw e;
        }
    }
	
	//////// METODO PARA TRAER MOVIMIENTOS TOTALES
	/*public List<MostrarMovimientoDTO> ObtenerMovimientos() {
	    // Crear la consulta almacenada con el nombre definido en la anotación @NamedStoredProcedureQuery
	    StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("Movimiento.ObtenerMovimientosTotales");

	    // Ejecutar el procedimiento almacenado y obtener la lista de resultados
	    List<Object[]> results = storedProcedure.getResultList();
	    List<MostrarMovimientoDTO> movimientos = new ArrayList<>();

	    // Mapear los resultados a MostrarMovimientoDTO
	    for (Object[] result : results) {
	        // Comprobación de que los resultados no son nulos y tienen la longitud esperada
	        if (result != null && result.length == 5) {
	            String producto = (String) result[0];         // Índice 0: PRODUCTO
	            String categoria = (String) result[1];        // Índice 1: CATEGORIA
	            String tipoMovimiento = (String) result[2];   // Índice 2: TIPO_MOVIMIENTO
	            Integer cantidad = (Integer) result[3];       // Índice 3: CANTIDAD
	            Date fechaMovimiento = (Date) result[4];      // Índice 4: FECHA

	            // Crear un nuevo objeto DTO y añadirlo a la lista
	            movimientos.add(new MostrarMovimientoDTO(producto, categoria, tipoMovimiento, cantidad, fechaMovimiento));
	        } else {
	            // Manejo de error si el resultado es nulo o no tiene la longitud esperada
	            System.err.println("Error: el resultado es nulo o no tiene la longitud esperada.");
	        }
	    }

	    return movimientos; // Retornar la lista de DTOs
	}
	*/
	///////////METODO PARA TRAER MOVIMIENTOS SI VA
	public List<MostrarMovimientoDTO> ObtenerMovimientos() {
	    // Crear la consulta almacenada con el nombre definido en la anotación @NamedStoredProcedureQuery
	    StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("Movimiento.ObtenerMovimientosTotales");

	    // Ejecutar el procedimiento almacenado y obtener la lista de resultados
	    List<MostrarMovimientoDTO> movimientos = storedProcedure.getResultList();

	    return movimientos; // Retornar la lista de DTOs
	}
	
	///////////
	public List<MostrarMovimientoDTO> ObtenerMovimientosParametrados(String fechaParam, String productoParam, String tipoMovimientoParam) {
	    // Crear la consulta almacenada con el nombre definido en la anotación @NamedStoredProcedureQuery
	    StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("Movimiento.ObtenerMovimientos");

	    // Establecer los parámetros de entrada del procedimiento almacenado
	    // Manejar fechaParam como NULL si está vacío
	    storedProcedure.setParameter("fecha_param", fechaParam != null && !fechaParam.isEmpty() ? fechaParam : null);
	    // Manejar productoParam como NULL si está vacío
	    storedProcedure.setParameter("producto_param", productoParam != null && !productoParam.isEmpty() ? productoParam : null);
	    // Manejar tipoMovimientoParam como NULL si está vacío
	    storedProcedure.setParameter("tipo_movimiento_param", tipoMovimientoParam != null && !tipoMovimientoParam.isEmpty() ? tipoMovimientoParam : null);

	    System.out.println("fechaParam: " + (fechaParam != null ? fechaParam : "NULL"));
	    System.out.println("productoParam: " + (productoParam != null ? productoParam : "NULL"));
	    System.out.println("tipoMovimientoParam: " + (tipoMovimientoParam != null ? tipoMovimientoParam : "NULL"));

	    
	    
	    // Ejecutar el procedimiento almacenado y obtener la lista de resultados
	    List<MostrarMovimientoDTO> movimientos = storedProcedure.getResultList();

	    return movimientos; // Retornar la lista de DTOs
	}



	
	//////////// METODO PARA TRAER MOVIMIENTOS POR PARAMETROS
	/*
	public List<MostrarMovimientoDTO> ObtenerMovimientosParametrados(String fechaParam, String productoParam, String tipoMovimientoParam) {
	    // Crear la consulta almacenada con el nombre definido en la anotación @NamedStoredProcedureQuery
	    StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("Movimiento.ObtenerMovimientos");

	    // Establecer los parámetros de entrada del procedimiento almacenado
	    storedProcedure.setParameter("fecha_param", fechaParam);
	    storedProcedure.setParameter("producto_param", productoParam);
	    storedProcedure.setParameter("tipo_movimiento_param", tipoMovimientoParam);

	    // Ejecutar el procedimiento almacenado y obtener la lista de resultados
	    List<Object[]> results = storedProcedure.getResultList();
	    List<MostrarMovimientoDTO> movimientos = new ArrayList<>();

	    // Mapear los resultados a MostrarMovimientoDTO
	    for (Object[] result : results) {
	        String producto = (String) result[0];         // Índice 0: PRODUCTO
	        String categoria = (String) result[1];        // Índice 1: CATEGORIA
	        String tipoMovimiento = (String) result[2];   // Índice 2: TIPO_MOVIMIENTO
	        Integer cantidad = (Integer) result[3];       // Índice 3: CANTIDAD
	        Date fechaMovimiento = (Date) result[4];      // Índice 4: FECHA_MOVIMIENTO

	        // Crear un nuevo objeto DTO y añadirlo a la lista
	        movimientos.add(new MostrarMovimientoDTO(producto, categoria, tipoMovimiento, cantidad, fechaMovimiento));
	    }

	    return movimientos; // Retornar la lista de DTOs
	}*/


	
	
}
