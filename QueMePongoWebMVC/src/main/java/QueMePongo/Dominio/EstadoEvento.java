package QueMePongo.Dominio;
import java.io.Serializable;

import javax.persistence.*;

import QueMePongo.Repositorio.BaseClassData;

@Entity
@Table(name = "EstadoEvento")
public class EstadoEvento extends BaseClassData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodEstadoEvt")
	private int id;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
