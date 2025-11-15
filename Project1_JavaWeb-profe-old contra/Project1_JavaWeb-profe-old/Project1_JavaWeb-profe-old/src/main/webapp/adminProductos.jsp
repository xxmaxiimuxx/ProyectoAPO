<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%
    modelo.Usuario usuario = (modelo.Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Catálogo de Artistas y Actores</title>
    <link rel="stylesheet" href="css/catalogo.css">
</head>
<body>

<header>
    <h1>Catálogo de Artistas y Actores</h1>
    <p>Bienvenido, <strong><%= usuario.getNombre()%></strong></p>
    <a href="login.jsp" class="logout-btn">Cerrar sesión</a>
</header>

<section class="productos">
    <h2>Cantantes</h2>
    <div class="card">
        <img src="https://cdn.pixabay.com/photo/2017/01/31/19/29/singer-2025767_1280.png" alt="Grupo">
        <h3>Grupos</h3>
        <p>$500.000</p>
        <button>Contratar</button>
    </div>
    <div class="card">
        <img src="https://cdn.pixabay.com/photo/2016/03/31/20/11/microphone-1290523_1280.png" alt="Solista">
        <h3>Solistas</h3>
        <p>$700.000</p>
        <button>Contratar</button>
    </div>
    <div class="card">
        <img src="https://cdn.pixabay.com/photo/2019/10/21/14/29/singer-4568984_1280.png" alt="Duetos">
        <h3>Duetos</h3>
        <p>$450.000</p>
        <button>Contratar</button>
    </div>

    <h2>Actores</h2>
    <div class="card">
        <img src="https://cdn.pixabay.com/photo/2017/07/31/11/21/man-2557446_1280.png" alt="Papel principal">
        <h3>Papel principal</h3>
        <p>$100.000</p>
        <button>Contratar</button>
    </div>
    <div class="card">
        <img src="https://cdn.pixabay.com/photo/2017/07/31/11/21/woman-2557447_1280.png" alt="Papel secundario">
        <h3>Papel secundario</h3>
        <p>$300.000</p>
        <button>Contratar</button>
    </div>
    <div class="card">
        <img src="https://cdn.pixabay.com/photo/2016/03/31/19/57/theater-1290335_1280.png" alt="Papel de antagonista">
        <h3>Papel de antagonista</h3>
        <p>$800.000</p>
        <button>Contratar</button>
    </div>
</section>

</body>
</html>