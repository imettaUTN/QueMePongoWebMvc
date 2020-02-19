package QueMePongo.Dominio;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import javax.persistence.*;

import QueMePongo.Web.Modelos.Comman;
@Entity
@Table(name = "Login")

public class Login implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "UserId")
	private int UserId;
	
	@Column(name = "Email")
	private String email;

// encriptar
	@Column(name = "Password")
	private String password;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String xemail) {
		email = xemail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String xpassword) {
		password = xpassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean ValidarLogin() throws Exception{
			
			boolean valida = true;
			String claveEncriptada=Comman.encrypt(this.getPassword());
			
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QUEMEPONGO","ROMERO","Cris01");
			CallableStatement miSentencia = cn.prepareCall("{call SP_VALIDAR_LOGIN(?,?,?)}");
			
			miSentencia.setString(1, this.getEmail());
			miSentencia.setString(2, claveEncriptada);
			miSentencia.registerOutParameter(3, Types.BIT);
			
			miSentencia.execute();
			valida = miSentencia.getBoolean(3);
			
			return valida;
		}
}