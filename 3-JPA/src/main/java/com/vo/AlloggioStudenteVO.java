package com.vo;

public class AlloggioStudenteVO {
	private String nome;
	private String cognome;
	private Integer numeroStanza;

	public AlloggioStudenteVO(String nome, String cognome, Integer numeroStanza) {
		this.nome = nome;
		this.cognome = cognome;
		this.numeroStanza = numeroStanza;
	}

	@Override
	public String toString() {
		return "AlloggioStudenteVO [nome=" + nome + ", cognome=" + cognome + ", numeroStanza=" + numeroStanza + "]";
	}

}
