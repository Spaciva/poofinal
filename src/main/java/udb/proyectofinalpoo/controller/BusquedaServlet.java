package udb.proyectofinalpoo.controller;
import udb.proyectofinalpoo.RecursoDaoJdbc;
import udb.proyectofinalpoo.model.Recurso;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.*;

@WebServlet("/buscar")
public class BusquedaServlet extends HttpServlet {
    private final RecursoDaoJdbc dao = new RecursoDaoJdbc();
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse
            resp) throws ServletException, IOException {
        String autor = req.getParameter("autor");
        String palabra = req.getParameter("palabra");
        Integer idEdit = parseInt(req.getParameter("idEdit"));
        Integer anioDesde = parseInt(req.getParameter("anioDesde"));
        Integer anioHasta = parseInt(req.getParameter("anioHasta"));
        List<Recurso> res = dao.buscar(autor, palabra, idEdit, anioDesde,
                anioHasta);
        req.setAttribute("resultados", res);
        req.getRequestDispatcher("/WEB-INF/views/resultados.jsp").forward(req,
                resp);
    }
    private Integer parseInt(String s){ try{ return (s==null||s.isBlank())?
            null: Integer.valueOf(s);}catch(Exception e){return null;} }
}