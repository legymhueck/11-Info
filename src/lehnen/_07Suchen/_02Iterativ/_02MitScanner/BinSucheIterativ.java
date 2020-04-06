package lehnen._07Suchen._02Iterativ._02MitScanner;

import java.util.Arrays;
import java.util.Scanner;

public class BinSucheIterativ {
    private int[] testArray;

    public BinSucheIterativ() {
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
        testArray = arrayFuellen(testArray, minNumberInArray, maxNumberInArray); // fill the array with random numbers without doubles

        System.out.print("\nUnsortiertes Array:\n" + Arrays.toString(testArray));  // print the unsorted array
        bubbleSort(testArray);                                                     // sort the array
        System.out.println("\n\nSortiertesArray:\n" + Arrays.toString(testArray)); // print the sorted array

        boolean suchzahlVorhanden = binaereSuche_iterativ(testArray, numberToFind);
        System.out.println("\nSuchzahl " + numberToFind + " vorhanden?: " + suchzahlVorhanden);
    }

    public boolean binaereSuche_iterativ(int[] pArray, int pSuchzahl) {
        int indexLinks;
        int indexMitte;
        int indexRechts;
        indexLinks = 0;
        indexRechts = pArray.length;

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

    public static void main(String[] args) {
        new BinSucheIterativ();
    }
}
