package QueMePongo.Web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import QueMePongo.Dominio.Usuario;
import QueMePongo.Modelos.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@Controller
@RequestMapping(value="/usuario.htm")
public class usuarioController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid UserModel user, BindingResult result)
    {
        if (result.hasErrors()) {
            return "login";
        }
		
        Usuario user1 = new Usuario();
        user1.setPassword(user1.getPassword());
        user1.setMail(user1.getMail());
        user1.persistir(user1);
        
        return "redirect:/menu.htm";
    }
    @RequestMapping(method = RequestMethod.GET)
    protected UserModel formBackingObject(HttpServletRequest request) throws ServletException {
    	UserModel usuario =  new UserModel();
        return usuario;
    }


}
