package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.AlloggioDAO;
import com.dao.AlloggioDAOImpl;
import com.dao.StudenteCorsoDAO;
import com.dao.StudenteCorsoDAOImpl;
import com.entity.Corso;
import com.entity.Studente;

public class Main {

	public static void main(String[] args) {
		AlloggioDAO alloggioDAO = new AlloggioDAOImpl();
//
//		alloggioDAO.insertAlloggio(new Alloggio(102, 3));
//
//		alloggioDAO.deleteAlloggio(1);
//
//		alloggioDAO.updateAlloggio(new Alloggio(2, 102, 69));
//
//		alloggioDAO.getAlloggi().forEach(System.out::println);
//
//		AlloggioStudenteDAO alloggioStudenteDAO = new AlloggioStudenteDAOImpl();
//
//		List<Studente> studenti = new ArrayList<>();
//		Studente s1 = new Studente("111", "Marco", "Marco");
//		Studente s2 = new Studente("121", "Marco2", "Marco2");
//
//		studenti.add(s2);
//		studenti.add(s1);
//
//		Alloggio a = new Alloggio(105, 3);

//		alloggioStudenteDAO.insertAlloggioStudente(a, studenti);

//		alloggioStudenteDAO.updateStudente(new Studente(5, "12111", "Marco22", "Marco2"));

//		alloggioStudenteDAO.getAlloggioStudente().forEach(System.out::println);

		StudenteCorsoDAO studenteCorsoDAO = new StudenteCorsoDAOImpl();

		Map<Studente, List<Corso>> corsoStudente = new HashMap<>();
		List<Corso> corsi = new ArrayList<>();

		Studente s1 = new Studente("111", "Roberto", "Graffeo");

		Corso c1 = new Corso("Matematica");

		Corso c2 = new Corso("Informatica");

		corsi.add(c1);
		corsi.add(c2);

		corsoStudente.put(s1, corsi);

//		studenteCorsoDAO.insertStudenteCorso(corsoStudente);

//		studenteCorsoDAO.updateCorso(new Corso(1, "Matematica 2"));

//		studenteCorsoDAO.deleteCorso(3);

		studenteCorsoDAO.getStudenteCorso().forEach(System.out::println);

	}

}
