package Cursos.CursoApi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idActividad;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private List<Curso> cursos;

    @Column(nullable = false, length = 250)
    private String pregunta;

    @Column(nullable = false, length = 5)
    private boolean esCorrecto;

    @Column(nullable = false, length = 6)
    private float calificacion;

    public Actividad(String pregunta, boolean esCorrecto, float calificacion) {
        this.pregunta = pregunta;
        this.esCorrecto = esCorrecto;
        this.calificacion = calificacion;
    }

    public Actividad() {
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public boolean getEsCorrecto() {
        return esCorrecto;
    }

    public void setEsCorrecto(boolean esCorrecto) {
        this.esCorrecto = esCorrecto;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "idActividad=" + idActividad +
                ", cursos=" + cursos +
                ", pregunta='" + pregunta + '\'' +
                ", esCorrecto=" + esCorrecto +
                ", calificacion=" + calificacion +
                '}';
    }

}
