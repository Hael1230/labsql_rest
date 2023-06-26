package link.softbond.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import link.softbond.entities.Problema;

@Repository
public interface ProblemaRepository extends JpaRepository<Problema, Integer>{

    Optional<Problema> findByEstado(Integer estado);

   
    
}
