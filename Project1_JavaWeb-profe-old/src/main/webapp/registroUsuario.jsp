<%@include file="lib/header.jsp" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro de Usuario | TalentBoxLJ</title>

        <style>
            body {
                background-image: url('https://images.unsplash.com/photo-1760096905034-e3ca78eb7f81?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=710');
                background-size: cover;
                background-position: center;
                background-attachment: fixed;
                font-family: 'Segoe UI', sans-serif;
                margin: 0;
                padding: 0;
            }

            .form-container {
                max-width: 550px;
                margin: 60px auto;
                background-color: rgba(255, 255, 255, 0.93);
                padding: 40px 50px;
                border-radius: 20px;
                box-shadow: 0 8px 25px rgba(0,0,0,0.25);
            }

            .form-container h3 {
                color: blue;
                font-weight: 700;
                text-align: center;
                margin-bottom: 30px;
            }

            .form-label {
                font-weight: 600;
                color: blue;
            }

            .form-control {
                border-radius: 10px;
                border: 2px solid blue;
                transition: all 0.3s ease;
            }

            .form-control:focus {
                border-color: blue;
                box-shadow: 0 0 8px rgba(0, 68, 204, 0.5);
                outline: none;
            }

            .btn-primary {
                background: linear-gradient(90deg, black, blue);
                border: none;
                border-radius: 10px;
                font-weight: 600;
                padding: 10px 20px;
                transition: 0.3s;
            }

            .btn-primary:hover {
                background: linear-gradient(90deg, yellow, blue);
                transform: scale(1.05);
            }

            .btn-secondary {
                border-radius: 10px;
                font-weight: 600;
                padding: 10px 20px;
            }

            .alert {
                margin-top: 25px;
                border-radius: 10px;
            }

            .row .col-md-6 {
                margin-bottom: 10px;
            }

        </style>
    </head>

    <body>
        <div class="container">
            <div class="form-container">
                <h3>Registro</h3>

                <!-- ✅ FORMULARIO CORREGIDO -->
                <form action="${pageContext.request.contextPath}/UsuariosServlet" 
                      method="post" enctype="multipart/form-data">
                    
                    <input type="hidden" name="accion" value="insert">

                    <div class="row">
                        <div class="col-md-6">
                            <label class="form-label">Nombre Apellido</label>
                            <input type="text" class="form-control" name="name" placeholder="Nombre" required>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Cédula</label>
                            <input type="text" class="form-control" name="id" placeholder="Cédula" required>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Especialidad</label>
                            <input type="text" class="form-control" name="Especialidad" placeholder="Especialidad">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Género</label>
                            <select class="form-control" name="genero">
                                <option value="Femenino">Femenino</option>
                                <option value="Masculino">Masculino</option>
                                <option value="Otros">Otros</option>
                            </select>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Edad</label>
                            <input type="number" class="form-control" name="Edad" placeholder="Edad">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Nacionalidad</label>
                            <select class="form-control" name="nacionalidad">
                                <option value="Colombiano">Colombiano</option>
                                <option value="Mexicano">Mexicano</option>
                                <option value="Argentino">Argentino</option>
                            </select>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Experiencia</label>
                            <input type="number" class="form-control" name="exper" placeholder="Años de experiencia">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Disponibilidad</label>
                            <select class="form-control" name="disponibilidad">
                                <option value="Sí">Sí</option>
                                <option value="No">No</option>
                            </select>
                        </div>

                        <div class="col-12">
                            <label class="form-label">Imagen de Perfil</label>
                            <input type="file" class="form-control" name="imagenPerfil">
                        </div>
                    </div>

                    <!-- Botones -->
                    <div class="d-flex justify-content-between mt-4">
                        <button type="submit" class="btn btn-primary w-50 me-2">Registrar</button>
                        <a href="adminUsuarios.jsp" class="btn btn-secondary w-50 ms-2">Ver Registros</a>
                    </div>
                </form>

            </div>
        </div>

                      
        <%@include file="lib/footer.jsp" %>
    </body>
</html>
