package QueMePongo.Dominio.ObjetosValor;
import java.time.*;
public class Clima {
	
private int temperaturaMinima;
private int temperaturaMaxima;
private LocalDateTime fecha;

public Clima(int temMinima, int temMaxima, LocalDateTime fecha) {
	this.setFecha(fecha);
	this.setTemperaturaMaxima(temMaxima);
	this.setTemperaturaMinima(temMinima);
}
public int getTemperaturaMinima() {
	return temperaturaMinima;
}
public void setTemperaturaMinima(int temperaturaMinima) {
	this.temperaturaMinima = temperaturaMinima;
}
public int getTemperaturaMaxima() {
	return temperaturaMaxima;
}
public void setTemperaturaMaxima(int temperaturaMaxima) {
	this.temperaturaMaxima = temperaturaMaxima;
}
public LocalDateTime getFecha() {
	return fecha;
}
public void setFecha(LocalDateTime fecha) {
	this.fecha = fecha;
}

}
