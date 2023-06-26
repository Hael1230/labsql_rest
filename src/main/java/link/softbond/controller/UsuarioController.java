package link.softbond.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import link.softbond.entities.Usuario;
import link.softbond.repositorios.UsuarioRepository;



@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<?> listaUsuario(){
		try {
			return ResponseEntity.ok(usuarioRepository.findAll());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PostMapping("/registro")
	public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){
		try {
			return ResponseEntity.ok(usuarioRepository.save(usuario));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdUsuario(@PathVariable Integer id){
		
		try {
			Optional<Usuario> UsuarioCurrent=usuarioRepository.findById(id);
			
			if(UsuarioCurrent.isPresent()) {
				return ResponseEntity.ok(UsuarioCurrent);
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		
	}

}
