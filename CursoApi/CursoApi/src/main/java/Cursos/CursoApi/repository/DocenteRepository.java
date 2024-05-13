package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Docente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, Integer> {
    
}
