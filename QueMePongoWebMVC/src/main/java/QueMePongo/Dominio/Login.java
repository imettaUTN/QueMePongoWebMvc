package QueMePongo.Dominio;
import java.io.Serializable;
import javax.persistence.*;
import QueMePongo.Repositorio.BaseClassData;

@Entity
@Table(name = "Login")

public class Login extends BaseClassData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "UserId")
	private int UserId;
	
	@Column(name = "Email")
	private String Email;

// encriptar
	@Column(name = "Password")
	private String Password;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}