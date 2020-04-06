package lehnen._07Suchen._02Iterativ._01Basics;

import java.util.Arrays;

public class BinSucheIterativ {

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

    public BinSucheIterativ() {

        int[] sortiertesArray = new int[]{2, 6, 9};

        int suchzahlInArray = 2;        // Integer zum Testen. Ergebnis der binären Suche: true.
        int suchzahlNichtInArray1 = -1; // Integer zum Testen. Ergebnis der binären Suche: false.
        int suchzahlNichtInArray2 = 10; // Integer zum Testen. Ergebnis der binären Suche: false.

        // indexRechts ist "array-length - 1"!
        System.out.println(Arrays.toString(sortiertesArray));
        System.out.println(suchzahlInArray + "\tvorhanden? " + binSuche_iterativ(sortiertesArray, suchzahlInArray));
        System.out.println(suchzahlNichtInArray1 + "\tvorhanden? " + binSuche_iterativ(sortiertesArray, suchzahlNichtInArray1));
        System.out.println(suchzahlNichtInArray2 + "\tvorhanden? " + binSuche_iterativ(sortiertesArray, suchzahlNichtInArray2));
    }

    public boolean binSuche_iterativ(int[] pArray, int pSuchzahl) {
        int indexLinks;
        int indexMitte;
        int indexRechts;
        indexLinks = 0;
        indexRechts = pArray.length - 1; // Wichtig: der rechte Index ist die Länge des Arrays - 1 !!

        while (indexLinks <= indexRechts) {
            indexMitte = (int) ((indexRechts + indexLinks) / 2);
            if (pArray[indexMitte] == pSuchzahl) {
                return true;
            }
            if (pArray[indexMitte] < pSuchzahl) {
                indexLinks = indexMitte + 1;
            }
            if (pArray[indexMitte] > pSuchzahl) {
                indexRechts = indexMitte - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new BinSucheIterativ();
    }
}


