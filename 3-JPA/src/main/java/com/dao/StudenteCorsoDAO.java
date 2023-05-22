package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Corso;
import com.entity.Studente;
import com.vo.StudenteCorsoVO;

public interface StudenteCorsoDAO {
	public void insertStudenteCorso(Map<Studente, List<Corso>> studenteCorso);

	public void updateCorso(Corso corso);

	public void deleteCorso(Integer corsoId);

	public List<StudenteCorsoVO> getStudenteCorso();
}
