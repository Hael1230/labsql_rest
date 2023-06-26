package link.softbond.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import link.softbond.entities.Consulta;
import link.softbond.entities.Practica;
import link.softbond.repositorios.ConsultaRepository;
@RestController
@CrossOrigin
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
	    try {
	        Optional<Consulta> consulta = consultaRepository.findById(id);

	        if (consulta.isPresent()) {
	            return ResponseEntity.ok(consulta.get());
	        }

	        return ResponseEntity.notFound().build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	
	@PostMapping("/{id}/practicas")
	public ResponseEntity<?> registrarPractica(
	        @PathVariable("id") Integer consultaId,
	        @RequestBody Map<String, Object> request) {

	    Consulta consulta = consultaRepository.findById(consultaId).orElse(null);
	    if (consulta == null) {
	        return ResponseEntity.notFound().build();
	    }

	    try {
	        String consultaTexto = (String) request.get("consulta");
	        List<Consulta> resultado = ejecutarConsulta(consultaTexto);

	        Practica practica = new Practica();
	        practica.setConsulta(consulta);
	        practica.setResultado(resultado);
	        practicaRepository.save(practica);

	        Map<String, Object> response = new HashMap<>();
	        response.put("consulta", resultado);
	        response.put("mensaje", "La práctica se registró correctamente");

	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
}
