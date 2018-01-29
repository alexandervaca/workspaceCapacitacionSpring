package com.eduit.spring.clase4.service;

import com.eduit.spring.clase4.dao.ArticuloDAO;
import com.eduit.spring.clase4.model.Articulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("articuloService")
public class ArticuloService {




    @Autowired
    private ArticuloDAO articuloDAO;

    @Transactional
    public Articulo salvarArticulo(Articulo articulo) {
        return articuloDAO.save(articulo);
    }

    @Transactional
    public void borrarArticulo(Articulo articulo) {
        articuloDAO.delete(articulo);
    }

    @Transactional(readOnly = true)
    public List<Articulo> listarArticulos() {
        List<Articulo> articulos = new ArrayList<Articulo>();
        for(Articulo articulo : articuloDAO.findAll()){
           articulos.add(articulo);
        }
        return articulos;
    }

    @Transactional(readOnly = true)
    public Articulo obtenerPorId(Long id) {
        return articuloDAO.findOne(id);
    }

    @Transactional
    public Articulo modificarArticulo(Articulo articulo) {
        return articuloDAO.save(articulo);
    }

    public boolean exists(Articulo articulo){
        return articuloDAO.exists(articulo.getId());
    }

	public Articulo obtenerPorParametros(Integer cantidad, Float precio,
			String presentacion) {
		return articuloDAO.getByCantidadAndPrecioAndPresentacion(cantidad,precio,presentacion);
	}

	public Articulo modificarArticuloCantidad(Articulo articulo) {
		Articulo articuloPersisted  = articuloDAO.findOne(articulo.getId());
		articuloPersisted.setCantidad(articulo.getCantidad());
		articuloDAO.save(articuloPersisted);
		return articuloPersisted;
	}



}
