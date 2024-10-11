package com.example.Inventario_final.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.Inventario_final.Models.Categoria;
import com.example.Inventario_final.Models.TipoMovimiento;
import com.example.Inventario_final.Repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired 
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> ListarCategoria() {
		
		return categoriaRepository.findAll();
	}
	
	public Optional<Categoria> buscarId(Integer id){
		return categoriaRepository.findById(id);
	}
	
	

}
