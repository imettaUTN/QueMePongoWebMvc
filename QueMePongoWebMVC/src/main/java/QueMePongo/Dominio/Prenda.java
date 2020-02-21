package QueMePongo.Dominio;

import java.io.Serializable;
import javax.persistence.*;
import QueMePongo.DAO.JPAUtil;
import QueMePongo.Dominio.Enumerados.*;

@Entity
@Table(name = "Prendas")
public class Prenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodPrenda")
	int codPrenda;
	
	@Column(name = "Descripcion")
	private String descripcion;

	@Column(name = "ColorPrimario")
	private String  colorPrimario;
	
	@Column(name = "ColorSecundario")
	private String colorSecundario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodGuardarropa", referencedColumnName = "CodGuardarropa")
	private Guardarropa guardarropa;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodTipoPrenda", referencedColumnName = "CodTipoPrenda")
	private TipoPrenda tipoPrenda;
	
	@Column(name = "Sugerencia")
	private int sugerenciaEvento; //Evento
	
	@Column(name = "CCNivelAbrigo")
	private int ccNivelDeAbrigo; //Coeficiente Cambio Nivel de Abrigo
	
	@Transient
	private EnumCapa numeroDeCapa;
	
	@Transient
	private String urlImagen;
	
	public void guardar(){
		
			JPAUtil trn = new JPAUtil();
			trn.transaccion().prenda().persistir(this);
	}

	public static Prenda buscarPorCodigo(int codigoPrenda) {
		JPAUtil trn = new JPAUtil();
		return trn.transaccion().prenda().buscarPorId(codigoPrenda);
	}

	public int nivelAbrigo() {
		
		// Nota: Si el cambio de nivel es distinto de cero implica que el usuario
		// modifico el valor por default asignado a la prenda.
		
		int abrigo = this.tipoPrenda.getNivelAbrigo().getId();
		
			if(this.ccNivelDeAbrigo != 0) {
		
				abrigo += this.ccNivelDeAbrigo;
			}
		
			return abrigo; 
	}
	
	public boolean esInferior(){
		
		return (this.tipoPrenda.getCategoria().getCodCategoria() == 2);
	}
	
	public boolean esSuperior(){
		
		return (this.tipoPrenda.getCategoria().getCodCategoria() == 1);
	}
	
	public boolean esAccesorio(){
		
		return (this.tipoPrenda.getCategoria().getCodCategoria() == 4);
	}

	public boolean esCalzado() {

		return (this.tipoPrenda.getCategoria().getCodCategoria() == 3);
	}

	public void visualizar(){
		
		System.out.print(" Prenda: " + tipoPrenda.getDescripcion() + " - Color Primario: " + colorPrimario + " - Color Secundario: " + colorSecundario + "\n");
		
	}
	
	public String getDescripcion() {
		
		return this.descripcion;
	}
	
	public int getCapa(){
		
		return this.tipoPrenda.getCapa();
	}

	public int getCodPrenda() {
		return codPrenda;
	}

	public void setCodPrenda(int codPrenda) {
		this.codPrenda = codPrenda;
	}

	public String getColorPrimario() {
		return colorPrimario;
	}

	public void setColorPrimario(String colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public String getColorSecundario() {
		return colorSecundario;
	}

	public void setColorSecundario(String colorSecundario) {
		this.colorSecundario = colorSecundario;
	}

	public Guardarropa getGuardarropa() {
		return guardarropa;
	}

	public void setGuardarropa(Guardarropa guardarropa) {
		this.guardarropa = guardarropa;
	}

	public TipoPrenda getTipoPrenda() {
		return tipoPrenda;
	}

	public void setTipoPrenda(TipoPrenda tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}

	public Categoria getCategoria() {
		return this.tipoPrenda.getCategoria();
	}

	
	public EnumCapa getNumeroDeCapa() {
		return numeroDeCapa;
	}

	public void setNumeroDeCapa(EnumCapa numeroDeCapa) {
		this.numeroDeCapa = numeroDeCapa;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCambioNivel() {
		return ccNivelDeAbrigo;
	}

	public void setCambioNivel(int cambioNivel) {
		ccNivelDeAbrigo = cambioNivel;
	}
	
	public void vincularEvento(Evento evento) {
		
		this.sugerenciaEvento = evento.getCodEvento();
		this.guardar();
		
	}
	
	public boolean disponible() {
		
		if(this.sugerenciaEvento == 0) {
			return true;
		}else
		{
			return false;
		}	
		
	}	

}
