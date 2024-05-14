package Cursos.CursoApi.model;
import java.sql.Date;

import java.util.List;
import jakarta.persistence.*;
@Entity
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer idCertificado;

    

}
