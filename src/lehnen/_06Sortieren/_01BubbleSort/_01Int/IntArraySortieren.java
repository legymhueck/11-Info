package lehnen._06Sortieren._01BubbleSort._01Int;

import java.util.Arrays;

public class IntArraySortieren {
    private int[] meinZahlenArray;

    public IntArraySortieren() {
        meinZahlenArray = new int[]{20, 40, 32, 2, 19, 191, 87, 12, 15};

        System.out.print("Unsortiert:\t");
        System.out.print(Arrays.toString(meinZahlenArray) + " ");
        System.out.println();
        System.out.print("Sortiert:\t");
        bubbleSortStrings(meinZahlenArray);
        System.out.print(Arrays.toString(meinZahlenArray) + " ");
    }

    public static void main(String[] args) {
        new IntArraySortieren();
    }

    public void bubbleSortStrings(int[] pArray) {
        boolean swapped;
        for (int i = 0; i < pArray.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < pArray.length - i - 1; j++) {

                if (pArray[j] > pArray[j + 1]) {
                    int temp = pArray[j];
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
}
