<%@ taglib uri="https://jakarta.ee/jstl/core" prefix="c" %>
<h3>Búsqueda</h3>
<form method="get" action="${pageContext.request.contextPath}/buscar">
  Autor: <input name="autor"/>
  Palabra: <input name="palabra"/>
  Editorial ID: <input name="idEdit"/>
  Año desde: <input name="anioDesde"/>
  Año hasta: <input name="anioHasta"/>
  <button type="submit">Buscar</button>
</form>
