package link.softbond.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import link.softbond.entities.Consulta;
import link.softbond.entities.Examen;
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{
    
}
