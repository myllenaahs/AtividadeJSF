package br.edu.ifpb.bean;

import br.edu.ifpb.entidade.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class CamposBean {

	private String campo1;
	private String campo2;

	public String getCampo1() {
		return campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	public String getCampo2() {
		return campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

	public String inverter() {

		String aux;

		aux = campo1;
		campo1 = campo2;
		campo2=aux;
		return null;
	}

}
