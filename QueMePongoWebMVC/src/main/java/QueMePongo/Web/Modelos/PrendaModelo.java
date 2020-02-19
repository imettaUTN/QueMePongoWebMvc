package QueMePongo.Web.Modelos;

public class PrendaModelo {
	private String descripcion;
	private String  colorPrimario;
	private String colorSecundario;
	private String categoria;
	private int codPrenda;
    private int codigoGuardarropa;  
	private String codigosPrendasSug;

	
    public PrendaModelo(String desc, String cp, String cs, String cat, int codPrenda, int codGuardarropa) {
		this.setColorPrimario(cp);
		this.setColorSecundario(cs);
		this.setDescripcion(desc);
		this.setCategoria(cat);
		this.setCodPrenda(codPrenda);
		this.setCodigoGuardarropa(codGuardarropa);
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	public int getCodPrenda() {
		return codPrenda;
	}
	public void setCodPrenda(int codPrenda) {
		this.codPrenda = codPrenda;
	}
	public int getCodigoGuardarropa() {
		return codigoGuardarropa;
	}
	public void setCodigoGuardarropa(int codigoGuardarropa) {
		this.codigoGuardarropa = codigoGuardarropa;
	}
	public String getCodigosPrendasSug() {
		return codigosPrendasSug;
	}
	public void setCodigosPrendasSug(String codigosPrendasSug) {
		this.codigosPrendasSug = codigosPrendasSug;
	}
	
}
