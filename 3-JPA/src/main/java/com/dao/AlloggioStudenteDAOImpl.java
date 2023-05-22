package com.dao;

import java.util.List;

import com.entity.Alloggio;
import com.entity.Studente;
import com.provider.ProviderManager;
import com.vo.AlloggioStudenteVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class AlloggioStudenteDAOImpl implements AlloggioStudenteDAO {
	EntityManagerFactory emf;
	EntityManager em;

	@Override
	public void insertAlloggioStudente(Alloggio alloggio, List<Studente> studenti) {
		initRoutine();
		alloggio.setStudenti(studenti);
		em.persist(alloggio);

		for (Studente s : studenti) {
			s.setAlloggio(alloggio);
			em.persist(s);
		}

		closingRoutine();

	}

	@Override
	public void updateStudente(Studente studente) {
		initRoutine();
		em.merge(studente);
		closingRoutine();

	}

	@Override
	public List<AlloggioStudenteVO> getAlloggioStudente() {
		initRoutine();
		List<AlloggioStudenteVO> alloggiStudenti = em
				.createNamedQuery("Studente.findAllAlloggioStudente", AlloggioStudenteVO.class).getResultList();
		closingRoutine();
		return alloggiStudenti;
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
