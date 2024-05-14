package Cursos.CursoApi.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @Column(nullable = false, length = 250)
    private String nombre;

    @Column(nullable = false, length = 250)
    private String imagen;

    @Column(nullable = false, length = 250)
    private String descripcion;

    @OneToMany(mappedBy = "cursos", cascade = CascadeType.ALL)
    private List<Actividad> actividades;

    @OneToMany(mappedBy = "cursos", cascade = CascadeType.ALL)
    private List<Examen> examenes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "usuario_curso",
        joinColumns = @JoinColumn(name = "idCurso", referencedColumnName = "idUsuario"),
        inverseJoinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "idCurso")
    )
    private List<Usuario> usuarios;

    @OneToOne(mappedBy = "curso", cascade = CascadeType.ALL)
    private Certificado certificado;

    public Curso(String nombre, String imagen, String descripcion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public Curso() {

    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", actividades=" + actividades +
                ", examenes=" + examenes +
                '}';
    }

}
