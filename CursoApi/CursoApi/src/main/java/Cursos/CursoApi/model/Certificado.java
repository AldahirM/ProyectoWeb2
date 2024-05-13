package Cursos.CursoApi.model;
import java.sql.Date;

import java.util.List;
import jakarta.persistence.*;
@Entity
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Certificado;

    @OneToOne
    @JoinColumn(name = "id_Curso")
    private Curso curso;

    @OneToMany(mappedBy = "certificado", cascade = CascadeType.ALL)
    private List<Alumno_Certificado> alumno_certificados;

    @Column(nullable = false, length = 20)
    private Date fechaEmision;

    @Column(nullable = false, length = 6)
    private double calificacion;

    public Certificado(Curso curso, Date fechaEmision, double calificacion) {
        this.curso = curso;
        this.fechaEmision = fechaEmision;
        this.calificacion = calificacion;
    }

    public Certificado() {
    }

    public Integer getId_Certificado() {
        return id_Certificado;
    }

    public Curso getCurso() {
        return curso;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public List<Alumno_Certificado> getAlumno_certificados() {
        return alumno_certificados;
    }

    public void setId_Certificado(Integer id_Certificado) {
        this.id_Certificado = id_Certificado;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setAlumno_certificados(List<Alumno_Certificado> alumno_certificados) {
        this.alumno_certificados = alumno_certificados;
    }

    @Override
    public String toString() {
        return "Certificado{" +
                "id_Certificado=" + id_Certificado +
                ", curso=" + curso +
                ", fechaEmision=" + fechaEmision +
                ", calificacion=" + calificacion +
                '}';
    }


}
