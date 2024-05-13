package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Alumno;
import Cursos.CursoApi.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    AlumnoRepository alumnoRepository;

    @GetMapping
    public ResponseEntity<Iterable<Alumno>> getAlumnos() {
        return ResponseEntity.ok(alumnoRepository.findAll());
    }

    @GetMapping("/{id_Alumno}")
    public ResponseEntity<Alumno> getAlumno(@PathVariable Integer id_Alumno) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id_Alumno);
        if (alumnoOptional.isPresent()) {
            return ResponseEntity.ok(alumnoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Alumno newAlumno, UriComponentsBuilder ucb) {
        Alumno savedAlumno = alumnoRepository.save(newAlumno);
        URI uri = ucb.path("/alumno/{id_Alumno}").buildAndExpand(savedAlumno.getId_Alumno()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id_Alumno}")
    public ResponseEntity<Void> update(@PathVariable Integer id_Alumno, @RequestBody Alumno alumnoAct) {
        Alumno alumnoAnt = alumnoRepository.findById(id_Alumno).get();
        if (alumnoAnt != null) {
            alumnoAct.setId_Alumno(alumnoAnt.getId_Alumno());
            alumnoRepository.save(alumnoAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_Alumno}")
    public ResponseEntity<Void> delete(@PathVariable Integer id_Alumno) {
        if (alumnoRepository.findById(id_Alumno).isPresent()) {
            alumnoRepository.deleteById(id_Alumno);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
