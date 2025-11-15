package modelo;

import modelo.GestionarUsuarios;
import modelo.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.LinkedList;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)

public class Persona extends HttpServlet {


    private static final long serialVersionUID = 1L;
    private GestionarUsuarios gestionarUsuarios = new GestionarUsuarios("/usuarios.txt");

    // ==========================================================
    // MÉTODO: GET → Mostrar lista de usuarios
    // ==========================================================
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LinkedList<Usuario> usuarios = gestionarUsuarios.ListarUsuarios();
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminUsuarios.jsp");
        dispatcher.forward(request, response);
    }

    // ==========================================================
    // MÉTODO: POST → Acciones registrar, eliminar, editar
    // ==========================================================
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        System.out.println("Acción recibida: " + accion);

        if (accion == null || accion.isEmpty()) {
            response.sendRedirect("index.jsp");
            return;
        }

        switch (accion) {
            case "insert":
            case "registrar":
                registrarUsuario(request, response);
                break;
            case "delete":
            case "eliminar":
                eliminarUsuario(request, response);
                break;
            case "editar":
                editarUsuario(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
                break;
        }
    }

    // ==========================================================
    // MÉTODO: REGISTRAR USUARIO
    // ==========================================================
    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            String cedula = request.getParameter("cedula");
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String especialidad = request.getParameter("especialidad");
            String genero = request.getParameter("genero");
            String nacionalidad = request.getParameter("nacionalidad");
            int experiencia = Integer.parseInt(request.getParameter("experiencia"));
            String disponibilidad = request.getParameter("disponibilidad");
            String contrasena = request.getParameter("contraseña");
            String rol = request.getParameter("rol");

            // Procesar la imagen del formulario (campo name="imagenPerfil")
            Part imagenPart = request.getPart("imagenPerfil");
            String imagen = null;

            if (imagenPart != null && imagenPart.getSize() > 0) {
                imagen = imagenPart.getSubmittedFileName();
                // Si quieres guardar el archivo:
                // String ruta = getServletContext().getRealPath("/uploads/") + imagen;
                // imagenPart.write(ruta);
            }

            // Crear el usuario con los parámetros correctos
            Usuario nuevoUsuario = new Usuario(
                    cedula,
                    nombre,
                    edad,
                    especialidad,
                    genero,
                    nacionalidad,
                    experiencia,
                    disponibilidad,
                    imagen,
                    contrasena,
                    rol
            );

            gestionarUsuarios.agregarUsuario(nuevoUsuario);

            LinkedList<Usuario> usuarios = gestionarUsuarios.ListarUsuarios();
            request.setAttribute("usuarios", usuarios);

            RequestDispatcher dispatcher = request.getRequestDispatcher("adminUsuarios.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    // ==========================================================
    // MÉTODO: ELIMINAR USUARIO
    // ==========================================================
    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String cedula = request.getParameter("cedula");
        gestionarUsuarios.eliminarUsuario(cedula);

        LinkedList<Usuario> usuarios = gestionarUsuarios.ListarUsuarios();
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminUsuarios.jsp");
        dispatcher.forward(request, response);
    }

    // ==========================================================
    // MÉTODO: EDITAR USUARIO
    // ==========================================================
    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            String cedula = request.getParameter("cedula");
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String especialidad = request.getParameter("especialidad");
            String genero = request.getParameter("genero");
            String nacionalidad = request.getParameter("nacionalidad");
            int experiencia = Integer.parseInt(request.getParameter("experiencia"));
            String disponibilidad = request.getParameter("disponibilidad");
            String contrasena = request.getParameter("contraseña");
            String rol = request.getParameter("rol");

            Part imagenPart = request.getPart("imagenPerfil");
            String imagen = null;

            if (imagenPart != null && imagenPart.getSize() > 0) {
                imagen = imagenPart.getSubmittedFileName();
            }

            Usuario usuarioEditado = new Usuario(
                    cedula,
                    nombre,
                    edad,
                    especialidad,
                    genero,
                    nacionalidad,
                    experiencia,
                    disponibilidad,
                    imagen,
                    contrasena,
                    rol
            );

            gestionarUsuarios.editarUsuario(usuarioEditado);

            LinkedList<Usuario> usuarios = gestionarUsuarios.ListarUsuarios();
            request.setAttribute("usuarios", usuarios);

            RequestDispatcher dispatcher = request.getRequestDispatcher("adminUsuarios.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    
    public String getServletInfo() {
        return "Servlet para registrar, editar y eliminar usuarios";
    }
}
