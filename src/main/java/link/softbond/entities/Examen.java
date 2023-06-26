package link.softbond.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name = "examen")
@Data
public class Examen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "persona_id")
	private Integer id;
	
	private String descripcion;
	@Column(name = "fechainicio")
	private Date fechaInicio;
	@Column(name = "fechafin")
	private Date fechaFin;
	private Integer problema;
	private Integer cantidad;
}
