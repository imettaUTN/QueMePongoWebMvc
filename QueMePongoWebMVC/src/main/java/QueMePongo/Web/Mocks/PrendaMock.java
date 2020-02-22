package QueMePongo.Web.Mocks;

import java.util.ArrayList;
import java.util.List;

import QueMePongo.Dominio.*;
import QueMePongo.Dominio.Enumerados.EnumCapa;

public class PrendaMock {
	
    
	private Categoria GetCategoria() {
		Categoria categoria = new Categoria();
        categoria.setCodCategoria(1);
        categoria.setDescripcion("Zapatillas");
        return categoria;
	}
    public List<Categoria> listaCategorias(){
		List<Categoria>  ll = new ArrayList<Categoria>();
    	ll.add(this.GetCategoria());
    	ll.add(this.GetCategoria());
    	ll.add(this.GetCategoria());
    	ll.add(this.GetCategoria());
    	ll.add(this.GetCategoria());
    	return ll;
    }
	
    private TipoPrenda GetTipoPrenda() {		  
	         TipoPrenda tp = new TipoPrenda();
	         tp.setDescripcion("lalal");
	         tp.setCategoria(GetCategoria());
	         tp.setCodTipoPrenda(1);
	      return tp;
	}
	
	public List<TipoPrenda> listaTipoPrendas(){
		List<TipoPrenda>  ll = new ArrayList<TipoPrenda>();
		ll.add(this.GetTipoPrenda());
		ll.add(this.GetTipoPrenda());
		ll.add(this.GetTipoPrenda());
		ll.add(this.GetTipoPrenda());
		ll.add(this.GetTipoPrenda());
		ll.add(this.GetTipoPrenda());
      return ll;
	}
	
	public List<Guardarropa> listaGuardarropa(){
		List<Guardarropa>  ll = new ArrayList<Guardarropa>();
		ll.add(this.GetGuardarropa());
		ll.add(this.GetGuardarropa());
		ll.add(this.GetGuardarropa());
		ll.add(this.GetGuardarropa());
      return ll;
	}
	
	private Guardarropa GetGuardarropa() {
		Guardarropa guard = new Guardarropa();
        guard.setCompartido(false);
        guard.setDescripcion("guardarropa");
        guard.setId(33);    
        return guard;
	}
	
	
	public Prenda getPrenda() {
		   Prenda prend = new Prenda();           	               
	         prend.setGuardarropa(this.GetGuardarropa());
	         prend.setColorPrimario("rojo");
	         prend.setTipoPrenda(GetTipoPrenda());
	         prend.setColorSecundario("azul");
	         prend.setDescripcion("prenda 1");
	         prend.setNumeroDeCapa(EnumCapa.Primera);
		return prend;
	}
	
	public List<Prenda> listaPrenda(){
		List<Prenda>  ll = new ArrayList<Prenda>();
		ll.add(this.getPrenda());
		ll.add(this.getPrenda());
		ll.add(this.getPrenda());
		ll.add(this.getPrenda());
		ll.add(this.getPrenda());
		ll.add(this.getPrenda());
		ll.add(this.getPrenda());
		ll.add(this.getPrenda());
		return ll;
	}

}
