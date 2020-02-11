package QueMePongo.Dominio.Enumerados;

public enum EnumEstadoSugerencia {

	NUEVO("NUEVA SUGERENCIA",1),
	ACEPTADA("SUGERENCIA ACEPTADA",2),
	RECHAZADA("SUGERENCIA RECHAZADA",3);

	private int id;
	private String descripcion;
	
	private EnumEstadoSugerencia( String descripcion,int id){
		this.setDescripcion(descripcion);
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}