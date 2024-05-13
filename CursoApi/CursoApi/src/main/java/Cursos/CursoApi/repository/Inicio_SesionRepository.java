package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Inicio_Sesion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Inicio_SesionRepository extends CrudRepository<Inicio_Sesion, Integer> {
    
}
