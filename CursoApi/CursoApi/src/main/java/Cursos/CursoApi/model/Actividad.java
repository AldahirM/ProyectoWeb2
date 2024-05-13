package Cursos.CursoApi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idActividad;

    @ManyToOne
    private List<Curso> cursos;
    
    @Column(nullable = false, length = 250)
    private String descripcion;

    @Column(nullable = false, length = 5)
    private boolean esCorrecto;

    @Column(nullable = false, length = 6)
    private float calificacion;

    public Actividad(String descripcion, boolean esCorrecto, float calificacion) {
        this.descripcion = descripcion;
        this.esCorrecto = esCorrecto;
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
