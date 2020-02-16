package QueMePongo.Dominio;
import java.io.Serializable;
import javax.persistence.*;

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
}