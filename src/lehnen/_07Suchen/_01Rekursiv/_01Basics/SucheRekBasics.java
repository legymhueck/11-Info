package lehnen._07Suchen._01Rekursiv._01Basics;

import java.util.Arrays;

public class SucheRekBasics {
    /**
     * Mit dieser Klasse soll möglichst nur der Algorithmus im Vordergrund stehen.
     * <p>
     * Das sortierte Array ist vorgegeben.
     * <p>
     * Es werden 3 verschiedene Zahlen gesucht:
     * 1) Eine Zahl, die sich im Array befindet.
     * 2) Eine Zahl, die sich nicht im Array befindet und kleiner ist.
     * 3) Eine Zahl, die sich nicht im Array befindet und größer ist.
     */

    public SucheRekBasics() {

        int[] sortiertesArray = new int[]{2, 6, 9};

        int suchzahlInArray = 2;        // Integer zum Testen. Ergebnis der binären Suche: true.
        int suchzahlNichtInArray1 = -1; // Integer zum Testen. Ergebnis der binären Suche: false.
        int suchzahlNichtInArray2 = 10; // Integer zum Testen. Ergebnis der binären Suche: false.

        System.out.println(Arrays.toString(sortiertesArray));
        System.out.println(suchzahlInArray + "\tvorhanden? " + binSucheRek(sortiertesArray, suchzahlInArray, 0, sortiertesArray.length - 1));
        System.out.println(suchzahlNichtInArray1 + "\tvorhanden? " + binSucheRek(sortiertesArray, suchzahlNichtInArray1, 0, sortiertesArray.length - 1));
        System.out.println(suchzahlNichtInArray2 + "\tvorhanden? " + binSucheRek(sortiertesArray, suchzahlNichtInArray2, 0, sortiertesArray.length - 1));
    }

    private boolean binSucheRek(int[] pArray, int pSuchzahl, int pIndexLinks, int pIndexRechts) {

        if (pIndexLinks > pIndexRechts) {
            return false;
        }
        int indexMitte = (int) ((pIndexLinks + pIndexRechts) / 2);

        if (pArray[indexMitte] == pSuchzahl) {
            return true;
        } else if (pSuchzahl < pArray[indexMitte]) {
            return binSucheRek(pArray, pSuchzahl, pIndexLinks, indexMitte - 1);
        } else {
            return binSucheRek(pArray, pSuchzahl, indexMitte + 1, pIndexRechts);
        }

    }

    public static void main(String[] args) {
        new SucheRekBasics();
    }
}
