package QueMePongo.Web;

import java.util.ArrayList;
import java.util.List;
import QueMePongo.Web.Mocks.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import QueMePongo.Dominio.Categoria;
import QueMePongo.Dominio.Evento;
import QueMePongo.Dominio.Guardarropa;
import QueMePongo.Dominio.Prenda;
import QueMePongo.Dominio.Sugerencia;
import QueMePongo.Dominio.TipoPrenda;
import QueMePongo.Dominio.Usuario;
import QueMePongo.Dominio.Enumerados.EnumCapa;
import QueMePongo.Web.Modelos.Comman;
import QueMePongo.Web.Modelos.SugerenciaListContainerModel;

@Controller

public class SugerenciaController {
	

	@RequestMapping(value = "/Sugerencias.htm" ,method = RequestMethod.GET)
	public ModelAndView MostrarSugerencias(Model model ,HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView("sugerencias");
		SugerenciaListContainerModel prendasModelosList = new SugerenciaListContainerModel();
		int i = 1;
		
		Evento ev = null ;
		HttpSession sesion = request.getSession();

		if (sesion.getAttribute("evento") != null) {
			ev = (Evento) sesion.getAttribute("evento");
		}
				
		for(Sugerencia sugerencia : ev.getSugerencias() ) {
			prendasModelosList.setListaPrendas(Comman.ConvertPrendaToModel(sugerencia.getListaPrendasSugeridas()));
			model.addAttribute("Sugerencia" + i, prendasModelosList);
			modelAndView.addObject("codPrendas"+ i, prendasModelosList.ObtenerClaveDatosBasicosSug() +  ",MCS=" +sugerencia.getMaxCapaSuperior() + ",MCI=" +sugerencia.getMaxCapaInferior());
			i++;
		}	
		return modelAndView;
	}
	
	@RequestMapping(value = "/RechazarSugerencia.htm",method = RequestMethod.GET )
	public ModelAndView RechazarSugerencia(@RequestParam("codPrendas") String codPrendas, Model model,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("rechazarSugerencia");
		SugerenciaListContainerModel userList = new SugerenciaListContainerModel();
		Sugerencia sug = new Sugerencia();
		
		//este es el que va
	//	sug.RecostruirSugerenciasMap(codigosPrendas(codPrendas));
		//test
		sug = getListPrenda().getSugerencias().get(0);
       sug.RecostruirSugerenciasMap();
		
       //
       sug.setMaxCapaInferior(buscarNivelCapa("MCI", codPrendas));
		sug.setMaxCapaSuperior(buscarNivelCapa("MCS", codPrendas));

		
		//Esto es la posta
		/*for(String idPrenda : codPrendas.split(",")) {
			if(! idPrenda.contains("C")) {
			userList.addPrenda(Comman.converPrendaModel(Prenda.buscarPorCodigo(Integer.valueOf(idPrenda))));		    
		}
			}*/
 
   userList.setListaPrendas(Comman.ConvertPrendaToModel(getListPrenda().getSugerencias().get(0).getListaPrendasSugeridas()));
		modelAndView.addObject("sugerencia", userList);
		HttpSession sesion = request.getSession();
		sesion.setAttribute("SugerenciaRechazada", sug);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/RechazarSugerencia.htm" ,method = RequestMethod.POST)
	public String RechazarSugerencia( SugerenciaListContainerModel sugerencia, BindingResult result, HttpServletRequest request) throws Exception {
		HttpSession sesion = request.getSession();
        Sugerencia sug  = (Sugerencia) sesion.getAttribute("SugerenciaRechazada");
		sug.setMotivoDeRechazo(sugerencia.getMotivoRechazo());
		//sug.RechazarSugerencia();
		return "redirect:/menu.htm";
	}
	
	@RequestMapping(value = "/AceptarSugerencia.htm",method = RequestMethod.GET )
	public ModelAndView AceptarSugerencia(@RequestParam("codPrendas") String codPrendas, Model model,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("aceptarSugerencia");
		SugerenciaListContainerModel userList = new SugerenciaListContainerModel();
		Sugerencia sug = new Sugerencia();
		
		//este es el que va
	//	sug.RecostruirSugerenciasMap(codigosPrendas(codPrendas));
		//test
		sug = getListPrenda().getSugerencias().get(0);
       sug.RecostruirSugerenciasMap();
		
       //
       sug.setMaxCapaInferior(buscarNivelCapa("MCI", codPrendas));
		sug.setMaxCapaSuperior(buscarNivelCapa("MCS", codPrendas));

		
		//Esto es la posta
		/*for(String idPrenda : codPrendas.split(",")) {
			if(! idPrenda.contains("C")) {
			userList.addPrenda(Comman.converPrendaModel(Prenda.buscarPorCodigo(Integer.valueOf(idPrenda))));		    
		}
			}*/
 
   userList.setListaPrendas(Comman.ConvertPrendaToModel(getListPrenda().getSugerencias().get(0).getListaPrendasSugeridas()));
		modelAndView.addObject("sugerencia", userList);
		HttpSession sesion = request.getSession();
		sesion.setAttribute("SugerenciaAceptada", sug);
		
		return modelAndView;
	}
	@RequestMapping(value = "/AceptarSugerencia.htm" ,method = RequestMethod.POST)
	public String AceptarSugerencia( SugerenciaListContainerModel sugerencia, BindingResult result, HttpServletRequest request) throws Exception {
		HttpSession sesion = request.getSession();
        Sugerencia sug  = (Sugerencia) sesion.getAttribute("SugerenciaAceptada");
		//sug.AceptarSugerencia();
		return "redirect:/menu.htm";
	}
	private String codigosPrendas(String codigoPrenda) 
	{
		String cod= "";
		for(String s : codigoPrenda.split(",")) {
			if(s.contains("M")) {
				return cod;
			}
			if(cod == "") {
				cod = s;
			}
			else {
				cod += "," + s;
			}
		}
		return cod;
	}
	private int buscarNivelCapa(String clave, String codigoPrenda) 
	{
		for(String s : codigoPrenda.split(",")) {
			if(s.contains(clave)) {
				return Integer.valueOf(s.split("=")[1]);
			}
			
    	}
		return -1;
	}
	private Evento getListPrenda() {
		EventoMock ev = new EventoMock();
		return ev.getEvento();
	}
	

}
