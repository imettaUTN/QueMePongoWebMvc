package QueMePongo.Web;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import QueMePongo.Dominio.*;
import QueMePongo.Validaciones.*;
import QueMePongo.Web.Modelos.GuardarropaListContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@Controller

public class GuardarropaController {
	protected final Log logger = LogFactory.getLog(getClass());
	 
	
	@RequestMapping(value = "EliminarGuardarropa")
	protected String EliminarGuardarropa(@RequestParam("codGuard") String codGuard ,HttpServletRequest request) throws ServletException {
		Guardarropa guarda =  Guardarropa.buscarPorId(Integer.valueOf(codGuard));

		   HttpSession sesion = request.getSession();
		   Usuario user = (Usuario) sesion.getAttribute("Usuario");
		   user.eliminarGuardarropa(guarda.getId(), guarda.isCompartido());
			return "redirect:/menu.htm";
	}
	@RequestMapping(value = "ModificarGuardarropa", method = RequestMethod.GET)
	protected ModelAndView ModificarGuardarropa(@RequestParam("codGuard") String codGuard ,HttpServletRequest request) throws ServletException {
		ModelAndView modelAndView = new ModelAndView("guardarropaModifica");

		Guardarropa guarda =  Guardarropa.buscarPorId(Integer.valueOf(codGuard));
		modelAndView.addObject("guard",guarda);
		return modelAndView;
	}

	 @RequestMapping( value="ModificarGuardarropa" ,method = RequestMethod.POST)
	 public String ModificarGuardarropa( Guardarropa guard, BindingResult result,HttpServletRequest request) throws Exception
	 {
	  /*   if (result.hasErrors()) {
	         return "redirect:/guardarropa";
	     }*/
	   HttpSession sesion = request.getSession();
	   Usuario user = (Usuario) sesion.getAttribute("Usuario");
user.agregarGuardarropa(guard);
	   user.guardar(); 
	   return "redirect:/menu.htm";
	 }
	 
	 @RequestMapping( value="ListarGuardarropas")
	 public ModelAndView ListarGuardarropa( HttpServletRequest request) 
	 {
       ModelAndView model = new ModelAndView("ListarGuardarropas");
	   HttpSession sesion = request.getSession();
	   Usuario user = (Usuario) sesion.getAttribute("Usuario");
	   GuardarropaListContainer lista = new GuardarropaListContainer();
	   lista.setListaGuardarropa(user.getGuardarropas());
	   model.addObject("Lguarda",lista);
	   return model;
	 }
	 
	
	 @RequestMapping( value="AltaGuardarropa" ,method = RequestMethod.POST)
	 public String CrearGuardarropa( Guardarropa guard, BindingResult result,HttpServletRequest request) throws Exception
	 {
	  /*   if (result.hasErrors()) {
	         return "redirect:/guardarropa";
	     }*/
	   HttpSession sesion = request.getSession();
	   Usuario user = (Usuario) sesion.getAttribute("Usuario");
	   user.agregarGuardarropa(guard);
	   user.guardar(); 
	   return "redirect:/menu.htm";
	 }

	 
	 @RequestMapping(value="AltaGuardarropa" ,method = RequestMethod.GET)
	 protected ModelAndView GetModelToView(HttpServletRequest request) throws ServletException {
	  ModelAndView modelAndView = new ModelAndView("AltaGuardarropa");

	 	Guardarropa guarda = new Guardarropa();

		   HttpSession sesion = request.getSession();
		   Usuario user = (Usuario) sesion.getAttribute("Usuario");
	 	
	 	modelAndView.addObject("codPerfil", user.getCodPerfil().getCodigoPerfil());
		modelAndView.addObject("guard",guarda);
	     return modelAndView;
	 }}