package QueMePongo.Servicio;
import QueMePongo.Dominio.*;
import QueMePongo.Repositorio.*;

public class SugerenciasRechazadas extends BaseClassData {
		
	@Override
	public Object  buscarPorId(int i) {
		return this.getEntityManager().find(SugerenciasRechazadas.class, i);
	}

	@Override
	public void persistir(Object objeto) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge((Sugerencia)objeto);
		this.getEntityManager().getTransaction().commit();
		
	}
	
}