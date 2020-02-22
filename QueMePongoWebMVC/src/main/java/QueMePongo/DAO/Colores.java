package QueMePongo.DAO;
import javax.persistence.EntityManager;
import QueMePongo.Dominio.*;
public class Colores extends Repositorio{
		
	public Colores(EntityManager em) {
		super(em);
	}

	public ColoresRechazados buscarPorId(String i) {
		return em.find(ColoresRechazados.class, i);
	}
	
	public void persistir(ColoresRechazados colores){
		em.getTransaction().begin();
		em.merge(colores);
		em.getTransaction().commit();
	}
}