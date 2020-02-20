package QueMePongo.Dominio;
import javax.persistence.*;

@Entity
@Table(name = "ColoresExcluidos")
public class ColoresRechazados {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodColorExcl")
	private int id;
	
	@Column(name = "P1CodColor1")
	private String p1Color1;
	
	@Column(name = "P1CodColor2")
	private String p1Color2;
	
	@Column(name = "P2CodColor1")
	private String p2Color1;
	
	@Column(name = "P2CodColor2")
	private String p2Color2;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UsrCod", referencedColumnName = "UsrCod")
	private Usuario usuario;

	public String getP1Color1() {
		return p1Color1;
	}

	public void setP1Color1(String p1Color1) {
		this.p1Color1 = p1Color1;
	}

	public String getP1Color2() {
		return p1Color2;
	}

	public void setP1Color2(String p1Color2) {
		this.p1Color2 = p1Color2;
	}

	public String getP2Color1() {
		return p2Color1;
	}

	public void setP2Color1(String p2Color1) {
		this.p2Color1 = p2Color1;
	}

	public String getP2Color2() {
		return p2Color2;
	}

	public void setP2Color2(String p2Color2) {
		this.p2Color2 = p2Color2;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void rechazarPorColores(Sugerencia sugerencia) {
		
		
		int prendaMaxSuperior = 10 + sugerencia.getMaxCapaSuperior();
		int prendaMaxInferior = 20 + sugerencia.getMaxCapaInferior();
		
		this.setP1Color1(sugerencia.prendasSugeridas.get(prendaMaxSuperior).getColorPrimario());
		this.setP1Color2(sugerencia.prendasSugeridas.get(prendaMaxSuperior).getColorSecundario());
		this.setP2Color1(sugerencia.prendasSugeridas.get(prendaMaxInferior).getColorPrimario());
		this.setP2Color2(sugerencia.prendasSugeridas.get(prendaMaxInferior).getColorSecundario());
		
	}

	@Override
	public String toString() {
		return "ColoresRechazados [id=" + id + ", p1Color1=" + p1Color1 + ", p1Color2=" + p1Color2 + ", p2Color1="
				+ p2Color1 + ", p2Color2=" + p2Color2 + ", usuario=" + usuario + "]";
	}
	
}
