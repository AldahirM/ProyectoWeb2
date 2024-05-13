package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Certificado;
import Cursos.CursoApi.model.Curso;
import Cursos.CursoApi.model.Docente;
import Cursos.CursoApi.model.Escuela;
import Cursos.CursoApi.repository.CertificadoRepository;
import Cursos.CursoApi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/certificado")
public class CertificadoController {

    @Autowired
    private CertificadoRepository certificadoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    //Consulta general
    @GetMapping()
    public ResponseEntity<Iterable<Certificado>> findAll(){
        return ResponseEntity.ok(certificadoRepository.findAll());
    }

    //Consulta por id
    @GetMapping("/{idCertificado}")
    public  ResponseEntity<Certificado> findById(@PathVariable Integer idCertificado){
        Optional<Certificado> certificadoOptional = certificadoRepository.findById(idCertificado);
        if (!certificadoOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(certificadoOptional.get());
    }

    //Crear un certificado
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Certificado certificado, UriComponentsBuilder ucb){
        Optional<Curso> cursoOptional = cursoRepository.findById(certificado.getCurso().getIdCurso());
        if (!cursoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        certificado.setCurso(cursoOptional.get());
        Certificado savedCertificado = certificadoRepository.save(certificado);
        URI uri = ucb
                .path("certificado/{idCertificado}")
                .buildAndExpand(savedCertificado.getId_Certificado())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
