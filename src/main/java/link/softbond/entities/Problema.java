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

public class Problema {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    
    private String nombre;
    private String descripcion;
    private String docente;
    private Integer estado;
    private String nombrebase;
    public Tabla getTabla() {
        return null;
    }
    public static boolean isEmpty() {
        return false;
    }
}
