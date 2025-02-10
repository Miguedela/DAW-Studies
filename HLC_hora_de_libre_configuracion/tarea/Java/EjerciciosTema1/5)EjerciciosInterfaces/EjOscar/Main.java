import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();
        ArrayList<Alimento> almacen = new ArrayList();
        ArrayList<Liquidos> detergentes = new ArrayList();

        Vino vino1 = new Vino("Marca1","tinto",12.0,8.0,5.0,700,"Cristal", fecha );
        Vino vino2 = new Vino("Marca2","rosado",6.0,5.3,5.0,330,"Botella de Cristal", fecha );

        Cereales cereal1 = new Cereales("Oatmeal",3.0, TipoCereal.avena,fecha);
        Cereales cereal2 = new Cereales("Fitness fiber",2.25,TipoCereal.trigo,fecha);

        Detergente detergente1 =  new Detergente("Agerul",6.0,5000,"Botella plastico grande",20.0);
        Detergente detergente2 = new Detergente("Dixan", 4.0,2500,"Botella de plastico mediana",10.0);
        Detergente detergente3 = new Detergente("Norit",1.25,500,"Botella de plastico pequeña",2.0);

        almacen.add(vino1);
        almacen.add(vino2);
        almacen.add(cereal1);
        almacen.add(cereal2);

        detergentes.add(detergente1);
        detergentes.add(detergente2);
        detergentes.add(detergente3);


        System.out.println("Lista de alimentos:");
        for (Alimento alimento : almacen) {
            System.out.println(alimento.toString());
        }

        System.out.println();
        System.out.println("Lista de liquidos:");
        for (Liquidos liquido : detergentes) {
            System.out.println(liquido.toString());
        }

        System.out.println();
        System.out.println("Total de calorias: " + calculaCalorias(almacen));

        System.out.println();
        System.out.println("Importe Total: " + calculaImportetotal(almacen,detergentes)+"€") ;

        System.out.println();
        System.out.println("Total de descuentos: " + totalDescuentos(detergentes)+"%");
        System.out.println("Dinero ahorrado: " + calculaAhorro(detergentes)+"€");
    }
    public static int calculaCalorias(ArrayList<Alimento> alm){
        int calorias = 0;
        for (int i = 0; i < alm.size(); i++) {
            Alimento temp = alm.get(i);
            if (temp instanceof Vino) {
                Vino vino = (Vino) temp;
                calorias += vino.getCalorias();
            } else if (temp instanceof Cereales) {
                Cereales cereal = (Cereales) temp;
                calorias += cereal.getCalorias();
            }
        }
        return calorias;
    }
    public static double calculaImportetotal (ArrayList<Alimento> alm, ArrayList<Liquidos> liq ){
        double importeTotal = 0;
        for (int i = 0; i < alm.size(); i++) {
            Alimento temp = alm.get(i);
            if (temp instanceof Vino) {
                Vino vino = (Vino) temp;
                importeTotal += vino.getPrecioDescuento();
            }else if (temp instanceof Cereales) {
                Cereales cereal = (Cereales) temp;
                importeTotal += cereal.getPrecio();
            }
        }

        for (Liquidos liquido : liq) {
            Liquidos liquidoTemp = liquido;
            if(liquidoTemp instanceof Detergente){
                Detergente detergente = (Detergente) liquidoTemp;
                importeTotal += detergente.getPrecioDescuento();
            }
        }
        return importeTotal;
    }

    public static int totalDescuentos ( ArrayList<Liquidos> liq ){
        int descuentoTotal = 0;

        for (Liquidos liquido : liq) {
            Liquidos liquidoTemp = liquido;
            if(liquidoTemp instanceof Detergente){
                Detergente detergente = (Detergente) liquidoTemp;
                descuentoTotal += detergente.getDescuento();
            }
        }
        return descuentoTotal;
    }

    public static double calculaAhorro (ArrayList<Liquidos> liq ){
        double importeTotal = 0;
        for (Liquidos liquido : liq) {

            if(liquido instanceof Detergente){
                Detergente detergente = (Detergente) liquido;
                importeTotal += (detergente.getPrecio()-detergente.getPrecioDescuento());
            }
        }
        return importeTotal;
    }
}
