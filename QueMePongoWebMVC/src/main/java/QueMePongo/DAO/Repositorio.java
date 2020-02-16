package QueMePongo.DAO;
import javax.persistence.EntityManager;

public class Repositorio {
	
	private Categorias categorias;
	private TipoPrendas tipoPrendas;
	private Perfiles perfiles;
	private Prendas prendas;
	private Usuarios usuarios;
	private Colores colores;
	private SugerenciasRechazadas sugerencia;
	private GuardarropasPersistencia guardarropa;
	private EstadosEventos estados;
	private Eventos eventos;
	protected EntityManager em;
	
	public Repositorio(EntityManager em){
		this.em = em;
	}
	
	public TipoPrendas tipoPrenda(){
		
		if(tipoPrendas == null) {
			tipoPrendas = new TipoPrendas(em);
		}
		
		return tipoPrendas;
	}
	
	public Categorias categorias(){
		
		if(categorias == null) {
			categorias = new Categorias(em);
		}
		
		return categorias;
	}
	
	public EstadosEventos estados(){
		
		if(estados == null) {
			estados = new EstadosEventos(em);
		}
		
		return estados;
	}
	
	public Perfiles perfil(){
		
		if(perfiles == null) {
			perfiles = new Perfiles(em);
		}
		
		return perfiles;
	}
	
	public Eventos evento(){
		
		if(eventos == null) {
			eventos = new Eventos(em);
		}
		
		return eventos;
	}
	
	public Prendas prenda(){
		
		if(prendas == null) {
			prendas = new Prendas(em);
		}
		
		return prendas;
	}
	
	public Usuarios usuario(){
		
		if(usuarios == null) {
			usuarios = new Usuarios(em);
		}
		
		return usuarios;
	}
	
	public Colores color(){
		
		if(colores == null) {
			colores = new Colores(em);
		}
		
		return colores;
	}
	
	public SugerenciasRechazadas sugerenciaRechaza(){
		
		if(sugerencia == null) {
			sugerencia = new SugerenciasRechazadas(em);
		}
		
		return sugerencia;
	}
	
	public GuardarropasPersistencia guardarropa(){
		
		if(guardarropa == null) {
			guardarropa = new GuardarropasPersistencia(em);
		}
		
		return guardarropa;
	}
	
	
	public void cerrar() {
		em.close();
	}

}
