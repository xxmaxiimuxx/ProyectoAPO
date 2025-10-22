package modelo;

import java.util.LinkedList;

public class GestionarUsuarios {

    // Lista para almacenar los usuarios temporalmente (en memoria)
    private static LinkedList<Usuario> listaUsuarios = new LinkedList<>();

    // ===================== CREAR USUARIO =====================
    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuario agregado: " + usuario.getNombre());
    }

    // ===================== LISTAR USUARIOS =====================
    public LinkedList<Usuario> ListarUsuarios() {
        return listaUsuarios;
    }

    // ===================== BUSCAR POR CÓDIGO =====================
    public Usuario buscarPorcedula(String cedula) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }

    // ===================== EDITAR USUARIO =====================
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
                usuario.setTipoUsuario(usuarioEditado.getTipoUsuario());

                System.out.println("Usuario editado: " + usuario.getCedula());
                break;
            }
        }
    }

    // ===================== ELIMINAR USUARIO =====================
    public void eliminarUsuario(String cedula) {
        listaUsuarios.removeIf(usuario -> usuario.getCedula().equals(cedula));
        System.out.println("Usuario eliminado: " + cedula);
    }
}
