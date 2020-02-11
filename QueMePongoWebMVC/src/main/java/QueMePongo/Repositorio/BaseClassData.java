package QueMePongo.Repositorio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseClassData {
	 EntityManager em ;
	 
	 //SINGLETON
	 public EntityManager getEntityManager() {
		 if(em == null) {
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DDS");
		em = entityManagerFactory.createEntityManager();
		 }
		return em;
	 }
	 
	 @Transactional(readOnly = true)
	 public Object buscarPorId(int i) {
			return this.getEntityManager().find(this.getClass(), i);

	}	

	 @Transactional(readOnly = true)
	 public void persistir(Object  objeto) {
			this.getEntityManager().merge(objeto);		
	 }
	 
		
	public void cerrar() {
		em.close();
	}

}
