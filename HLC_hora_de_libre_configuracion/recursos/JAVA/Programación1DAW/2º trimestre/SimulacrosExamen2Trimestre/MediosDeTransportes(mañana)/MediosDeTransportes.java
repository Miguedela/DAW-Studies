import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Interfaz con los los metodos para los claxon
interface SonidoDeClaxon {
  public String[] generaSonidosMelodia();

  public void suenaMelodia(String[] melodia);

  public static int getCuentaSonidos() {
    return 0;
  }
}

// Clase enum de los sonidos que tiene una melodia
enum ClaxonMelodia {
  pi,
  pii,
  ri,
  rii,
  ti,
  tii,
}

// Clase de medios de transporte
class MedioDeTransporte {

  // Atributos
  protected int añoFabricacion;
  protected String sonido;

  // Metodo constructor
  public MedioDeTransporte(int añoFabricacion, String sonido) {
    this.añoFabricacion = añoFabricacion;
    this.sonido = sonido;
  }

  // Getters
  public int getAñoFabricacion() {
    return añoFabricacion;
  }

  public String getSonido() {
    return sonido;
  }
}

// Subclase de coches
class Coche extends MedioDeTransporte {

  // Atributos
  private String[] melodia;

  // Metodo constructor heredado del padre (super)
  public Coche(int añoFabricacion, String[] melodia) {
    super(añoFabricacion, "melodia");
    this.melodia = melodia;
  }

  public String[] getMelodia() {
    return melodia;
  }
}

// Subclase de camion
class Camion extends MedioDeTransporte {

  // Creacion de objetos
  Scanner s = new Scanner(System.in);

  // Metodo constructor heredado del padre (super)
  public Camion(int añoFabricacion) {
    super(añoFabricacion, "");
    System.out.println(
        "¿Qué tipo de claxon quiere para el camión? (1 agudo / 2 grave)");
    int tipoClaxon = s.nextInt();
    while (tipoClaxon != 1 && tipoClaxon != 2) {
      System.out.println(" Sonido no válido");
      tipoClaxon = s.nextInt();
    }

    if (tipoClaxon == 1) {
      this.sonido = "agudo";
    } else {
      this.sonido = "grave";
    }
  }
}

// Clase Concesionario donde se realiza el programa
class Concesionario implements SonidoDeClaxon {

  // Creacion de objetos
  Scanner s = new Scanner(System.in);
  Random r = new Random();

  // Atributos
  private String nombre;
  private Coche[] coches;
  private Camion[] camiones;
  private int opc;
  private static int cuentaSonidos;
  private ArrayList<String> melodiasCopiadas;

  public Concesionario(String nombre) {
    this.nombre = nombre;
    coches = new Coche[6];
    camiones = new Camion[6];
    cuentaSonidos = 0;
    melodiasCopiadas = new ArrayList<>();
  }

  // Metodo del menú
  public void menu() {
    do {
      System.out.println(
          "Bienvenido al gestor de sonidos en medios de transporte. A continuación puede elegir qué acción desea.");
      System.out.println();
      System.out.println();
      System.out.println("1.Fabrica coche");
      System.out.println("2.Fabrica camión");
      System.out.println("3.Cuenta sonidos");
      System.out.println("4.Muestra medios de transporte");
      System.out.println("5.Copiar la melodia");
      System.out.println("6.Salir");
      opc = s.nextInt();

      if (opc == 1) {
        fabricarCoche();
      } else if (opc == 2) {
        fabricarCamion();
      } else if (opc == 3) {
        System.out.println(
            "El número de sonidos existentes es de: " + getCuentaSonidos());
      } else if (opc == 4) {
        mostrarMediosDeTransporte();
      } else if (opc == 5) {
        copiarMelodia();
      } else {
        while (opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5 && opc != 6) {
          System.out.println(
              "Opción no válida, por favor introduzcala nuevamente.");
          opc = s.nextInt();
        }
      }
    } while (opc != 6);
  }

  // Metodo que me fabrica el coche
  public void fabricarCoche() {
    if (coches[5] != null) {
      System.out.println(
          "No se pueden añadir más coches, no hay más capacidad de almacenaje en el concesionario " +
              nombre);
    } else {
      System.out.print("Introduce el año de fabricación: ");
      int anoFabricacion = s.nextInt();

      for (int i = 0; i < coches.length; i++) {
        if (coches[i] == null) {
          String[] melodia = generaSonidosMelodia();
          suenaMelodia(melodia);

          Coche coche = new Coche(anoFabricacion, melodia);
          coches[i] = coche;
          System.out.println(
              "Coche agragado con éxito a la posición " + (i + 1));
          break;
        }
      }
    }
  }

  // Metodo que fabrica el camión
  public void fabricarCamion() {
    if (camiones[5] != null) {
      System.out.println(
          "No se pueden añadir más camiones, no hay más capacidad de almacenaje en el concesionario " +
              nombre);
    } else {
      System.out.print("Introduce el año de fabricación: ");
      int anoFabricacion = s.nextInt();
      Camion camion = new Camion(anoFabricacion);

      for (int i = 0; i < camiones.length; i++) {
        if (camiones[i] == null) {
          camiones[i] = camion;
          if (camion.getSonido().equalsIgnoreCase("agudo")) {
            System.out.println("fiiiiiii");
          } else {
            System.out.println("brrrroonn");
          }
          cuentaSonidos++;
          System.out.println(
              "Camión agragado con éxito a la posición " + (i + 1));
          break;
        }
      }
    }
  }

  // Metodo que crea el sonido que hara cada coche
  @Override
  public String[] generaSonidosMelodia() {
    String[] claxon = new String[r.nextInt(3, 6)]; // Creo un array de String del mismo tamaño que pitidos hay (un
    // sonido para cada posicion)

    ClaxonMelodia[] valores = ClaxonMelodia.values(); // Variable de mi clase enum 'claxonMelodia' para obtener los
    // valores

    // Bucle for-i que recorre el array de String para asignar un sonido a cada
    // posicion
    for (int i = 0; i < claxon.length; i++) {
      claxon[i] = valores[r.nextInt(valores.length)].name(); // Igualo el objeto sonido a una opciona aleatoria
      // del enum 'claxonMelodia'
    }
    claxon[0] = valores[1].name(); // Igualo la primera posicion de claxcon(pitido) a "pii"
    claxon[claxon.length - 1] = valores[1].name(); // Igualo la ultima posicion de claxcon(pitido) a "pii"
    cuentaSonidos += claxon.length; // Agrego el numero de pitidos al atributo statico

    return claxon;
  }

  // Metodo que muestra por pantalla el sonido generada (solo de melodia)
  @Override
  public void suenaMelodia(String[] melodia) {
    for (String pitido : melodia) {
      System.out.print(pitido + " ");
    }
    System.out.println();
  }

  public static int getCuentaSonidos() {
    return cuentaSonidos;
  }

  // Metodo que muestra todos los medios de transporte
  public void mostrarMediosDeTransporte() {
    if (coches[0] == null) {
      System.out.println("No hay coches en el concesionario");
    } else {
      System.out.println("-------Coches-------");
      for (int i = 0; i < coches.length; i++) {
        if (coches[i] == null) {
          break;
        }
        System.out.println(
            "El coche de la posicion " +
                (i + 1) +
                " es del año " +
                coches[i].getAñoFabricacion() +
                " y su claxon es " +
                coches[i].getSonido());
      }
    }

    if (camiones[0] == null) {
      System.out.println("No hay camiones en el concesionario");
    } else {
      System.out.println("-------Camiones-------");
      for (int i = 0; i < camiones.length; i++) {
        if (camiones[i] == null) {
          break;
        }
        System.out.println(
            "El camion de la posicion " +
                (i + 1) +
                " es del año " +
                camiones[i].getAñoFabricacion() +
                " y su claxon es " +
                camiones[i].getSonido());
      }
    }
  }

  // Metodo que copia las melodias de los coches indicado en un array list
  public void copiarMelodia() {
    System.out.print("De que coche quiere coger la melodía: ");
    int melodiaPosicion = s.nextInt();
    melodiaPosicion -= 1;

    for (int i = 0; i < coches[melodiaPosicion].getMelodia().length; i++) {
      melodiasCopiadas.add(coches[melodiaPosicion].getMelodia()[i]);
    }

    System.out.println("Melodia copiada hasta el momento");
    System.out.println(melodiasCopiadas);
  }
}
