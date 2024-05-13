package Cursos.CursoApi.model;

import jakarta.persistence.*;
@Entity
public class Alumno_Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Alumno_Certificado;

    @ManyToOne
    @JoinColumn(name = "id_Alumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_Certificado")
    private Certificado certificado;

    public Alumno_Certificado() {
    }

    public Alumno_Certificado(Alumno alumno, Certificado certificado) {
        this.alumno = alumno;
        this.certificado = certificado;
    }

    public Integer getId_Alumno_Certificado() {
        return id_Alumno_Certificado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setId_Alumno_Certificado(Integer id_Alumno_Certificado) {
        this.id_Alumno_Certificado = id_Alumno_Certificado;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    @Override
    public String toString() {
        return "AlumnoCertificado{" +
                "id_Alumno_Certificado=" + id_Alumno_Certificado +
                ", alumno=" + alumno +
                ", certificado=" + certificado +
                '}';
    }
}
