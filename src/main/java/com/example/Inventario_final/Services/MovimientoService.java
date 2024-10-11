package com.example.Inventario_final.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inventario_final.Models.Movimiento;
import com.example.Inventario_final.Repository.MovimientoRepository;

@Service
public class MovimientoService {
	
	@Autowired
	private MovimientoRepository  movimientoRepository;
	
	public Movimiento insertarMovimiento(Movimiento movimiento) {
        
		try {
            return movimientoRepository.save(movimiento);
        } catch (Exception e) {
            // Loguear el error
            System.err.println("Error al insertar movimiento: " + e.getMessage());
            throw e;
        }
    }
	
	
}
