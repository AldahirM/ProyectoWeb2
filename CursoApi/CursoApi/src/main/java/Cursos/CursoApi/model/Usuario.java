package Cursos.CursoApi.model;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @Column(name = "idUsuario", nullable = false, length = 10)
    private String idUsuario;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String imagen;

    @Column(nullable = false, length = 50)
    private String descripcion;

    

}
