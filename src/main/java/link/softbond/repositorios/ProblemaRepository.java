package link.softbond.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import link.softbond.entities.Opcion;
import link.softbond.entities.Problema;

@Repository
public interface ProblemaRepository extends JpaRepository<Problema, Integer>{

    public List<Problema> findAll();

    public Optional<Problema> findByEstado(Integer estado);

    public Optional<Problema> findById(Integer id);
    
    Page<Problema> findByExamenId(Integer examenId, Pageable pageable);

	Optional<Problema> findByIdExamenId(Integer problemaId, Integer examenId);
    
}
