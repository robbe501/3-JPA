package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.TableGenerator;

@Entity
@NamedQuery(name = "Alloggio.findAll", query = "SELECT new com.vo.AlloggioVO(a.numeroStanza, a.postiLetto) FROM Alloggio a")
@TableGenerator(name = "alloggio")
public class Alloggio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alloggio_id")
	private Integer alloggioId;

	@Column(name = "posti_letto")
	private Integer postiLetto;

	@Column(name = "numero_stanza")
	private Integer numeroStanza;

	// bi-directional many-to-one association to Customer
	@OneToMany(mappedBy = "alloggio", cascade = CascadeType.ALL)
	private List<Studente> studenti;

	public Alloggio() {
	}

	public Alloggio(Integer numeroStanza, Integer postiLetto) {
		this.postiLetto = postiLetto;
		this.numeroStanza = numeroStanza;
	}

	public Alloggio(Integer alloggioId, Integer numeroStanza, Integer postiLetto) {
		this.alloggioId = alloggioId;
		this.numeroStanza = numeroStanza;
		this.postiLetto = postiLetto;
	}

	public Integer getAlloggioId() {
		return alloggioId;
	}

	public void setAlloggioId(Integer alloggioId) {
		this.alloggioId = alloggioId;
	}

	public Integer getPostiLetto() {
		return postiLetto;
	}

	public void setPostiLetto(Integer postiLetto) {
		this.postiLetto = postiLetto;
	}

	public Integer getNumeroStanza() {
		return numeroStanza;
	}

	public void setNumeroStanza(Integer numeroStanza) {
		this.numeroStanza = numeroStanza;
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}

}
