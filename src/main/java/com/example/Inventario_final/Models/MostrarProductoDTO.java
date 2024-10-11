package com.example.Inventario_final.Models;

import java.math.BigDecimal;

public class MostrarProductoDTO {
    private Integer idProducto;
    private String producto;
    private String categoria;
    private BigDecimal precio;
    private Integer cantidad;
    
    

    public MostrarProductoDTO() {
		
	}

	// Constructor, getters, and setters
    public MostrarProductoDTO(Integer idProducto, String producto, String categoria, BigDecimal precio, Integer cantidad) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
