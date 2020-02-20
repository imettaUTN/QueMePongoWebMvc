package QueMePongo.Web.Mocks;

import java.util.ArrayList;
import java.util.List;

import QueMePongo.Dominio.Categoria;
import QueMePongo.Dominio.Evento;
import QueMePongo.Dominio.Guardarropa;
import QueMePongo.Dominio.Prenda;
import QueMePongo.Dominio.Sugerencia;
import QueMePongo.Dominio.TipoPrenda;
import QueMePongo.Dominio.Usuario;
import QueMePongo.Dominio.Enumerados.EnumCapa;

public class EventoMock {
List<Evento> eventos = new ArrayList<Evento>();
	
	public Evento getEvento() {
	     /*Esta lista viene de la DB*/  
		 Evento evento = new Evento();
		 List<Prenda> Lprendas = new ArrayList<Prenda>();
		 Sugerencia sug = new Sugerencia();
	      Prenda prend = new Prenda();
         Categoria categoria = new Categoria();

         categoria.setCodCategoria(1);
         categoria.setDescripcion("Zapatillas");
         TipoPrenda tp = new TipoPrenda();
         tp.setDescripcion("lalal");
         tp.setCategoria(categoria);
         tp.setCodTipoPrenda(1);
                  
         
         Guardarropa guard = new Guardarropa();
         guard.setCompartido(false);
         guard.setDescripcion("guardarropa");
         guard.setId(0);          
         prend.setGuardarropa(guard);
         prend.setColorPrimario("rojo");
         prend.setTipoPrenda(tp);
         prend.setColorSecundario("azul");
         prend.setDescripcion("prenda 1");
         prend.setDisponibleParaSugerir(true);
         prend.setNumeroDeCapa(EnumCapa.Primera);
    	for( int i = 0 ; i <= 4; i++) {
           prend.setCodPrenda(i);
			Lprendas.add(prend);			
		}
    	sug.setIdSugerencia(1);
    	sug.setMaxCapaInferior(0);
    	sug.setMaxCapaSuperior(2);	
    	sug.setUsuario(new Usuario());
    	sug.setListaPrendasSugeridas(Lprendas);
    	evento.AgregarSugerenciaAEvento(sug);
    	evento.AgregarSugerenciaAEvento(sug);
    	evento.AgregarSugerenciaAEvento(sug);
    	evento.AgregarSugerenciaAEvento(sug);
    	evento.AgregarSugerenciaAEvento(sug);

    	       return evento;
	    }
	
	public List<Evento> getEventos() {
		eventos.add(getEvento());
		eventos.add(getEvento());
		eventos.add(getEvento());
		eventos.add(getEvento());
		eventos.add(getEvento());
		eventos.add(getEvento());

		return eventos;

	}
}
