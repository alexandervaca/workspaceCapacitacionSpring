package ar.com.eduit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.com.eduit.dao.FacturaDao;
import ar.com.eduit.entities.Factura;
import ar.com.eduit.service.FacturaService;

@Service(value="facturaService")
@Scope(value="prototype")
public class FacturaServiceImpl implements FacturaService {

    @Autowired
	private FacturaDao facturaDao;

	public FacturaDao getFacturaDao() {
		return facturaDao;
	}

	public void setFacturaDao(FacturaDao facturaDao) {
		this.facturaDao = facturaDao;
	}


	@Override
	public Factura crearFactura(Factura factura) {
		factura.setTotal(0.0f);
		factura.setId((Long) facturaDao.save(factura));
		return factura;
	}



	
}
