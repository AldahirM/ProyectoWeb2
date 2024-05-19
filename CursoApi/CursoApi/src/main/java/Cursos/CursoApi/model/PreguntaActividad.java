package Cursos.CursoApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
public class PreguntaActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPreguntaActividad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idActividad")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Actividad actividad;

    @Column(nullable = false, length = 250)
    private String pregunta;

    @Column(nullable = true, length = 250)
    private String respuestaUsuario;

    @Column(nullable = false, length = 250)
    private String respuestaCorrecta;

    @Column(nullable = false, length = 5)
    private boolean esCorrecto;

    @Column(length = 50000)
    private String informacion;

    // Setters
    public void setIdPregunta(Integer idPregunta) {
        this.idPreguntaActividad = idPregunta;
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

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    // Getters
    public Integer getIdPregunta() {
        return idPreguntaActividad;
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

    public String getInformacion() {
        return informacion;
    }

    // toString
    @Override
    public String toString() {
        return "PreguntaActividad{" +
                "idPreguntaActividad=" + idPreguntaActividad +
                ", pregunta='" + pregunta + '\'' +
                ", respuestaUsuario='" + respuestaUsuario + '\'' +
                ", respuestaCorrecta='" + respuestaCorrecta + '\'' +
                ", esCorrecto=" + esCorrecto +
                ", informacion='" + informacion + '\'' +
                '}';
    }
}
