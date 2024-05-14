package Cursos.CursoApi.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExamen;

    @Column (nullable = false, length = 50)
    private String nombreExamen;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
    private List<PreguntaExamen> preguntasExamen;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @Column(nullable = false, length = 250)
    private String descripcion;

    @Column(nullable = false, length = 6)
    private boolean completada;

    @Column(nullable = false, length = 6)
    private float calificacion;

    public Examen(String descripcion, boolean completada, float calificacion) {
        this.descripcion = descripcion;
        this.completada = completada;
        this.calificacion = calificacion;
    }

    public Examen() {
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public List<PreguntaExamen> getPreguntasExamen() {
        return preguntasExamen;
    }

    public void setPreguntasExamen(List<PreguntaExamen> preguntasExamen) {
        this.preguntasExamen = preguntasExamen;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "idExamen=" + idExamen +
                ", nombreExamen='" + nombreExamen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                ", calificacion=" + calificacion +
                '}';
    }
}
