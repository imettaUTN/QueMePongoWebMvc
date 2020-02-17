package QueMePongo.Dominio.Enumerados;

public enum EnumCategoria {

	
	Superior("Parte del dorso",1),
	Inferior("Cintura para abajo",2),
	Calzado("Calzado",3),
	Accesorio("Accesorio",4);
	
	private String descripcion;
	private int id;

	private EnumCategoria(String descripcion, int id){
		this.id = id;
		this.descripcion = descripcion;
	}

	public String getNombreDescripcion() {
		return descripcion;
	}

	public int getId() {
		return id;
	}

}
