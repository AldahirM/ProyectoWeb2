package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Curso;
import Cursos.CursoApi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    //Consulta general
    @GetMapping()
    public ResponseEntity<Iterable<Curso>> findAll()
    {
        return ResponseEntity.ok(cursoRepository.findAll());
    }


    //Consulta por id
    @GetMapping("/{idCurso}")
    public  ResponseEntity<Curso> findById(@PathVariable Integer idCurso){
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        if (!cursoOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursoOptional.get());
    }

    //Crear un curso
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Curso curso, UriComponentsBuilder ucb){

        Curso savedCurso = cursoRepository.save(curso);
        URI uri = ucb
                .path("curso/{idCurso}")
                .buildAndExpand(savedCurso.getIdCurso())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    //Actualizar un curso
    @PutMapping ("/{idCurso}")
    public ResponseEntity<Void> update (@PathVariable Integer idCurso, @RequestBody Curso curso){
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        if (!cursoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        curso.setIdCurso(cursoOptional.get().getIdCurso());
        cursoRepository.save(curso);
        return ResponseEntity.noContent().build();
    }

    //Borrar un curso
    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Void> delete (@PathVariable Integer idCurso){
        if (cursoRepository.findById(idCurso).get() == null){
            return ResponseEntity.notFound().build();
        }
        cursoRepository.deleteById(idCurso);
        return ResponseEntity.noContent().build();
    }
    
}
