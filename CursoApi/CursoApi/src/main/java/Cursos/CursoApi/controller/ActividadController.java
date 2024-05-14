package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Actividad;
import Cursos.CursoApi.repository.ActividadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    private ActividadRepository actividadRepository;


    //Consulta general
    @GetMapping()
    public ResponseEntity<Iterable<Actividad>> findAll(){
        return ResponseEntity.ok(actividadRepository.findAll());
    }

    //Consulta por id
    @GetMapping("/{idExamen}")
    public  ResponseEntity<Actividad> findById(@PathVariable Integer idActividad){
        Optional<Actividad> examenOptional = actividadRepository.findById(idActividad);
        if (!examenOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(examenOptional.get());
    }

    //Crear un examen
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Actividad actividad, UriComponentsBuilder ucb){

        Actividad savedActividad = actividadRepository.save(actividad);
        URI uri = ucb
                .path("actividad/{idActividad}")
                .buildAndExpand(savedActividad.getIdActividad())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    //Actualizar un examen
    @PutMapping ("/{idActividad}")
    public ResponseEntity<Void> update (@PathVariable Integer idActividad, @RequestBody Actividad actividad){

        Optional<Actividad> actividadOptional = actividadRepository.findById(idActividad);
        if (!actividadOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        actividad.setIdActividad(actividadOptional.get().getIdActividad());
        actividadRepository.save(actividad);
        return ResponseEntity.noContent().build();
    }

    //Borrar un curso
    @DeleteMapping("/{idExamen}")
    public ResponseEntity<Void> delete (@PathVariable Integer idActividad){
        if (actividadRepository.findById(idActividad).get() == null){
            return ResponseEntity.notFound().build();
        }
        actividadRepository.deleteById(idActividad);
        return ResponseEntity.noContent().build();
    }
}
