package Cursos.CursoApi.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idActividad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCurso")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Curso curso;

    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    private List<PreguntaActividad> preguntasActividad;

    @Column(nullable = false, length = 250)
    private String tituloActividad;

    @Column(nullable = false, length = 6)
    private boolean completada;

    @Column(nullable = false, length = 6)
    private float calificacion;

    public Actividad(String tituloActividad, boolean completada, float calificacion) {
        this.tituloActividad = tituloActividad;
        this.completada = completada;
        this.calificacion = calificacion;
    }

    public Actividad() {
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public String getTituloActividad() {
        return tituloActividad;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<PreguntaActividad> getPreguntasActividad() {
        return preguntasActividad;
    }

    public Curso getCursos() {
        return curso;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public void setTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setPreguntasActividad(List<PreguntaActividad> preguntasActividad) {
        this.preguntasActividad = preguntasActividad;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "idActividad=" + idActividad +
                ", tituloActividad='" + tituloActividad + '\'' +
                ", completada=" + completada +
                ", calificacion=" + calificacion +
                '}';
    }

}
