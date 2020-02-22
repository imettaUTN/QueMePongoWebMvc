package QueMePongo.Web;

import java.util.*;

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

import QueMePongo.Dominio.*;
import QueMePongo.Validaciones.ValidadorPrenda;
import QueMePongo.Web.Mocks.PrendaMock;
import QueMePongo.Web.Modelos.*;

@Controller
@RequestMapping(value = "/Prenda.htm")
public class prendaController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(PrendaModelo prenda, BindingResult result, HttpServletRequest request) {

		Prenda p = Comman.FromModelToClasPrenda(prenda);
		p.guardar();
		return "redirect:/menu.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView formBackingObject(HttpServletRequest request) throws ServletException {

		//PrendaMock mock = new PrendaMock();
		List<GuardarropaModelo> guarda = new ArrayList<GuardarropaModelo>();

		HttpSession sesion = request.getSession();
		Usuario user = (Usuario) sesion.getAttribute("Usuario");

		
		guarda.addAll(Comman.ConvertTipoGuardarropaToModelList(user.getGuardarropas()));
		
		List<TipoPrendaModelo> tipos = new ArrayList<TipoPrendaModelo>();
		tipos.addAll(Comman.ConvertTipoPrendaToModelList(TipoPrenda.ListarTiposDePrenda()));
		
		ModelAndView model = new ModelAndView("Prenda");

		request.setAttribute("guardarropas", guarda);

		request.setAttribute("tiposPrendas", tipos);

		PrendaModelo pre = new PrendaModelo();
		model.addObject("modelo", pre);

		return model;
	}

}
