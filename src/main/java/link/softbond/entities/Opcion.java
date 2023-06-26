package link.softbond.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	private Integer id;

    @OneToOne
    @JoinColumn(name="id")
    private Consulta consulta;

    @OneToOne
    @JoinColumn(name="id")
    private Examen examen;

    private Timestamp fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private Usuario usuario;
}
