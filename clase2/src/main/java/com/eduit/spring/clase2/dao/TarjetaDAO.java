package com.eduit.spring.clase2.dao;

import org.springframework.data.repository.CrudRepository;

import com.eduit.spring.clase2.model.Tarjeta;

public interface TarjetaDAO extends CrudRepository<Tarjeta, Long> {

}
