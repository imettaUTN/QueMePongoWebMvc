package QueMePongo.Dominio;
import java.io.Serializable;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodCategoria")
	private int CodCategoria;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	public int getCodCategoria() {
		return CodCategoria;
	}
	public void setCodCategoria(int codCategoria) {
		CodCategoria = codCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
