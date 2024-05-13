package Cursos.CursoApi.model;
import jakarta.persistence.*;
@Entity
public class Curso_Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Curso_Leccion;

    @ManyToOne
    @JoinColumn(name = "id_Curso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_Leccion")
    private Leccion leccion;

    public Curso_Leccion() {
    }

    public Curso_Leccion(Curso curso, Leccion leccion) {
        this.curso = curso;
        this.leccion = leccion;
    }

    public Integer getId_Curso_Leccion() {
        return id_Curso_Leccion;
    }

    public Curso getCurso() {
        return curso;
    }

    public Leccion getLeccion() {
        return leccion;
    }

    public void setId_Curso_Leccion(Integer id_Curso_Leccion) {
        this.id_Curso_Leccion = id_Curso_Leccion;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setLeccion(Leccion leccion) {
        this.leccion = leccion;
    }

    @Override
    public String toString() {
        return "Curso_Leccion{" +
                "id_Curso_Leccion=" + id_Curso_Leccion +
                ", curso=" + curso +
                ", leccion=" + leccion +
                '}';
    }
}
