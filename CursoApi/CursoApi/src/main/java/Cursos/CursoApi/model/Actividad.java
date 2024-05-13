package Cursos.CursoApi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Actividad;

    @OneToMany(mappedBy = "actividad")
    private List<Leccion_Actividad> leccion_actividades;

    @OneToMany(mappedBy = "actividad")
    private List<Actividad_Pregunta> actividad_preguntas;

    @Column(nullable = false, length = 250)
    private String descripcion;

    @Column(nullable = false, length = 5)
    private boolean completada;

    @Column(nullable = false, length = 6)
    private double calificacion;

    public Actividad(String descripcion, boolean completada, double calificacion) {
        this.descripcion = descripcion;
        this.completada = completada;
        this.calificacion = calificacion;
    }

    public Actividad() {
    }

    public Integer getId_Actividad() {
        return id_Actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean getCompletada() {
        return completada;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setId_Actividad(Integer id_Actividad) {
        this.id_Actividad = id_Actividad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setActividad_preguntas(List<Actividad_Pregunta> actividad_preguntas) {
        this.actividad_preguntas = actividad_preguntas;
    }

    public void setLeccion_actividades(List<Leccion_Actividad> leccion_actividades) {
        this.leccion_actividades = leccion_actividades;
    }

    public List<Leccion_Actividad> getLeccion_actividades() {
        return leccion_actividades;
    }

    public List<Actividad_Pregunta> getActividad_preguntas() {
        return actividad_preguntas;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "id_Actividad=" + id_Actividad +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                ", calificacion=" + calificacion +
                '}';
    }

}
