package com.vo;

public class AlloggioVO {

	private Integer numeroStanza;
	private Integer postiLetto;

	public Integer getNumeroStanza() {
		return numeroStanza;
	}

	public void setNumeroStanza(Integer numeroStanza) {
		this.numeroStanza = numeroStanza;
	}

	public Integer getPostiLetto() {
		return postiLetto;
	}

	public void setPostiLetto(Integer postiLetto) {
		this.postiLetto = postiLetto;
	}

	public AlloggioVO(Integer numeroStanza, Integer postiLetto) {
		this.numeroStanza = numeroStanza;
		this.postiLetto = postiLetto;
	}

	@Override
	public String toString() {
		return "AlloggioVO [numeroStanza=" + numeroStanza + ", postiLetto=" + postiLetto + "]";
	}

}
