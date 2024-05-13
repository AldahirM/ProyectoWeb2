package Cursos.CursoApi.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Examen;

    @OneToMany(mappedBy = "examen")
    private List<Examen_Pregunta> examen_preguntas;

    @OneToOne (mappedBy = "examen", cascade = CascadeType.ALL)
    Leccion leccion;

    @Column(nullable = false, length = 6)
    private double calificacion;

    public Examen() {

    }

    public Examen(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setExamen_preguntas(List<Examen_Pregunta> examen_preguntas) {
        this.examen_preguntas = examen_preguntas;
    }

    public Integer getIdExamen() {
        return id_Examen;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setIdExamen(Integer idExamen) {
        this.id_Examen = idExamen;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public List<Examen_Pregunta> getExamen_preguntas() {
        return examen_preguntas;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "idExamen=" + id_Examen +
                ", calificacion=" + calificacion +
                '}';
    }
}
