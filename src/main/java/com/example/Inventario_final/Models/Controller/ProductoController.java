package com.example.Inventario_final.Models.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Inventario_final.Models.MostrarProductoDTO;
import com.example.Inventario_final.Models.Producto;
import com.example.Inventario_final.Services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String mostrarVistaProductos(Model model) {
        return "VistaProducto"; // Nombre del archivo HTML sin la extensión
    }
    
    @GetMapping("/Listar")
    public ResponseEntity<?> buscarProductos() {
        try {
            List<MostrarProductoDTO> productos = productoService.ObtenerProductosTotal();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar productos: " + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarProductos(
            @RequestParam("nombreProducto") String nombreProducto,
            @RequestParam("nombreCategoria") String nombreCategoria) {
        try {
            List<MostrarProductoDTO> productos = productoService.ObtenerProductos(nombreProducto, nombreCategoria);
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar productos: " + e.getMessage());
        }
    }

    
    @GetMapping("/login") 
	public String loginPage() {
		return "login";
	}
}
