package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class GestionarUsuarios {

    // Lista para almacenar los usuarios temporalmente (en memoria)
    private static LinkedList<Usuario> listaUsuarios = new LinkedList<>();

    // === CREAR USUARIO ==
    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuario agregado: " + usuario.getNombre());
    }

    // ===== LISTAR USUARIOS =========
    public LinkedList<Usuario> ListarUsuarios() {
        return listaUsuarios;
    }

    // ========= BUSCAR POR CÉDULA ====
    public Usuario buscarPorcedula(String cedula) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }

    // ==== EDITAR USUARIO ====
    public void editarUsuario(Usuario usuarioEditado) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCedula().equals(usuarioEditado.getCedula())) {
                usuario.setNombre(usuarioEditado.getNombre());
                usuario.setEspecialidad(usuarioEditado.getEspecialidad());
                usuario.setGenero(usuarioEditado.getGenero());
                usuario.setEdad(usuarioEditado.getEdad());
                usuario.setNacionalidad(usuarioEditado.getNacionalidad());
                usuario.setExperiencia(usuarioEditado.getExperiencia());
                usuario.setDisponibilidad(usuarioEditado.getDisponibilidad());

                System.out.println("Usuario editado: " + usuario.getCedula());
                break;
            }
        }
    }

    // ========= ELIMINAR USUARIO ======
    public void eliminarUsuario(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            System.out.println("Cédula vacía o nula en eliminarUsuario()");
            return;
        }

        boolean eliminado = listaUsuarios.removeIf(usuario -> usuario.getCedula().equals(cedula));

        if (eliminado) {
            System.out.println("Usuario eliminado con cédula: " + cedula);
        } else {
            System.out.println(" No se encontró usuario con cédula: " + cedula);
        }
    }

    private String rutaArchivo;             // ruta del archivo de usuarios
    private ArrayList<Usuario> usuariosArchivo;  
// lista de usuarios cargada desde archivo

// Constructor para inicializar el manejo de archivo
    public GestionarUsuarios(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.usuariosArchivo = leerArchivo(); // aquí carga la lista desde archivo
    }

// Agregar usuario al archivo
    public void agregarArchivo(Usuario u) {
        if (usuariosArchivo == null) { // seguridad por si algo no se inicializó
            usuariosArchivo = new ArrayList<>();
        }
        usuariosArchivo.add(u);
        guardarArchivo();
    }

// Buscar usuario por nombre y contraseña en archivo
    public Usuario buscarPorNombreYContrasena(String nombre, String contrasena) {
        if (usuariosArchivo == null) {
            usuariosArchivo = leerArchivo();
        }
        for (Usuario u : usuariosArchivo) {
            if (u.getNombre().equals(nombre) && u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        return null;
    }

// Guardar usuarios en archivo
    private void guardarArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, false))) {
            for (Usuario u : usuariosArchivo) {
                bw.write(String.join(",", u.getNombre(), u.getContrasena(), u.getRol()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// Leer usuarios desde archivo
    private ArrayList<Usuario> leerArchivo() {
        ArrayList<Usuario> lista = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] c = linea.split(",");
                if (c.length >= 3) {
                    lista.add(new Usuario(c[0].trim(), c[1].trim(), c[2].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
