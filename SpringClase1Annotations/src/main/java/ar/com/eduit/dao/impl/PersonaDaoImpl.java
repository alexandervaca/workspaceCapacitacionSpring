package ar.com.eduit.dao.impl;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ar.com.eduit.dao.PersonaDao;
import ar.com.eduit.model.Persona;

@Repository("personaDao")
@Scope("singleton")
public class PersonaDaoImpl implements PersonaDao {

	@Override
	public Long save(Persona persona) {
		System.out.println("salvando persona ... " + persona);
        return new Random().nextLong();
	}

	@Override
	public void delete(Persona persona) {
		System.out.println("Persona.delete...");
	}

}
