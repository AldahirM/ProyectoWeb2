package Cursos.CursoApi.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Leccion;

    @OneToOne
    @JoinColumn(name = "id_Examen")
    private Examen examen;

    @OneToMany(mappedBy = "leccion")
    private List<Curso_Leccion> curso_Lecciones;

    @OneToMany(mappedBy = "leccion")
    private List<Leccion_Actividad> leccion_Actividades;

    @Column(nullable = false, length = 6)
    private double calificacion;

    public Leccion(double calificacion) {
        this.calificacion = calificacion;
    }

    public Leccion() {
    }

    public Integer getId_Leccion() {
        return id_Leccion;
    }

    public List<Curso_Leccion> getCurso_Lecciones() {
        return curso_Lecciones;
    }

    public List<Leccion_Actividad> getLeccion_Actividades() {
        return leccion_Actividades;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setId_Leccion(Integer id_Leccion) {
        this.id_Leccion = id_Leccion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Leccion{" +
                "id_Leccion=" + id_Leccion +
                ", calificacion=" + calificacion +
                '}';
    }
    
}
