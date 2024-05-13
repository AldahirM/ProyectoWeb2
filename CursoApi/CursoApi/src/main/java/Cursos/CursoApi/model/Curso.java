package Cursos.CursoApi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CCT")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Escuela escuela;

    @OneToOne(mappedBy = "curso", cascade = CascadeType.ALL)
    Certificado certificado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_Docente")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Docente docente;

    @OneToMany(mappedBy = "curso")
    private List<Curso_Leccion> curso_Lecciones;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String descripcion;

    @Column(nullable = false, length = 255)
    private String imagen;

    public Curso(Docente docente, String nombre, String descripcion, String imagen) {
        this.docente = docente;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Curso() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public Docente getDocente() {
        return docente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", docente=" + docente +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }

}
