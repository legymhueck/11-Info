/**
 * Diese Klasse sucht rekursiv nach einer Zahl in
 *  - einem Array, dessen Größe selbst festgelegt wird.
 *  - Zudem werden min und max vorkommender Integerwerte festgelegt.
 *
 */
package lehnen._07Suchen._01RekursiveSuche;

import java.util.Arrays;
import java.util.Scanner;

public class SucheRekursiv {
    private int[] testArray;

    public SucheRekursiv() {
        System.out.println("Es wird ein benutzerdefiniertes Array erzeugt.\nDer Benutzer legt Größe und Zahlenraum (min - max) fest.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWie viele Indizes soll das Array haben?: ");
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

        // search for numberToFind
        // the following shorthand for an if statement means:
        //   if the number you're looking for in the array is smaller than the maximum number in the sorted array
        //       evaluate the binary search
        //   otherwise
        //       return false
        boolean suchzahlVorhanden = numberToFind < maxNumberInArray ? binaereSucheRek(testArray, numberToFind, 0, testArray.length) : false;
        System.out.println("\nSuchzahl " + numberToFind + " vorhanden?: " + suchzahlVorhanden);
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

    public boolean binaereSucheRek(int[] pA, int pI, int pLinks, int pRechts) {
        if (pLinks <= pRechts) {        // Abbruchbedingung: der Start des Suchbereichs ist größer als das Ende
            int mitte = (int) ((pLinks + pRechts) / 2);
            if (pA[mitte] == pI) {              // mitte gibt einen Index zurück, nicht den Wert mit dem verglichen wird
                return true;
            } else {
                if (pA[mitte] < pI) {           // s.o.: mitte gibt einen Index zurück, nicht den Wert mit dem verglichen wird
                    pLinks = mitte + 1;
                    return binaereSucheRek(pA, pI, pLinks, pRechts);    // gib das Ergebnis der Suche im rechten Teil als Ergebnis zurück
                } else //if (pA[mitte] > pI) {    // s.o. mitte gibt einen Index zurück, nicht den Wert mit dem verglichen wird + hier reicht nur ein else ohne else if, weil es keinen anderen Fall gibt
                    pRechts = mitte - 1;
                return binaereSucheRek(pA, pI, pLinks, pRechts);        // gib das Ergebnis der Suche im linken Teil als Ergebnis zurück
            }
            // hier kommt man nie hin! Entweder wird return im if-Fall oder im else-Fall aufgerufen
        } else {
            return false;
        }
    }
}
