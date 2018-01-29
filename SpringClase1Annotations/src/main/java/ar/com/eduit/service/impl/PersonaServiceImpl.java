package ar.com.eduit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.com.eduit.dao.PersonaDao;
import ar.com.eduit.model.Persona;
import ar.com.eduit.service.PersonaService;

@Service(value="personaDaoImpl")
@Scope(value="prototype")
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaDao personaDao;
	
	@Override
	public Persona save(Persona persona) {
		Long id = personaDao.save(persona);
		persona.setId(id);
		return persona;
	}

	@Override
	public void delete(Persona persona) {
		personaDao.delete(persona);
	}

}
