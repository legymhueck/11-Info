package lehnen._06Sortieren._02String;

import java.util.Arrays;

public class StringsSortieren {
    private String[] meineNamen;

    public StringsSortieren() {
        meineNamen = new String[]{"Kemal", "Zacharias", "Melanie", "Frank", "Antje"};
        System.out.print("Unsortiert:\t");
        System.out.print(Arrays.toString(meineNamen) + " ");
        bubbleSortStrings(meineNamen);
        System.out.println();
        System.out.print("Sortiert:\t");
        System.out.println(Arrays.toString(meineNamen) + " ");
    }

    public void bubbleSortStrings(String[] pArray) {
        boolean swapped;
        for (int i = 0; i < pArray.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < pArray.length - i - 1; j++) {

                if (pArray[j].compareTo(pArray[j + 1]) > 0) {
                    String temp = pArray[j];
                    pArray[j] = pArray[j + 1];
                    pArray[j + 1] = temp;
                    swapped = true;
                }
            }
            // IF no two elements were swapped by inner loop, then break
            if (swapped == false) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new StringsSortieren();
    }
}
