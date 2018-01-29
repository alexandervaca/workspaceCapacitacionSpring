package ar.com.eduit.beans;

public class PersonaBean implements Persona {

	@Override
	public void save(Persona persona) {
		System.out.println("save persona");
	}

}
