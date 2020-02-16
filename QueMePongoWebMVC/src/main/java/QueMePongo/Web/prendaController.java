package QueMePongo.Web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import QueMePongo.Dominio.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@Controller
@RequestMapping(value="/prenda.htm")
public class prendaController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    /*@RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid Credenciales credenciales, BindingResult result)
    {
        if (result.hasErrors()) {
            return "login";
        }
		
        
        return "redirect:/hello.htm";
    }*/
    @RequestMapping(method = RequestMethod.GET)
    protected String formBackingObject(HttpServletRequest request) throws ServletException {
       return "Prenda";
    }


}
