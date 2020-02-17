package QueMePongo.Servicio;
import java.util.*;

import QueMePongo.Dominio.Evento;
public class ServidorColaDeEventos {

		private Queue<Evento> colaEventosNuevos;
		private Queue<Evento> colaEventosActivos;
		public ServidorColaDeEventos() {
			this.colaEventosNuevos= new LinkedList<Evento>();
			this.colaEventosActivos= new LinkedList<Evento>();
		}
		
		
		public Queue<Evento> getColaEventosNuevos() {
			return colaEventosNuevos;
		}
				
		public Queue<Evento> getColaEventosActivos() {
			return colaEventosActivos;
		}
		
		
		public void EncolarEvento(Evento evento, Queue<Evento> cola) {
			cola.add(evento);
		}
		
		
		
		
		public void EncolarNuevoEvento(Evento evento) {
			EncolarEvento(evento, this.getColaEventosNuevos());
			
		}
		
		/*
		public List<Sugerencia> ProcesarEventoEnCola() throws IOException {
			//aca va la magia de procesamiento de la cola
			// ver de usar algun framwwork que haga esto
			Evento eventoProcesado = this.getCabeceraColaEventosNuevos();
			invoker.ProcesarEvento(eventoProcesado);
			EncolarEvento(eventoProcesado, this.colaEventosActivos);
			return eventoProcesado.getSugerencias();
		}*/
		
		
		public Evento getCabeceraColaEventosNuevos() {
			return  this.colaEventosNuevos.poll();
		}
		
		public void setCabeceraColaEventosNuevos(Evento cabeceraColaEventosNuevos) {
		}
		
		public Evento getCabeceraColaEventosActivos() {
			return this.colaEventosActivos.poll();
		}
		
		public void setCabeceraColaEventosActivos(Evento cabeceraColaEventosActivos) {
		}
		
		/*
		public InvokerGestorEvento getInvoker() {
			return invoker;
		}
		
		public void setInvoker(InvokerGestorEvento invoker) {
			this.invoker = invoker;
		}
		*/
}
