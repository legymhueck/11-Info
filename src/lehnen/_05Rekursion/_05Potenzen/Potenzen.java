package lehnen._05Rekursion._05Potenzen;

import java.util.Scanner;

public class Potenzen {

    public static void main(String[] args) {
        Potenzen p = new Potenzen();
        System.out.print("Geben Sie die Basis ein: ");
        int basis = p.zahlEinlesen();
        System.out.print("Geben Sie den Exponent ein: ");
        int exponent = p.zahlEinlesen();
        System.out.println(p.potenzRekursiv(basis, exponent));
    }

    public int zahlEinlesen() {
        return new Scanner(System.in).nextInt();
    }

    public long potenzRekursiv(int pBasis, int pExponent) {
        if (pExponent == 0) {
            return 1;
        } else {
            return pBasis * (potenzRekursiv(pBasis, pExponent - 1));
        }
    }
}
