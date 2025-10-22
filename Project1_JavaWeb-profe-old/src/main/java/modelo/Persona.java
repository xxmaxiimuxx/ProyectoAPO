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
public class Persona  {

    private static final long serialVersionUID = 1L;
    private final GestionarUsuarios gestionarUsuarios = new GestionarUsuarios();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Mostrar lista de usuarios al entrar
        LinkedList<Usuario> usuarios = gestionarUsuarios.ListarUsuarios();
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminUsuarios.jsp");
        dispatcher.forward(request, response);
    }


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

    // =========================================
    // MÉTODO: REGISTRAR USUARIO
    // =========================================
    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            String tipoUsuario = "General"; // valor por defecto si no se selecciona
            String nombre = request.getParameter("name");
            String codigo = request.getParameter("id");
            String especialidad = request.getParameter("email");
            String genero = request.getParameter("genero");
            int edad = Integer.parseInt(request.getParameter("age"));
            String nacionalidad = request.getParameter("nacionalidad");
            int experiencia = Integer.parseInt(request.getParameter("exper"));
            String disponibilidad = request.getParameter("disponibilidad");

            Part imagenPart = request.getPart("imagenPerfil"); // opcional

            Usuario nuevoUsuario = new Usuario(
                    tipoUsuario, nombre, codigo, especialidad, genero,
                    edad, nacionalidad, experiencia, disponibilidad
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

    // =========================================
    // MÉTODO: ELIMINAR USUARIO
    // =========================================
    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String codigo = request.getParameter("id");
        gestionarUsuarios.eliminarUsuario(codigo);

        LinkedList<Usuario> usuarios = gestionarUsuarios.ListarUsuarios();
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminUsuarios.jsp");
        dispatcher.forward(request, response);
    }

    // =========================================
    // MÉTODO: EDITAR USUARIO
    // =========================================
    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            String cedula = request.getParameter("id");
            String nombre = request.getParameter("name");
            int edad = Integer.parseInt(request.getParameter("age"));
            String tipoUsuario = request.getParameter("user_type");
            String especialidad = request.getParameter("especialidad");
            String genero = request.getParameter("genero");
            String nacionalidad = request.getParameter("nacionalidad");
            int experiencia = Integer.parseInt(request.getParameter("experiencia"));
            String disponibilidad = request.getParameter("disponibilidad");

            Usuario usuarioEditado = new Usuario(
                    tipoUsuario, nombre, cedula, especialidad, genero,
                    edad, nacionalidad, experiencia, disponibilidad
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
   