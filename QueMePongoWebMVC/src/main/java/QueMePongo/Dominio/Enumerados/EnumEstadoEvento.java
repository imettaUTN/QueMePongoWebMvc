package QueMePongo.Dominio.Enumerados;

public enum EnumEstadoEvento {
	
	NUEVO("Nuevo aun no procesado",1),
	ENPROCESO("Procesando evento, se le asignas sugerencias.",2),
	DISPONIBLE("Evento disponible para evaluaci�n.",3),
	CANCELADO("Evento Cancelado.",4),
	FINALIZADO("Evento finalizado.",5),
	ACTUALIZADO("Evento cuyo clima cambio.",6),
	PROCESADO("Evento al cual el usuario modifico el estado.",6);;
	
	
	private String descripcion;
	private int id;
	
	private EnumEstadoEvento(String descripcion, int id) {
		this.descripcion = descripcion;
		this.id = id;
	}
	
	public String GetDescripcion() {
		return this.descripcion;
	}
	
	public int GetId() {
		return this.id;
	}

}
