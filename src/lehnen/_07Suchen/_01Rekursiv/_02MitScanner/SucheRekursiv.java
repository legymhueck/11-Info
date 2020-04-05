/**
 * Diese Klasse sucht rekursiv nach einer Zahl in. Dabei
 *  - kann die Array-Größe selbst festgelegt werden kann.
 *  - können Min und Max vorkommender Integerwerte selbst bestimmt werden.
 *  - kann die Suchzahl selbst bestimmt werden.
 *
 *  Am Ende des Codes findet sich eine alternative Implementation der binären rekursiven Suche von Marius Böhm.
 *
 */
package lehnen._07Suchen._01Rekursiv._02MitScanner;

import java.util.Arrays;
import java.util.Scanner;

public class SucheRekursiv {
    private int[] testArray;

    public SucheRekursiv() {
        System.out.println("Es wird ein benutzerdefiniertes Array erzeugt.\nDer Benutzer legt Größe und Zahlenraum (min - max) fest.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWie viele Indexe soll das Array haben?: ");
        int arraySize = scanner.nextInt();

        System.out.print("\nWie groß soll der Zahlenraum sein?: ");
        System.out.print("\nMinimum:\t");
        int minNumberInArray = scanner.nextInt();
        System.out.print("Maximum:\t");
        int maxNumberInArray = scanner.nextInt();

        System.out.print("\nNach welcher Zahl soll gesucht werden? ");
        int numberToFind = scanner.nextInt();
        scanner.close();

        testArray = new int[arraySize]; // create an empty test Array
        testArray = arrayFuellen(testArray, minNumberInArray, maxNumberInArray); // fill the Array with random numbers without doubles

        System.out.print("\nUnsortiertes Array:\n" + Arrays.toString(testArray));  // print the unsorted array
        bubbleSort(testArray);                                                     // sort the array
        System.out.println("\n\nSortiertesArray:\n" + Arrays.toString(testArray)); // print the sorted array

        boolean suchzahlVorhanden = binaereSucheRek_LE(testArray, numberToFind, 0, testArray.length - 1);
        System.out.println("\nSuchzahl " + numberToFind + " vorhanden?: " + suchzahlVorhanden);

        /* Folgenden Code auskommentieren, um die alternative Implementation zu testen. */
        //boolean suchzahlVorhanden2 = binaereSucheRek_MarBoe(testArray, numberToFind, 0, testArray.length - 1);
        //System.out.println("\nSuchzahl " + numberToFind + " vorhanden?: " + suchzahlVorhanden2);
    }

    public static void main(String[] args) {
        new SucheRekursiv();
    }

    private int[] arrayFuellen(int[] pArray, int pMinNumber, int pMaxNumber) {
        for (int i = 0; i < pArray.length; i++) {
            pArray[i] = (int) (Math.random() * ((pMaxNumber - pMinNumber) + 1) + pMinNumber);
            for (int j = 0; j < i; j++) {

                if (pArray[i] == pArray[j]) {
                    i--;
                    break;
                }
            }
        }
        return pArray;
    }

    private void bubbleSort(int[] pArray) {
        boolean b_sorted = false;
        while (!b_sorted) {
            b_sorted = true;
            for (int i = 0; i < pArray.length - 1; i++) {
                if (pArray[i] > pArray[i + 1]) {

                    int temp = pArray[i];
                    pArray[i] = pArray[i + 1];
                    pArray[i + 1] = temp;
                    b_sorted = false;
                }
            }
        }
    }

    public boolean binaereSucheRek_LE(int[] pArray, int pSuchzahl, int pLinks, int pRechts) {
        if (pLinks > pRechts) {
            return false;
        }
        int mitte = (int) ((pRechts + pLinks) / 2);
        if (pArray[mitte] == pSuchzahl) {
            return true;
        } else if (pSuchzahl < pArray[mitte]) {
            return binaereSucheRek_LE(pArray, pSuchzahl, pLinks, mitte -1);
        } else {
            return binaereSucheRek_LE((pArray), pSuchzahl, mitte + 1, pRechts);
        }
    }

    public boolean binaereSucheRek_MarBoe(int[] pArray, int pSuchzahl, int pLinks, int pRechts) {
        if (pLinks <= pRechts) {
            int mitte = (int) ((pLinks + pRechts) / 2);
            if (pArray[mitte] == pSuchzahl) {
                return true;
            } else {
                if (pArray[mitte] < pSuchzahl) {
                    pLinks = mitte + 1;
                    return binaereSucheRek_MarBoe(pArray, pSuchzahl, pLinks, pRechts);
                } else
                    pRechts = mitte - 1;
                return binaereSucheRek_MarBoe(pArray, pSuchzahl, pLinks, pRechts);
            }
        } else {
            return false;
        }
    }
}
