package QueMePongo.Dominio;
import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "TipoTela")
public class TipoTela  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodTipoTela")
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
