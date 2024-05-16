package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Curso;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer> {
    //List<Curso> findCursosByIdCorreo(String idCorreo);
}
