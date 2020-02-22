package QueMePongo.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import QueMePongo.Dominio.*;

public class TipoPrendas extends Repositorio{
	
	public TipoPrendas(EntityManager em) {
		super(em);
	}

public List<QueMePongo.Dominio.TipoPrenda> listado(){
		
		List<QueMePongo.Dominio.TipoPrenda> TipoPrendas = new ArrayList<>();
		Query query = em.createQuery("SELECT P FROM TipoPrenda P ");
		TipoPrendas = query.getResultList();
		return TipoPrendas;
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