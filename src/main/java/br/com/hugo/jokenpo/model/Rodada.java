package br.com.hugo.jokenpo.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rodada {

	private List<Disputa> disputas;

	public Rodada() {
	}

	public Rodada(List<Disputa> disputas) {
		this.disputas = disputas;
	}

	public List<Disputa> getDisputas() {
		return disputas;
	}
	
	public Map<Jogador, Resultado> jogar(List<Disputa> disputas) {
		Map<Jogador, Resultado> ret = new HashMap<>();

		disputas.stream().forEach(disputa -> {
			Resultado resultado = null;	
			boolean avaliaDerrota = avaliaDerrota(disputa.getJogada());
			if(avaliaDerrota){
				resultado = Resultado.DERROTA;
			}else {
				boolean avaliaVitoria = avaliaVitoria(disputa.getJogada());
				if(avaliaVitoria) {
					resultado = Resultado.VITORIA;					
				}else {
					resultado = Resultado.EMPATE;				
				}
			}
			ret.put(disputa.getJogador(), resultado);
		});	

		int valueCount = 0;
        for (Resultado resultado : ret.values()){
            if (Resultado.DERROTA.equals(resultado))
                valueCount++;
        }
        if(valueCount ==ret.size())
        	ret.replaceAll((key, oldResult) -> Resultado.EMPATE);

		
		return ret.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
		                (e1, e2) -> e1, LinkedHashMap::new));				
	}

	private boolean avaliaDerrota(Jogada jogada) {
		return disputas.stream().anyMatch(disputa -> jogada.perdePara(disputa.getJogada()));
	}

	private boolean avaliaVitoria(Jogada jogada) {
		return disputas.stream().anyMatch(disputa -> jogada.venceDe(disputa.getJogada()));
	}
	
	
	public boolean existeIdJogador(int id) {
		return disputas.stream().anyMatch(disputa -> disputa.getJogador().getId()==id);
	}

	public Jogador getJogadorDisputa(int id) {
		for (Disputa disputa : this.disputas) {
			Jogador jogador = disputa.getJogador();
			if(jogador.getId() == id) {
				return jogador;
			}
		}
		return null;
	}

	public void removerJogadorDisputa(int id) {	
		disputas.removeIf(disputa -> disputa.getJogador().getId() == id);
	}
	
	public boolean existeIdDisputa(int id) {
		return disputas.stream().anyMatch(disputa -> disputa.getId()==id);
	}

	public Disputa getDisputa(int id) {
		for (Disputa disputa : this.disputas) {
			if(disputa.getId()==id) {
				return disputa;
			}
		}
		return null;
	}

	public void removerDisputa(int id) {	
		disputas.removeIf(disputa -> disputa.getId() == id);
	}

	public void adicionarJogadorDisputa(Disputa disputa) {
		this.disputas.add(disputa);

	}

	private static Rodada rodada = new Rodada();

	public static Rodada getJogada() {
		return rodada;
	}

	public static void setJogada(Rodada rodada) {
		Rodada.rodada = rodada;
	}
}