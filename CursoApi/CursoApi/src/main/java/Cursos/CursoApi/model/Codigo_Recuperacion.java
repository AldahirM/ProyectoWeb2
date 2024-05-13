package Cursos.CursoApi.model;

import jakarta.persistence.*;
@Entity
public class Codigo_Recuperacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Codigo_Recuperacion;

    @OneToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;
    
    @Column (nullable = false, length = 50)
    private String codigo;

    public Codigo_Recuperacion(String codigo) {
        this.codigo = codigo;
    }

    public Codigo_Recuperacion() {
    }

    public Integer getIdCodigoRecuperacion() {
        return id_Codigo_Recuperacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setIdCodigoRecuperacion(Integer id_Codigo_Recuperacion) {
        this.id_Codigo_Recuperacion = id_Codigo_Recuperacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Codigo_Recuperación{" +
                ", idCodigoRecuperacion=" + id_Codigo_Recuperacion +
                ", usuario=" + usuario +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
