package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Alumno_Certificado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Alumno_CertificadoRepository extends CrudRepository<Alumno_Certificado, Integer> {
    
}
