package Cursos.CursoApi.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Docente;

    @OneToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario; 

    @OneToOne
    @JoinColumn(name = "id_Escuela")
    private Escuela escuela;

    @OneToMany (mappedBy = "docente", cascade = CascadeType.ALL)
    List<Curso> cursos;

    @Column(nullable = false, length = 15)
    private String telefono;

    public Docente(Usuario usuario, Escuela escuela, String telefono) {
        this.usuario = usuario;
        this.escuela = escuela;
        this.telefono = telefono;
    }

    public Docente() {
    }

    public Integer getId_Docente() {
        return id_Docente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId_Docente(Integer id_Docente) {
        this.id_Docente = id_Docente;
    }

    public void setUsuario(Usuario id_Usuario) {
        this.usuario = id_Usuario;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "id_Docente=" + id_Docente +
                ", Usuario=" + usuario +
                ", Escuela=" + escuela +
                ", telefono=" + telefono +
                '}';
    }
}
