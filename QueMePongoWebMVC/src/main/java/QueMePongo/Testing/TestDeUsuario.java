package QueMePongo.Testing;
import QueMePongo.Dominio.*;
import QueMePongo.DAO.*;
import QueMePongo.Web.Modelos.*;


public class TestDeUsuario {
	
	//Conexi�n a Base de Datos
	JPAUtil jpa = new JPAUtil();
	
	private Perfil perfilBasico;
	private Usuario usuarioNuevo = new Usuario();
	private Usuario usuarioAlta = new Usuario();
	private Comman seguridad = new Comman();
	private Guardarropa guardarropa = new Guardarropa();
	private Prenda prendaNueva = new Prenda();
	
	@Before
	public void init(){
		
		perfilBasico = jpa.transaccion().perfil().buscarPorId(2);
		
		usuarioNuevo.setCodigoUsuario("RossiPablo2020");
		usuarioNuevo.setPassword(Comman.encrypt("Pablo01"));
		usuarioNuevo.setNombre("Pablo");
		usuarioNuevo.setApellido("Rossi");
		usuarioNuevo.setMail("pablo.rossi@gmail.com");
		usuarioNuevo.setCodPerfil(perfilBasico);
		usuarioNuevo.guardar();
		
		guardarropa.setDescripcion("Mi primer guardarropa");
		guardarropa.setCompartido(false);
		
		usuarioAlta = jpa.transaccion().usuario().buscarPorId("RossiPablo2020");
		usuarioAlta.agregarGuardarropa(guardarropa);
		usuarioAlta.guardar();
	}
	
	@Test
	public void elPerfilDelUsuarioEsBasico(){
		
		Assert.assertEquals(2,usuarioAlta.getCodPerfil().getCodigoPerfil());
	}
	
	@Test
	public void elUsuarioCreaUnGuardarropa(){
		
		Assert.assertEquals(1,usuarioAlta.getGuardarropas().size());
	}
	
	@Test
	public void usuarioSuperaCantidadMaximaDePrendasBasicas60(){
		
		usuarioAlta.setPrendasDisponibles(62);
		Assert.assertFalse(usuarioAlta.agregarPrendaAGuardarropa(prendaNueva, 0));
	}
}

