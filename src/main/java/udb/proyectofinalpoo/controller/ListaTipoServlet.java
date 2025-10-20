package udb.proyectofinalpoo.controller;
import udb.proyectofinalpoo.dao.RecursoDaoJdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/listarPorTipo")
public class ListaTipoServlet extends HttpServlet {
    private final RecursoDaoJdbc dao = new RecursoDaoJdbc();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tipo = Integer.parseInt(req.getParameter("tipo"));
        var lista = dao.listarPorTipoUltimos15(tipo);
        req.setAttribute("resultados", lista);
        req.getRequestDispatcher("/WEB-INF/views/resultados.jsp").forward(req, resp);
    }
}