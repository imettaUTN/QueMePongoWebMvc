package QueMePongo.Web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import QueMePongo.Dominio.Login;
import QueMePongo.Dominio.Usuario;
import QueMePongo.Validaciones.ValidadorLogin;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
@RequestMapping(value = "/login.htm")
public class LoginController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ValidadorLogin()); // registramos el validador
	}

	private boolean errorEnCredenciales;

	@RequestMapping(method = RequestMethod.POST)
	public String ValidarLogin(@Valid Login login, BindingResult result, HttpServletRequest request) throws Exception {
		if (result.hasErrors()) {

			return "redirect:/login.htm";
		}

		this.setErrorEnCredenciales(login.ValidarLogin());
		if (this.isErorEnCredenciales()) {
			
			return "redirect:/login.htm";
		}
		logger.info("Guardando login en sesion");
		HttpSession sesion = request.getSession();
		Usuario user = new Usuario();
		user = user.recuperar(login.getEmail());
		sesion.setAttribute("Usuario", user);

		return "redirect:/menu.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView GetModelToView(HttpServletRequest request) throws ServletException {
		ModelAndView modelAndView = new ModelAndView("LoginUser");
		if (this.isErorEnCredenciales()) {
			modelAndView.addObject("ErorMessage", "Usuario o contraseña no validos");

		}
		Login login = new Login();
		modelAndView.addObject(login);
		return modelAndView;
	}

	public boolean isErorEnCredenciales() {
		return errorEnCredenciales;
	}

	public void setErrorEnCredenciales(boolean erorEnCredenciales) {
		this.errorEnCredenciales = erorEnCredenciales;
	}

}
