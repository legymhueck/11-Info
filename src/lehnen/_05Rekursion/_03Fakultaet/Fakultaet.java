package lehnen._05Rekursion._03Fakultaet;

import java.util.Scanner;

/**
 * Unter Fakultät versteht man das Produkt aller natürlichen Zahlen kleiner UND gleich dieser Zahl,
 * also von 1 bis n.
 * Ausgenommen ist die Zahl 0! Da das leere Produkt stets 1 ist, gilt: 0! = 1.
 *
 * Abkürzung: ! (ein Ausrufezeichen nach der Zahl, von der die Fakultät berechnet werden soll).
 *
 * Beispiele:
 * 0!  = 1              = 1
 * 1!  = 1              = 1
 * 2!  = 1 * 2          = 2
 * 3!  = 1 * 2 * 3      = 6
 * 4!  = 1 * 2 * 3 * 4  = 24
 *
 * Hier sieht man, dass z. B.
 *    4! gleich 4 * 3! ist.
 *    3! gleich 3 * 2! ist.
 *    2! gleich 2 * 1! ist.
 *    1! gleich 1 * 0! ist.
 *
 *    Somit lässt sich einfach der rekursive Aufruf definieren:
 *    -> Die Zahl selbst multipliziert mit der Fakultät der vorangehenden Zahl!
 */
public class Fakultaet {
    private int zahl;

    public static void main(String[] args) {
        Fakultaet f = new Fakultaet();
        f.zahl = f.eingabeZahl();
        System.out.println("Die Fakultät von " + f.zahl + " ist " + f.fakultaetRekursiv(f.zahl));
    }

    public long fakultaetRekursiv(int pZahl) {
        if (pZahl == 0) {
            return 1;
        } else {
            return pZahl * fakultaetRekursiv(pZahl - 1);
        }
    }

    public int eingabeZahl() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine Zahl ein: ");
        zahl = scanner.nextInt();
        scanner.close();
        return zahl;
    }
}
