package QueMePongo.Servicio;
import java.io.IOException;

import QueMePongo.Dominio.*;

//PROXY


public class InvokerGestorEvento {
	/*
private IComand comand;

public IComand getComand() {
	return comand;
}

public void setComand(IComand comand) {
	this.comand = comand;
}
*/
public Evento ProcesarEvento( Evento  evento) throws IOException {
	CommandObtenerClima clima = new CommandObtenerClima();
	clima.Execute(evento);
	CommandObtenerSugerencia sugerencia = new CommandObtenerSugerencia();
	sugerencia.Execute(evento);
	return evento;
}

}

