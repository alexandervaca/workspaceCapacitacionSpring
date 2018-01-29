package ar.com.eduit.dao;

import ar.com.eduit.model.Persona;

public interface PersonaDao {

	public Long save(Persona persona);
	
	public void delete(Persona persona);
	
}
