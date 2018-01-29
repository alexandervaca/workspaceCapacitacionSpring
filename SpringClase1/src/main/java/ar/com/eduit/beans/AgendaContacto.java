package ar.com.eduit.beans;

public class AgendaContacto implements Agenda {

	private Persona persona;
	
	@Override
	public void saveContacto() {
		System.out.println("save contacto...");
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
