package com.eduit.spring.clase4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduit.spring.clase4.dao.FacturaDAO;
import com.eduit.spring.clase4.model.Factura;

@Service("facturaService")
public class FacturaService {

	@Autowired
	private FacturaDAO facturaDAO;

	@Transactional
	public Factura salvarFactura(Factura factura) {
		return facturaDAO.save(factura);
	}

	@Transactional
	public void borrarFactura(Factura factura) {
		facturaDAO.delete(factura);
	}

	@Transactional
	public List<Factura> listarFacturas() {
		List<Factura> facturas = new ArrayList<Factura>();
		for (Factura factura : facturaDAO.findAll()) {
			facturas.add(factura);
		}
		return facturas;
	}

	@Transactional
	public Factura obtenerPorId(Long id) {
		return facturaDAO.findOne(id);
	}

	public List<Factura> findByCliente(String cliente) {
		return facturaDAO.findByCliente(cliente);
	}

	public Factura findByNumero(Integer numero) {
		return facturaDAO.findByNumero(numero);
	}

}
