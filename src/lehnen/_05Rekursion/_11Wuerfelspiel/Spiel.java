package lehnen._05Rekursion._11Wuerfelspiel;

import resources._01NRW._01Datenstrukturklassen._01Linear.List;
import resources._01NRW._01Datenstrukturklassen._02Baum.BinarySearchTree;

import java.util.Scanner;

public class Spiel {
    private final Wuerfel wuerfel = new Wuerfel();
    private final List<Integer> ergebnis_liste = new List<>();
    private final BinarySearchTree<Wurfergebnis> ergebnis_baum = new BinarySearchTree<>();

    private int anzahl_abfragen() {
        System.out.print("Wie oft soll gewürfelt werden? ");
        return new Scanner(System.in).nextInt();
    }

    // Diese Methode darf nur einmal aufgerufen werden, weil nur 1x toFirst() aufgerufen werden darf!
    // Sie ist damit Startmethode für get_max_from_list_rek().
    private int get_max_from_list() {
        ergebnis_liste.toFirst();
        return get_max_from_list_rek();
    }

    private int get_max_from_list_rek() {
        if (!ergebnis_liste.hasAccess()) { // Dies geschieht am Ende der Liste, da sie dann hasAccess == false ist.
            return 0;  // wird 0 zurückgegeben. Diese 0 wird mit den anderen Elementen in der Liste verglichen.
        } else {
            int value = ergebnis_liste.getContent();
            ergebnis_liste.next();
            int max = get_max_from_list_rek();

            return Math.max(max, value);
        }
    }

    private int get_sum_from_baum_rek(BinarySearchTree<Wurfergebnis> pBaum) {
        if (pBaum.isEmpty()) {
            return 0;
        } else {
            int value = pBaum.getContent().getErgebnis();
            int lSum = get_sum_from_baum_rek(pBaum.getLeftTree());
            int rSum = get_sum_from_baum_rek(pBaum.getRightTree());

            System.out.println("L=" + lSum + " W=" + value + " R=" + rSum);
            return lSum + value + rSum;
        }
    }

    private int get_sum_from_baum() {
        if (ergebnis_baum.isEmpty()) {
            return 0;
        } else {
            return get_sum_from_baum_rek(ergebnis_baum);
        }
    }

    private int get_min_from_baum_rek(BinarySearchTree<Wurfergebnis> pBaum) {
        if ((pBaum.getLeftTree() == null) || pBaum.getLeftTree().isEmpty()) {
            return pBaum.getContent().getErgebnis();
        } else {
            return get_min_from_baum_rek(pBaum.getLeftTree());
        }
    }

    private int get_min_from_baum() {
        if (ergebnis_baum.isEmpty()) {
            return 0;
        } else {
            return get_min_from_baum_rek(ergebnis_baum);
        }
    }

    public void wuerfeln(int anzahl) {
        int wurf = wuerfel.wuerfeln();
        System.out.println(wurf);
        ergebnis_liste.append(wurf);
        ergebnis_baum.insert(new Wurfergebnis(wurf));

        if (anzahl > 1) {
            wuerfeln(anzahl - 1);
        }
    }

    public void start() {
        int anzahl = anzahl_abfragen();
        wuerfeln(anzahl);

        System.out.println("Max = " + get_max_from_list());
        System.out.println("Min = " + get_min_from_baum());
        System.out.println("Summe = " + get_sum_from_baum());
        System.out.println(get_min_from_baum_rek(ergebnis_baum));
        System.out.println(get_sum_from_baum_rek(ergebnis_baum));

    }

    public static void main(String[] args) {
        new Spiel().start();
    }
}
