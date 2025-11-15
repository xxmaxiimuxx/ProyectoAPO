package modelo;

public class Usuario extends Persona {

    private String cedula;
    private String nombre;
    private int edad;
    private String especialidad;
    private String genero;
    private String nacionalidad;
    private int experiencia;
    private String disponibilidad;
    private String imagen;     
    private String contrasena;   
    private String rol; 
    

    // ============================================
    // CONSTRUCTORES
    // ============================================
    
    // Constructor vacío (necesario para frameworks y servlets)
    public Usuario() {}

    // Constructor completo con parámetros en orden correcto
    public Usuario(String cedula, String nombre, int edad, String especialidad,
                   String genero, String nacionalidad, int experiencia,
                   String disponibilidad, String imagen,String contrasena, String rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.especialidad = especialidad;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.experiencia = experiencia;
        this.disponibilidad = disponibilidad;
        this.imagen = imagen;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    
    // Constructor para login
    public Usuario(String nombre, String contrasena, String rol) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    Usuario(String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    // ============================================
    // GETTERS Y SETTERS
    // ============================================

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
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

    public String getContrasena() { 
        return contrasena; 
    }
    
    public void setContrasena(String contrasena) { 
        this.contrasena = contrasena; 
    }

    public String getRol() { 
        return rol; 
    }
    
    public void setRol(String rol) { 
        this.rol = rol; 
    }
    
    
}