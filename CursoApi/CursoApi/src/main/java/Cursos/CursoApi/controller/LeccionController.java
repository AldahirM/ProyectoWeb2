package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Curso;
import Cursos.CursoApi.model.Docente;
import Cursos.CursoApi.model.Escuela;
import Cursos.CursoApi.model.Leccion;
import Cursos.CursoApi.repository.ExamenRepository;
import Cursos.CursoApi.repository.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/leccion")
public class LeccionController {

    @Autowired
    private LeccionRepository leccionRepository;

    @Autowired
    private ExamenRepository examenRepository;

    //Consulta general
    @GetMapping()
    public ResponseEntity<Iterable<Leccion>> findAll(){
        return ResponseEntity.ok(leccionRepository.findAll());
    }

    //Consulta por id
    @GetMapping("/{idLeccion}")
    public  ResponseEntity<Leccion> findById(@PathVariable Integer idLeccion){
        Optional<Leccion> leccionOptional = leccionRepository.findById(idLeccion);
        if (!leccionOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(leccionOptional.get());
    }

    //Crear una leccion
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Leccion leccion, UriComponentsBuilder ucb){

        Leccion savedLeccion= leccionRepository.save(leccion);
        URI uri = ucb
                .path("leccion/{idLeccion}")
                .buildAndExpand(savedLeccion.getId_Leccion())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    //Actualizar una leccion
    @PutMapping ("/{idLeccion}")
    public ResponseEntity<Void> update (@PathVariable Integer idLeccion, @RequestBody Leccion leccion){

        Optional<Leccion> leccionOptional = leccionRepository.findById(idLeccion);
        if (!leccionOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        leccion.setId_Leccion(leccionOptional.get().getId_Leccion());
        leccionRepository.save(leccion);
        return ResponseEntity.noContent().build();
    }

    //Borrar una leccion
    @DeleteMapping("/{idLeccion}")
    public ResponseEntity<Void> delete (@PathVariable Integer idLeccion){
        if (leccionRepository.findById(idLeccion).get() == null){
            return ResponseEntity.notFound().build();
        }
        leccionRepository.deleteById(idLeccion);
        return ResponseEntity.noContent().build();
    }

}
