package QueMePongo.Servicio;

import java.io.IOException;

import QueMePongo.Dominio.*;
import QueMePongo.Dominio.ObjetosValor.Clima;

//import Desarrollo.ObjetosValor.Clima;

public class CommandObtenerClima implements IComand {

	public Evento Execute(Evento evento) throws IOException {

		ProxyApiClima proxy = new ProxyApiClima();
		Clima _clima = proxy.ObtenerTemperatura(evento.getFechaEvento());
		evento.setTemperaturaMaxima(_clima.getTemperaturaMaxima());
		evento.setTemperaturaMinima(_clima.getTemperaturaMinima());
		return evento;

	}

}
