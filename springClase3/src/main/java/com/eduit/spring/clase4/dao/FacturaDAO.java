package com.eduit.spring.clase4.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eduit.spring.clase4.model.Factura;

public interface FacturaDAO extends CrudRepository<Factura, Long> {
	
	public List<Factura> findByCliente(String cliente);
	
	public Factura findByNumero(Integer numero);

}
