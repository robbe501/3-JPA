package com.dao;

import java.util.List;

import com.entity.Alloggio;
import com.vo.AlloggioVO;

public interface AlloggioDAO {
	public void insertAlloggio(Alloggio alloggio);

	public void updateAlloggio(Alloggio alloggio);

	public void deleteAlloggio(Integer alloggioId);

	public List<AlloggioVO> getAlloggi();
}
