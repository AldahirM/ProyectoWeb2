package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Examen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends CrudRepository<Examen, Integer> {

}
