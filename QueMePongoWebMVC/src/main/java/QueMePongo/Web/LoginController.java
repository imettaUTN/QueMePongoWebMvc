package QueMePongo.Web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import QueMePongo.Dominio.Login;
import QueMePongo.Modelos.LoginModel;

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
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid LoginModel loginModel, BindingResult result)
    {
        if (result.hasErrors()) {
            return "login";
        }
		
        Login login = new Login();
        login.setPassword(loginModel.getPassword());
        login.setEmail(loginModel.getMail());
        login.persistir(login);
        
        return "redirect:/menu.htm";
    }
    @RequestMapping(method = RequestMethod.GET)
    protected LoginModel formBackingObject(HttpServletRequest request) throws ServletException {
        LoginModel loginModel = new LoginModel();
        return loginModel;
    }

}
