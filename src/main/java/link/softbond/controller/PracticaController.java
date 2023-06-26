package link.softbond.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import link.softbond.entities.Practica;
import link.softbond.repositorios.PracticaRepository;

@RestController
@CrossOrigin
@RequestMapping("/practicas")
public class PracticaController {
	
	@Autowired
	PracticaRepository practicaRepository;
	
	@GetMapping
    public ResponseEntity<List<Practica>> obtenerPracticas() {
        List<Practica> practicas = practicaRepository.findAll();
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practica> obtenerPracticaPorId(@PathVariable("id") Integer id) {
        Optional<Practica> practica = practicaRepository.findById(id);
        return practica.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Practica> crearPractica(@RequestBody Practica practica) {
        Practica nuevaPractica = practicaRepository.save(practica);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPractica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practica> actualizarPractica(
            @PathVariable("id") Integer id,
            @RequestBody Practica practicaActualizada) {
        Optional<Practica> practicaExistente = practicaRepository.findById(id);
        if (practicaExistente.isPresent()) {
            Practica practica = practicaExistente.get();
            
            // Actualiza los campos según los atributos de la clase Practica
            practica.setUsuario(practicaActualizada.getUsuario());
            practica.setConsulta(practicaActualizada.getConsulta());
            practica.setSSQL(practicaActualizada.getSSQL());
            practica.setFecha(practicaActualizada.getFecha());
            practica.setResultado(practicaActualizada.getResultado());
            practica.setEstado(practicaActualizada.getEstado());
            practica.setIp(practicaActualizada.getIp());

            Practica practicaActualizada = practicaRepository.save(practica);
            return ResponseEntity.ok(practicaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPractica(@PathVariable("id") Integer id) {
        Optional<Practica> practica = practicaRepository.findById(id);
        if (practica.isPresent()) {
            practicaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
