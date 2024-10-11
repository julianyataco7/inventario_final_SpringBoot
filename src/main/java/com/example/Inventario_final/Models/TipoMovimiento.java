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

    public TipoMovimiento(Integer idTipoMovimiento, String nombre) {
        super();
        this.idTipoMovimiento = idTipoMovimiento;
        this.nombre = nombre;
    }

    public Integer getIdTipoMovimiento() { // Método añadido
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(Integer idTipoMovimiento) { // Método corregido
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
