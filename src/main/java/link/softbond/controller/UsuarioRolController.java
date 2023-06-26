package link.softbond.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import link.softbond.entities.Rol;
import link.softbond.entities.Usuario;
import link.softbond.entities.UsuarioRol;
import link.softbond.controller.UsuarioController;
import link.softbond.repositorios.UsuarioRolRepository;

@RestController
@CrossOrigin
@RequestMapping("/usuario/rol")
public class UsuarioRolController {
	@Autowired
	UsuarioRolRepository usurolrepo;
	
	@GetMapping
	public ResponseEntity<?> listUsuarioRol(){
		try {
			return ResponseEntity.ok(usurolrepo.findAll());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	

}
