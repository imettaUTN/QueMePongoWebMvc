package QueMePongo.Dominio;
import java.io.Serializable;

import javax.persistence.*;

import QueMePongo.DAO.JPAUtil;


@Entity
@Table(name = "EstadoEvento")
public class EstadoEvento  implements Serializable{
	
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
	
	public EstadoEvento() {};
	public EstadoEvento(int id, String desc) {
		this.setDescripcion(desc);
		this.setId(id);
	}
	
	
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
	
	public static EstadoEvento BuscarPorId(int id) {
		JPAUtil trn = new JPAUtil();
		return trn.transaccion().estados().buscarPorId(id);
	}
}
