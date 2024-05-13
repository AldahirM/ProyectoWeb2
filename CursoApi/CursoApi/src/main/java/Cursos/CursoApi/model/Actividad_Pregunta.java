package Cursos.CursoApi.model;

import jakarta.persistence.*;

@Entity
public class Actividad_Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Actividad_Pregunta;

    @ManyToOne
    @JoinColumn(name = "id_Activdad")
    private Actividad actividad;

    @ManyToOne
    @JoinColumn(name = "id_Pregunta")
    private Pregunta pregunta;

    public Actividad_Pregunta() {
    }

    public Actividad_Pregunta(Actividad actividad, Pregunta pregunta, Actividad_Pregunta actividad_pregunta) {
        this.actividad = actividad;
        this.pregunta = pregunta;
    }

    public Integer getId_Actividad_Pregunta() {
        return id_Actividad_Pregunta;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setId_Actividad_Pregunta(Integer id_Actividad_Pregunta) {
        this.id_Actividad_Pregunta = id_Actividad_Pregunta;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "Actividad_Pregunta{" +
                "id_Actividad_Pregunta=" + id_Actividad_Pregunta +
                ", actividad=" + actividad +
                ", pregunta=" + pregunta +
                '}';
    }

}
