<%@ include file="lib/header.jsp" %>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <title>Inicio de Sesión | TalentBoxLJ</title>

        <!-- Estilos personalizados -->
        <style>
            /*  Fondo con imagen suave y filtro para no opacar el contenido */
            body {
                background-image: url('https://images.unsplash.com/photo-1591241902488-1e002c269aaf?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=1170');
                background-size: cover;
                background-position: center;
                background-attachment: fixed;
                background-repeat: no-repeat;
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                min-height: 100vh;
                margin: 0;
                padding-bottom: 60px;
                position: relative;
            }

            /* Capa semitransparente para mantener legibilidad */
            body::before {
                content: "";
                position: fixed;
                top: 0;
                left: 0;
                width: 200%;
                height: 200%;
                background-color: rgba(155, 155, 155, 0.10); /* aclara la imagen */
                z-index: -1;
            }

            .banner-principal {
                width: 20%;
                max-height: 70px;
                object-fit: cover;
                border-radius: 50px;
                box-shadow: 0 3px 10px rgba(0, 0, 0, 0.6);
            }

            /* Contenedor del formulario */
            .login-container {
                background-color: rgba(255, 255, 255, 0.9);
                border-radius: 110px;
                box-shadow: 0 4px 20px rgba(0, 0, 0, 0.15);
                padding: 70px;
                margin: 90px auto;
                max-width: 450px;
                transition: transform 0.3s ease, box-shadow 0.3s ease;
            }

            .login-container:hover {
                transform: translateY(-3px);
                box-shadow: 0 10px 90px rgba(0, 0, 0, 0.12);
            }
            /*boton de inicio de ssesion arriba de usuario*/
            h3 {
                color: black;
                margin-bottom: 20px;
                font-weight: 900;
            }

            /*Personalización de cuadros de texto */
            .form-control {
                background-color: rgb;
                border: 2px solid burlywood;
                border-radius: 60px;
                color: black;
                font-size: 1rem;
                padding: 10px;
                transition: all 0.3s ease;
            }
            /* botones de usuario y contraseña color de fondo*/
            .form-control:focus {
                color: blue;
                box-shadow: 0 0 8px rgba(78, 115, 223, 0.4);
                background-color: thistle;
            }

            /*  Botón principal de ingresar*/
            .btn-primary {
                background: linear-gradient(90deg, black, blue);
                border: none;
                border-radius: 8px;
                padding: 10px;
                font-size: 1.1rem;
                font-weight: bolder;
                transition: all 0.3s ease;
            }

            .btn-primary:hover {
                background: linear-gradient(90deg, black, blue);
                transform: scale(1.09);
            }

            /* Enlaces */
            a {
                color: blue;
                text-decoration: none;
                font-weight: 600;
            }

            a:hover {
                text-decoration: underline;
            }

            /* Footer */
            footer {
                position: absolute;
                bottom: 0;
                width: 100%;
                text-align: center;
                font-size: 1.10rem;
                color: white; /* Texto negro */
                box-shadow: 0 -1px 1px rgba(0, 0, 0, 0.19);
                background: linear-gradient(90deg, black, blue);
                padding: 10px 0;
            }
        </style>
    </head>

    <body>

        <!-- Banner superior -->
        <div class="text-center mt-4">
            <img src="imagenes/imagenestalento.png"
                 alt="Banner principal"
                 class="banner-principal img-fluid rounded shadow">

        </div>

        <!-- FORMULARIO DE LOGIN -->
        <div class="login-container text-center mt-4">
            <h3>Iniciar Sesión</h3>

            <form action="UsuariosServlet" method="post" class="mx-auto" style="max-width: 580px;">
                <input type="hidden" name="action" value="login">

                <div class="mb-3 text-start">
                    <label class="form-label">Usuario</label>
                    <input type="text" name="usuario" class="form-control" placeholder="Usuario" required>
                </div>

                <div class="mb-3 text-start">
                    <label class="form-label">Contraseña</label>
                    <input type="password" name="password" class="form-control" placeholder="Contraseña" required>
                </div>

                <button type="submit" class="btn btn-primary w-100 mt-3">Ingresar</button>
            </form>

            <div class="register-link mt-3">
                ¿No tienes una cuenta? <a href="registroUsuario.jsp">Registrar Usuario</a>
            </div>
        </div>

       

        <%@ include file="lib/footer.jsp" %>
    </body>
</html>
