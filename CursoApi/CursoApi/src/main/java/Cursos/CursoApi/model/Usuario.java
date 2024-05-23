package Cursos.CursoApi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @Column(name = "idCorreo", nullable = false, length = 80)
    private String idCorreo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Certificado> certificados;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "usuario_curso",
        joinColumns = @JoinColumn(name = "idCorreo", referencedColumnName = "idCorreo"),
        inverseJoinColumns = @JoinColumn(name = "idCurso", referencedColumnName = "idCurso"))
    private List<Curso> cursos;

    @OneToOne(mappedBy = "usuario")
    private InicioSesion inicioSesion;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = false, length = 80)
    private String apePat;

    @Column(nullable = false, length = 80)
    private String apeMat;

    @Column(nullable = false, length = 3)
    private Integer edad;

    @Column(nullable = false, length = 20)
    private String sexo;

    @Column(nullable = false, length = 50)
    private String contrasena;

    @Column(nullable = false, length = 20)
    private String tipoUsuario;

    // Setters
    public void setIdCorreo(String idCorreo) {
        this.idCorreo = idCorreo;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void setInicioSesion(InicioSesion inicioSesion) {
        this.inicioSesion = inicioSesion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    // Getters
    public String getIdCorreo() {
        return idCorreo;
    }

    public List<Certificado> getCertificados() {
        return certificados;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public InicioSesion getInicioSesion() {
        return inicioSesion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApePat() {
        return apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void addCursos(Curso curso) {
        this.cursos.add(curso);
    }

    // toString
    @Override
    public String toString() {
        return "Usuario{" +
                "idCorreo='" + idCorreo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apePat='" + apePat + '\'' +
                ", apeMat='" + apeMat + '\'' +
                ", edad=" + edad +
                ", sexo='" + sexo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }

    public Usuario() {

    }

    public Usuario(String idCorreo, String nombre, String apePat, String apeMat, Integer edad, String sexo, String contrasena, String tipoUsuario) {
        this.idCorreo = idCorreo;
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.edad = edad;
        this.sexo = sexo;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }


}
