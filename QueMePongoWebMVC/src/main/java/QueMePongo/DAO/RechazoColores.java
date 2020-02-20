package QueMePongo.DAO;
import javax.persistence.EntityManager;
import QueMePongo.Dominio.*;

public class RechazoColores extends Repositorio{
		
	public RechazoColores(EntityManager em) {
		super(em);
	}

	public void persistir(ColoresRechazados colores){
		em.getTransaction().begin();
		em.merge(colores);
		em.getTransaction().commit();
	}
}
