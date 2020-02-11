package QueMePongo.Servicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class Credenciales {
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	private String nombre;
    private String password;
    private String apellido;
    private String mail;
    
    public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

 
 public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

	public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}
