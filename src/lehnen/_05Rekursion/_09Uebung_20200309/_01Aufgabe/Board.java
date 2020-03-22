package lehnen._05Rekursion._09Uebung_20200309._01Aufgabe;

public class Board {
    Cell[] row;

    public Board() {
        row = new Cell[9];
        init();
    }

    private void init() {
        for (int i = 0; i < row.length; i++) {
            row[i] = new Cell();     // 0 = empty, i.e. no valid value set
        }
    }


    public void solve_recursive() {
    }

    /**
     * Es gibt Felder, die vorgegebene Zahlen enthalten.
     * Es gibt Felder, die eine 0 enthalten.
     *
     * Aufgabe:
     * Alle 0-Felder sollen mit den fehlenden Zahlen von 1 - 9 aufegfüllt werden.
     */
    public void solve_iterative() {
        // Your code goes here ...
    }

    public void displayPermulations(MainView pMainView) {
        /**
         * Hier sollen alle Permutationen der 9 Felder angezeigt werden, d.h.
         * 1 1 1 1 1 1 1 1 1
         * 1 1 1 1 1 1 1 1 2
         * 1 1 1 1 1 1 1 1 3
         * 1 1 1 1 1 1 1 1 4
         * 1 1 1 1 1 1 1 1 5
         * 1 1 1 1 1 1 1 1 6
         * 1 1 1 1 1 1 1 1 7
         * 1 1 1 1 1 1 1 1 8
         * 1 1 1 1 1 1 1 1 9
         * 1 1 1 1 1 1 1 2 1
         * 1 1 1 1 1 1 1 3 1
         * 1 1 1 1 1 1 1 4 1
         * usw.
         * 9 9 9 9 9 9 9 9 9
         *
         * Tipp: Du brauchst verschachtelte for-Schleifen
         *
         */


    }


    private boolean valueVorhanden(int pZahl, Cell[] pArray) {
        /**
         * Diese Methode soll testen, ob eine Zahl im Array schon vorhanden ist.
         * Eine ähnliche Methode haben wir vielfach schon geschrieben.
         *
         * Das return false musst du natürlich anpassen.
         */
        return false;
    }


    public void sort() {
        /**
         * Hier sollen die ZELLEN sortiert werden.
         * Die Werte aus der Zelle im Index 0 des Arrays erhältst du z. B. mit row[0].getValue()
         *
         * Optimierung:
         *
         * Wie bei BubbleSort kannst du mit break; die Schleife verlassen, wenn nicht getauscht wurde.
         */

    }


    /**
     * Erläutere schriftlich,
     *  - wie die Methode random_fill vorgeht, um Zufallszahlen in das Array zu schreiben.
     *
     *  Kommentiere dazu den Code ausführlich!
     *
     */
    public void random_fill(int pCount) {
        clear();
        for (int i = 0; i < pCount && i < row.length; i++) {
            int pos = (int) (Math.random() * 9);
            int rand = (int) (Math.random() * 9 + 1);

            if (row[pos].getValue() == 0) {
                row[pos].setValue(rand, true);

                if (!check()) {
                    row[pos].setValue(0, false);
                    i--;
                }
            } else {
                i--;
            }

        }
    }

    public void clear() {
        for (int i = 0; i < row.length; i++) {
            row[i].setValue(0, false);
        }
    }

    /**
     * Erläutere schriftlich, was die Methode check macht.
     * Kommentiere dazu den Code ausführlich!
     *
     */
    private boolean check() {
        boolean bOK = true;
        boolean[] arr = new boolean[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }

        for (int i = 0; i < row.length && bOK; i++) {
            int value = row[i].getValue();
            if (value > 0) {
                if (arr[value]) {
                    bOK = false;
                } else {
                    arr[value] = true;
                }
            }
        }
        return bOK;
    }

    public int getValue(int pIndex) {
        if (pIndex >= 0 && pIndex < row.length) {
            return row[pIndex].getValue();
        } else {
            return 0;
        }
    }

    public void setValue(int pIndex, int pValue, boolean bIsSystemValue) {
        if (pIndex >= 0 && pIndex < row.length) {
            row[pIndex].setValue(pValue, bIsSystemValue);
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
