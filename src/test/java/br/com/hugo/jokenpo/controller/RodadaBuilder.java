package br.com.hugo.jokenpo.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.hugo.jokenpo.model.Disputa;
import br.com.hugo.jokenpo.model.Rodada;

public class RodadaBuilder {

    private List<Disputa> disputas;
   
    public RodadaBuilder() {
        this.disputas = new ArrayList<>();
    }

    public RodadaBuilder addDisputa(Disputa disputa) {
        this.getDisputas().add(disputa);
        return this;
    }

    public Rodada constroi() {
        Rodada rodada = new Rodada(this.getDisputas());
        return rodada;
    }

	public List<Disputa> getDisputas() {
		return disputas;
	}

}