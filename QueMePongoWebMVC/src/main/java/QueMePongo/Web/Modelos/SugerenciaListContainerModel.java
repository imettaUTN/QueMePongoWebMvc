package QueMePongo.Web.Modelos;

import java.util.*;

public class SugerenciaListContainerModel {
	private List<PrendaModelo> listaPrendas;
	private int motivoRechazo;
	private String datosBasicosSugerencia;

	// Son los datos que le paso a la vista para recostruir la sugerencia
	public String ObtenerClaveDatosBasicosSug() {
		String clave = "";
		for (PrendaModelo pm : this.getListaPrendas()) {
			if (clave == "") {
				clave = String.valueOf(pm.getCodPrenda());
			} else {
				clave += "," + String.valueOf(pm.getCodPrenda());
			}
		}
		return clave;
	}

	public void addPrenda(PrendaModelo pp) {
		listaPrendas.add(pp);
	}

	public List<PrendaModelo> getListaPrendas() {
		return listaPrendas;
	}

	public void setListaPrendas(List<PrendaModelo> listaPrendas) {
		this.listaPrendas = listaPrendas;
	}

	public int getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(int motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public String getDatosBasicosSugerencia() {
		return datosBasicosSugerencia;
	}

	public void setDatosBasicosSugerencia(String datosBasicosSugerencia) {
		this.datosBasicosSugerencia = datosBasicosSugerencia;
	}
}