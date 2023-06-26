package link.softbond.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import link.softbond.entities.Rol;
import link.softbond.repositorios.RolRepository;

@RestController
@CrossOrigin
@RequestMapping("/rol")
public class RolController {
	
	@Autowired
	RolRepository rolRepository;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdRol(@PathVariable Integer id){
		
		try {
			Optional<Rol> rolCurrent=rolRepository.findById(id);
			if(rolCurrent.isPresent()) {
				
				return ResponseEntity.ok(rolCurrent);
				
			}
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@GetMapping
	public ResponseEntity<?> listaRol() {
		try {

			return ResponseEntity.ok(rolRepository.findAll());

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	
	
	

}
