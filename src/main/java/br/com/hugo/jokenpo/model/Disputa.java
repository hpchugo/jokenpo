package br.com.hugo.jokenpo.model;

public class Disputa {
	private int id;
	private Jogador jogador;
	private Jogada jogada;
	
	public Disputa(Jogador jogador, Jogada jogada) {
		this.jogador = jogador;
		this.jogada = jogada;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public Jogada getJogada() {
		return jogada;
	}

	@Override
	public String toString() {
		return "Disputa [id=" + id + ", jogador=" + jogador + ", jogada=" + jogada + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disputa other = (Disputa) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
