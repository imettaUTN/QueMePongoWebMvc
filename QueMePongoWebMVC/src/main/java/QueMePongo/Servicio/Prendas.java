package QueMePongo.Servicio;


public class Prendas {
	int codPrenda;
	private String descripcion;
	private String  colorPrimario;
	private String colorSecundario;
	private int CambioNivel; 

	
	public int getCodPrenda() {
		return codPrenda;
	}
	public void setCodPrenda(int codPrenda) {
		this.codPrenda = codPrenda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getColorPrimario() {
		return colorPrimario;
	}
	public void setColorPrimario(String colorPrimario) {
		this.colorPrimario = colorPrimario;
	}
	public String getColorSecundario() {
		return colorSecundario;
	}
	public void setColorSecundario(String colorSecundario) {
		this.colorSecundario = colorSecundario;
	}
	public int getCambioNivel() {
		return CambioNivel;
	}
	public void setCambioNivel(int cambioNivel) {
		CambioNivel = cambioNivel;
	}
}
