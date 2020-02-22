package QueMePongo.DAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import QueMePongo.Dominio.*;

public class Eventos extends Repositorio{
		
	public Eventos(EntityManager em) {
		super(em);
	}

	public Evento buscarPorId(int i) {
		return em.find(Evento.class, i);
	}
	
	public void persistir(Evento evento){
		em.getTransaction().begin();
		em.merge(evento);
		em.getTransaction().commit();
	}
	
	public List<Prendas> sugerencia(Evento evento){
		
		int codEvento = evento.getCodEvento();
		List<Prendas> prendas = new ArrayList<Prendas>();
		Query query = em.createQuery("SELECT E FROM Prendas E WHERE E.sugerenciaEvento = " + codEvento);
		
		prendas = query.getResultList();
	
		return prendas;
	}
	
	public void eliminar(int codEvento){
		
		em.getTransaction().begin();
		Evento evt = new Evento();
		evt = em.getReference(Evento.class, codEvento);
		em.remove(evt);
		em.getTransaction().commit();
	}
}