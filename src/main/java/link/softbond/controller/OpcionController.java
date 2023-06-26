package link.softbond.controller;

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
import org.springframework.web.bind.annotation.RestController;

import link.softbond.entities.Opcion;
import link.softbond.repositorios.ExamenRepository;
import link.softbond.repositorios.OpcionRepository;

@RestController
public class OpcionController {

	@Autowired
	private ExamenRepository examenRepository;
	
	@Autowired
	private OpcionRepository opcionRepository;
	
	
	@GetMapping("/examenes/{id}/generar")
	public Page<Opcion> listarComentariosPorPublicacion(@PathVariable(value = "id") Integer examenId,Pageable pageable){
		return opcionRepository.findByExamenId(examenId, pageable);
	}
	
	@PostMapping("/examenes/{id}/opciones")
	public Opcion guardarComentario(@PathVariable(value = "id") Integer examenId,@Validated @RequestBody Opcion opcion) {
		return examenRepository.findById(examenId).map(examen -> {
			opcion.setExamen(examen);
			return opcionRepository.save(opcion);
		}).orElseThrow();
	}
	
	@PutMapping("/examenes/{id}/opciones/{opcionId}")
	public Opcion actualizarComentario(@PathVariable(value = "id") Integer examenId,@PathVariable(value = "opcionId") Integer opcionId,@Validated @RequestBody Opcion opcionRequest) {
		if(!examenRepository.existsById(examenId)) {
			
		}
		
		return opcionRepository.findById(opcionId).map(opcion -> {
			opcion.setFecha(opcionRequest.getFecha());
			return opcionRepository.save(opcion);
		}).orElseThrow();
	}
	
	@DeleteMapping("/examenes/{id}/opciones/{opcionId}")
	public ResponseEntity<?> eliminarComentario(@PathVariable(value = "id") Integer examenId,@PathVariable(value = "opcionId") Integer opcionId){
		return opcionRepository.findByIdExamenId(opcionId, examenId).map(opcion -> {
			opcionRepository.delete(opcion);
			return ResponseEntity.ok().build();
		}).orElseThrow();
	}
}
