package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Certificado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificadoRepository extends CrudRepository<Certificado, Integer> {

}
