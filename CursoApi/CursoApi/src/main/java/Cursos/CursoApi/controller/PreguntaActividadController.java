package Cursos.CursoApi.controller;
import Cursos.CursoApi.model.Actividad;
import Cursos.CursoApi.model.PreguntaActividad;
import Cursos.CursoApi.repository.PreguntaActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/preguntaActividad")
public class PreguntaActividadController {

    @Autowired
    private PreguntaActividadRepository preguntaActividadRepository;

    //Consulta general
    @GetMapping()
    public ResponseEntity<Iterable<PreguntaActividad>> findAll()
    {
        return ResponseEntity.ok(preguntaActividadRepository.findAll());
    }

    //Consulta por id
    @GetMapping("/{idPreguntaActividad}")
    public  ResponseEntity<PreguntaActividad> findById(@PathVariable Integer idPreguntaActividad){
        Optional<PreguntaActividad> preguntaActividadOptional = preguntaActividadRepository.findById(idPreguntaActividad);
        if (!preguntaActividadOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(preguntaActividadOptional.get());
    }

    //Crear un pregunta
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PreguntaActividad preguntaActividad, UriComponentsBuilder ucb){

        PreguntaActividad savedPreguntaActividad = preguntaActividadRepository.save(preguntaActividad);
        URI uri = ucb
                .path("preguntaActividad/{idPreguntaActividad}")
                .buildAndExpand(savedPreguntaActividad.getIdPregunta())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    //Actualizar una pregunta
    @PutMapping ("/{idPreguntaActividad}")
    public ResponseEntity<Void> update (@PathVariable Integer idPreguntaActividad, @RequestBody PreguntaActividad preguntaActividad){

        Optional<PreguntaActividad> preguntaActividadOptional = preguntaActividadRepository.findById(idPreguntaActividad);
        if (!preguntaActividadOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        preguntaActividad.setIdPregunta(preguntaActividadOptional.get().getIdPregunta());
        preguntaActividadRepository.save(preguntaActividad);
        return ResponseEntity.noContent().build();
    }

    //Borrar una pregunta
    @DeleteMapping("/{idPreguntaActividad}")
    public ResponseEntity<Void> delete (@PathVariable Integer idPreguntaActividad){
        if (preguntaActividadRepository.findById(idPreguntaActividad).get() == null){
            return ResponseEntity.notFound().build();
        }
        preguntaActividadRepository.deleteById(idPreguntaActividad);
        return ResponseEntity.noContent().build();
    }
}
