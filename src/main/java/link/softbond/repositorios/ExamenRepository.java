package link.softbond.repositorios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import link.softbond.entities.Examen;

public class ExamenRepository {

    public Page<Examen> findAll(Pageable pageable) {
        return null;
    }

    public Examen save(Examen examen) {
        return null;
    }

    public Optional<Examen> findById(Integer id) {
        return null;
    }

    public void delete(Examen examen) {
    }
    
}
