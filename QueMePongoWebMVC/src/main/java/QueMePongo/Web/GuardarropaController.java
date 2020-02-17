package QueMePongo.Web;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import QueMePongo.Dominio.*;
import QueMePongo.Validaciones.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@Controller
@RequestMapping(value="/guardarropa.htm")

public class GuardarropaController {
	protected final Log logger = LogFactory.getLog(getClass());
	 
	 @InitBinder
	 protected void initBinder(WebDataBinder binder) {
	     binder.setValidator(new ValidadorGuardarropa()); // registramos el validador
	 }

	 @RequestMapping(method = RequestMethod.POST)
	 public String CrearGuardarropa(@Valid Guardarropa guard, BindingResult result,HttpServletRequest request) throws Exception
	 {
	     if (result.hasErrors()) {
	         return "redirect:/guardarropa";
	     }
	   HttpSession sesion = request.getSession();
	   Login log = (Login) sesion.getAttribute("login");
	   guard.AgregarUsuarioAdm(log.getEmail());
	   guard.guardar(); 
	   return "redirect:/menu.htm";
	 }
	 @RequestMapping(method = RequestMethod.GET)
	 protected ModelAndView GetModelToView(HttpServletRequest request) throws ServletException {
	  ModelAndView modelAndView = new ModelAndView("guardarropa");

	 	Guardarropa guarda = new Guardarropa();
	 	modelAndView.addObject(guarda);
	     return modelAndView;
	 }
	}