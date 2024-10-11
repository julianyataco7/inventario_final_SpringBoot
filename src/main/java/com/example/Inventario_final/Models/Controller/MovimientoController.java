package com.example.Inventario_final.Models.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Inventario_final.Models.Movimiento;
import com.example.Inventario_final.Services.MovimientoService;

@Controller
@RequestMapping("/movimientos")
public class MovimientoController {
	
	@Autowired
	private MovimientoService movimientoService;
	
	@PostMapping("/insertar")
    public ResponseEntity<?> insertarMovimiento(@RequestBody Movimiento movimiento) {
		
		try {
            // Lógica para guardar en la base de datos
            return ResponseEntity.ok("Movimiento guardado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el movimiento: " + e.getMessage());
        } 
		 
		
       
    }

}
