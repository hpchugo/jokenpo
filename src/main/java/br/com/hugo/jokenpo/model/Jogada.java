package br.com.hugo.jokenpo.model;

import java.util.Arrays;
import java.util.List;

public enum Jogada{

	LAGARTO, PAPEL, PEDRA, SPOCK, TESOURA;

	public List<Jogada> listaPerdePara;
	public List<Jogada> listaVenceDe;

	public boolean perdePara(Jogada outraJogada) {
		return listaPerdePara.contains(outraJogada);
	}

	public boolean venceDe(Jogada outraJogada) {
		return listaVenceDe.contains(outraJogada);
	}

	static {
		LAGARTO.listaPerdePara = Arrays.asList(PEDRA, TESOURA);
		PAPEL.listaPerdePara = Arrays.asList(LAGARTO, TESOURA);
		PEDRA.listaPerdePara = Arrays.asList(PAPEL, SPOCK);
		SPOCK.listaPerdePara = Arrays.asList(LAGARTO, PAPEL);
		TESOURA.listaPerdePara = Arrays.asList(PEDRA, SPOCK);
	}
	
	static {
		LAGARTO.listaVenceDe = Arrays.asList(PAPEL, SPOCK);
		PAPEL.listaVenceDe = Arrays.asList(PEDRA, SPOCK);
		PEDRA.listaVenceDe = Arrays.asList(LAGARTO, TESOURA);
		SPOCK.listaVenceDe = Arrays.asList(TESOURA, PEDRA);
		TESOURA.listaVenceDe = Arrays.asList(PAPEL, LAGARTO);
		
	}
}
