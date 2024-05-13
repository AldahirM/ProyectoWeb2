package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Pregunta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends CrudRepository<Pregunta, Integer> {

}
