package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._08Traversierungen.OhneListe;

import lehnen._08NichtLineareDatenstrukturen._08ComparableContent._07ComparableString.ComparableString;
import resources._01NRW._01Datenstrukturklassen._02Baum.BinarySearchTree;

public class MainApp {
    BinarySearchTree<ComparableString> meinBST = new BinarySearchTree<>();

    public static void main(String[] args) {
        new MainApp().start();
    }

    private void start() {
        meinBST.insert(new ComparableString("Michael"));
        meinBST.insert(new ComparableString("Andrea"));
        meinBST.insert(new ComparableString("Tobias"));
        meinBST.insert(new ComparableString("Fabian"));

        System.out.println("Preorder:");
        preorder(meinBST);
        System.out.println("\n\nInorder:");
        inorder(meinBST);
        System.out.println("\n\nPostorder:");
        postorder(meinBST);

        // Vervollständige die folgenden Methoden!
    }

    private void preorder(BinarySearchTree<ComparableString> pBaum) { // WLR

    }

    private void inorder(BinarySearchTree<ComparableString> pBaum) { // LWR

    }

    private void postorder(BinarySearchTree<ComparableString> pBaum) { //LRW

    }
}


