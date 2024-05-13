package Cursos.CursoApi.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Escuela {
    @Id
    @Column(name = "id_Escuela", nullable = false, length = 10)
    private String id_Escuela;

    @OneToOne(mappedBy = "escuela", cascade = CascadeType.ALL)
    Docente docente;

    @OneToMany(mappedBy = "escuela", cascade = CascadeType.ALL)
    private List<Curso> cursos = new ArrayList<>();

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String direccion;

    @Column(nullable = false, length = 50)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String correo;

    public Escuela(String nombre, String direccion, String telefono, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Escuela() {
    }

    public String getIdEscuela() {
        return id_Escuela   ;
    }

    public String getId_Escuela() {
        return id_Escuela;
    }

    public Docente getDocente() {
        return docente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setIdEscuela(String id_Escuela) {
        this.id_Escuela = id_Escuela;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId_Escuela(String id_Escuela) {
        this.id_Escuela = id_Escuela;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Escuela{" +
                "CCT=" + id_Escuela+
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
