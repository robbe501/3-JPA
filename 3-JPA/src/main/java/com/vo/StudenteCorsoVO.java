package com.vo;

public class StudenteCorsoVO {
	private String nome;
	private String cognome;
	private String nomeCorso;

	public StudenteCorsoVO(String nome, String cognome, String nomeCorso) {
		this.nome = nome;
		this.cognome = cognome;
		this.nomeCorso = nomeCorso;
	}

	@Override
	public String toString() {
		return "StudenteCorsoVO [nome=" + nome + ", cognome=" + cognome + ", nomeCorso=" + nomeCorso + "]";
	}

}
