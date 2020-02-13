package QueMePongo.Dominio;
import java.io.Serializable;

import javax.persistence.*;
//import Desarrollo.Enumerados.EnumCapa;
import QueMePongo.Repositorio.BaseClassData;

@Entity
@Table(name = "TipoPrenda")
public class TipoPrenda extends BaseClassData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodTipoPrenda")
	private int CodTipoPrenda;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "NroCapa")
	private int capa;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodTipoTela", referencedColumnName = "CodTipoTela")
	private TipoTela tipoTela;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodNivelAbrigo", referencedColumnName = "CodNivelAbrigo")
	private NivelDeAbrigo nivelAbrigo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodTipoEvento", referencedColumnName = "CodTipoEvento")
	private TipoEvento tipoEvento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodCategoria", referencedColumnName = "CodCategoria")
	private Categoria categoria;

	public int getId() {
		return CodTipoPrenda;
	}

	public void setId(int id) {
		this.CodTipoPrenda = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCapa() {
		return capa;
	}

	public void setCapa(int capa) {
		this.capa = capa;
	}

	public TipoTela getTipoTela() {
		return tipoTela;
	}

	public void setTipoTela(TipoTela tipoTela) {
		this.tipoTela = tipoTela;
	}

	public NivelDeAbrigo getNivelAbrigo() {
		return nivelAbrigo;
	}

	public void setNivelAbrigo(NivelDeAbrigo nivelAbrigo) {
		this.nivelAbrigo = nivelAbrigo;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
