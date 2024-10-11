package com.example.Inventario_final.Models.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Inventario_final.Services.CategoriaService;
import com.example.Inventario_final.Models.Categoria;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> ListarCategoria(){		
		List<Categoria> categoria= categoriaService.ListarCategoria();
		return ResponseEntity.ok(categoria);
	}

}
