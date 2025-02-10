// Subclase de persona
public class Varon extends Persona {
	// Primer metodo constructor
	public Varon(String nombre) {
		
		super(nombre);
		this.sexo = 'V';
	}
	
	// Segundo metodo constructor
	public Varon(){
		this.sexo = 'V';
	}
}
