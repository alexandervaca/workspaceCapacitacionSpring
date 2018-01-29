package com.eduit.spring.clase2.dao;

import com.eduit.spring.clase2.model.Cliente;
import com.eduit.spring.clase2.model.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteDAO extends CrudRepository<Cliente, Long> {

	@Query("from com.eduit.spring.clase2.model.Cliente c where c.direccion = :direccion")
	public List<Cliente> getClientesBydireccion(@Param("direccion") String direccion);

	@Query("select cli from com.eduit.spring.clase2.model.Cliente cli join  cli.cuentas cuentas  where cuentas = :cuenta ")
	public List<Cliente> getClientesByCuentas(@Param("cuenta") Cuenta cuenta);

}
