package br.com.hugo.jokenpo.controller.dto;


import br.com.hugo.jokenpo.model.Rodada;


public class JogadaDto {
	
	private Rodada rodada;
	
	public JogadaDto() {}
	
	public JogadaDto(Rodada rodada) {
		this.rodada = rodada;
	}

	public Rodada getJogada() {
		return rodada;
	}

	
}