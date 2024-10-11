	package com.example.Inventario_final.Models;
	
	import jakarta.persistence.*;
	import java.math.BigDecimal;
	
	@Entity
	@Table(name = "producto")
	@NamedStoredProcedureQuery(
	    name = "Producto.ObtenerProductos",
	    procedureName = "sp_VerProductos",
	    resultSetMappings = "MostrarProductoDTOMapping",  // Asegúrate de referenciar el mapeo
	    parameters = {
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nombreProducto", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nombreCategoria", type = String.class)
	    }
	)
	@SqlResultSetMapping(
	    name = "MostrarProductoDTOMapping",
	    columns = {
	        @ColumnResult(name = "idProducto"),  // Asegúrate de que esto coincida
	        @ColumnResult(name = "producto"),     // Asegúrate de que esto coincida
	        @ColumnResult(name = "categoria"),     // Asegúrate de que esto coincida
	        @ColumnResult(name = "precio"),        // Asegúrate de que esto coincida
	        @ColumnResult(name = "cantidad")       // Asegúrate de que esto coincida
	    }
	)
////////////////////
	@NamedStoredProcedureQuery(
		    name = "Producto.ObtenerProductosTotal",
		    procedureName = "sp_VerProductosTotal",
		    resultSetMappings = "MostrarProductoDTOMappingTotal"  // Asegúrate de referenciar el mapeo		   
		)
	@SqlResultSetMapping(
		    name = "MostrarProductoDTOMappingTotal",
		    columns = {
		        @ColumnResult(name = "idProducto"),  // Asegúrate de que esto coincida
		        @ColumnResult(name = "producto"),     // Asegúrate de que esto coincida
		        @ColumnResult(name = "categoria"),     // Asegúrate de que esto coincida
		        @ColumnResult(name = "precio"),        // Asegúrate de que esto coincida
		        @ColumnResult(name = "cantidad")       // Asegúrate de que esto coincida
		    }
		)
	public class Producto {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idProducto;
	
	    @Column(nullable = false, length = 100)
	    private String nombre;
	
	    @Column(nullable = false)
	    private BigDecimal precio;
	
	    @Column(nullable = false, length = 20)
	    private String unidadMedida;
	
	    @ManyToOne
	    @JoinColumn(name = "id_categoria", nullable = false)
	    private Categoria idCategoria;  // Cambiar el nombre a idCategoria
	
	    // Constructores, getters y setters
	    public Producto() {
	        super();
	    }
	
	    public Producto(Integer idProducto, String nombre, BigDecimal precio, String unidadMedida, Categoria idCategoria) {
	        super();
	        this.idProducto = idProducto;
	        this.nombre = nombre;
	        this.precio = precio;
	        this.unidadMedida = unidadMedida;
	        this.idCategoria = idCategoria;  // Cambiar a idCategoria
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
	
	    public Categoria getIdCategoria() {  // Cambiar a idCategoria
	        return idCategoria;
	    }
	
	    public void setIdCategoria(Categoria idCategoria) {  // Cambiar a idCategoria
	        this.idCategoria = idCategoria;
	    }
	}
