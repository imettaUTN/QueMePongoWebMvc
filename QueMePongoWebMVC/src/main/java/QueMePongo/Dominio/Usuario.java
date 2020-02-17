package QueMePongo.Dominio;
import java.io.Serializable;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.io.IOException;
//import Desarrollo.ObjetosValor.UbicacionEvento;
import java.util.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.*;

import QueMePongo.DAO.JPAUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

@Entity
@Table(name = "Usuarios")
public class Usuario  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ver de cambiar de lugar, no deberia estar en la clase
	private static String  ENCRYPT_KEY="QueMePongoTPDDS";

	@Id
	@Column(name = "UsrCod")
	private String codigoUsuario;	
	
	@Column(name = "UsrPass")
	private String password;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Apellido")
	private String apellido; 
	
	private int codigoPerfil;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PrfCod", referencedColumnName = "PrfCod")
	private Perfil codPerfil;
	
	@Column(name = "Mail")
	private String mail;
	
	@Column(name = "PrendasDisponibles")
	private int prendasDisponibles;
	
	//Muchos a Muchos
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="GuardarropasUsuarios", 
	joinColumns={@JoinColumn(name="UsrCod", referencedColumnName="UsrCod")},
	inverseJoinColumns={@JoinColumn(name="CodGuardarropa", referencedColumnName="CodGuardarropa")})
	private List<Guardarropa> guardarropas = new ArrayList<Guardarropa>();
	
	@Transient
	private List<Evento> eventos = new ArrayList<Evento>();
	
	public void guardar() throws Exception{
		
		JPAUtil trn = new JPAUtil();
		this.setPassword(Usuario.encript(this.getPassword()));
		trn.transaccion().usuario().persistir(this);
	}
	
	public Usuario recuperar(String id){
		
		JPAUtil trn = new JPAUtil();
		return trn.transaccion().usuario().buscarPorId(id);
	}
	
	/*
	public void CargarEvento(LocalDate fecha, UbicacionEvento ubicacion, TipoEvento tipo) throws Exception{
		
		Evento evento = new Evento();
		evento.nuevoEvento(fecha,this, ubicacion,tipo);
		this.eventos.add(evento);
		evento.ProcesarEvento();
	}
	*/
	
	// Nota: Valor false porque supera el limite disponible.
	
	public boolean agregarPrendaAGuardarropa(Prenda prenda, int index){
		
		Guardarropa guardarropa = new Guardarropa();
		
		guardarropa = this.obtenerGuardarropa(index);
		
		if(this.codPerfil.getCodigoPerfil() == 2){
			
			if(this.prendasDisponibles <= 60) {
				
				prenda.setGuardarropa(guardarropa);
				this.disminuirDisponible();
				prenda.guardar();
				return true;
				
			}else 
			{
				return false;
			}
			
		}else
		{
			prenda.setGuardarropa(guardarropa);
			prenda.guardar();
			return true;
		}	
		
	}
	
	
	public void eliminarPrenda(Prenda prenda, int guardarropa){
		
		this.getGuardarropas().get(guardarropa).eliminarPrenda(prenda);
		
	}
	
	
	// Ver Tema de Rechazo.
	public void aceptarSugerencia(Sugerencia sugerencia, Evento evento){
		
		/*
		for(Sugerencia sg : evento.getSugerencias()) {
			if(sg.getIdSugerencia() != sugerencia.getIdSugerencia()) {
				sugerencia.RechazarSugerencia();
			}
			else {
				sugerencia.AceptarSugerencia();
				evento.setSugerenciaSeleccionada(sugerencia);
			}
		}
		*/
		
	}
	
	
	public int cantidadDeGuardarropas() {
			
			return this.guardarropas.size();
			
	}
	
	
	public void eliminarGuardarropa(int guardarropa, boolean compartido){
		
		this.guardarropas.remove(guardarropa);
		
	}
	
	public boolean crearGuardarropa(String desc, boolean compartido){
		
		if(this.codPerfil.getCodigoPerfil() == 2){
			
			if(this.cantidadDeGuardarropas() <= 3) {
		
				Guardarropa nuevoGuardarropa = new Guardarropa();
				nuevoGuardarropa.crearGuardarropa(desc, compartido, this);
				this.guardarropas.add(nuevoGuardarropa);
				return true;
		
			}else 
			{
				return false;
			}
		
		}else 
		{
			
			Guardarropa nuevoGuardarropa = new Guardarropa();
			nuevoGuardarropa.crearGuardarropa(desc, compartido, this);
			this.guardarropas.add(nuevoGuardarropa);
			return true;
			
		}
	}

	 
	private static String encript(String text) throws Exception {  
	    Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
	 
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.ENCRYPT_MODE, aesKey);
	 
	    byte[] encrypted = cipher.doFinal(text.getBytes());
	         
	    return Base64.getEncoder().encodeToString(encrypted);
	    }
	 
	private static String decrypt(String encrypted) throws Exception {
	    byte[] encryptedBytes=Base64.getDecoder().decode( encrypted.replace("\n", "") );
	         
	    Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
	 
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.DECRYPT_MODE, aesKey);
	 
	    String decrypted = new String(cipher.doFinal(encryptedBytes));
	         
	    return decrypted;
	    }
	 

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getCodigoPerfil() {
		return codigoPerfil;
	}


	public void setCodigoPerfil(int codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Perfil getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(Perfil codPerfil) {
		this.codPerfil = codPerfil;
	}

	public void agregarGuardarropa(Guardarropa guardarropa) {
		this.guardarropas.add(guardarropa);
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPrendasDisponibles() {
		return prendasDisponibles;
	}

	public void setPrendasDisponibles(int prendasDisponibles) {
		this.prendasDisponibles = prendasDisponibles;
	}
	
	public void disminuirDisponible() {
		
		this.prendasDisponibles -= 1;
	}
	
	public void aumentarDisponible() {
		
		this.prendasDisponibles += 1;
	}

	public List<Guardarropa> getGuardarropas() {
		return guardarropas;
	}

	public void setGuardarropas(List<Guardarropa> guardarropas) {
		this.guardarropas = guardarropas;
	}
	
	public Guardarropa obtenerGuardarropa(int index) {
		
		return this.getGuardarropas().get(index);
	}
	
	public boolean validaLogin() throws Exception{
		
		boolean valida = true;
		String claveEncriptada=this.encript(this.getPassword());
		
		Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QUEMEPONGO","ROMERO","Cris01");
		CallableStatement miSentencia = cn.prepareCall("{call SP_VALIDAR_LOGIN(?,?,?)}");
		
		miSentencia.setString(1, this.getCodigoUsuario());
		miSentencia.setString(2, claveEncriptada);
		miSentencia.registerOutParameter(3, Types.BIT);
		
		miSentencia.execute();
		valida = miSentencia.getBoolean(3);
		
		return valida;
	}
}
