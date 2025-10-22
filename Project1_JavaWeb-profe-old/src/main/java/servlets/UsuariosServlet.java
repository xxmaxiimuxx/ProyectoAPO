package servlets;

import modelo.GestionarUsuarios;
import modelo.Usuario;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/UsuariosServlet")

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UsuariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private GestionarUsuarios gestionarUsuarios = new GestionarUsuarios();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LinkedList<Usuario> usuarios = gestionarUsuarios.ListarUsuarios();
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/adminUsuarios.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("**** Ingreso a POST *****");

        String accion = request.getParameter("accion");
        System.out.println("**** Acción ----: " + accion);

        if ("insert".equals(accion)) {
            registrarUsuario(request, response);
        } else if ("delete".equals(accion)) {
            eliminarUsuario(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nombre = request.getParameter("name");
        String cedula = request.getParameter("id");
        String especialidad = request.getParameter("email");
        String genero = request.getParameter("genero");

        int edad = 0;
        try {
            edad = Integer.parseInt(request.getParameter("age"));
        } catch (NumberFormatException e) {
            edad = 0;
        }

        String nacionalidad = request.getParameter("nacionalidad");

        int experiencia = 0;
        try {
            experiencia = Integer.parseInt(request.getParameter("exper"));
        } catch (NumberFormatException e) {
            experiencia = 0;
        }

        String disponibilidad = request.getParameter("disponibilidad");

        Part imagenPart = request.getPart("imagenPerfil");

        Usuario nuevoUsuario = new Usuario(
                "General", // tipoUsuario
                nombre, // nombre
                cedula, // cedula
                especialidad, // especialidad
                genero, // genero
                edad, // edad
                nacionalidad, // nacionalidad
                experiencia, // experiencia
                disponibilidad // disponibilidad
        );

        gestionarUsuarios.agregarUsuario(nuevoUsuario);

        LinkedList<Usuario> usuarios = gestionarUsuarios.ListarUsuarios();
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminUsuarios.jsp");
        dispatcher.forward(request, response);
    }

    public GestionarUsuarios getGestionarUsuarios() {
        return gestionarUsuarios;
    }

    public void setGestionarUsuarios(GestionarUsuarios gestionarUsuarios) {
        this.gestionarUsuarios = gestionarUsuarios;
    }

    public UsuariosServlet() {
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String cedula = request.getParameter("id");
        gestionarUsuarios.eliminarUsuario(cedula);

        LinkedList<Usuario> usuarios = gestionarUsuarios.ListarUsuarios();
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminUsuarios.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para gestionar usuarios (registro, eliminación, listado)";
    }
}
