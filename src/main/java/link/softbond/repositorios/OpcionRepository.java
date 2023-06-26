package link.softbond.repositorios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import link.softbond.entities.Opcion;

@Repository
public interface OpcionRepository extends JpaRepository<Opcion, Integer> {

	Page<Opcion> findByExamenId(Integer examenId, Pageable pageable);

	Optional<Opcion> findByIdExamenId(Integer comentarioId, Integer examenId);
}
