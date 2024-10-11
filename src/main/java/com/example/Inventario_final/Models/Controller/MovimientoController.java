package com.example.Inventario_final.Models.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Inventario_final.Models.MostrarMovimientoDTO;
import com.example.Inventario_final.Models.MostrarProductoDTO;
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
	
	@GetMapping("")
	public String mostrarVistaMovimiento() {
		return "VerMovimientos";
	}
	
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
	
	@GetMapping("/listar")
    public ResponseEntity<?> buscarProductos() {
        try {
            List<MostrarMovimientoDTO> movimientos = movimientoService.ObtenerMovimientos();
            return ResponseEntity.ok(movimientos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar movimiento: " + e.getMessage());
        }
    }
	
	@PostMapping("/buscar")
	public ResponseEntity<?> buscarProductos(
	        @RequestBody MostrarMovimientoDTO mdto) {
	    try {
	        String fechaParam = null;

	        if (mdto.getFechaMovimiento() != null) {
	            // Convertir el String de fecha a Date
	            Date fechaMovimiento = mdto.getFechaMovimiento();
	            
	            // Convertir a ZonedDateTime en la zona horaria UTC
	            ZonedDateTime zonedDateTime = fechaMovimiento.toInstant()
	                .atZone(ZoneId.of("UTC")); // Asegúrate de que esta es la zona correcta

	            // Convertir a LocalDate
	            LocalDate localDate = zonedDateTime.toLocalDate();

	            // Formatear a "YYYY-MM-DD"
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            fechaParam = localDate.format(formatter);
	        }

	        String productoParam = (mdto.getNombreProducto() != null && !mdto.getNombreProducto().isEmpty())
	                ? mdto.getNombreProducto()
	                : null;

	        String tipoMovimientoParam = (mdto.getTipoMovimiento() != null && !mdto.getTipoMovimiento().isEmpty())
	                ? mdto.getTipoMovimiento()
	                : null;

	        // Imprimir los parámetros en consola para verificar lo que se envía
	        System.out.println("controllerFecha: " + fechaParam);
	        System.out.println("controllerProducto: " + productoParam);
	        System.out.println("controllerMovimiento: " + tipoMovimientoParam);

	        // Llama al servicio y pasa los valores de fecha, producto y tipoMovimiento
	        List<MostrarMovimientoDTO> movimiento = movimientoService.ObtenerMovimientosParametrados(
	                fechaParam,
	                productoParam,
	                tipoMovimientoParam
	        );

	        // Devuelve la lista de movimientos en la respuesta
	        return ResponseEntity.ok(movimiento);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Error al buscar productos: " + e.getMessage());
	    }
	}

}
