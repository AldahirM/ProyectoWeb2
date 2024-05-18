package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Actividad;
import Cursos.CursoApi.model.Curso;
import Cursos.CursoApi.model.Usuario;
import Cursos.CursoApi.repository.CursoRepository;
import Cursos.CursoApi.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Consulta general
    @GetMapping()
    public ResponseEntity<Iterable<Curso>> findAll() {
        return ResponseEntity.ok(cursoRepository.findAll());
    }

    // Consulta por id
    @GetMapping("/{idCurso}")
    public ResponseEntity<Curso> findById(@PathVariable Integer idCurso) {
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        if (!cursoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursoOptional.get());
    }

    // Crear un curso
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Curso curso, UriComponentsBuilder ucb) {

        Curso savedCurso = cursoRepository.save(curso);
        URI uri = ucb
                .path("curso/{idCurso}")
                .buildAndExpand(savedCurso.getIdCurso())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    // Actualizar un curso
    @PutMapping("/{idCurso}")
    public ResponseEntity<Void> update(@PathVariable Integer idCurso, @RequestBody Curso curso) {
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        if (!cursoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        curso.setIdCurso(cursoOptional.get().getIdCurso());
        cursoRepository.save(curso);
        return ResponseEntity.noContent().build();
    }

    // Borrar un curso
    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Void> delete(@PathVariable Integer idCurso) {
        if (cursoRepository.findById(idCurso).get() == null) {
            return ResponseEntity.notFound().build();
        }
        cursoRepository.deleteById(idCurso);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idCurso}/usuarios/{idCorreo}")
    public ResponseEntity<Usuario> addUsuario(@PathVariable(value = "idCurso") Integer idCurso,
            @PathVariable(value = "idCorreo") String idCorreo) {
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idCorreo);
        if (!cursoOptional.isPresent() || !usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else if (!cursoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }else {
            Curso curso = cursoOptional.get();
            Usuario usuario = usuarioOptional.get();
            usuario.addCursos(curso);
            cursoRepository.save(curso);
        }
        return ResponseEntity.ok(usuarioOptional.get());
    }

    @GetMapping("/{idCurso}/actividades")
    public ResponseEntity<List<Actividad>> getActividadesByCursoId(@PathVariable Integer idCurso) {
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        if (!cursoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<Actividad> actividades = cursoOptional.get().getActividades();
        return ResponseEntity.ok(actividades);
    }


}
