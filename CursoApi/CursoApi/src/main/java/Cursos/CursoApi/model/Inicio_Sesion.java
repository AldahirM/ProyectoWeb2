package Cursos.CursoApi.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class Inicio_Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Inicio_Sesion;

    @OneToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;

    @Column(nullable = false, length = 20)
    private Date fecha;

    @Column(nullable = false, length = 20)
    private Time hora;

    @Column(nullable = false, length = 5)
    private boolean valido;

    public Inicio_Sesion(Usuario usuario, Date fecha, Time hora, boolean valido) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.valido = valido;
    }

    public Inicio_Sesion() {
    }

    public Integer getIdInicio_Sesion() {
        return id_Inicio_Sesion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setId_Inicio_Sesion(Integer id_Inicio_Sesion) {
        this.id_Inicio_Sesion = id_Inicio_Sesion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

    @Override
    public String toString() {
        return "InicioSesion{" +
                "idInicio_Sesion=" + id_Inicio_Sesion +
                ", Usuario=" + usuario +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", valido=" + valido +
                '}';
    }

}