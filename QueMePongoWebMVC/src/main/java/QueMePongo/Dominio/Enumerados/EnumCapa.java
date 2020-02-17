package QueMePongo.Dominio.Enumerados;

public enum EnumCapa {
	
	Primera("Primera Capa de Ropa",1), 
	Segunda("Segunda Capa de Ropa",2), 
	Tercera("Tercera Capa de Ropa",3), 
	Cuarta("Cuarta Capa de Ropao",4); 
	
	private String descripcion;
	private int valor;
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	private EnumCapa (String descripcion, int valor){
		
		this.setDescripcion(descripcion);
		this.setValor(valor);
	}
}
