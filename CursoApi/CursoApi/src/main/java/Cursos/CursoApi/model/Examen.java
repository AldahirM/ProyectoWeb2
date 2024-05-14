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
    private List<Pregunta> preguntas;

    @Column(nullable = false, length = 5)
    private boolean esCorrecto;

    @Column(nullable = false, length = 7)
    private float calificacion;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @Column (nullable = false, length = 5)
    private boolean completado;

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public void setEsCorrecto(boolean esCorrecto) {
        this.esCorrecto = esCorrecto;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    // Getters
    public Integer getIdExamen() {
        return idExamen;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public boolean isEsCorrecto() {
        return esCorrecto;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public Curso getCurso() {
        return curso;
    }

    public boolean isCompletado() {
        return completado;
    }

    // toString
    @Override
    public String toString() {
        return "Examen{" +
                "idExamen=" + idExamen +
                ", nombreExamen='" + nombreExamen + '\'' +
                ", preguntas=" + preguntas +
                ", esCorrecto=" + esCorrecto +
                ", calificacion=" + calificacion +
                ", curso=" + curso +
                ", completado=" + completado +
                '}';
    }


}
