package QueMePongo.Web.Mocks;

import QueMePongo.Dominio.*;

public class UsuarioMock {

	
	private Usuario GetUsuario() {
		Usuario usu = new Usuario();
		usu.setApellido("juan");
		usu.setCodigoUsuario("01");
		usu.setPassword("aa");
		usu.setPrendasDisponibles(0);
		return usu;
	}

public Usuario GetBasicosuario() {
	Perfil per = new Perfil();
	per.setCodigoPerfil(2);
	per.setDescripcion("Basico");
	Usuario usu = this.GetUsuario();
	usu.setCodPerfil(per);
	return usu;
}
public Usuario GetPremiunsuario() {
	Perfil per = new Perfil();
	per.setCodigoPerfil(3);
	per.setDescripcion("Premiun");
	Usuario usu = this.GetUsuario();
	usu.setCodPerfil(per);
	return usu;
}
public Usuario GetAdmUsuario() {
	Perfil per = new Perfil();
	per.setCodigoPerfil(1);
	per.setDescripcion("Administrador");
	Usuario usu = this.GetUsuario();
	usu.setCodPerfil(per);
	return usu;
}

}
