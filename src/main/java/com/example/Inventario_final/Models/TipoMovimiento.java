package com.example.Inventario_final.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_movimiento")
public class TipoMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoMovimiento;

    @Column(nullable = false, length = 25)
    private String nombre;
    
    
	public TipoMovimiento() {
		super();
	}

	public TipoMovimiento(Integer idTipo, String nombre) {
		super();
		this.idTipoMovimiento = idTipo;
		this.nombre = nombre;
	}

	public Integer getIdTipo() {
		return idTipoMovimiento;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipoMovimiento = idTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    
}

