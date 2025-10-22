<%@ page import="java.util.LinkedList" %>
<%@ page import="modelo.Usuario" %>
<%@ include file="lib/header.jsp" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Usuarios Registrados | TalentBoxLJ</title>
        <style>
            body {
                background-image: url('https://images.unsplash.com/photo-1760096905034-e3ca78eb7f81?ixlib=rb-4.1.0&auto=format&fit=crop&w=1200&q=80');
                background-size: cover;
                background-attachment: fixed;
                font-family: 'Segoe UI', sans-serif;
                margin: 0;
                padding: 0;
            }

            .table-container {
                max-width: 1000px;
                margin: 60px auto;
                background-color: rgba(255, 255, 255, 0.95);
                padding: 30px 40px;
                border-radius: 15px;
                box-shadow: 0 8px 25px rgba(0,0,0,0.25);
            }

            h3 {
                color: blue;
                text-align: center;
                font-weight: 700;
                margin-bottom: 30px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                border-radius: 10px;
                overflow: hidden;
            }

            th, td {
                border: 1px solid #ccc;
                padding: 10px 12px;
                text-align: center;
                font-size: 15px;
            }

            th {
                background: linear-gradient(90deg, black, blue);
                color: white;
            }

            tr:nth-child(even) {
                background-color: #f3f3f3;
            }

            tr:hover {
                background-color: rgba(0, 0, 255, 0.1);
            }

            .btn {
                border: none;
                border-radius: 8px;
                padding: 6px 12px;
                font-weight: 600;
                cursor: pointer;
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
                margin-top: 20px;
                display: block;
                text-align: center;
                text-decoration: none;
                font-weight: 600;
                padding: 10px;
                border-radius: 10px;
            }

            .btn-back:hover {
                background: linear-gradient(90deg, yellow, blue);
                color: black;
            }
        </style>
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
                        <th>Experiencia</th>
                        <th>Disponibilidad</th>
                        <th>Tipo Usuario</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Usuario u : lista) {%>
                    <tr>
                        <td><%= u.getNombre()%></td>
                        <td><%= u.getCedula()%></td>
                        <td><%= u.getEspecialidad()%></td>
                        <td><%= u.getGenero()%></td>
                        <td><%= u.getEdad()%></td>
                        <td><%= u.getNacionalidad()%></td>
                        <td><%= u.getExperiencia()%> años</td>
                        <td><%= u.getDisponibilidad()%></td>
                        <td><%= u.getTipoUsuario()%></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/UsuariosServlet" method="post" style="display:inline;">
                                <input type="hidden" name="accion" value="delete">
                                <input type="hidden" name="cedula" value="<%= u.getCedula()%>">
                                <button type="submit" class="btn btn-delete">Eliminar</button>
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

        <%@ include file="lib/footer.jsp" %>
    </body>
</html>
