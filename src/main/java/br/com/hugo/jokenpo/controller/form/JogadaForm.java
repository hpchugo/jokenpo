package br.com.hugo.jokenpo.controller.form;

import java.util.List;

import br.com.hugo.jokenpo.model.Disputa;
import br.com.hugo.jokenpo.model.Rodada;

public class JogadaForm {
	private List<Disputa> disputas;

	public List<Disputa> getDisputas() {
		return disputas;
	}

	public void setDisputas(List<Disputa> disputas) {
		this.disputas = disputas;
	}
	
	public Rodada converter() {
		return new Rodada(this.getDisputas());
	}
}
