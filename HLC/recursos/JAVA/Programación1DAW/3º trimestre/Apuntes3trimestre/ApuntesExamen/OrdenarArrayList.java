package ApuntesExamen;

import java.util.ArrayList;

public class OrdenarArrayList {
    public void ordenarEstudiantesAscendente(ArrayList<String> arrayList) {
        for (int x = 0; x < arrayList.size(); x++) {
            for (int y = 0; y < arrayList.size(); y++) {
                String x1 = (String) arrayList.get(x);
                String x2 = (String) arrayList.get(y);
                String aux;
                if (x1.compareTo(x2) > 0) {
                    aux = (String) arrayList.get(x);
                    arrayList.set(x, arrayList.get(y));
                    arrayList.set(y, aux);
                }
            }
        }
    }
    
    public void ordenarEstudiantesDescendente(ArrayList<String> arrayList) {
        for (int x = 0; x < arrayList.size(); x++) {
            for (int y = 0; y < arrayList.size(); y++) {
                String x1 = (String) arrayList.get(x);
                String x2 = (String) arrayList.get(y);
                String aux;
                if (x1.compareTo(x2) > 0) {
                    aux = (String) arrayList.get(x);
                    arrayList.set(x, arrayList.get(y));
                    arrayList.set(y, aux);
                }
            }
        }
    }
}

