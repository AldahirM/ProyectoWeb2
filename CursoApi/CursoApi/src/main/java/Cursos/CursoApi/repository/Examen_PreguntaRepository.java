package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Examen_Pregunta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Examen_PreguntaRepository extends CrudRepository<Examen_Pregunta, Integer> {

}
