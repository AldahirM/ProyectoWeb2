package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.PreguntaExamen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends CrudRepository<PreguntaExamen, Integer> {

}
