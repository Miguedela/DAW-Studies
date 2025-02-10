import java.util.ArrayList;

// Clase donde se desarrolla el main
public class GestionClubSocial {
    // Atributos
    private ArrayList<Persona> tPersonas;

    // Metodo constructor
    public GestionClubSocial() {
        this.tPersonas = new ArrayList<>();
    }

    // Metodo para añadir las personas a los Arrays
    public void aniadePersona(Persona p) {
        tPersonas.add(p);
    }

    // Metodo para leer las personas registradas
    public String toString() {
        String resultado = "";
        for (Persona p : tPersonas) {
            resultado += p + "\n";
        }
        return resultado;
    }

    // Metodo estatico para mostrar las familias
    private static Familia familia(Persona p) {
        Familia familiaP = new Familia();
        familiaP.setPadre(p.getPadre());
        familiaP.setMadre(p.getMadre());

        return familiaP;
    }

    // Clase main (ejecutable)
    public static void main(String[] args) {
        Varon eusebio = new Varon("Eusebio");
        Mujer clotilde = new Mujer("Clotilde");
        eusebio.casarCon(clotilde);

        Varon pancracio = new Varon("Pancracio");
        Mujer rogelia = new Mujer("Rogelia");
        pancracio.casarCon(rogelia);

        Varon pepe = new Varon("Pepe");
        pepe.setPadre(eusebio);
        pepe.setMadre(clotilde);

        Mujer juana = new Mujer("Juana");
        juana.setPadre(pancracio);
        juana.setMadre(rogelia);

        pepe.casarCon(juana);

        Mujer julia = (Mujer) rogelia.daALuz('M', "Julia");

        Varon pedrito = (Varon) juana.daALuz('V', "Pedrito");
        Varon juanito = (Varon) juana.daALuz('V', "Juanito");
        Mujer josefita = (Mujer) juana.daALuz('M', "Josefita");

        Varon manolo = new Varon("Manolo");
        manolo.casarCon(josefita);

        Varon roberto = new Varon("Roberto");
        roberto.casarCon(julia);

        Mujer angela = (Mujer) julia.daALuz('M', "Angela");
        Varon sebastian = (Varon) julia.daALuz('V', "Sebastian");

        Mujer maria = new Mujer("Maria");
        pedrito.casarCon(maria);

        // Aquí debes añadir los métodos según los requisitos del enunciado, y todo aquello que necesites,
        // por ejemplo, métodos para buscar personas, establecer relaciones, etc.......
        // También deberás añadir las pruebas necesarias para que la ejecución sea parecida a la proporcionada
        // en el enunciado.

        // Comprobación si son la misma persona
        eusebio.mismaPersona(pedrito);
        eusebio.mismaPersona(eusebio);

        System.out.println();
        /* ----------------------------------------------------------------- */

        // Comprobaciónes de hermanos
        // Comprobación de Julia Juana
        if (julia.esHermanoADe(juana) == true) {
            System.out.println("¿" + julia.toString() + " y " + juana.toString() +  "son hermanos?: Sí");
        } else {
            System.out.println("¿" + julia.toString() + " y " + juana.toString() +  "son hermanos?: No");
        }

        // Comprobación de Julia y Pedrito
        if (julia.esHermanoADe(pedrito) == true) {
            System.out.println("¿" + julia.toString() + " y " + pedrito.toString() +  "son hermanos?: Sí");
        } else {
            System.out.println("¿" + julia.toString() + " y " + pedrito.toString() +  "son hermanos?: No");
        }

        System.out.println();
        /* ----------------------------------------------------------------- */
        
        // Comprobaciónes de padres e hijos
        // Comprobación de Josefita y Pepe
        if (josefita.esHijoADe(pepe) == true) {
            System.out.println("¿" + josefita.toString() + " y " + pepe.toString() + " son hijo y padre?: Sí");
        } else {
            System.out.println("¿" + josefita.toString() + " y " + pepe.toString() + " son hijo y padre?: No");
        }
        
        // Comprobación de Josefita y Manolo
        if (josefita.esHijoADe(manolo) == true) {
            System.out.println("¿" + josefita.toString() + " y " + manolo.toString() + " son hijo y padre?: Sí");
        } else {
            System.out.println("¿" + josefita.toString() + " y " + manolo.toString() + " son hijo y padre?: No");
        }
        
        System.out.println();
        /* ----------------------------------------------------------------- */
        
        // Comprobaciónes de primos
        // Comprobación de primos de Juanito y Juantio
        if (juanito.esPrimoADe(angela) == true) {
            System.out.println("¿" + juanito.toString() + " y " + juanito.toString() + " son primos?: Sí");
        } else {
            System.out.println("¿" + juanito.toString() + " y " + juanito.toString() + " son primos?: No");
        }

        // Comprobación de primos de Juanito y Sebastian
        if (juanito.esPrimoADe(sebastian) == true) {
            System.out.println("¿" + juanito.toString() + " y " + sebastian.toString() + " son primos?: Sí");
        } else {
            System.out.println("¿" + juanito.toString() + " y " + sebastian.toString() + " son primos?: No");
        }

        System.out.println();
        /* ----------------------------------------------------------------- */

        // Comprobación de sobrino-tio carnal
        // Coprobacion de Juanito y Julia
        if (juanito.esSobrinoACarnalDe(julia) == true) {
            System.out.println("¿" + juanito.toString() + " y " + julia.toString() + " son sobrino-tio carnales?: Sí");
        } else {
            System.out.println("¿" + juanito.toString() + " y " + julia.toString() + " son sobrino-tio carnales?: No");
        }

        // Coprobacion de Juanito y Julia
        if (juanito.esSobrinoACarnalDe(roberto) == true) {
            System.out.println("¿" + juanito.toString() + " y " + roberto.toString() + " son sobrino-tio carnales?: Sí");
        } else {
            System.out.println("¿" + juanito.toString() + " y " + roberto.toString() + " son sobrino-tio carnales?: No");
        }

        System.out.println();
        /* ----------------------------------------------------------------- */
        
        // Comprobación de tio-sobrino carnal
        // Coprobacion de Juanito y Julia
        if (julia.esTioACarnalDe(josefita) == true) {
            System.out.println("¿" + julia.toString() + " y " + josefita.toString() + " son tio-sobrino carnales?: Sí");
        } else {
            System.out.println("¿" + julia.toString() + " y " + josefita.toString() + " son tio-sobrino carnales?: No");
        }
        
        // Coprobacion de Juanito y Julia
        if (josefita.esTioACarnalDe(pepe) == true) {
            System.out.println("¿" + josefita.toString() + " y " + pepe.toString() + " son tio-sobrino carnales?: Sí");
        } else {
            System.out.println("¿" + josefita.toString() + " y " + pepe.toString() + " son tio-sobrino carnales?: No");
        }

        System.out.println();
        /* ----------------------------------------------------------------- */

        // Comprobación de tio-politico
        // Coprobacion de Juanito y Julia
        if (julia.esTioAPoliticoDe(juanito) == true) {
            System.out.println("¿" + juanito.toString() + " y " + julia.toString() + " son tio-sobrino político?: Sí");
        } else {
            System.out.println("¿" + juanito.toString() + " y " + julia.toString() + " son tio-sobrino político?: No");
        }

        // Coprobacion de Juanito y Julia
        if (julia.esTioAPoliticoDe(juanito) == true) {
            System.out.println("¿" + julia.toString() + " y " + juanito.toString() + " son tio-sobrino político?: Sí");
        } else {
            System.out.println("¿" + julia.toString() + " y " + juanito.toString() + " son tio-sobrino político?: No");
        }

        System.out.println();
        /* ----------------------------------------------------------------- */

        // Comprobación de sobrino-tio político
        // Coprobacion de Juanito y Julia
        if (juanito.esSobrinoAPoliticoDe(roberto) == true) {
            System.out.println("¿" + juanito.toString() + " y " + julia.toString() + " son sobrino-tio político?: Sí");
        } else {
            System.out.println("¿" + juanito.toString() + " y " + julia.toString() + " son sobrino-tio político?: No");
        }

        // Coprobacion de Juanito y Julia
        if (juanito.esSobrinoAPoliticoDe(julia) == true) {
            System.out.println("¿" + juanito.toString() + " y " + roberto.toString() + " son sobrino-tio político?: Sí");
        } else {
            System.out.println("¿" + juanito.toString() + " y " + roberto.toString() + " son sobrino-tio político?: No");
        }

        System.out.println();
        /* ----------------------------------------------------------------- */

        // Comrobación de abuelo y nieto
        // Coprobacion de Eusebio y Pedrito
        if (eusebio.esAbueloADe(pedrito)) {
            System.out.println("¿" + eusebio.toString() + " y " + pedrito.toString() + " son abuelo y nieto?: Sí");
        } else {
            System.out.println("¿" + eusebio.toString() + " y " + pedrito.toString() + " son abuelo y nieto?: No");
        }

        // Coprobacion de Eusebio y Pepe
        if (eusebio.esAbueloADe(pepe)) {
            System.out.println("¿" + eusebio.toString() + " y " + pepe.toString() + " son abuelo y nieto?: Sí");
        } else {
            System.out.println("¿" + eusebio.toString() + " y " + pepe.toString() + " son abuelo y nieto?: No");
        }

        /* ----------------------------------------------------------------- */

        // Mostrar Familias;
        System.out.println();
        System.out.println("Familia de " + pepe.toString());
        System.out.println(familia(pepe).toString());

        System.out.println();
        System.out.println("Familia de " + juana.toString());
        System.out.println(familia(juana).toString());

        System.out.println();
        System.out.println("Familia de " + juanito.toString());
        System.out.println(familia(juanito).toString());
    }
}