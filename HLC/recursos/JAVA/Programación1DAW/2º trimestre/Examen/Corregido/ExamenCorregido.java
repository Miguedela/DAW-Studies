package Corregido;

/**
 * ExamenCorregido
 */
public class ExamenCorregido {

    // Metodo boolean para comprobar sí son la misma persona
    @Override
    public boolean equals(Persona p) {
        if (this == p) {
            return true;
        }

        if (p == null) {
            return false;
        }

        if (getClass() != p.getClass) {
            return false;
        }

        final Persona otro = (Persona) p;

        if (!Persona.equals(this.nombre, otro.nombre)) {
            return false;
        }

        if (!Persona.equals(this.padre, otro.padre)) {
            return false;
        }

        return Persona.equals(otro.padre, otro.madre);
    }

    // Metodo para saber si son hermanos
    public boolean esHermano(Persona p) {
        // Comprobación para evitar erros
        if (p == null || this == null) {
            return false;
        }

        if (p.getPadre() != null && p.getMadre() != null && this.padre == p.padre && this.madre == p.madre) {
            return true;
        } else {
            return false;
        }
    }

    // Metodo para comprobar si es su hijo
    public boolean esHijo(Persona p) {
        // Comprobación para evitar erros
        if (p == null || this == null) {
            return false;
        }

        if (this.madre.nombre.equals(p.nombre) || this.padre.nombre.equals(p.nombre)) {
            return true;
        } else {
            return false;
        }
    }

    // Metodo para comprobar si son primos
    public boolean esPrimo(Persona p) {
        // Comprobación para evitar erros
        if (p == null || this == null) {
            return false;
        }

        if (this.madre.esHermano(p.madre) || this.madre.esHermano(p.padre) || this.padre.esHermano(p.padre)
                || this.padre.esHermano(p.madre)) {
            return true;
        } else {
            return false;
        }
    }

    // Metodos para saber sí esSobrinoCarnal
    public boolean esSobrinoCarnal(Persona p) {
        // Comprobación para evitar erros
        if (p == null || this == null) {
            return false;
        }

        if (p.esHermano(this.padre) || p.esHermano(this.madre)) {
            return true;
        } else {
            return false;
        }
    }

    // Metodos para saber si esTioCarnal
    public boolean esTioCarnal(Persona p) {
        // Comprobación para evitar erros
        if (p == null || this == null) {
            return false;
        }

        if (this.esHermano(p.padre) || this.esHermano(p.madre) && !this.nombre.equals(p.padre.nombre)
                && !this.nombre.equals(p.madre.nombre)) {
            return true;
        } else {
            return false;
        }
    }

    // Metodos para saber si esTioPolitico
    public boolean esTioPolitico(Persona p) {
        // Comprobación para evitar erros
        if (p == null || this == null) {
            return false;
        }

        if (this.conyuge.esTioCarnal(p)) {
            return true;
        } else {
            return false;
        }
    }

    // Metodos para saber sí esSobrinoPolitico
    public boolean esSobrinoPolitico(Persona p) {
        // Comprobación para evitar erros
        if (p == null || this == null) {
            return false;
        }

        if (this.madre.esHermano(p.conyuge) || this.padre.esHermano(p.conyuge)) {
            return true;
        } else {
            return false;
        }
    }

    // Metodo para saber si es abuelo-nieto
    public boolean esAbuelo(Persona p) {
        // Comprobación para evitar erros
        if (p == null || this == null) {
            return false;
        }

        if (p.padre.esHijo(this) || p.madre.esHijo(this)) {
            return true;
        } else {
            return false;
        }
    }
}