package com.example.Inventario_final.Models.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Inventario_final.Models.Movimiento;
import com.example.Inventario_final.Models.TipoMovimiento;
import com.example.Inventario_final.Services.MovimientoService;
import com.example.Inventario_final.Services.TipoMovimientoService;
import com.example.Inventario_final.Exceptions.ResourceNotFoundException; // Asegúrate de que la importación sea correcta

@Controller
@RequestMapping("/movimientos")
public class MovimientoController {
	
	@Autowired
	private MovimientoService movimientoService;
	
	@Autowired
	private TipoMovimientoService tipoMovimientoService;
	
	@PostMapping("/insertar")
	public ResponseEntity<?> insertarMovimiento(@RequestBody Movimiento movimiento) {
	    try {
	        // Cargar el tipo de movimiento desde el servicio
	        TipoMovimiento tipoMovimiento = tipoMovimientoService.findById(movimiento.getTipoMovimiento().getIdTipoMovimiento())
	                .orElseThrow(() -> new ResourceNotFoundException("Tipo de movimiento no encontrado"));

	        // Asignar el tipo de movimiento cargado al movimiento
	        movimiento.setTipoMovimiento(tipoMovimiento);
	        
	        // Guardar el movimiento
	        movimientoService.insertarMovimiento(movimiento);
	        
	        return ResponseEntity.ok("Movimiento guardado con éxito.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el movimiento: " + e.getMessage());
	    }
	}
}
