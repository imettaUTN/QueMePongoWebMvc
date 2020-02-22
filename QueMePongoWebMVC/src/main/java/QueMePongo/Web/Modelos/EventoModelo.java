package QueMePongo.Web.Modelos;

import javax.persistence.Column;

public class EventoModelo {
private int codEvento;
private String descripcion;
private String fecha;
private String estado;

public EventoModelo(int codEv, String desc, String fecha, String estado) {
	this.setCodEvento(codEv);
	this.setDescripcion(desc);
	this.setFecha(fecha);
	this.setEstado(estado);
}

public int getCodEvento() {
	return codEvento;
}
public void setCodEvento(int codEvento) {
	this.codEvento = codEvento;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}


}
