package Cursos.CursoApi.model;

import jakarta.persistence.*;

@Entity
public class Examen_Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Examen_Pregunta;

    @ManyToOne
    @JoinColumn(name = "id_Examen")
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "id_Pregunta")
    private Pregunta pregunta;

    public Examen_Pregunta() {
    }

    public Examen_Pregunta(Examen id_Examen, Pregunta pregunta) {
        this.examen = id_Examen;
        this.pregunta = pregunta;
    }

    public Integer getId_Examen_Pregunta() {
        return id_Examen_Pregunta;
    }

    public Examen getExamen() {
        return examen;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setId_Examen_Pregunta(Integer id_Examen_Pregunta) {
        this.id_Examen_Pregunta = id_Examen_Pregunta;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "Examen_Pregunta{" +
                "id_Examen_Pregunta=" + id_Examen_Pregunta +
                ", Examen=" + examen +
                ", id_Pregunta=" + pregunta +
                '}';
    }

}