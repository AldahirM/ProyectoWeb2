package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Leccion_Actividad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Leccion_ActividadRepository extends CrudRepository<Leccion_Actividad, Integer> {

}
