package com.example.Inventario_final.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario_final.Models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	

}
