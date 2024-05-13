package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Usuario;
import Cursos.CursoApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;




@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> getUsuarios() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id_Usuario}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id_Usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id_Usuario);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/{correo}")
    public ResponseEntity<Usuario> buscarPorCorreo(@PathVariable String correo) {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Usuario newUsuario, UriComponentsBuilder ucb) {
        Usuario savedUsuario = usuarioRepository.save(newUsuario);
        URI uri = ucb.path("/usuario/{id_Usuario}").buildAndExpand(savedUsuario.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id_Usuario}")
    public ResponseEntity<Void> update(@PathVariable Integer id_Usuario, @RequestBody Usuario usuarioAct) {
        Usuario usuarioAnt = usuarioRepository.findById(id_Usuario).get();
        if (usuarioAnt != null) {
            usuarioAct.setIdUsuario((usuarioAnt.getIdUsuario()));
            usuarioRepository.save(usuarioAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_Usuario}")
    public ResponseEntity<Void> delete(@PathVariable Integer id_Usuario) {
        if (usuarioRepository.findById(id_Usuario).isPresent()) {
            usuarioRepository.deleteById(id_Usuario );
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
