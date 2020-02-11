package QueMePongo.Dominio;
import java.io.Serializable;

import javax.persistence.*;

import QueMePongo.Repositorio.BaseClassData;

@Entity
@Table(name = "TipoEvento")
public class TipoEvento extends BaseClassData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodTipoEvento")
	private int codTipoEvento;
	
	@Column(name = "Descripcion")
	private String descripcion;

	public int getCodTipoEvento() {
		return codTipoEvento;
	}

	public void setCodTipoEvento(int codTipoEvento) {
		this.codTipoEvento = codTipoEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
