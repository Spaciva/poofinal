package udb.proyectofinalpoo.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name = "recurso")
public class Recurso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRec;
    private Integer idPais;
    private String ciudad;
    private Integer idTipoR;
    private Integer idEdit; // en tesis = institución
    @Column(nullable=false)
    private String titulo;
    @Column(name="annopublic", nullable=false)
    private Integer anioPublic;
    private Integer edicion;
    @Column(nullable=false)

    private Integer cantidad;
    @Column(nullable=false)
    private BigDecimal precio;
    @Lob
    private String descripcion;
    @Lob
    private String palabrabusqueda;
    // getters/setters
}