<%@ page import="java.util.LinkedList" %>
<%@ page import="modelo.Usuario" %>
<%@ include file="lib/header.jsp" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Usuarios Registrados | TalentBoxLJ</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            body {
                background-image: url('https://images.unsplash.com/photo-1760096905034-e3ca78eb7f81?ixlib=rb-4.1.0&auto=format&fit=crop&w=1200&q=80');
                background-size: cover;
                background-attachment: fixed;
                background-position: center;
                font-family: 'Segoe UI', sans-serif;
                margin: 0;
                padding: 0;
                min-height: 100vh;
                display: flex;
                flex-direction: column;
            }

            .table-container {
                width: 90%;
                max-width: 1100px;
                margin: 50px auto;
                background-color: rgba(255, 255, 255, 0.95);
                padding: 25px 30px;
                border-radius: 15px;
                box-shadow: 0 8px 25px rgba(0,0,0,0.25);
                overflow-x: auto;
            }

            h3 {
                color: blue;
                text-align: center;
                font-weight: 700;
                margin-bottom: 25px;
                font-size: 1.8rem;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                border-radius: 10px;
                overflow: hidden;
                min-width: 700px;
            }

            th, td {
                border: 1px solid #ccc;
                padding: 10px 12px;
                text-align: center;
                font-size: 0.95rem;
                word-wrap: break-word;
            }

            th {
                background: linear-gradient(90deg, black, blue);
                color: white;
                font-weight: 600;
            }

            tr:nth-child(even) {
                background-color: #f3f3f3;
            }

            tr:hover {
                background-color: rgba(0, 0, 255, 0.1);
            }

            .foto-usuario {
                width: 60px;
                height: 60px;
                border-radius: 50%;
                object-fit: cover;
                border: 2px solid #ccc;
            }

            .btn {
                border: none;
                border-radius: 8px;
                padding: 6px 12px;
                font-weight: 600;
                cursor: pointer;
                transition: 0.3s ease;
            }

            .btn-delete {
                background-color: red;
                color: white;
            }

            .btn-delete:hover {
                background-color: darkred;
            }

            .btn-back {
                background: linear-gradient(90deg, black, blue);
                color: white;
                margin-top: 25px;
                display: block;
                text-align: center;
                text-decoration: none;
                font-weight: 600;
                padding: 12px;
                border-radius: 10px;
                width: 100%;
                max-width: 400px;
                margin-left: auto;
                margin-right: auto;
            }

            .btn-back:hover {
                background: linear-gradient(90deg, yellow, blue);
                color: black;
            }

            footer {
                text-align: center;
                padding: 15px;
                color: white;
                background: rgba(0, 0, 0, 0.8);
                margin-top: auto;
                font-size: 0.9rem;
            }

            @media (max-width: 768px) {
                th, td {
                    font-size: 0.85rem;
                    padding: 8px;
                }
                h3 {
                    font-size: 1.4rem;
                }
                .table-container {
                    padding: 20px;
                }
            }
        </style>

        <script>
            function eliminarFila(boton) {
                if (confirm('¿Seguro que deseas eliminar este usuario?')) {
                    const fila = boton.closest('tr');
                    fila.remove();
                }
            }
        </script>
    </head>

    <body>
        <div class="table-container">
            <h3>Usuarios Registrados</h3>

            <%
                LinkedList<Usuario> lista = (LinkedList<Usuario>) request.getAttribute("usuarios");
                if (lista == null || lista.isEmpty()) {
            %>
            <p style="text-align:center; color:gray; font-weight:500;">No hay usuarios registrados aún.</p>
            <%
            } else {
            %>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Cédula</th>
                        <th>Especialidad</th>
                        <th>Género</th>
                        <th>Edad</th>
                        <th>Nacionalidad</th>
                        <th>Foto</th>
                        <th>Disponibilidad</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Usuario u : lista) {
                            String img = (u.getImagen() != null && !u.getImagen().isEmpty())
                                    ? "uploads/" + u.getImagen()
                                    : "imagenes/default.jpg";
                    %>
                    <tr>
                        <td><%= u.getNombre()%></td>
                        <td><%= u.getCedula()%></td>
                        <td><%= u.getEspecialidad()%></td>
                        <td><%= u.getGenero()%></td>
                        <td><%= u.getEdad()%></td>
                        <td><%= u.getNacionalidad()%></td>
                        <td><img src="<%= img%>" alt="Foto" class="foto-usuario"></td>
                        <td><%= u.getDisponibilidad()%></td>
                        <td>
                            <!-- 🔹 Botón eliminar con formulario -->
                            <form action="UsuariosServlet" method="post" style="display:inline;">
                                <input type="hidden" name="accion" value="eliminar">
                                <input type="hidden" name="cedula" value="<%= u.getCedula()%>">
                                <button type="submit" class="btn btn-delete"
                                        onclick="return confirm('¿Seguro que deseas eliminar este usuario?');">
                                    Eliminar
                                </button>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </tbody>

            </table>
            <%
                }
            %>

            <a href="registroUsuario.jsp" class="btn-back">← Registrar Nuevo Usuario</a>
        </div>

        <footer>
            © 2025 TalentBoxLJ - Despierta tu talento, alcanza tus sueños
        </footer>
    </body>
</html>
