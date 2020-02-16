package QueMePongo.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import QueMePongo.Dominio.Login;
import QueMePongo.Validaciones.ValidadorLogin;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@Controller
@RequestMapping(value="/login.htm")
public class LoginController {
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
     @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ValidadorLogin()); // registramos el validador
    }

    @RequestMapping(method = RequestMethod.POST)
    public String ValidarLogin(@Valid Login login, BindingResult result)
    {
        if (result.hasErrors()) {
            return "login";
        }
		
        /*Login login = new Login();
        login.setPassword(loginModel.getPassword());
        login.setEmail(loginModel.getMail());
        login.persistir(login);*/
        
        return "redirect:/menu.htm";
    }
    @RequestMapping(method = RequestMethod.GET)
    protected ModelAndView GetModelToView(HttpServletRequest request) throws ServletException {
     ModelAndView modelAndView = new ModelAndView("LoginUser");

    	Login login = new Login();
    	modelAndView.addObject(login);
        return modelAndView;
    }
    

}
