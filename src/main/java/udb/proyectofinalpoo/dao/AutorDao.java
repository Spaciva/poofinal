package udb.proyectofinalpoo.dao;
import udb.proyectofinalpoo.model.Autor;
import java.util.List;

public interface AutorDao {
    List<Autor> listar();
    Autor buscarPorId(int idAutor);
    void insertar(Autor a);
    void actualizar(Autor a);
    void eliminar(int idAutor);
}