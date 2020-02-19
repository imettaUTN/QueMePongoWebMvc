package QueMePongo.Web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import QueMePongo.Dominio.Perfil;
import QueMePongo.Dominio.Usuario;
import QueMePongo.Validaciones.ValidadorUsuario;
@Controller
@RequestMapping(value="/usuario.htm")
public class usuarioController {
	protected final Log logger = LogFactory.getLog(getClass());
	 
 @InitBinder
 protected void initBinder(WebDataBinder binder) {
     binder.setValidator(new ValidadorUsuario()); // registramos el validador
 }

 @RequestMapping(method = RequestMethod.POST)
 public String RegistrarUsuario(@Valid Usuario user, BindingResult result,HttpServletRequest request) throws Exception
 {
     if (result.hasErrors()) {
         return "usuario";
     }
     Perfil perfil = null;
     switch(user.getCodigoPerfil()) {
     case 1:  perfil = new Perfil("ADMINISTRADOR",1); break;
     case 2:  perfil = new Perfil("PUBLICO",2); break;
     case 3:  perfil = new Perfil("PRIVADO",3); break;

     }
    
    user.setCodPerfil(perfil);
	HttpSession sesion = request.getSession();
	sesion.setAttribute("Usuario", user);
    user.guardar();
       
     return "redirect:/menu.htm";
 }
 @RequestMapping(method = RequestMethod.GET)
 protected ModelAndView GetModelToView(HttpServletRequest request) throws ServletException {
  ModelAndView modelAndView = new ModelAndView("usuario");

 	Usuario user = new Usuario();
 	modelAndView.addObject(user);
     return modelAndView;
 }
}
