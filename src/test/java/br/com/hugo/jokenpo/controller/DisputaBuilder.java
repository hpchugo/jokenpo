package br.com.hugo.jokenpo.controller;

import br.com.hugo.jokenpo.model.Disputa;
import br.com.hugo.jokenpo.model.Jogada;
import br.com.hugo.jokenpo.model.Jogador;

public class DisputaBuilder {

    private Jogador jogador;
    private Jogada jogada;

    public DisputaBuilder comJogador(int id, String nome) {
        this.jogador = new Jogador(id, nome);
        return this;
    }

    public DisputaBuilder comJogada(Jogada jogada) {
        this.jogada = jogada;
        return this;
    }

    public Disputa constroi() {
        Disputa disputa = new Disputa(this.jogador, this.jogada);
        return disputa;
    }

}