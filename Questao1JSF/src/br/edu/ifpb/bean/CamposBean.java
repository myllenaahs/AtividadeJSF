package br.edu.ifpb.bean;

import br.edu.ifpb.entidade.*;

public class CamposBean {
	
	private Campos campos;
	
	public CamposBean(){
		this.campos = new Campos ();
	}

	public Campos getCampos() {
		return campos;
	}

	public void setCampos(Campos campos) {
		this.campos = campos;
	}
	
	public String inverter (){
		
		String aux;
		
		aux=campos.getCampo1();
		campos.setCampo1(campos.getCampo2());
		campos.setCampo2(aux);		
		return null;
	}
	
}
