package link.softbond.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import link.softbond.entities.Rol;

@Repository

public interface RolRepository extends JpaRepository<Rol, Integer>{
	
	

}
