package link.softbond.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Consulta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

    @ManyToOne
    @JoinColumn(name="id")
    private Problema idproblema;

    private String descripcion;
    private String explicacion;
    private String solucion;
    private String explicsolucion;
    private String solucionalternativa;
    private Integer numpracticas;
    private Integer estado;
}    
