package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Inicio_Sesion;
import Cursos.CursoApi.repository.Inicio_SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/inicio_sesion")
public class Inicio_SesionController {

    @Autowired
    Inicio_SesionRepository inicioSesionRepository;

    @GetMapping
    public ResponseEntity<Iterable<Inicio_Sesion>> getInicioSesiones() {
        return ResponseEntity.ok(inicioSesionRepository.findAll());////fdsfd
    }

    @GetMapping("/{id_Inicio_Sesion}")
    public ResponseEntity<Inicio_Sesion> getInicioSesion(@PathVariable Integer id_Inicio_Sesion) {
        Optional<Inicio_Sesion> inicioSesionOptional = inicioSesionRepository.findById(id_Inicio_Sesion);
        if (inicioSesionOptional.isPresent()) {
            return ResponseEntity.ok(inicioSesionOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Inicio_Sesion newInicioSesion, UriComponentsBuilder ucb) {
        Inicio_Sesion savedInicioSesion = inicioSesionRepository.save(newInicioSesion);
        URI uri = ucb.path("/inicio_sesion/{id_Inicio_Sesion}").buildAndExpand(savedInicioSesion.getIdInicio_Sesion()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id_Inicio_Sesion}")
    public ResponseEntity<Void> update(@PathVariable Integer id_Inicio_Sesion, @RequestBody Inicio_Sesion inicioSesionAct) {
        Inicio_Sesion inicioSesionAnt = inicioSesionRepository.findById(id_Inicio_Sesion).get();
        if (inicioSesionAnt != null) {
            inicioSesionAct.setId_Inicio_Sesion(inicioSesionAnt.getIdInicio_Sesion());
            inicioSesionRepository.save(inicioSesionAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_Inicio_Sesion}")
    public ResponseEntity<Void> delete(@PathVariable Integer id_Inicio_Sesion) {
        if (inicioSesionRepository.findById(id_Inicio_Sesion).isPresent()) {
            inicioSesionRepository.deleteById(id_Inicio_Sesion);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
