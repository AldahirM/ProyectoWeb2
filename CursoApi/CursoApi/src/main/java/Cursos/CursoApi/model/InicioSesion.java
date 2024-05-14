package Cursos.CursoApi.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class InicioSesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInicioSesion;

    @OneToOne
    @JoinColumn(name = "idCorreo")
    private Usuario usuario;

    @Column(nullable = false, length = 20)
    private Date fecha;

    @Column(nullable = false, length = 20)
    private Time hora;

    @Column(nullable = false, length = 5)
    private boolean valido;

    public InicioSesion(Date fecha, Time hora, boolean valido) {
        this.fecha = fecha;
        this.hora = hora;
        this.valido = valido;
    }

    public InicioSesion() {
    }

    public Integer getIdInicio_Sesion() {
        return idInicioSesion;
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

    public void setIdInicioSesion(Integer idInicioSesion) {
        this.idInicioSesion = idInicioSesion;
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
                "idInicio_Sesion=" + idInicioSesion +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", valido=" + valido +
                '}';
    }

}