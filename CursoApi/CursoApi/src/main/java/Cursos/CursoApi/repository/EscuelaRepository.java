package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Escuela;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscuelaRepository extends CrudRepository<Escuela, String> {

}
