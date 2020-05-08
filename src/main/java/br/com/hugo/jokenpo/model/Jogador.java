package br.com.hugo.jokenpo.model;

import java.io.Serializable;

public class Jogador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	
	public Jogador(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", name=" + name + "]";
	}
}
