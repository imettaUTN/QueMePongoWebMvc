package QueMePongo.Web;

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
import QueMePongo.Dominio.Usuario;
import QueMePongo.Validaciones.ValidadorEvento;
import QueMePongo.Web.Mocks.EventoMock;
import QueMePongo.Web.Modelos.EventoModelo;
import QueMePongo.Web.Modelos.EventosListContainerModel;

@Controller
public class EventoController {
	protected final Log logger = LogFactory.getLog(getClass());

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ValidadorEvento()); // registramos el validador
	}

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
	public String CargarEvento(@Valid Evento evento, BindingResult result, HttpServletRequest request)
			throws Exception {

		if (result.hasErrors()) {

			return "redirect:/CargarEvento.htm";
		}
		evento.setEstado(new EstadoEvento(1, "nuevo"));
		HttpSession sesion = request.getSession();
		LocalDate localDate = LocalDate.parse(evento.getFecha());
		LocalDateTime endOfDate = LocalTime.MAX.atDate(localDate);
		evento.setFechaEvento(endOfDate);
		Usuario user = (Usuario) sesion.getAttribute("Usuario");
		evento.setUsuario(user);
		sesion.setAttribute("nuevoEvento", evento);

		return "redirect:/CargarEvento";
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

	@RequestMapping(value = "/ProcesarEvento.htm", method = RequestMethod.GET)
	public String AceptarSugerencia(@RequestParam("IdEvento") String idEvento, EventoModelo model,
			HttpServletRequest request) {
		// ACA LLAMO AL ABM DE SUGERENCIA
		Evento event = new Evento();
		event = Evento.BuscarEvento(Integer.valueOf(idEvento));
		HttpSession sesion = request.getSession();
		sesion.setAttribute("evento", event);	

		return "redirect:/Sugerencias.htm";
	}

}
