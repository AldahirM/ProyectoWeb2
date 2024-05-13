package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Docente;
import Cursos.CursoApi.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    DocenteRepository docenteRepository;

    @GetMapping
    public ResponseEntity<Iterable<Docente>> getDocentes() {
        return ResponseEntity.ok(docenteRepository.findAll());
    }

    @GetMapping("/{id_Docente}")
    public ResponseEntity<Docente> getDocente(@PathVariable Integer id_Docente) {
        Optional<Docente> docenteOptional = docenteRepository.findById(id_Docente);
        if (docenteOptional.isPresent()) {
            return ResponseEntity.ok(docenteOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Docente newDocente, UriComponentsBuilder ucb) {
        Docente savedDocente = docenteRepository.save(newDocente);
        URI uri = ucb.path("/docente/{id_Docente}").buildAndExpand(savedDocente.getId_Docente()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id_Docente}")
    public ResponseEntity<Void> update(@PathVariable Integer id_Docente, @RequestBody Docente docenteAct) {
        Docente docenteAnt = docenteRepository.findById(id_Docente).get();
        if (docenteAnt != null) {
            docenteAct.setId_Docente((docenteAnt.getId_Docente()));
            docenteRepository.save(docenteAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_Docente}")
    public ResponseEntity<Void> delete(@PathVariable Integer id_Docente) {
        if (docenteRepository.findById(id_Docente).isPresent()) {
            docenteRepository.deleteById(id_Docente);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
