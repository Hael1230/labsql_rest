package link.softbond.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import link.softbond.entities.UsuarioRol;

@Repository

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Integer> {

}
