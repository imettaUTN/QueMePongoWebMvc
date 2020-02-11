package QueMePongo.Dominio;

import java.io.Serializable;

import javax.persistence.*;

import QueMePongo.Repositorio.BaseClassData;

@Entity
@Table(name = "Perfil")
public class Perfil extends BaseClassData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PrfCod")
	private int codigoPerfil;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	public int getCodigoPerfil() {
		return codigoPerfil;
	}
	public void setCodigoPerfil(int codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/*public void guardar(){
		
		JPAUtil trn = new JPAUtil();
		trn.transaccion().perfil().persistir(this);
	}
	
	public Perfil recuperar(int id){
		
		JPAUtil trn = new JPAUtil();
		return trn.transaccion().perfil().buscarPorId(id);
	}*/
}
