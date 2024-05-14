package Cursos.CursoApi.model;

import jakarta.persistence.*;

public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;

    @ManyToOne
    @JoinColumn(name = "idExamen")
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "idActividad")
    private Actividad actividad;

    @Column(nullable = false, length = 250)
    private String pregunta;

    @Column(nullable = false, length = 250)
    private String respuestaUsuario;

    @Column(nullable = false, length = 250)
    private String respuestaCorrecta;

    @Column(nullable = false, length = 5)
    private boolean esCorrecto;

    // Setters
    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setRespuestaUsuario(String respuestaUsuario) {
        this.respuestaUsuario = respuestaUsuario;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void setEsCorrecto(boolean esCorrecto) {
        this.esCorrecto = esCorrecto;
    }

    // Getters
    public Integer getIdPregunta() {
        return idPregunta;
    }

    public Examen getExamen() {
        return examen;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuestaUsuario() {
        return respuestaUsuario;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public boolean isEsCorrecto() {
        return esCorrecto;
    }

    // toString
    @Override
    public String toString() {
        return "Pregunta{" +
                "idPregunta=" + idPregunta +
                ", examen=" + examen +
                ", actividad=" + actividad +
                ", pregunta='" + pregunta + '\'' +
                ", respuestaUsuario='" + respuestaUsuario + '\'' +
                ", respuestaCorrecta='" + respuestaCorrecta + '\'' +
                ", esCorrecto=" + esCorrecto +
                '}';
    }


}
