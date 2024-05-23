package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.InicioSesion;
import Cursos.CursoApi.model.Usuario;
import Cursos.CursoApi.repository.Inicio_SesionRepository;
import Cursos.CursoApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/iniciosesion")
public class InicioSesionController {

    @Autowired
    Inicio_SesionRepository inicioSesionRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<Iterable<InicioSesion>> getInicioSesiones() {
        return ResponseEntity.ok(inicioSesionRepository.findAll());
    }

    @GetMapping("/{idInicioSesion}")
    public ResponseEntity<InicioSesion> getInicioSesion(@PathVariable Integer idInicioSesion) {
        Optional<InicioSesion> inicioSesionOptional = inicioSesionRepository.findById(idInicioSesion);
        if (inicioSesionOptional.isPresent()) {
            return ResponseEntity.ok(inicioSesionOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody InicioSesion newInicioSesion, UriComponentsBuilder ucb) {
        InicioSesion savedInicioSesion = inicioSesionRepository.save(newInicioSesion);
        URI uri = ucb.path("/iniciosesion/{idInicioSesion}").buildAndExpand(savedInicioSesion.getIdInicioSesion()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idInicioSesion}")
    public ResponseEntity<Void> update(@PathVariable Integer idInicioSesion, @RequestBody InicioSesion inicioSesionAct) {
        InicioSesion inicioSesionAnt = inicioSesionRepository.findById(idInicioSesion).get();
        if (inicioSesionAnt != null) {
            inicioSesionAct.setIdInicioSesion(inicioSesionAnt.getIdInicioSesion());
            inicioSesionRepository.save(inicioSesionAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idInicioSesion}")
    public ResponseEntity<Void> delete(@PathVariable Integer idInicioSesion) {
        Optional<InicioSesion> inicioSesionOptional = inicioSesionRepository.findById(idInicioSesion);
        if (inicioSesionOptional.isPresent()) {
            inicioSesionRepository.deleteById(idInicioSesion);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/usuario/{idCorreo}")
    public ResponseEntity<InicioSesion> getInicioSesionByUsuario(@PathVariable String idCorreo) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idCorreo);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get().getInicioSesion());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
