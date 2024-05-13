package Cursos.CursoApi.model;

import jakarta.persistence.*;
@Entity
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Administrador;

    @OneToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;

    @Column(nullable = false, length = 15)
    private String telefono;

    public Administrador() {
    }

    public Administrador(Usuario usuario, String telefono) {
        this.usuario = usuario;
        this.telefono = telefono;
    }

    public Integer getId_Administrador() {
        return id_Administrador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId_Administrador(Integer id_Administrador) {
        this.id_Administrador = id_Administrador;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "id_Administrador=" + id_Administrador +
                ", Usuario=" + usuario +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
