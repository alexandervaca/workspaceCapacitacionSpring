package com.eduit.spring.clase2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eduit.spring.clase2.dao.TarjetaDAO;
import com.eduit.spring.clase2.model.Tarjeta;

@Service("tarjetaService")
public class TarjetaService {

	@Autowired
	private TarjetaDAO tarjetaDAO;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Tarjeta saveTarjeta(Tarjeta tarjeta) {
		return tarjetaDAO.save(tarjeta);
	}

	@Transactional
	public Tarjeta getById(Long id) {
		return tarjetaDAO.findOne(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void deleteTarjeta(Tarjeta tarjeta) {
		tarjetaDAO.delete(tarjeta);
	}
	
	
}
