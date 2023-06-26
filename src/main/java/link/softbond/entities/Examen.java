package link.softbond.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.*;

import lombok.Data;



@Entity
@Table(name = "examen")
@Data
public class Examen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer examenId;
	
	private String descripcion;
	@Column(name = "fechainicio")
	private Date fechaInicio;
	@Column(name = "fechafin")
	private Date fechaFin;
	private Integer cantidad;

	@OneToOne
	@JoinColumn(name="id")
    private Problema problema;
}
