package udb.proyectofinalpoo.model;


import java.math.BigDecimal;

public class Recurso {
    private Integer idRec;
    private Integer idPais;
    private String ciudad;
    private Integer idTipoR;
    private Integer idEdit;       // en tesis: institución
    private String titulo;
    private Integer anioPublic;
    private Integer edicion;
    private Integer cantidad;
    private BigDecimal precio;
    private String descripcion;
    private String palabrabusqueda;

    public Integer getIdRec() { return idRec; }
    public void setIdRec(Integer idRec) { this.idRec = idRec; }
    public Integer getIdPais() { return idPais; }
    public void setIdPais(Integer idPais) { this.idPais = idPais; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public Integer getIdTipoR() { return idTipoR; }
    public void setIdTipoR(Integer idTipoR) { this.idTipoR = idTipoR; }
    public Integer getIdEdit() { return idEdit; }
    public void setIdEdit(Integer idEdit) { this.idEdit = idEdit; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Integer getAnioPublic() { return anioPublic; }
    public void setAnioPublic(Integer anioPublic) { this.anioPublic = anioPublic; }
    public Integer getEdicion() { return edicion; }
    public void setEdicion(Integer edicion) { this.edicion = edicion; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getPalabrabusqueda() { return palabrabusqueda; }
    public void setPalabrabusqueda(String palabrabusqueda) { this.palabrabusqueda = palabrabusqueda; }
}
