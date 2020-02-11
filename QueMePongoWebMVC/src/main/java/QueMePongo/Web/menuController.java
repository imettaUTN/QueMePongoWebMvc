package QueMePongo.Web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/menu.htm")
public class menuController {
	@RequestMapping( method = RequestMethod.GET)
    protected String formBackingObject(HttpServletRequest request) throws ServletException {
        return "menu";
        }


}
