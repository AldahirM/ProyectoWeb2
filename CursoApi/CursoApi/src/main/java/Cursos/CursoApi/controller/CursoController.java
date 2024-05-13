package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Curso;
import Cursos.CursoApi.model.Docente;
import Cursos.CursoApi.model.Escuela;
import Cursos.CursoApi.repository.CursoRepository;
import Cursos.CursoApi.repository.DocenteRepository;
import Cursos.CursoApi.repository.EscuelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    //Consulta general
    @GetMapping()
    public ResponseEntity<Iterable<Curso>> findAll(){
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
        /*Optional<Docente> docenteOptional = docenteRepository.findById(curso.getDocente().getId_Docente());

        if (!docenteOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        curso.setDocente(docenteOptional.get());
        */
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
        Optional<Docente> docenteOptional = docenteRepository.findById(curso.getDocente().getId_Docente());

        if (!docenteOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        if (!cursoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        curso.setDocente(docenteOptional.get());

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


    @GetMapping("/escuela/{idCurso}")
    public ResponseEntity<Escuela> findByIdEscuela(@PathVariable Integer idCurso) {
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        if (!cursoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Curso curso = cursoOptional.get(); // Obtener el curso de la opción opcional
        Escuela escuela = curso.getEscuela(); // Acceder a la escuela asociada al curso
        return ResponseEntity.ok(escuela);
    }



}

