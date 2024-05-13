package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Actividad;
import Cursos.CursoApi.model.Pregunta;
import Cursos.CursoApi.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/pregunta")
public class PreguntaController {

    @Autowired
    private PreguntaRepository preguntaRepository;

    //Consulta general
    @GetMapping()
    public ResponseEntity<Iterable<Pregunta>> findAll(){
        return ResponseEntity.ok(preguntaRepository.findAll());
    }

    //Consulta por id
    @GetMapping("/{idPregunta}")
    public  ResponseEntity<Pregunta> findById(@PathVariable Integer idPregunta){
        Optional<Pregunta> preguntaOptional = preguntaRepository.findById(idPregunta);
        if (!preguntaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(preguntaOptional.get());
    }

    //Crear una pregunta
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Pregunta pregunta, UriComponentsBuilder ucb){

        Pregunta savedPregunta = preguntaRepository.save(pregunta);
        URI uri = ucb
                .path("pregunta/{idPregunta}")
                .buildAndExpand(savedPregunta.getId_Pregunta())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    //Actualizar una pregunta
    @PutMapping ("/{idPregunta}")
    public ResponseEntity<Void> update (@PathVariable Integer idPregunta, @RequestBody Pregunta pregunta){

        Optional<Pregunta> preguntaOptional = preguntaRepository.findById(idPregunta);

        if (!preguntaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }


        pregunta.setId_Pregunta(preguntaOptional.get().getId_Pregunta());
        preguntaRepository.save(pregunta);
        return ResponseEntity.noContent().build();
    }
}
