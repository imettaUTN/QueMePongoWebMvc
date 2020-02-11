package QueMePongo.Modelos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class LoginModel {
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	private String mail;
    public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
    
	public Log getLogger() {
		return logger;
	}


}
