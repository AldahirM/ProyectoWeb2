package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.*;
import Cursos.CursoApi.repository.ExamenRepository;
import Cursos.CursoApi.repository.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/examen")
public class ExamenController {

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private LeccionRepository leccionRepository;

    //Consulta general
    @GetMapping()
    public ResponseEntity<Iterable<Examen>> findAll(){
        return ResponseEntity.ok(examenRepository.findAll());
    }

    //Consulta por id
    @GetMapping("/{idExamen}")
    public  ResponseEntity<Examen> findById(@PathVariable Integer idExamen){
        Optional<Examen> examenOptional = examenRepository.findById(idExamen);
        if (!examenOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(examenOptional.get());
    }

    //Crear un examen
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Examen examen, UriComponentsBuilder ucb){

        Examen savedExamen = examenRepository.save(examen);
        URI uri = ucb
                .path("examen/{idExamen}")
                .buildAndExpand(savedExamen.getIdExamen())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    //Actualizar un examen
    @PutMapping ("/{idExamen}")
    public ResponseEntity<Void> update (@PathVariable Integer idExamen, @RequestBody Examen examen){

        Optional<Examen> examenOptional = examenRepository.findById(idExamen);
        if (!examenOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        examen.setIdExamen(examenOptional.get().getIdExamen());
        examenRepository.save(examen);
        return ResponseEntity.noContent().build();
    }

    //Borrar un curso
    @DeleteMapping("/{idExamen}")
    public ResponseEntity<Void> delete (@PathVariable Integer idExamen){
        if (examenRepository.findById(idExamen).get() == null){
            return ResponseEntity.notFound().build();
        }
        examenRepository.deleteById(idExamen);
        return ResponseEntity.noContent().build();
    }
}
