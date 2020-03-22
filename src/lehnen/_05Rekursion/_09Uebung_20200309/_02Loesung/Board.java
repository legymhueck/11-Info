package lehnen._05Rekursion._09Uebung_20200309._02Loesung;

public class Board {
    Cell[] row;

    public Board() {
        row = new Cell[9];
        init();
    }

    private void init() {
        for (int i = 0; i < row.length; i++) {
            row[i] = new Cell();     // 0 = empty, no valid value set
        }
    }


    public boolean solve_recursive(int pRowIndex) {

        if (pRowIndex == row.length) { // Base Case
            return true;
        } else {

            if (row[pRowIndex].getValue() == 0) {

                for (int i = 1; i <= 9; i++) {

                    if (!valueVorhanden(i, row)) {
                        row[pRowIndex].setValue(i, false);

                        if (solve_recursive(pRowIndex + 1)) // wenn sich der Rest noch lösen lässt
                            return true;
                    }
                }

                row[pRowIndex].setValue(0, false); // falls es keine Lösung gibt
                return false;
            } else {

                return solve_recursive(pRowIndex + 1);
            }
        }
    }

    public boolean solve_recursive2(int pRowIndex) {

        if (pRowIndex == row.length) {
            return true;
        } else {

            if (row[pRowIndex].getValue() == 0) {

                for (int i = 1; i <= 9; i++) {

                    if (!setzeValueFallsNichtVorhanden(i, row, pRowIndex) && solve_recursive(pRowIndex + 1)) {
                        return true;
                    }
                }

                row[pRowIndex].setValue(0, false); // falls es keine Lösung gibt
                return false;
            } else {

                return solve_recursive(pRowIndex + 1);
            }
        }
    }

    private boolean setzeValueFallsNichtVorhanden(int pZahl, Cell[] pRow, int pRowIndex) {
        if (!valueVorhanden(pZahl, pRow)) {
            row[pRowIndex].setValue(pZahl, false);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Es gibt Felder, die vorgegebene Zahlen enthalten.
     * Es gibt Felder, die eine 0 enthalten.
     * Alle 0-Felder werden mit den fehlenden Zahlen von 1 - 9 aufegfüllt.
     */
    public void solve_iterative() {
        for (int i = 0; i < row.length; i++) {  // für Indizes
            if (row[i].getValue() == 0) {
                int value = 1;

                for (int j = 0; j < row.length; j++) { // für values

                    if (valueVorhanden(value, row)) {
                        value++;
                    } else {
                        row[i].setValue(value, false);
                    }
                }
            }
        }
    }

    public void displayPermulations(MainView pMainView) {
        for (int f1 = 1; f1 <= 9; f1++) { // Durchlauf
            row[0].setValue(f1, false);
            pMainView.updateCell(0, f1);
            for (int f2 = 1; f2 <= 9; f2++) { // Index
                row[1].setValue(f2, false);
                pMainView.updateCell(1, f2);
                for (int f3 = 1; f3 <= 9; f3++) { // Index
                    row[2].setValue(f3, false);
                    pMainView.updateCell(2, f3);
                    for (int f4 = 1; f4 <= 9; f4++) { // Durchlauf
                        row[3].setValue(f4, false);
                        pMainView.updateCell(3, f4);
                        for (int f5 = 1; f5 <= 9; f5++) { // Index
                            row[4].setValue(f5, false);
                            pMainView.updateCell(4, f5);
                            for (int f6 = 1; f6 <= 9; f6++) { // Index
                                row[5].setValue(f6, false);
                                pMainView.updateCell(5, f6);
                                for (int f7 = 1; f7 <= 9; f7++) { // Durchlauf
                                    row[6].setValue(f7, false);
                                    pMainView.updateCell(6, f7);
                                    for (int f8 = 1; f8 <= 9; f8++) { // Index
                                        row[7].setValue(f8, false);
                                        pMainView.updateCell(7, f8);
                                        for (int f9 = 1; f9 <= 9; f9++) { // Index
                                            row[8].setValue(f9, false);
                                            pMainView.updateCell(8, f9);

                                            System.out.println(f1 + " " + f2 + " " + f3 + " " + f4 + " " + f5 + " " + f6 + " " + f7 + " " + f8 + " " + f9);
                                            //pMainView.updateView();
                                            /*try {
                                                Thread.sleep(100);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            } catch (Exception e) {
                                                e.printStackTrace();

                                            }*/
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    private boolean valueVorhanden(int pZahl, Cell[] pArray) {
        boolean doppelteVorhanden = false;
        for (int i = 0; i < pArray.length; i++) {
            if (pZahl == pArray[i].getValue()) {
                doppelteVorhanden = true;
                break;
            }
        }
        return doppelteVorhanden;
    }


    public void sort() {

        boolean swapped;
        for (int i = 0; i < row.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < row.length - i - 1; j++) {
                if (row[j].getValue() > row[j + 1].getValue()) {
                    Cell temp = row[j];
                    row[j] = row[j + 1];
                    row[j + 1] = temp;
                    swapped = true;
                }
            }
            // IF no two elements were swapped by inner loop, then break
            if (swapped == false) {
                break;
            }
        }
    }


    public void random_fill(int pCount) {
        clear();
        for (int i = 0; i < pCount && i < row.length; i++) {
            int pos = (int) (Math.random() * 9);       // Zufallszahl zwischen 0 und 9 (exclusive) erzeugen --> Array Index
            int rand = (int) (Math.random() * 9 + 1);   // Zufallszahl zwischen 1 und 9 (inklusive) erzeugen --> Value

            if (row[pos].getValue() == 0) {
                row[pos].setValue(rand, true);

                if (!check()) {
                    row[pos].setValue(0, false);    // value not valid --> reset and try again in next iteration
                    i--; // try again!
                }
            } else {
                i--;    // position is already set to a value, try again
            }

        }
    }

    public void clear() {
        for (int i = 0; i < row.length; i++) {
            row[i].setValue(0, false);
        }
    }

    private boolean check() {
        boolean bOK = true;     // everything ok at the beginning
        boolean[] bArr = new boolean[10];  // check for double values

        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = false;
        }

        for (int i = 0; i < row.length && bOK; i++) {
            int value = row[i].getValue();
            if (value > 0) {
                if (bArr[value]) {
                    bOK = false;    // value found again!
                } else {
                    bArr[value] = true;  // value found for the first  time
                }
            }
        }
        return bOK;
    }

    public int getValue(int idx) {
        if (idx >= 0 && idx < row.length) {
            return row[idx].getValue();
        } else {
            return 0;
        }
    }

    public void setValue(int idx, int value, boolean bIsSystemValue) {
        if (idx >= 0 && idx < row.length) {
            row[idx].setValue(value, bIsSystemValue);
        }
    }

    public boolean isSystemValue(int idx) {
        if (idx >= 0 && idx < row.length) {
            return row[idx].isSystemValue();
        } else {
            return false;
        }
    }
}
