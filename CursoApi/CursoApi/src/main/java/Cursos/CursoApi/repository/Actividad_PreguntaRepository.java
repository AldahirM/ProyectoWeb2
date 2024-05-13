package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Actividad_Pregunta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Actividad_PreguntaRepository extends CrudRepository<Actividad_Pregunta, Integer> {

}
