package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Actividad;
import Cursos.CursoApi.model.Curso;
import Cursos.CursoApi.model.PreguntaActividad;
import Cursos.CursoApi.repository.ActividadRepository;

import Cursos.CursoApi.repository.CursoRepository;
import Cursos.CursoApi.repository.PreguntaActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private PreguntaActividadRepository preguntaActividadRepository;

    //Consulta general
    @GetMapping()
    public ResponseEntity<Iterable<Actividad>> findAll()
    {
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

    //Actualizar una actividad
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
    @DeleteMapping("/{idActividad}")
    public ResponseEntity<Void> delete (@PathVariable Integer idActividad){
        if (actividadRepository.findById(idActividad).get() == null){
            return ResponseEntity.notFound().build();
        }
        actividadRepository.deleteById(idActividad);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/curso/{idCurso}")
    public ResponseEntity<List<Actividad>> findActividadesByCursoId(@PathVariable Integer idCurso) {
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        if (!cursoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<Actividad> actividades = cursoOptional.get().getActividades();
        return ResponseEntity.ok(actividades);
    }

    @GetMapping("/{idActividad}/preguntas")
    public ResponseEntity<List<PreguntaActividad>> getPreguntasByActividadId(@PathVariable Integer idActividad) {
        Optional<Actividad> actividadOptional = actividadRepository.findById(idActividad);
        if (!actividadOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<PreguntaActividad> preguntas = actividadOptional.get().getPreguntasActividad(); // Suponiendo que tienes un método getPreguntas() en la entidad Actividad que devuelve todas las preguntas asociadas a esa actividad
        return ResponseEntity.ok(preguntas);
    }

}
