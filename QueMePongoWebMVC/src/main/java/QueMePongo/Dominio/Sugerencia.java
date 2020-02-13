package QueMePongo.Dominio;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
//import Repositorio.Repositorio;

import QueMePongo.Repositorio.BaseClassData;

@Entity
@Table(name = "Exclusion")
public class Sugerencia extends BaseClassData implements Serializable{
	
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
	
	@Transient
	private int maxCapaSuperior;
	
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

	public void AceptarSugerencia(Sugerencia sugerencia) {
		// TODO: Asignar sugerencia a Evento en formato XML.
	}
	
	/*
	public void RechazarSugerencia() {
		
		JPAUtil jpa = new JPAUtil();
		this.cargarExclusiones();
		jpa.transaccion().sugerenciaRechaza().persistir(this);
		System.out.println("Fin RechazarSugerencia");
	}
	*/
	
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
	
	public void cargarExclusiones() {
		
		System.out.println("Ingreso a cargarExclusiones.");
		
		for(Integer key:this.prendasSugeridas.keySet()) {
			
			System.out.println("KEY:"+key);
			Prenda p = new Prenda();
			p = this.prendasSugeridas.get(key);
			System.out.println("Prenda:"+p.getCodPrenda());
			this.exclusiones.add(p);
			
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
