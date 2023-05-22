package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.TableGenerator;

@Entity
@NamedQuery(name = "Corso.findAllStudenteCorso", query = "SELECT new com.vo.StudenteCorsoVO(s.nome, s.cognome, c.nome) FROM Corso c JOIN c.studenti s")
@TableGenerator(name = "corso")
public class Corso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "corso_id")
	private Integer corsoId;

	private String nome;

	// bi-directional many-to-many association to Film
	@ManyToMany(mappedBy = "corsi", cascade = CascadeType.ALL)
	private List<Studente> studenti;

	public Corso() {
	}

	public Corso(Integer corsoId, String nome) {
		this.corsoId = corsoId;
		this.nome = nome;
	}

	public Corso(String nome) {
		this.nome = nome;
	}

	public Integer getCorsoId() {
		return corsoId;
	}

	public void setCorsoId(Integer corsoId) {
		this.corsoId = corsoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}

}
