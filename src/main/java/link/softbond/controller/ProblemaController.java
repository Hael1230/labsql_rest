package link.softbond.controller;
import org.springframework.beans.factory.annotation.Autowired;
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

import link.softbond.entities.*;
import link.softbond.repositorios.*;
import link.softbond.service.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ProblemaController {
    @Autowired
    ProblemaRepository problemaRepository;

    @GetMapping("/{problemas}/{list}")
    public List<Problema> getProblemaAll(){
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

    @GetMapping("/{problemas}/{id}/{tablas}")
    public Tabla getTablaid(@PathVariable Integer id) {
		
		List<Problema> problema = ProblemaService.findById(id);
		
		if (!Problema.isEmpty()) {
			return problema.get(0).getTabla();
		}
		
		return null;

	}

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
		
		if (!Problema.isEmpty()) {
			return problema.get(0).getTabla();
		}
		
		return null;

	}
}
