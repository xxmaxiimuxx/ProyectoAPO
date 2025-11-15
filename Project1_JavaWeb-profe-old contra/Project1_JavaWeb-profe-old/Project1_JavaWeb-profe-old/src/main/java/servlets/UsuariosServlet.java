package servlets;

import modelo.GestionarUsuarios;
import modelo.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/UsuariosServlet")
@MultipartConfig
public class UsuariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    String ruta = getServletContext().getRealPath("/usuarios.txt");
    private GestionarUsuarios gestionarUsuarios = new GestionarUsuarios(ruta);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        // ✅ Manejo de acción eliminar desde GET (si el botón o enlace usa GET)
        if ("eliminar".equalsIgnoreCase(accion)) {
            eliminarUsuario(request, response);
            return;
        }

        // ✅ Por defecto: listar usuarios
        LinkedList<Usuario> usuarios = gestionarUsuarios.ListarUsuarios();
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminUsuarios.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String ruta = getServletContext().getRealPath("/data/usuarios.txt");

        if (accion == null) {
            accion = "";
        }

        switch (accion.toLowerCase()) {
            case "insertar":
                registrarUsuario(request, response);
                break;

            case "eliminar":
                eliminarUsuario(request, response);
                break;

            case "login":
                iniciarSesion(request, response);
                break;

            default:
                response.sendRedirect("UsuariosServlet");
                break;
        }
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nombre = request.getParameter("nombre");
        String cedula = request.getParameter("cedula");
        String especialidad = request.getParameter("especialidad");
        String genero = request.getParameter("genero");
        String contrasena = request.getParameter("contrasena");
        String rol = request.getParameter("rol");

        int edad = 0;
        try {
            edad = Integer.parseInt(request.getParameter("edad"));
        } catch (NumberFormatException e) {
            System.out.println("⚠ Edad inválida");
        }

        String nacionalidad = request.getParameter("nacionalidad");

        int experiencia = 0;
        try {
            experiencia = Integer.parseInt(request.getParameter("experiencia"));
        } catch (NumberFormatException e) {
            System.out.println("⚠ Experiencia inválida");
        }

        String disponibilidad = request.getParameter("disponibilidad");

        Part imagenPart = request.getPart("imagenPerfil");
        String imagen = null;

        if (imagenPart != null && imagenPart.getSize() > 0) {
            imagen = imagenPart.getSubmittedFileName();
        }

        Usuario nuevoUsuario = new Usuario(
                cedula, nombre, edad, especialidad, genero,
                nacionalidad, experiencia, disponibilidad, imagen, contrasena, rol
        );

        gestionarUsuarios.agregarUsuario(nuevoUsuario);
        System.out.println("✅ Usuario agregado: " + nombre);

        // Redirigir a lista actualizada
        response.sendRedirect("UsuariosServlet");
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String cedula = request.getParameter("cedula");

        if (cedula != null && !cedula.trim().isEmpty()) {
            gestionarUsuarios.eliminarUsuario(cedula);
            System.out.println("🗑 Usuario eliminado: " + cedula);
        } else {
            System.out.println("⚠ No se recibió una cédula válida para eliminar.");
        }

        // ✅ Redirige para evitar reenvíos del formulario al recargar
        response.sendRedirect("UsuariosServlet");
    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String usuarioIngresado = request.getParameter("usuario");
        String contrasenaIngresada = request.getParameter("contrasena");

        // Usamos el método que busca directamente en el archivo
        Usuario usuarioEncontrado = gestionarUsuarios.buscarPorNombreYContrasena(usuarioIngresado, contrasenaIngresada);

        if (usuarioEncontrado != null) {

            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuarioEncontrado);

            if ("admin".equalsIgnoreCase(usuarioEncontrado.getRol())) {
                response.sendRedirect("adminUsuarios.jsp"); // admin
            } else {
                response.sendRedirect("adminProductos.jsp"); // usuarios normales
            }

        } else {
            request.setAttribute("error", "Usuario o contraseña incorrectos");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

}
