package QueMePongo.DAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import QueMePongo.Dominio.*;
public class TipoEventos extends Repositorio{
		
	public TipoEventos(EntityManager em) {
		super(em);
	}

	public TipoEvento buscarPorId(int i) {
		return em.find(TipoEvento.class, i);
	}
	
	public void persistir(TipoEvento tipo){
		em.getTransaction().begin();
		em.merge(tipo);
		em.getTransaction().commit();
	}
	
	public List<QueMePongo.Dominio.TipoEvento> listado(){
		
		List<QueMePongo.Dominio.TipoEvento> tipoEventos = new ArrayList<>();
		Query query = em.createQuery("SELECT P FROM TipoEvento P ");
		tipoEventos = query.getResultList();
		return tipoEventos;
	}
}
