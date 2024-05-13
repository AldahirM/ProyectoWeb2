package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Curso_Leccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Curso_LeccionRepository extends CrudRepository<Curso_Leccion, Integer> {

}
