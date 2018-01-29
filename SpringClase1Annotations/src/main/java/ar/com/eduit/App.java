package ar.com.eduit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.com.eduit.configuration.SpringConfiguration;
import ar.com.eduit.model.Articulo;
import ar.com.eduit.model.Persona;
import ar.com.eduit.service.ArticuloService;
import ar.com.eduit.service.PersonaService;
import ar.com.eduit.service.impl.ArticuloServiceImpl;
import ar.com.eduit.service.impl.PersonaServiceImpl;

public class App {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		// EstacionMetereologica norte = context.getBean("estacionMetereologicaNorte",EstacionMetereologica.class);
		// norte.tomarMedicion();
		//
		// EstacionMetereologica sur = context.getBean("estacionMetereologicaSur",EstacionMetereologica.class);
		// sur.tomarMedicion();
		//
		// EstacionMetereologica estacionNorteTermometro = context.getBean("norteTermometro",EstacionMetereologica.class);
		// estacionNorteTermometro.tomarMedicion();

		// Articulo tel = new Articulo("telefono", "caja", 1000.00f, 10);
		// ArticuloService articuloService = context.getBean(ArticuloServiceImpl.class);
		// articuloService.salvarArticulo(tel);

		 Persona persona = new Persona();
		 persona.setNombre("Pepe");
		// PersonaService personaService = context.getBean(PersonaServiceImpl.class);
		// personaService.save(persona);

		 PersonaService personaService = context.getBean(PersonaServiceImpl.class);
		 personaService.delete(persona);
	}
}
