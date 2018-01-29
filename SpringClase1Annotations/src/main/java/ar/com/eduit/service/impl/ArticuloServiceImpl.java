package ar.com.eduit.service.impl;

import ar.com.eduit.dao.ArticuloDao;
import ar.com.eduit.model.Articulo;
import ar.com.eduit.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="articuloDaoImpl")
@Scope(value="prototype")
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	private ArticuloDao articuloDao;
	
	
	@Override
	public Articulo salvarArticulo(Articulo articulo) {
	    Long id = articuloDao.save(articulo);
	    articulo.setId(id);
		return articulo;
	}



}
