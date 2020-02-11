package QueMePongo.Dominio;
import java.io.Serializable;
import javax.persistence.*;
import QueMePongo.Repositorio.BaseClassData;

@Entity
@Table(name = "Colores")

public class Color extends BaseClassData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodColor")
	private int codColor;
	
	@Column(name = "Descripcion")
	private String descripcion;

	public int getCodColor() {
		return codColor;
	}

	public void setCodColor(int codColor) {
		this.codColor = codColor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
