package ar.com.eduit.dao.impl;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import ar.com.eduit.dao.ArticuloDao;
import ar.com.eduit.model.Articulo;

@Repository("articuloDao")
@Scope("singleton")
public class ArticuloDaoImpl implements ArticuloDao {

    @Override
    public Long save(Articulo articulo) {
        System.out.println("salvando articulo ... " + articulo);
        return new Random().nextLong();
    }
}
