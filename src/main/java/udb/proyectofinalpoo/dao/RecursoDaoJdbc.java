package udb.proyectofinalpoo.dao;
import  udb.proyectofinalpoo.model.Recurso;
import  udb.proyectofinalpoo.util.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class RecursoDaoJdbc {


        private Connection conn() throws SQLException { return DB.get(); }

        public List<Recurso> listarPorTipoUltimos15(int idTipoR) {
            String sql = """
      SELECT idRec, titulo, annopublic
      FROM recurso
      WHERE idTipoR = ? AND annopublic >= YEAR(CURDATE()) - 15 ORDER BY annopublic DESC, titulo """;
            List<Recurso> out = new ArrayList<>();
            try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, idTipoR);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Recurso r = new Recurso();
                        r.setIdRec(rs.getInt("idRec"));
                        r.setTitulo(rs.getString("titulo"));
                        r.setAnioPublic(rs.getInt("annopublic"));
                        out.add(r);
                    }
                }
            } catch (SQLException e) { throw new RuntimeException(e); }
            return out;
        }

        public List<Recurso> buscar(String autorNombre, String palabra, Integer idEdit, Integer anioDesde, Integer anioHasta) {
            StringBuilder sb = new StringBuilder();
            sb.append("""
      SELECT DISTINCT r.idRec, r.titulo, r.annopublic
      FROM recurso r
      LEFT JOIN autoresrecursos ar ON ar.idRec = r.idRec
      LEFT JOIN autor a ON a.idAutor = ar.idAutor
      LEFT JOIN recursopalabra rp ON rp.idRec = r.idRec
      LEFT JOIN palabraclave pc ON pc.idPalabra = rp.idPalabra
      WHERE 1=1
    """);

            List<Object> params = new ArrayList<>();
            if (autorNombre != null && !autorNombre.isBlank()) {
                sb.append(" AND CONCAT(a.nombres,' ',a.apellidos) LIKE ? ");
                params.add("%" + autorNombre + "%");
            }
            if (palabra != null && !palabra.isBlank()) {
                sb.append(" AND pc.palabra LIKE ? ");
                params.add("%" + palabra + "%");
            }
            if (idEdit != null) {
                sb.append(" AND r.idEdit = ? ");
                params.add(idEdit);
            }
            if (anioDesde != null) {
                sb.append(" AND r.annopublic >= ? ");
                params.add(anioDesde);
            }
            if (anioHasta != null) {
                sb.append(" AND r.annopublic <= ? ");
                params.add(anioHasta);
            }
            sb.append(" ORDER BY r.annopublic DESC, r.titulo ");

            List<Recurso> out = new ArrayList<>();
            try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sb.toString())) {
                for (int i = 0; i < params.size(); i++) ps.setObject(i + 1, params.get(i));
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Recurso r = new Recurso();
                        r.setIdRec(rs.getInt(1));
                        r.setTitulo(rs.getString(2));
                        r.setAnioPublic(rs.getInt(3));
                        out.add(r);
                    }
                }
            } catch (SQLException e) { throw new RuntimeException(e); }
            return out;
        }
    }
}
