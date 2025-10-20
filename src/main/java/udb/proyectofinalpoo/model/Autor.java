package udb.proyectofinalpoo.model;
import jakarta.persistence.*;

@Entity @Table(name="autor")
public class Autor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutor;
    private String nombres;
    private String apellidos;
    // getters/setters
}