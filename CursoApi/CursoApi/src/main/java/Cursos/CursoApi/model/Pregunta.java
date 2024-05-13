package Cursos.CursoApi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Pregunta;

    @OneToMany(mappedBy = "pregunta")
    private List<Examen_Pregunta> examen_preguntas;

    @OneToMany(mappedBy = "pregunta")
    private List<Actividad_Pregunta> actividad_preguntas;

    @Column(nullable = false, length = 5)
    private boolean completada;

    @Column(nullable = true, length = 250)
    private String Respuesta_Usuario;

    @Column(nullable = true, length = 250)
    private String Respuesta_Correcta;

    public Pregunta(boolean completada, String respuesta_Usuario, String respuesta_Correcta) {
        this.completada = completada;
        this.Respuesta_Usuario = respuesta_Usuario;
        this.Respuesta_Correcta = respuesta_Correcta;
    }

    public Pregunta() {
    }

    public Integer getId_Pregunta() {
        return id_Pregunta;
    }

    public List<Actividad_Pregunta> getActividad_preguntas() {
        return actividad_preguntas;
    }

    public List<Examen_Pregunta> getExamen_preguntas() {
        return examen_preguntas;
    }

    public void setActividad_preguntas(List<Actividad_Pregunta> actividad_preguntas) {
        this.actividad_preguntas = actividad_preguntas;
    }

    public void setExamen_preguntas(List<Examen_Pregunta> examen_preguntas) {
        this.examen_preguntas = examen_preguntas;
    }

    public String getRespuesta_Usuario() {
        return Respuesta_Usuario;
    }

    public String getRespuesta_Correcta() {
        return Respuesta_Correcta;
    }

    public boolean getCompletada() {
        return completada;
    }

    public void setId_Pregunta(Integer id_Pregunta) {
        this.id_Pregunta = id_Pregunta;
    }

    public void setRespuesta_Usuario(String respuesta_Usuario) {
        Respuesta_Usuario = respuesta_Usuario;
    }

    public void setRespuesta_Correcta(String respuesta_Correcta) {
        Respuesta_Correcta = respuesta_Correcta;
    }

    public void setCompletada(boolean completada) {

        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id_Pregunta=" + id_Pregunta +
                ", completada=" + completada +
                ", Respuesta_Usuario='" + Respuesta_Usuario + '\'' +
                ", Respuesta_Correcta='" + Respuesta_Correcta + '\'' +
                '}';

    }

}
