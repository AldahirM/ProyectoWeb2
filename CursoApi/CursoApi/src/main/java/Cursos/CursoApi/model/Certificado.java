package Cursos.CursoApi.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCertificado")

public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer idCertificado;

    @OneToOne 
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCorreo")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;

    @Column (nullable = false, length = 250)
    private String nombreCurso;

    @Column (nullable = false, length = 250)
    private String nombreUsuario;

    @Column (nullable = false, length = 250)
    private Date fecha;

    @Column (nullable = false, length = 10)
    private float promedioCurso;

    // Setters
    public void setIdCertificado(Integer idCertificado) {
        this.idCertificado = idCertificado;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPromedioCurso(float promedioCurso) {
        this.promedioCurso = promedioCurso;
    }

    // Getters
    public Integer getIdCertificado() {
        return idCertificado;
    }

    public Curso getCurso() {
        return curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getPromedioCurso() {
        return promedioCurso;
    }

    // toString
    @Override
    public String toString() {
        return "Certificado{" +
                "idCertificado=" + idCertificado +
                ", nombreCurso='" + nombreCurso + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", fecha=" + fecha +
                ", promedioCurso=" + promedioCurso +
                '}';
    }




    

}
