<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>TalentBoxLJ</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Íconos -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

    <!-- Estilos personalizados -->
    <style>
        body {
            background-color: white;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        /* Navbar moderna */
        .navbar {
            background: linear-gradient(90deg, black, blue);
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.15);
        }

        .navbar-brand {
            font-weight: 700;
            font-size: 1.4rem;
            color: #ffffff !important;
            letter-spacing: 1px;
        }

        .nav-link {
            color: #e0e0e0 !important;
            transition: color 0.3s ease, transform 0.2s;
        }

        .nav-link:hover {
            color: #ffffff !important;
            transform: scale(1.05);
        }

        /* Botón buscar */
        .btn-outline-light {
            border-color: #ffffff;
            color: #ffffff;
            transition: all 0.3s;
        }

        .btn-outline-light:hover {
            background: linear-gradient(90deg, black, blue);
            color: #2b3a55;
        }

        /* Dropdown */
        .dropdown-menu {
            border-radius: 9px;
            border: none;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        }

        .dropdown-item:hover {
            background: linear-gradient(90deg, black, white);
        }

        /* Logo */
        .navbar-brand img {
            height: 40px;
            margin-right: 8px;
        }
    </style>
</head>

<body>

    <!-- Barra de navegación limpia -->
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <!-- Logo + nombre -->
            <a class="navbar-brand d-flex align-items-center" href="index.jsp">
                <img src="imagenes/logo.png" alt="Logo" onerror="this.style.display='none'">
                TalentBoxLJ
            </a>

            <!-- Botón móvil -->
            <button class="navbar-toggler text-light" type="button" data-bs-toggle="collapse" data-bs-target="#navbarMenu"
                    aria-controls="navbarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Contenido -->
            <div class="collapse navbar-collapse" id="navbarMenu">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active" href="index.jsp"><i class="bi bi-house-door"></i> Inicio</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-box"></i> Productos</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="menuContactos" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-people"></i> Contactos
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="menuContactos">
                            <li><a class="dropdown-item" href="#">Productos</a></li>
                            <li><a class="dropdown-item" href="#">Sugerencias</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Podcast</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="bi bi-calendar-check"></i> Reservar</a>
                    </li>
                </ul>

                <!-- Buscador -->
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Buscar..." aria-label="Buscar">
                    <button class="btn btn-outline-light" type="submit"><i class="bi bi-search"></i></button>
                </form>
            </div>
        </div>
    </nav>

</body>
</html>
