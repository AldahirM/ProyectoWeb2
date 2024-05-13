package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Escuela;
import Cursos.CursoApi.model.Curso;
import Cursos.CursoApi.repository.EscuelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/escuela")
public class EscuelaController {
    @Autowired
    EscuelaRepository escuelaRepository;

    @GetMapping
    public ResponseEntity<Iterable<Escuela>> getEscuelas() {
        return ResponseEntity.ok(escuelaRepository.findAll());
    }

    @GetMapping("/{idEscuela}")
    public ResponseEntity<Escuela> getEscuela(@PathVariable String idEscuela) {
        Optional<Escuela> escuelaOptional = escuelaRepository.findById(idEscuela);
        if (escuelaOptional.isPresent()) {
            return ResponseEntity.ok(escuelaOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Escuela newEscuela, UriComponentsBuilder ucb) {
        Escuela savedEscuela = escuelaRepository.save(newEscuela);
        URI uri = ucb.path("/escuela/{idEscuela}").buildAndExpand(savedEscuela.getIdEscuela()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idEscuela}")
    public ResponseEntity<Void> update(@PathVariable String idEscuela, @RequestBody Escuela escuelaAct) {
        Escuela escuelaAnt = escuelaRepository.findById(idEscuela).get();
        if (escuelaAnt != null) {
            escuelaAct.setIdEscuela(escuelaAnt.getIdEscuela());
            escuelaRepository.save(escuelaAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idEscuela}")
    public ResponseEntity<Void> delete(@PathVariable String idEscuela) {
        if (escuelaRepository.findById(idEscuela).get() != null) {
            escuelaRepository.deleteById(idEscuela);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{idEscuela}/cursos")
    public ResponseEntity<Iterable<Curso>> getCursos(@PathVariable String idEscuela) {
        Optional<Escuela> escuelaOptional = escuelaRepository.findById(idEscuela);
        if (!(escuelaOptional.isPresent())) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(escuelaOptional.get().getCursos());
    }
}
