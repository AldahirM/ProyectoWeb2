package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.InicioSesion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Inicio_SesionRepository extends CrudRepository<InicioSesion, Integer> {
    
}
