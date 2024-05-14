package Cursos.CursoApi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCurso")
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

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Actividad> actividades;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_curso", joinColumns = @JoinColumn(name = "idCurso", referencedColumnName = "idCurso"), inverseJoinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario"))
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

    public List<Usuario> getUsuarios() {
        return usuarios;
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
                '}';
    }

}
