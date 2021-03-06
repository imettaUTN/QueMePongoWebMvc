package QueMePongo.Dominio;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
//import Desarrollo.Enumerados.EnumCapa;

import QueMePongo.DAO.JPAUtil;


@Entity
@Table(name = "TipoPrenda")
public class TipoPrenda  implements Serializable{
	
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

	public int getCodTipoPrenda() {
		return CodTipoPrenda;
	}

	public void setCodTipoPrenda(int codTipoPrenda) {
		CodTipoPrenda = codTipoPrenda;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	public static List<TipoPrenda> ListarTiposDePrenda(){
		JPAUtil trn = new JPAUtil();
	return 	trn.transaccion().tipoPrenda().listado();	
	}
	public static TipoPrenda buscarPorId(int id) {
		JPAUtil trn = new JPAUtil();
		return trn.transaccion().tipoPrenda().buscarPorId(id);

	
	}
}
