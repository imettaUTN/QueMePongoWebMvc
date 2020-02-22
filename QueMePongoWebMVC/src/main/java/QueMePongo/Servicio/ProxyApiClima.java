package QueMePongo.Servicio;

import java.time.*;

import QueMePongo.Dominio.ObjetosValor.Clima;
import QueMePongo.Web.Mocks.ClimaMock;

public class ProxyApiClima {

	
	public Clima ObtenerTemperatura( LocalDateTime fecha) {
		//CREAR OBJETO APPI CON DATOS DE CONEXION Y UBICACION
		// AGREGARLE ESTADO AL OBJETO PARA SABER SI ESTA DISPONIBLE
		// BUSCAR LA PRMER APPU DISPONIBLE Y LLAMARLA PARA OBTENER CLIMA
		ClimaMock mock = new ClimaMock();
		Clima _clima = new Clima(mock.GetTemperaturaMaxima(fecha), mock.GetTemperaturaMinima(fecha), fecha);
		return _clima;
	}
	
}
