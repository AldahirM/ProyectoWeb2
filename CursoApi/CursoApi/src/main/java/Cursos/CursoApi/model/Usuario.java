package Cursos.CursoApi.model;
import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Usuario;

    @OneToOne (mappedBy = "usuario", cascade = CascadeType.ALL)
    Inicio_Sesion inicio_sesion;

    @OneToOne (mappedBy = "usuario", cascade = CascadeType.ALL)
    Codigo_Recuperacion codigo_recuperacion;

    @OneToOne (mappedBy = "usuario", cascade = CascadeType.ALL)
    Alumno alumno;

    @OneToOne (mappedBy = "usuario", cascade = CascadeType.ALL)
    Docente docente;

    @OneToOne (mappedBy = "usuario", cascade = CascadeType.ALL)
    Administrador administrador;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellidoPaterno;

    @Column(nullable = false, length = 50)
    private String apellidoMaterno;

    @Column(nullable = false, length = 50)
    private String correo;

    @Column(nullable = false, length = 25)
    private String contrasena;

    @Column(nullable = false, length = 15)
    private String rol;

    @Column(nullable = false, length = 50)
    private int edad;

    @Column(nullable = false, length = 50)
    private String genero;

    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasena, String rol, int edad, String genero) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.edad = edad;
        this.genero = genero;
    }
    public Usuario() {
    }

    public Integer getIdUsuario() {
        return id_Usuario;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.id_Usuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + id_Usuario +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", rol='" + rol + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                '}';
    }



}
