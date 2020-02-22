package QueMePongo.Web.Modelos;
import java.util.*;

import QueMePongo.Dominio.Evento;


public class EventosListContainerModel {
	private List<EventoModelo> listaPrendas = new ArrayList<EventoModelo>();

	public void ConvertirAListaModelo(List<Evento> eventos){
		for(Evento ev: eventos) {
			
			this.listaPrendas.add(new EventoModelo(ev.getCodEvento(), ev.getDescripcion(), ev.getFecha().toString(), ev.getEstado().getDescripcion()));
		}
	}
	
	public List<EventoModelo> getListaPrendas() {
		return listaPrendas;
	}

	public void setListaPrendas(List<EventoModelo> listaPrendas) {
		this.listaPrendas = listaPrendas;
	}

}
