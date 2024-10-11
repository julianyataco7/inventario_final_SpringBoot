package com.example.Inventario_final.Models;

import java.time.LocalDateTime;
import java.util.Date;

public class MostrarMovimientoDTO {

    private String nombreProducto;
    private String categoria;
    private String tipoMovimiento;
    private Integer cantidad;
    private Date fechaMovimiento;
    
	public MostrarMovimientoDTO() {
		super();
	}

	public MostrarMovimientoDTO(String nombreProducto, String categoria, String tipoMovimiento, Integer cantidad,
			Date fechaMovimiento) {
		super();
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.tipoMovimiento = tipoMovimiento;
		this.cantidad = cantidad;
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	
	

    
    
    

    
}

