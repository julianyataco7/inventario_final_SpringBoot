package com.example.Inventario_final.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@NamedStoredProcedureQuery(
    name = "Producto.ObtenerProductos",
    procedureName = "sp_VerProductos",
    resultSetMappings = "MostrarProductoDTOMapping",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nombreProducto", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nombreCategoria", type = String.class)
    }
)
@SqlResultSetMapping(
    name = "MostrarProductoDTOMapping",
    columns = {
        @ColumnResult(name = "idProducto"),
        @ColumnResult(name = "producto"),
        @ColumnResult(name = "categoria"),
        @ColumnResult(name = "precio"),
        @ColumnResult(name = "cantidad")
    }
)
////////////////////
@NamedStoredProcedureQuery(
    name = "Producto.ObtenerProductosTotal",
    procedureName = "sp_VerProductosTotal",
    resultSetMappings = "MostrarProductoDTOMappingTotal"
)
@SqlResultSetMapping(
    name = "MostrarProductoDTOMappingTotal",
    columns = {
        @ColumnResult(name = "idProducto"),
        @ColumnResult(name = "producto"),
        @ColumnResult(name = "categoria"),
        @ColumnResult(name = "precio"),
        @ColumnResult(name = "cantidad")
    }
)
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotNull(message = "El precio no puede ser nulo.")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0.")
    @Column(nullable = false)
    private BigDecimal precio;

    @NotBlank(message = "La unidad de medida no puede estar vacía.")
    @Size(max = 20, message = "La unidad de medida no puede exceder los 20 caracteres.")
    @Column(nullable = false, length = 20)
    private String unidadMedida;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;  // Cambiar el nombre a idCategoria

    // Constructores, getters y setters
    public Producto() {
        super();
    }

    public Producto(Integer idProducto, String nombre, BigDecimal precio, String unidadMedida,
                    Categoria categoria) {
        super();
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.unidadMedida = unidadMedida;
        this.categoria = categoria;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
