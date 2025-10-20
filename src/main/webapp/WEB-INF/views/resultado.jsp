<%@ taglib uri="https://jakarta.ee/jstl/core" prefix="c" %>
<h3>Resultados</h3>
<c:forEach var="r" items="${resultados}">
    <div><b>${r.titulo}</b> — ${r.anioPublic}</div>
</c:forEach>
<a href="${pageContext.request.contextPath}/buscar">Nueva búsqueda</a>
