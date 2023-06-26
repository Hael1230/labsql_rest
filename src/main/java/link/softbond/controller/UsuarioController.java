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

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

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
	
	@GetMapping("/send_mail/{id}")
	public ResponseEntity<String> sendAuthenticationEmail(@PathVariable("id_user") Integer userId) {
	    // Obtén el usuario correspondiente al ID desde la base de datos o el repositorio
	    Usuario usuario = usuarioRepository.findById(userId).orElse(null);
	    
	    if (usuario == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    // Genera y envía el correo de autenticación
	    try {
	        // Configuración de las propiedades del servidor de correo
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.example.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        
	        // Configuración de las credenciales del remitente del correo
	        String username = "your_email@example.com";
	        String password = "your_password";
	        
	        // Crea una sesión de correo con la autenticación
	        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });
	        
	        // Crea un mensaje de correo
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usuario.getEmail()));
	        message.setSubject("Correo de autenticación");
	        message.setText("Hola " + usuario.getNombre() + ",\n\n"
	                + "Este es un correo de autenticación.\n"
	                + "Por favor, haz clic en el siguiente enlace para autenticarte: "
	                + "http://tuaplicacion.com/authenticate/" + usuario.getId() + "\n\n"
	                + "Saludos,\n"
	                + "Tu Aplicación");
	        
	        // Envía el mensaje de correo
	        Transport.send(message);
	        
	        // Retorna una respuesta exitosa si el correo se envió correctamente
	        return ResponseEntity.ok("Correo de autenticación enviado correctamente");
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Retorna una respuesta de error si hubo un problema al enviar el correo
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

}
