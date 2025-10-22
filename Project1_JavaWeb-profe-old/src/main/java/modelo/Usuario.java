package modelo;

public class Usuario extends Persona {

    private String cedula;
    private String nombre;
    private int edad;
    private String tipoUsuario;
    private String especialidad;
    private String genero;
    private String nacionalidad;
    private int experiencia;
    private String disponibilidad;
    private String imagen;

    // Constructor vacío (necesario para el servlet)
    public Usuario() {
    }

    public Usuario(String cedula, String nombre, int edad, String tipoUsuario, String especialidad, String genero, String nacionalidad, int experiencia, String disponibilidad, String imagen) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.tipoUsuario = tipoUsuario;
        this.especialidad = especialidad;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.experiencia = experiencia;
        this.disponibilidad = disponibilidad;
        this.imagen = imagen;
    }

    // Constructor con todos los campos
    public Usuario(String tipoUsuario, String nombre, String cedula, String especialidad,
            String genero, int edad, String nacionalidad, int experiencia,
            String disponibilidad) {
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.genero = genero;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.experiencia = experiencia;
        this.disponibilidad = disponibilidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    // ====== Getters y Setters ======
    
    public String getcedula() {
        return cedula;
    }

    public void setCodigo(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
