package QueMePongo.DAO;
import javax.persistence.EntityManager;
import QueMePongo.Dominio.*;
public class GuardarropasPersistencia extends Repositorio{
	
	public GuardarropasPersistencia(EntityManager em) {
		super(em);
	}

	public Guardarropa buscarPorId(int i) {
		return em.find(Guardarropa.class, i);
	}
	
	public void persistir(Guardarropa guardarropa){
		em.getTransaction().begin();
		em.merge(guardarropa);
		em.getTransaction().commit();
	}
	
	public void eliminar(int cod){
		
		em.getTransaction().begin();
		Guardarropa g = new Guardarropa();
		g = em.getReference(Guardarropa.class, cod);
		em.remove(g);
		em.getTransaction().commit();
	}
}
