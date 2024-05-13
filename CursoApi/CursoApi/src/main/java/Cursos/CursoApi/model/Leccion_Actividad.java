package Cursos.CursoApi.model;

import jakarta.persistence.*;

@Entity
public class Leccion_Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Leccion_Actividad;

    @ManyToOne
    @JoinColumn(name = "id_Actividad")
    private Actividad actividad;
    
    @ManyToOne
    @JoinColumn(name = "id_Leccion")
    private Leccion leccion;

    public Leccion_Actividad() {
    }

    public Leccion_Actividad(Leccion leccion, Actividad actividad) {
        this.leccion = leccion;
        this.actividad = actividad;
    }

    public Integer getId_Leccion_Actividad() {
        return id_Leccion_Actividad;
    }

    public Leccion getLeccion() {
        return leccion;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setId_Leccion_Actividad(Integer id_Leccion_Actividad) {
        this.id_Leccion_Actividad = id_Leccion_Actividad;
    }

    public void setLeccion(Leccion leccion) {
        this.leccion = leccion;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        return "Leccion_Actividad{" +
                "id_Leccion_Actividad=" + id_Leccion_Actividad +
                ", leccion=" + leccion +
                ", actividad=" + actividad +
                '}';
    }

}
