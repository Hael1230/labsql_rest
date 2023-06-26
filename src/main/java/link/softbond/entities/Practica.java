package link.softbond.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Practica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany
	@JoinColumn(name="usuario")
	private Usuario usuario;
	@OneToMany
	@JoinColumn(name="id_consulta")
	private Consulta consulta;
	
	private String SSQL;
	
	private Date fecha;
	
	private String resultado;
	
	private String estado;
	
	private String ip;
	
	
}
