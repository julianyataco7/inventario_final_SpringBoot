package com.example.Inventario_final.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStock;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto Idproducto;

    @Column(nullable = false)
    private Integer cantidad;
    

	public Stock() {
		super();
	}

	public Stock(Integer idStock, Producto idproducto, Integer cantidad) {
		super();
		this.idStock = idStock;
		Idproducto = idproducto;
		this.cantidad = cantidad;
	}

	public Integer getIdStock() {
		return idStock;
	}

	public void setIdStock(Integer idStock) {
		this.idStock = idStock;
	}

	public Producto getIdproducto() {
		return Idproducto;
	}

	public void setIdproducto(Producto idproducto) {
		Idproducto = idproducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	

    
}
