package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._06ComparableInteger;

import resources._01NRW._01Datenstrukturklassen._02Baum.BinarySearchTree;

public class MainApp {
    private final BinarySearchTree<ComparableInteger> meinBST;

    public MainApp() {
        meinBST = new BinarySearchTree<>();
    }

    public static void main(String[] args) {
        new MainApp().start();
    }

    private void drucken() {

    }

    private void start() {
        ComparableInteger cInt1 = new ComparableInteger(1);
        ComparableInteger cInt2 = new ComparableInteger(2);
        ComparableInteger cInt3 = new ComparableInteger(3);
        ComparableInteger cInt4 = new ComparableInteger(4);

        // Bestimme, wo die Zahlen jeweils eingefügt werden
        meinBST.insert(cInt4);  // 4 wird als Wurzel eingefügt
        meinBST.insert(cInt2);  // 2 wird ...
        meinBST.insert(cInt1);  // 1 wird ...
        meinBST.insert(cInt3);  // 3 wird ...

        // Vervollständige die Methode drucken()
        // Sie muss noch nicht rekursiv implementiert werden.
        drucken();
    }
}