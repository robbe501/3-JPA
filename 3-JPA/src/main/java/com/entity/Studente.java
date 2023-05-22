package com.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.TableGenerator;

@Entity
@NamedQuery(name = "Studente.findAllAlloggioStudente", query = "SELECT new com.vo.AlloggioStudenteVO(s.nome, s.cognome, a.numeroStanza) FROM Studente s JOIN s.alloggio a")
@TableGenerator(name = "alloggio")
public class Studente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studente_id")
	private Integer studenteId;

	private String matricola;
	private String nome;
	private String cognome;

	// bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "alloggio_id")
	private Alloggio alloggio;

	// bi-directional many-to-many association to Actor
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "studente_corso", joinColumns = @JoinColumn(name = "studente_id"), inverseJoinColumns = @JoinColumn(name = "corso_id"))
	private List<Corso> corsi = new ArrayList<>();

	public Studente() {
	}

	public Studente(Integer studenteId, String matricola, String nome, String cognome) {
		this.studenteId = studenteId;
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Studente(String matricola, String nome, String cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Integer getStudenteId() {
		return studenteId;
	}

	public void setStudenteId(Integer studenteId) {
		this.studenteId = studenteId;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Alloggio getAlloggio() {
		return alloggio;
	}

	public void setAlloggio(Alloggio alloggio) {
		this.alloggio = alloggio;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

}
