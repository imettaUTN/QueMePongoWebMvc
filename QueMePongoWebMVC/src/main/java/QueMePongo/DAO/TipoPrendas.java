package QueMePongo.DAO;

import javax.persistence.EntityManager;

import QueMePongo.Dominio.*;

public class TipoPrendas extends Repositorio{
	
	public TipoPrendas(EntityManager em) {
		super(em);
	}

	public TipoPrenda buscarPorId(int i) {
		return em.find(TipoPrenda.class, i);
	}
	
	public void persistir(TipoPrenda tipoPrenda){
		em.getTransaction().begin();
		em.merge(tipoPrenda);
		em.getTransaction().commit();
	}
	
	public void eliminar(int tipoPrenda){
		
		em.getTransaction().begin();
		TipoPrenda p = new TipoPrenda();
		p = em.getReference(TipoPrenda.class, p);
		em.remove(p);
		em.getTransaction().commit();
	}
}