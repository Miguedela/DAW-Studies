package Corregido;

// Interfaz con los metodos necesarios
interface SonidoDeClaxon {
  public String[] generaSonidosMelodia();

  public void suenaMelodia(String[] melodia);

  public static int getCuentaSonidos() {
    return 0;
  }
}

enum ClaxonMusical {
  pi,
  pii,
  ri,
  rii,
  ti,
  tii,
}

enum Sonido {
  grave,
  agudo,
  melodia,
}

// Clase de Mediod de transporte
public abstract class MedioDeTransporteCorregido implements SonidoDeClaxon {

  // Atributos
  protected int sonidos = 0;
  private final int anyoFabricacion;
  protected Sonido tipoClaxon;
  protected static int cuentaSonidos = 0;

  // Metodo constructor
  public MedioDeTransporteCorregido(int anyoFabricacion) {
    this.anyoFabricacion = anyoFabricacion;
  }

  /*
   * solo para los veh�culos con tipo de claxon musical que crea en la
   * f�brica de veh�culos (Al fabricarse) una melod�a entre 3 y 6 sonidos
   * comenzando y terminando siempre por ?pii?.
   */
  @Override
  public String[] generaSonidosMelodia() {
    int onomatopeya = (int) (Math.random() * 3 + 3);
    // System.out.println(onomatopeya);
    String[] arraySonidos = new String[onomatopeya + 2];
    // sonidos[0]="pii";
    arraySonidos[0] = ClaxonMusical.pii.toString();

    // sonidos[onomatopeya+2-1] = "pii";
    arraySonidos[onomatopeya + 2 - 1] = ClaxonMusical.pii.toString();
    for (int i = 1; i < onomatopeya + 2 - 1; i++) {
      int sonidoAGuardar = (int) (Math.random() * 6);
      switch (sonidoAGuardar) {
        case 0:
          arraySonidos[i] = ClaxonMusical.pi.toString();
          break;
        case 1:
          arraySonidos[i] = ClaxonMusical.pii.toString();
          break;
        case 2:
          arraySonidos[i] = ClaxonMusical.ri.toString();
          break;
        case 3:
          arraySonidos[i] = ClaxonMusical.rii.toString();
          break;
        case 4:
          arraySonidos[i] = ClaxonMusical.ti.toString();
          break;
        case 5:
          arraySonidos[i] = ClaxonMusical.tii.toString();
          break;
      }
    }
    this.suenaMelodia(arraySonidos);
    this.sonidos = arraySonidos.length;
    cuentaSonidos += arraySonidos.length;
    return arraySonidos;
  }

  @Override
  public void suenaMelodia(String[] melodia) {
    for (String melodia1 : melodia) {
      System.out.print(melodia1 + ",");
    }
  }

  public static int getCuentaSonidos() {
    return cuentaSonidos;
  }

  @Override
  public String toString() {
    return ("MedioDeTransporte{" +
        "anyoFabricacion=" +
        anyoFabricacion +
        ", sonidos=" +
        this.sonidos +
        '}');
  }
}

// Subclase de coche
class Coche extends MedioDeTransporteCorregido {

  // Metodo constructor heredado
  public Coche(int anyoFabricacion) {
    super(anyoFabricacion);
    super.tipoClaxon = Sonido.melodia;
  }

  @Override
  public String[] generaSonidosMelodia() {
    return super.generaSonidosMelodia();
  }

  @Override
  public String toString() {
    return super.toString() + "Coche{" + "tipoClaxon=" + this.tipoClaxon + '}';
  }
}

// Subclase de camion
class Camion extends MedioDeTransporteCorregido {

  private String claxon;

  // Metodo constructor heredado
  public Camion(int anyoFabricacion, String claxon) {
    super(anyoFabricacion);
    this.claxon = claxon;
    sonidos = 1;
    cuentaSonidos++; // Solo tiene 1 sonido (grave o agudo)
  }

  public String getClaxon() {
    return claxon;
  }

  @Override
  public String toString() {
    return super.toString() + "Camion{" + "claxon=" + claxon + '}';
  }
}
