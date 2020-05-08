package br.com.hugo.jokenpo.controller;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import br.com.hugo.jokenpo.model.Disputa;
import br.com.hugo.jokenpo.model.Jogada;
import br.com.hugo.jokenpo.model.Jogador;
import br.com.hugo.jokenpo.model.Resultado;
import br.com.hugo.jokenpo.model.Rodada;

public class JokenpoControllerTest {

	private DisputaBuilder disputaBuilder;
	private Disputa disputaComLagarto;
	private Disputa disputaComPapel;
	private Disputa disputaComPedra;
	private Disputa disputaComSpock;
	private Disputa disputaComTesoura;
	private Map<Jogador, Resultado> expectedMap; 

	private RodadaBuilder rodadaBuilder;

	@Before
	public void init() {

		this.rodadaBuilder = new RodadaBuilder();
		this.disputaBuilder = new DisputaBuilder();

		this.disputaComLagarto = disputaBuilder
				.comJogador(1, "Jogador 1")
				.comJogada(Jogada.LAGARTO)
				.constroi();

		this.disputaComPapel = disputaBuilder
				.comJogador(2, "Jogador 2")
				.comJogada(Jogada.PAPEL)
				.constroi();

		this.disputaComPedra = disputaBuilder
				.comJogador(3, "Jogador 3")
				.comJogada(Jogada.PEDRA)
				.constroi();

		this.disputaComSpock = disputaBuilder
				.comJogador(4, "Jogador 4")
				.comJogada(Jogada.SPOCK)
				.constroi();

		this.disputaComTesoura = disputaBuilder
				.comJogador(5, "Jogador 5")
				.comJogada(Jogada.TESOURA)
				.constroi();

		expectedMap = new HashMap<Jogador, Resultado>();

	}

	@Test
	public void deveRegistrarVitoriaDoLagartoSobrePapel() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComLagarto)
				.addDisputa(disputaComPapel)
				.constroi();


		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.VITORIA);
		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarVitoriaDoLagartoSobreSpock() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComLagarto)
				.addDisputa(disputaComSpock)
				.constroi();

		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.VITORIA);
		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarVitoriaDoPapelSobrePedra() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPapel)
				.addDisputa(disputaComPedra)
				.constroi();

		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.VITORIA);
		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarVitoriaDoPapelSobreSpock() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPapel)
				.addDisputa(disputaComSpock)
				.constroi();

		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.VITORIA);
		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarVitoriaDaPedraSobreLagarto() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPedra)
				.addDisputa(disputaComLagarto)
				.constroi();

		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.VITORIA);
		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());

	}

	@Test
	public void deveRegistrarVitoriaDaPedraSobreTesoura() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPedra)
				.addDisputa(disputaComTesoura)
				.constroi();

		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.VITORIA);
		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}


	
	
	
	
	@Test
	public void deveRegistrarVitoriaDoSpockSobrePedra() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComSpock)
				.addDisputa(disputaComPedra)
				.constroi();

		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.VITORIA);
		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());

	}

	@Test
	public void deveRegistrarVitoriaDoSpockSobreTesoura() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComSpock)
				.addDisputa(disputaComTesoura)
				.constroi();

		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.VITORIA);
		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}



	@Test
	public void deveRegistrarVitoriaDaTesouraSobreLagarto() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComTesoura)
				.addDisputa(disputaComLagarto)
				.constroi();

		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.VITORIA);
		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarVitoriaDaTesouraSobrePapel() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComTesoura)
				.addDisputa(disputaComPapel)
				.constroi();

		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.VITORIA);
		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void deveRegistrarDerrotaDoLagartoParaPedra() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComLagarto)
				.addDisputa(disputaComPedra)
				.constroi();


		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.DERROTA);
		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.VITORIA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarDerrotaDoLagartoParaTesouta() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComLagarto)
				.addDisputa(disputaComTesoura)
				.constroi();

		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.DERROTA);
		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.VITORIA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarDerrotaDoPapelParaLagarto() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPapel)
				.addDisputa(disputaComLagarto)
				.constroi();

		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.DERROTA);
		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.VITORIA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarDerrotaDoPapelParaTesoura() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPapel)
				.addDisputa(disputaComTesoura)
				.constroi();

		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.DERROTA);
		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.VITORIA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarDerrotaDaPedraParaPapel() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPedra)
				.addDisputa(disputaComPapel)
				.constroi();

		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.DERROTA);
		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.VITORIA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());

	}

	@Test
	public void deveRegistrarDerrotaDaPedraParaSpock() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPedra)
				.addDisputa(disputaComSpock)
				.constroi();

		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.DERROTA);
		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.VITORIA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}


	
	
	
	
	@Test
	public void deveRegistrarDerrotaDoSpockParaLagarto() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComSpock)
				.addDisputa(disputaComLagarto)
				.constroi();

		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.DERROTA);
		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.VITORIA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());

	}

	@Test
	public void deveRegistrarDerrotaDoSpockParaPapel() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComSpock)
				.addDisputa(disputaComPapel)
				.constroi();

		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.DERROTA);
		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.VITORIA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}



	@Test
	public void deveRegistrarDerrotaDaTesouraParaPedra() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComTesoura)
				.addDisputa(disputaComPedra)
				.constroi();

		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.DERROTA);
		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.VITORIA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarDerrotaDaTesouraParaSpock() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComTesoura)
				.addDisputa(disputaComSpock)
				.constroi();

		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.DERROTA);
		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.VITORIA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}
	
	
	@Test
	public void deveRegistrarDisputaSemVencedores() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPapel)
				.addDisputa(disputaComPedra)
				.addDisputa(disputaComTesoura)
				.constroi();
		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.DERROTA);
		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.DERROTA);
		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}
	
	
	@Test
	public void deveRegistrarVitoriaLagartoSobrePapelSpock() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComLagarto)
				.addDisputa(disputaComPapel)
				.addDisputa(disputaComSpock)
				.constroi();
		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.VITORIA);
		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.DERROTA);
		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarVitoriaPapelSobreSpockPedra() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPapel)
				.addDisputa(disputaComPedra)
				.addDisputa(disputaComSpock)
				.constroi();
		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.VITORIA);
		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.DERROTA);
		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}

	@Test
	public void deveRegistrarVitoriaPedraSobreLagartoTesoura() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComPedra)
				.addDisputa(disputaComLagarto)
				.addDisputa(disputaComTesoura)
				.constroi();
		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.VITORIA);
		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.DERROTA);
		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}	

	@Test
	public void deveRegistrarVitoriaSpockSobrePedraTesoura() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComSpock)
				.addDisputa(disputaComPedra)
				.addDisputa(disputaComTesoura)
				.constroi();
		expectedMap.put(new Jogador(4, "Jogador 4"), Resultado.VITORIA);
		expectedMap.put(new Jogador(3, "Jogador 3"), Resultado.DERROTA);
		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}
	
	@Test
	public void deveRegistrarVitoriaTesouraSobreLagartoPapel() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComTesoura)
				.addDisputa(disputaComLagarto)
				.addDisputa(disputaComPapel)
				.constroi();
		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.VITORIA);
		expectedMap.put(new Jogador(1, "Jogador 1"), Resultado.DERROTA);
		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}
	
	@Test
	public void deveRegistrarDoisVencedores() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComTesoura)
				.addDisputa(new Disputa(new Jogador(6, "Jogador 6"), Jogada.TESOURA))
				.addDisputa(disputaComPapel)
				.constroi();
		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.VITORIA);
		expectedMap.put(new Jogador(6, "Jogador 6"), Resultado.VITORIA);
		expectedMap.put(new Jogador(2, "Jogador 2"), Resultado.DERROTA);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}
	
	public void deveRegistrarEmpate() {
		Rodada rodada = this.rodadaBuilder
				.addDisputa(disputaComTesoura)
				.addDisputa(new Disputa(new Jogador(6, "Jogador 6"), Jogada.TESOURA))
				.constroi();
		expectedMap.put(new Jogador(5, "Jogador 5"), Resultado.EMPATE);
		expectedMap.put(new Jogador(6, "Jogador 6"), Resultado.EMPATE);

		Map<Jogador, Resultado> expectedMapSorted = expectedMap.entrySet().stream().sorted((v1, v2) ->v1.getKey().getId().compareTo(v2.getKey().getId()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		assertEquals(expectedMapSorted.toString(),rodada.jogar(this.rodadaBuilder.getDisputas()).toString());
	}
}
