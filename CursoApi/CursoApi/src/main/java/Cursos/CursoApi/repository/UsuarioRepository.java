package Cursos.CursoApi.repository;

import Cursos.CursoApi.model.Usuario;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    //List<Usuario> findUsuariosByIdCurso(Integer idCurso);
}
