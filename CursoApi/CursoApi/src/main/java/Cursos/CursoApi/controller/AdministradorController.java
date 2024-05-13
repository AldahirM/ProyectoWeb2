package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Administrador;
import Cursos.CursoApi.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    AdministradorRepository administradorRepository;

    @GetMapping
    public ResponseEntity<Iterable<Administrador>> getAdministradores() {
        return ResponseEntity.ok(administradorRepository.findAll());
    }

    @GetMapping("/{id_Administrador}")
    public ResponseEntity<Administrador> getAdministrador(@PathVariable Integer id_Administrador) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(id_Administrador);
        if (administradorOptional.isPresent()) {
            return ResponseEntity.ok(administradorOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Administrador newAdministrador, UriComponentsBuilder ucb) {
        Administrador savedAdministrador = administradorRepository.save(newAdministrador);
        URI uri = ucb.path("/administrador/{id_Administrador}").buildAndExpand(savedAdministrador.getId_Administrador()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id_Administrador}")
    public ResponseEntity<Void> update(@PathVariable Integer id_Administrador, @RequestBody Administrador administradorAct) {
        Administrador administradorAnt = administradorRepository.findById(id_Administrador).get();
        if (administradorAnt != null) {
            administradorAct.setId_Administrador((administradorAnt.getId_Administrador()));
            administradorRepository.save(administradorAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_Administrador}")
    public ResponseEntity<Void> delete(@PathVariable Integer id_Administrador) {
        if (administradorRepository.findById(id_Administrador).isPresent()) {
            administradorRepository.deleteById(id_Administrador);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
