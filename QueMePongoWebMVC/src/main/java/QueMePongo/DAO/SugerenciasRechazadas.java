package QueMePongo.DAO;
import javax.persistence.EntityManager;
import QueMePongo.Dominio.*;
public class SugerenciasRechazadas extends Repositorio{
		
	public SugerenciasRechazadas(EntityManager em) {
		super(em);
	}

	public Colores buscarPorId(String i) {
		return em.find(Colores.class, i);
	}
	
	public void persistir(Sugerencia sugerencia){
		em.getTransaction().begin();
		em.merge(sugerencia);
		em.getTransaction().commit();
	}
}