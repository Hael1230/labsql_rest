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
public class Tabla {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

    private String nombre;
    private String edescripcion;
    @ManyToOne
    @JoinColumn(name="id")
    private Problema idproblema;
}
