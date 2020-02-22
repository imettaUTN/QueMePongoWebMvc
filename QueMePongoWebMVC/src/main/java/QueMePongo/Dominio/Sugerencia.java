package QueMePongo.Dominio;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import QueMePongo.DAO.JPAUtil;
//import Repositorio.Repositorio;


@Entity
@Table(name = "Exclusion")
public class Sugerencia  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodExclusion")
	private int IdSugerencia;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UsrCod", referencedColumnName = "UsrCod")
	private Usuario usuario;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="PrendaExclusion", 
	joinColumns={@JoinColumn(name="CodExclusion", referencedColumnName="CodExclusion")},
	inverseJoinColumns={@JoinColumn(name="CodPrenda", referencedColumnName="CodPrenda")})
	private List<Prenda> exclusiones = new ArrayList<Prenda>();
	
	@Transient
	HashMap<Integer, Prenda> prendasSugeridas = new HashMap<Integer, Prenda>();
	private List<Prenda> listaPrendasSugeridas ;
	
	@Transient
	private int maxCapaSuperior;
	
	public List<Prenda> getListaPrendasSugeridas() {
		return listaPrendasSugeridas;
	}

	public void setListaPrendasSugeridas(List<Prenda> listaPrendasSugeridas) {
		this.listaPrendasSugeridas = listaPrendasSugeridas;
	}

	@Transient
	private int maxCapaInferior;
	
	@Transient
	int motivoDeRechazo;
	
	public int getIdSugerencia() {
		return IdSugerencia;
	}

	public void setIdSugerencia(int idSugerencia) {
		IdSugerencia = idSugerencia;
	}

	public void AceptarSugerencia(int codEvento) {

		for(Prenda p:this.getListaPrendasSugeridas()) {
			
			p.vincularEvento(codEvento);
		}
	}
	public void RechazarSugerencia(int codigoRechazo) {
		
		JPAUtil jpa = new JPAUtil();
		
		
		switch(codigoRechazo) {
		
			case 1:
				
				//Rechaza por combinacion de colores
				ColoresRechazados colores = new ColoresRechazados();
				colores.rechazarPorColores(this);
				jpa.transaccion().color().persistir(colores);
		
			case 2:
				
				//Rechaza por combinacion de prendas
				this.cargarExclusiones();
				jpa.transaccion().sugerenciaRechaza().persistir(this);
								
			
			case 3:
				
			}
		}
		
		
	
	public int getMaxCapaSuperior(){
		
		return this.maxCapaSuperior;
	}
	
	public void setMaxCapaSuperior(int capa){
			
		this.maxCapaSuperior = capa; 
	}
	
	public int getMaxCapaInferior(){
		
		return this.maxCapaInferior;
	}
	
	public void setMaxCapaInferior(int capa){
		
		this.maxCapaInferior = capa;
	}
	
	public int getMotivoDeRechazo() {
		return motivoDeRechazo;
	}
	
	public void setMotivoDeRechazo(int motivoDeRechazo) {
		this.motivoDeRechazo = motivoDeRechazo;
	}

	public void cargarExclusiones() {
		this.exclusiones = converMapToList();		
	}
	
     public List<Prenda> converMapToList(){
		
	
		for(Integer key:this.prendasSugeridas.keySet()) {
			//System.out.println("KEY:"+key);
			Prenda p  = this.prendasSugeridas.get(key);
			//System.out.println("Prenda:"+p.getCodPrenda());
			this.listaPrendasSugeridas.add(p);
			
		}
		return this.getListaPrendasSugeridas();
	}
	
	public void RecostruirSugerenciasMap(String codigosPrendas) {
		for(String codigoPrenda : codigosPrendas.split(",")) {
			if(! codigoPrenda.contains("C")) {
				 Prenda	prend = Prenda.buscarPorCodigo(Integer.valueOf(codigoPrenda));
				 this.prendasSugeridas.put(prend.getCodPrenda(), prend);	
			}			
		}		
	}
	
	public void RecostruirSugerenciasMap() {
		for(Prenda prend : this.getListaPrendasSugeridas()) {
				 this.prendasSugeridas.put(prend.getCodPrenda(), prend);	
		}		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Guardarropa obtenerGuadarropa() {
		
		Guardarropa g = new Guardarropa();
		
		for(Prenda p:listaPrendasSugeridas) {
			
			g = p.getGuardarropa();
			break;
		}
		
		return g;
	}
	
}
