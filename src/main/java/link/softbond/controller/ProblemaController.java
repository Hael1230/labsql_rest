package link.softbond.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
import org.springframework.http.ResponseEntity;
>>>>>>> b9188b222c953af459b3c7c54195aad4db98f751
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import link.softbond.entities.*;
import link.softbond.repositorios.*;
import link.softbond.service.*;

import java.util.List;
import java.util.Optional;
@RestController
<<<<<<< HEAD

=======
>>>>>>> cff8c78a2878542a3a34ecb9adf04dc549ecb744
public class ProblemaController {
	@Autowired
	ProblemaRepository problemaRepository;

	@Autowired
	private ExamenRepository examenRepository;

	@GetMapping("/examenes/{id}/generar")
	public Page<Opcion> listarComentariosPorPublicacion(@PathVariable(value = "id") Integer examenId,Pageable pageable){
		return problemaRepository.findByExamenId(examenId, pageable);
	}

	@GetMapping("/{problemas}/{list}")
	public List<Problema> getProblemaAll() {
		return problemaRepository.findAll();
	}

	@GetMapping("/{problemas}/{list}/{activos}")
	public Problema getProblemadobyEstado(@PathVariable Integer estado) {

		Optional<Problema> problema = problemaRepository.findByEstado(estado);

		if (problema.isPresent()) {
			return problema.get();
		}

		return null;

	}

<<<<<<< HEAD
	@GetMapping("/{problemas}/{id}/{tablas}")
	public Tabla getTablaid(@PathVariable Integer id) {

		Optional<Problema> problema = problemaRepository.findById(id);

=======
    @GetMapping("/{problemas}/{id}/{tablas}")
    public Tabla getTablaid(@PathVariable Integer id) {
		
		List<Problema> problema = ProblemaService.findById(id);
		
>>>>>>> cff8c78a2878542a3a34ecb9adf04dc549ecb744
		if (!Problema.isEmpty()) {
			return problema.get(0).getTabla();
		}

		return null;

	}

<<<<<<< HEAD
	@GetMapping("/{problemas}/{id}/{consultas}")
	public Tabla getConsultaid(@PathVariable Integer id) {

		List<Problema> problema = problemaRepository.findById(id);

=======
    @GetMapping("/{problemas}/{id}/{tabla}/{id}/{datos}")
    public ResponseEntity<Tabla> getTablabyid(@PathVariable Integer id) {

        Optional<Problema> problemaOptional = problemaRepository.findById(id);
    
        if (problemaOptional.isPresent()) {
            Problema problema = problemaOptional.get();
            Tabla tabla = problema.getTabla();
    
            if (tabla != null) {
                Tabla tablaCompleta = TablaService.getTablaCompleta(tabla.getId());
    
                if (tablaCompleta != null) {
                    return ResponseEntity.ok(tablaCompleta);
                }
            }
        }
    
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{problemas}/{id}/{consultas}")
    public Tabla getConsultaid(@PathVariable Integer id) {
		
		List<Problema> problema = ProblemaService.findById(id);
		
>>>>>>> cff8c78a2878542a3a34ecb9adf04dc549ecb744
		if (!Problema.isEmpty()) {
			return problema.get(0).getTabla();
		}

		return null;

	}
}
