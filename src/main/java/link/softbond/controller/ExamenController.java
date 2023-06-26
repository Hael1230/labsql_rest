package link.softbond.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import link.softbond.entities.Examen;
import link.softbond.repositorios.ExamenRepository;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	@Autowired
	private ExamenRepository examenRepository;

	@GetMapping
	public Page<Examen> listarPublicaciones(Pageable pageable) {
		return examenRepository.findAll(pageable);
	}

	@PostMapping
	public Examen guardarPublicacion(@Validated @RequestBody Examen examen) {
		return examenRepository.save(examen);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Examen> actualizarPublicacion(@PathVariable Integer id,
			@Validated @RequestBody Examen examenRequest) {
		Optional<Examen> examenOptional = examenRepository.findById(id);

		if (!examenOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		examenRequest.setId(examenOptional.get().getId());
		examenRepository.save(examenRequest);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPublicacion(@PathVariable Integer id) {
		Optional<Examen> examenOptional = examenRepository.findById(id);

		if (!examenOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		examenRepository.delete(examenOptional.get());
		return ResponseEntity.noContent().build();
	}
}
