package QueMePongo.Web.Modelos;

public class PrendaModelo {
	private String descripcion;
	private String  colorPrimario;
	private String colorSecundario;
	private int catPrenda;
	private int codPrenda;
    private int codigoGuardarropa;  
	private String codigosPrendasSug;
	private String descripcionGuardarropa;
	private int tipoPrenda ;
    private String descripcionCat;
	private int coeficienteCambio;
    
	public PrendaModelo(String desc, String cp, String cs, String cat, int codPrenda, int codGuardarropa) {
		this.setColorPrimario(cp);
		this.setColorSecundario(cs);
		this.setDescripcion(desc);
		this.setDescripcionCat(cat);
		this.setCodPrenda(codPrenda);
		this.setCodigoGuardarropa(codGuardarropa);
	}
	

    public PrendaModelo() {
		// TODO Auto-generated constructor stub
	}


	public int getTipoPrenda() {
		return tipoPrenda;
	}
	public void setTipoPrenda(int tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
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
	public int getCodPrenda() {
		return codPrenda;
	}
	public String getDescripcionCat() {
		return descripcionCat;
	}


	public void setDescripcionCat(String descripcionCat) {
		this.descripcionCat = descripcionCat;
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


	public int getCatPrenda() {
		return catPrenda;
	}


	public void setCatPrenda(int catPrenda) {
		this.catPrenda = catPrenda;
	}


	public int getCoeficienteCambio() {
		return coeficienteCambio;
	}


	public void setCoeficienteCambio(int coeficienteCambio) {
		this.coeficienteCambio = coeficienteCambio;
	}


	public String getDescripcionGuardarropa() {
		return descripcionGuardarropa;
	}


	public void setDescripcionGuardarropa(String descripcionGuardarropa) {
		this.descripcionGuardarropa = descripcionGuardarropa;
	}
	
}
