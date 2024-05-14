package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.PreguntaActividad;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaActividadRepository extends CrudRepository<PreguntaActividad, Integer> {
}
