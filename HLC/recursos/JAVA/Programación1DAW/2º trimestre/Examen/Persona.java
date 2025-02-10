public abstract class Persona {
	// Atributos de examen
	protected String nombre;
	protected Varon padre;
	protected Mujer madre;
	protected Persona conyuge;
	protected char sexo;

	// Metodo constructor
	public Persona(String nombre) {
		this.nombre = nombre;
		this.padre = null;
		this.madre = null;
		this.conyuge = null;
	}

	// Segundo metodo constructor
	public Persona() {
		this.padre = null;
		this.madre = null;
		this.conyuge = null;
	}

	// Getters and Setters
	public Varon getPadre() {
		return padre;
	}

	public void setPadre(Varon padre) {
		this.padre = padre;
	}

	public Mujer getMadre() {
		return madre;
	}

	public void setMadre(Mujer madre) {
		this.madre = madre;
	}

	// Metodo que casa a una persona con alguien
	public void casarCon(Persona p) {
		if (p.getSexo() != this.sexo && this.conyuge == null && p.getconyuge() == null) {
			this.conyuge = p;
			p.setconyuge(this);
		}
	}

	// Metodo que divorcia a una persona con otra
	public void divorciarDe(Persona p) {
		this.setconyuge(null);
		p.setconyuge(null);
	}

	// Getters and Setters
	public Persona getconyuge() {
		return conyuge;
	}

	public void setconyuge(Persona conyuge) {
		this.conyuge = conyuge;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Metodos booleanos
	/* ----------------------------------------------------------------- */
	// Metodos que comprueba si son hermanos
	public boolean esHermanoADe(Persona p) {
		if (p.getPadre() == this.getPadre() && p.getMadre() == this.getMadre()) {
			return true;
		} else {
			return false;
		}
	}

	// Metodo de comprobación de hijo de
	public boolean esHijoADe(Persona p) {
		if (this.getPadre() == p || this.getMadre() == p) {
			return true;
		} else {
			return false;
		}
	}

	// Metodo de comprobación de primos
	public boolean esPrimoADe(Persona p) {
		if (p.getPadre().esHermanoADe(this.getPadre()) || p.getPadre().esHermanoADe(this.getMadre())
				|| p.getMadre().esHermanoADe(this.getPadre()) || p.getMadre().esHermanoADe(this.getMadre())) {
			return true;
		} else {
			return false;
		}
	}

	// Metodo de comprobacion de tio-sobrino carnal
	public boolean esSobrinoACarnalDe(Persona p) {
		if (this.getPadre().esHermanoADe(p) || this.getMadre().esHermanoADe(p)) {
			return true;
		} else {
			return false;
		}
	}

	// Metodo de comprobación de tio carnal
	public boolean esTioACarnalDe(Persona p) {
		if (this.esHermanoADe(p.getPadre()) || this.esHermanoADe(p.getMadre())) {
			return true;
		} else {
			return false;
		}
	}
	
	// Metodo de comprobación de tio político
	public boolean esTioAPoliticoDe(Persona p) {
		if (this.esHermanoADe(p.getPadre().getconyuge()) || this.esHermanoADe(p.getMadre().getconyuge())) {
			return true;
		} else {
			return false;
		}
	}

	// Metodo de comprobación de sobrino-tio político
	public boolean esSobrinoAPoliticoDe(Persona p) {
		if (this.getPadre().getconyuge().esHermanoADe(p) || this.getMadre().getconyuge().esHermanoADe(p)) {
			return true;
		} else {
			return false;
		}
	}

	// Metodo de comprobacion de abuelo
	public boolean esAbueloADe(Persona p) {
		if (p.getPadre().esHijoADe(this) == true || p.getMadre().esHijoADe(this)) {
			return true;
		} else {
			return false;
		}
	}

	// Metodo que comprueba si algunas personas son la misma
	public void mismaPersona(Persona p) {
		if (p.getNombre().equalsIgnoreCase(this.getNombre()) && p.getPadre() == this.getPadre()
				&& p.getMadre() == this.getMadre()) {
			System.out.println(p.toString() + " y " + toString() + " son la misma persona.");
		} else {
			System.out.println(p.toString() + " y " + toString() + " no son la misma persona.");
		}
	}

	// Metodo toString que devuelve el nombre
	public String toString() {
		return nombre;
	}
}
