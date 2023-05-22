package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Corso;
import com.entity.Studente;
import com.provider.ProviderManager;
import com.vo.StudenteCorsoVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class StudenteCorsoDAOImpl implements StudenteCorsoDAO {
	EntityManagerFactory emf;
	EntityManager em;

	@Override
	public void insertStudenteCorso(Map<Studente, List<Corso>> studenteCorso) {
		initRoutine();

		for (Studente s : studenteCorso.keySet()) {
			s.setCorsi(studenteCorso.get(s));
			em.persist(s);
		}

		closingRoutine();

	}

	@Override
	public void updateCorso(Corso corso) {
		initRoutine();

		em.merge(corso);

		closingRoutine();

	}

	@Override
	public void deleteCorso(Integer corsoId) {
		initRoutine();
		em.remove(em.find(Corso.class, corsoId));
		closingRoutine();

	}

	@Override
	public List<StudenteCorsoVO> getStudenteCorso() {
		initRoutine();
		List<StudenteCorsoVO> studenteCorso = em.createNamedQuery("Corso.findAllStudenteCorso", StudenteCorsoVO.class)
				.getResultList();
		closingRoutine();
		return studenteCorso;
	}

	private void closingRoutine() {
		try {
			ProviderManager.commitTransaction(em);
			System.out.println("Transazione Completata");
		} catch (RollbackException rbe) {
			rbe.printStackTrace();
			System.err.println("Transazione Fallita");
			ProviderManager.rollbackTransaction(em);
		}

		ProviderManager.closeTransaction(em);
		ProviderManager.closeEntityManagerFactory(emf);
	}

	private void initRoutine() {
		emf = ProviderManager.getEntityManagerFactory();
		em = ProviderManager.getEntityManager(emf);

		ProviderManager.beginTransaction(em);
	}

}
