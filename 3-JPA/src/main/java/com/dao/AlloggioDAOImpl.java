package com.dao;

import java.util.List;

import com.entity.Alloggio;
import com.provider.ProviderManager;
import com.vo.AlloggioVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class AlloggioDAOImpl implements AlloggioDAO {
	EntityManagerFactory emf;
	EntityManager em;

	@Override
	public void insertAlloggio(Alloggio alloggio) {
		initRoutine();
		em.persist(alloggio);
		closingRoutine();

	}

	@Override
	public void updateAlloggio(Alloggio alloggio) {
		initRoutine();
		em.merge(alloggio);
		closingRoutine();

	}

	@Override
	public void deleteAlloggio(Integer alloggioId) {
		initRoutine();
		em.remove(em.find(Alloggio.class, alloggioId));
		closingRoutine();

	}

	@Override
	public List<AlloggioVO> getAlloggi() {
		initRoutine();
		List<AlloggioVO> alloggi = em.createNamedQuery("Alloggio.findAll", AlloggioVO.class).getResultList();
		closingRoutine();
		return alloggi;
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
