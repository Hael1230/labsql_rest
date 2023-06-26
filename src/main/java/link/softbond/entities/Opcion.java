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
public class Opcion{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer OpcionId;

    @OneToOne
    @JoinColumn(name="id")
    private Consulta consulta;

    @OneToOne
    @JoinColumn(name="id")
    private Examen examen;

    private Timestamp fecha;

    @OneToOne
    @JoinColumn(name="id")
    private Usuario usuario;
}
