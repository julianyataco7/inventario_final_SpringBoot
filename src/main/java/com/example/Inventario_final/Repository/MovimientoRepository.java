package com.example.Inventario_final.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario_final.Models.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

}
