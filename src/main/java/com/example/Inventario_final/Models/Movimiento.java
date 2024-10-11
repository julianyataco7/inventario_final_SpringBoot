package com.example.Inventario_final.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_tipo_movimiento", nullable = false)
    private TipoMovimiento tipoMovimiento;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "fecha_movimiento", nullable = false)
    private LocalDateTime fechaMovimiento;
    

	public Movimiento() {
		super();
	}


	public Movimiento(Integer idMovimiento, Producto producto, TipoMovimiento tipoMovimiento, Integer cantidad,
			LocalDateTime fechaMovimiento) {
		super();
		this.idMovimiento = idMovimiento;
		this.producto = producto;
		this.tipoMovimiento = tipoMovimiento;
		this.cantidad = cantidad;
		this.fechaMovimiento = fechaMovimiento;
	}


	public Integer getIdMovimiento() {
		return idMovimiento;
	}


	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}


	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public LocalDateTime getFechaMovimiento() {
		return fechaMovimiento;
	}


	public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	

	

    
}

