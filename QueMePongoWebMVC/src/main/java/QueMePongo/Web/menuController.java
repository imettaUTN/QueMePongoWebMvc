package QueMePongo.Web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import QueMePongo.Dominio.Usuario;


@Controller
@RequestMapping(value="/menu.htm")
public class menuController {
	@RequestMapping( method = RequestMethod.GET)
    protected String formBackingObject(HttpServletRequest request) throws ServletException {
      HttpSession sesion = request.getSession();
		Usuario user = (Usuario) sesion.getAttribute("Usuario");
		
		if(user.getCodPerfil().getCodigoPerfil() ==3) {
			return "menu";
		}
		return "menuNoPremiun";
        }


}
