package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._07ComparableString;

import resources._01NRW._01Datenstrukturklassen._02Baum.BinarySearchTree;

public class MainApp {
    private final BinarySearchTree<ComparableString> meinBST;

    public MainApp() {
        meinBST = new BinarySearchTree<>();
    }

    public static void main(String[] args) {
        new MainApp().start();
    }

    private void start() {
        // Bestimme, wo die Nodes jeweils eingefügt werden.
        meinBST.insert(new ComparableString("Angelika")); // Wurzel
        meinBST.insert(new ComparableString("Jan"));      // rechts von ...
        meinBST.insert(new ComparableString("Eric"));     // ...
        meinBST.insert(new ComparableString("Marius"));   // ...
        meinBST.insert(new ComparableString("Max"));      // ...
        meinBST.insert(new ComparableString("Fabian"));   // ...
        meinBST.insert(new ComparableString("Felix"));    // ...

        // Angelika
        System.out.println(meinBST.getContent().getMeinComparableString());

        // Jan


        // Eric


        // Marius


        // Max


        // Fabian


        // Felix

    }
}
