package Cursos.CursoApi.controller;

import Cursos.CursoApi.model.Curso;
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

    
}
