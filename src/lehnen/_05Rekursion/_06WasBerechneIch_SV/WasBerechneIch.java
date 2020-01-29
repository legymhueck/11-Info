package lehnen._05Rekursion._06WasBerechneIch_SV;

import java.util.Scanner;

public class WasBerechneIch {
    private int zahl1;
    private int zahl2;

    public static void main(String[] args) {
        WasBerechneIch w = new WasBerechneIch();
        System.out.print("Erste Zahl: ");
        w.zahl1 = w.eingabe();
        System.out.print("Zweite Zahl: ");
        w.zahl2 = w.eingabe();

        System.out.println("Ergebnis: " + w.wasBerechneIch(w.zahl1, w.zahl2));
    }

    public int eingabe() {
        return new Scanner(System.in).nextInt();
    }

    private int wasBerechneIch(int pZahl1, int pZahl2) {
        if (pZahl2 == 0) {
            return 1;
        } else {
            int r = wasBerechneIch(pZahl1, pZahl2 / 2);
            if (pZahl2 % 2 == 0) {
                return r * r;
            } else {
                return r * r * pZahl1;
            }
        }
    }
}