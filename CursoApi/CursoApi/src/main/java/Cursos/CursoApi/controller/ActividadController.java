package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Actividad;
import Cursos.CursoApi.model.Curso;
import Cursos.CursoApi.model.Docente;
import Cursos.CursoApi.model.Escuela;
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
    @GetMapping("/{idActividad}")
    public  ResponseEntity<Actividad> findById(@PathVariable Integer idActividad){
        Optional<Actividad> actividadOptional = actividadRepository.findById(idActividad);
        if (!actividadOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actividadOptional.get());
    }

    //Crear una actividad
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Actividad actividad, UriComponentsBuilder ucb){

        Actividad savedActividad = actividadRepository.save(actividad);
        URI uri = ucb
                .path("actividad/{idActividad}")
                .buildAndExpand(savedActividad.getId_Actividad())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    //Actualizar una actividad
    @PutMapping ("/{idActividad}")
    public ResponseEntity<Void> update (@PathVariable Integer idActividad, @RequestBody Actividad actividad){

        Optional<Actividad> actividadOptional = actividadRepository.findById(idActividad);

        if (!actividadOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }


        actividad.setId_Actividad(actividadOptional.get().getId_Actividad());
        actividadRepository.save(actividad);
        return ResponseEntity.noContent().build();
    }

    //Borrar una actividad
    @DeleteMapping("/{idActividad}")
    public ResponseEntity<Void> delete (@PathVariable Integer idActividad){
        if (actividadRepository.findById(idActividad).get() == null){
            return ResponseEntity.notFound().build();
        }
        actividadRepository.deleteById(idActividad);
        return ResponseEntity.noContent().build();
    }
}
