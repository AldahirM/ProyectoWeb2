package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Usuario;
import Cursos.CursoApi.model.Curso;
import Cursos.CursoApi.repository.UsuarioRepository;
import Cursos.CursoApi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> getUsuarios() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable String idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Usuario newUsuario, UriComponentsBuilder ucb) {
        Usuario savedUsuario = usuarioRepository.save(newUsuario);
        URI uri = ucb.path("/usuario/{id_Usuario}").buildAndExpand(savedUsuario.getIdCorreo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Void> update(@PathVariable String idUsuario, @RequestBody Usuario usuarioAct) {
        Usuario usuarioAnt = usuarioRepository.findById(idUsuario).get();
        if (usuarioAnt != null) {
            usuarioAct.setIdCorreo((usuarioAnt.getIdCorreo()));
            usuarioRepository.save(usuarioAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_Usuario}")
    public ResponseEntity<Void> delete(@PathVariable String idUsuario) {
        if (usuarioRepository.findById(idUsuario).isPresent()) {
            usuarioRepository.deleteById(idUsuario);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{idCorreo}/curso/{idCurso}")
    public ResponseEntity<Usuario> addUsuario(@PathVariable(value = "idCorreo") String idCorreo,
            @PathVariable(value = "idCurso") Integer idCurso) {
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idCorreo);
        if (!cursoOptional.isPresent() || !usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else if (!cursoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            Curso curso = cursoOptional.get();
            Usuario usuario = usuarioOptional.get();
            curso.addUsuarios(usuario);
            usuarioRepository.save(usuario);
        }
        return ResponseEntity.ok(usuarioOptional.get());
    }

    @GetMapping("/{idUsuario}/cursos")
    public ResponseEntity<Iterable<Curso>> getCursos(@PathVariable String idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioOptional.get().getCursos());
        
    }
}
