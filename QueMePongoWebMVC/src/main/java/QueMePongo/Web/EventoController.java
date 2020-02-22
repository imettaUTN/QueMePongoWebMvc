package QueMePongo.Web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import QueMePongo.Dominio.EstadoEvento;
import QueMePongo.Dominio.Evento;
import QueMePongo.DAO.*;
import QueMePongo.Dominio.Usuario;
import QueMePongo.Servicio.CommandObtenerClima;
import QueMePongo.Validaciones.ValidadorEvento;
import QueMePongo.Web.Mocks.EventoMock;
import QueMePongo.Web.Modelos.EventoModelo;
import QueMePongo.Web.Modelos.EventosListContainerModel;

@Controller
public class EventoController {
	protected final Log logger = LogFactory.getLog(getClass());

	

	@RequestMapping(value = "/CargarEvento.htm", method = RequestMethod.GET)
	public ModelAndView BackEvento(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView("CargarEvento");
		Evento ev = new Evento();
		HttpSession sesion = request.getSession();

		if (sesion.getAttribute("nuevoEvento") != null) {
			ev = (Evento) sesion.getAttribute("nuevoEvento");
		}

		modelAndView.addObject("evento", ev);
		return modelAndView;
	}

	@RequestMapping(value = "/CargarEvento.htm", method = RequestMethod.POST)
	public String CargarEvento( Evento evento, BindingResult result, HttpServletRequest request)
			throws Exception {
		
		JPAUtil conexion = new JPAUtil();
		EstadoEvento estado = new EstadoEvento();
		estado = conexion.transaccion().estados().buscarPorId(1);
		
		evento.setEstado(estado);
		HttpSession sesion = request.getSession();
		int anio, mes, dia;
		dia = Integer.valueOf(evento.getFecha().split("/")[0]);
		mes = Integer.valueOf(evento.getFecha().split("/")[1]);
		anio = Integer.valueOf(evento.getFecha().split("/")[2]);
		evento.setearFechaEvento(anio, mes, dia, 0, 0);
		Usuario user = (Usuario) sesion.getAttribute("Usuario");
		evento.setUsuario(user);
		evento.guardar();

		return "redirect:/menu.htm";
	}

	@RequestMapping(value = "/ListarEvento.htm", method = RequestMethod.GET)
	public ModelAndView ListarEventos(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView("ListarEventos");
		EventosListContainerModel lista = new EventosListContainerModel();
		EventoMock em = new EventoMock();
		// aca convierto la lista de eventos del usuario a los eventos modelo.
		lista.ConvertirAListaModelo(em.getEventos());
		modelAndView.addObject("eventos", lista);
		return modelAndView;
	}

	@RequestMapping(value = "/ProcesarEvento.htm")
	public String AceptarSugerencia(@RequestParam("IdEvento") String idEvento ,HttpServletRequest request) throws IOException {
		Evento event = new Evento();
		event = Evento.BuscarEvento(Integer.valueOf(idEvento));
	   CommandObtenerClima command = new CommandObtenerClima();
	   event =command.Execute(event);
	   //CAMBIAR ESTADO 
       event.guardar(); 
	   HttpSession sesion = request.getSession();
		sesion.setAttribute("evento", event);	
    
		return "redirect:/MostrarSugerencias.htm";
	}

}
