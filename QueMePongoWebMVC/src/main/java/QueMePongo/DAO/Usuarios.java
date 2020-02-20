package QueMePongo.DAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import QueMePongo.Dominio.*;
public class Usuarios extends Repositorio{
		
	public Usuarios(EntityManager em) {
		super(em);
	}

	public Usuario buscarPorId(String i) {
		return em.find(Usuario.class, i);
	}
	
	public void persistir(Usuario usuario){
		if(usuario.getCodPerfil().getCodigoPerfil() == 1) {
			usuario.setPrendasDisponibles(60);
		}
		
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario recuperar(String id){
		
		JPAUtil trn = new JPAUtil();
		return trn.transaccion().usuario().buscarPorId(id);
	}
	
	public List<Evento> eventos(Usuario usuario){
		
		String codUsuario = usuario.getCodigoUsuario();
		List<Evento> eventos = new ArrayList<>();
		Query query = em.createQuery("SELECT E FROM Evento E");
		eventos = query.getResultList();
		return eventos;
	}
}
