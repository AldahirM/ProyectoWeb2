package Cursos.CursoApi.model;

import java.util.List;
import jakarta.persistence.*;
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Alumno;

    @OneToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Alumno_Certificado> alumno_certificados;

    @Column(nullable = false, length = 2)
    private int grado;

    public Alumno(Usuario usuario, int grado) {
        this.usuario = usuario;
        this.grado = grado;
    }

    public Alumno() {
    }

    public Integer getId_Alumno() {
        return id_Alumno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getGrado() {
        return grado;
    }

    public List<Alumno_Certificado> getAlumno_certificados() {
        return alumno_certificados;
    }

    public void setId_Alumno(Integer id_Alumno) {
        this.id_Alumno = id_Alumno;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public void setAlumno_certificados(List<Alumno_Certificado> alumno_certificados) {
        this.alumno_certificados = alumno_certificados;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id_Alumno=" + id_Alumno +
                ", Usuario=" + usuario +
                ", grado=" + grado +
                '}';
    }
}
