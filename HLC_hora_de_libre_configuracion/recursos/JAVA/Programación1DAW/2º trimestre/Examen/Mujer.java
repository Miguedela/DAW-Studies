// Subclase de mujer
public class Mujer extends Persona {
	// Primer metodo constructor
	public Mujer(String nombre) {

		super(nombre);
		this.sexo = 'M';
	}

	// Segundo metodo constructor
	public Mujer() {
		this.sexo = 'M';
	}

	// Metodo para dar a luz
	public Persona daALuz(char sexo, String nombre) {
		Persona p;
		// Condicion if para saber si es hombre o mujer
		if (sexo == 'V')
			p = new Varon();
		else
			p = new Mujer();

		p.setMadre(this);
		p.setPadre((Varon) this.conyuge);
		p.setNombre(nombre);

		return p;
	}
}
