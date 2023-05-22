package com.dao;

import java.util.List;

import com.entity.Alloggio;
import com.entity.Studente;
import com.vo.AlloggioStudenteVO;

public interface AlloggioStudenteDAO {
	public void insertAlloggioStudente(Alloggio alloggio, List<Studente> studenti);

	public void updateStudente(Studente studente);

	public List<AlloggioStudenteVO> getAlloggioStudente();
}
