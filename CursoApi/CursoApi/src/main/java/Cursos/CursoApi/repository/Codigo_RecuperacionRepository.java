package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Codigo_Recuperacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Codigo_RecuperacionRepository extends CrudRepository<Codigo_Recuperacion, Integer> {

}
