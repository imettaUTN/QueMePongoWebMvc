package QueMePongo.DAO;
import javax.persistence.*;

public class JPAUtil {
	
	final String PERSISTENCE_UNIT_NAME = "DDS";
	private EntityManagerFactory emFactory;
	private Repositorio repositorio;
	
	public Repositorio transaccion() {
	
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		repositorio = new Repositorio(emFactory.createEntityManager());
		
		return repositorio;
	
	}

}
