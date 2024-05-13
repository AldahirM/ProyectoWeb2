package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Leccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeccionRepository extends CrudRepository<Leccion, Integer> {

}
