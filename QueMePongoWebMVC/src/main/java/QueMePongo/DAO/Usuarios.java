package QueMePongo.DAO;
import javax.persistence.EntityManager;

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
}
