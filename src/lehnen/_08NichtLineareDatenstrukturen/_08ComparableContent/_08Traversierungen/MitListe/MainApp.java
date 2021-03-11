package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._08Traversierungen.MitListe;

import lehnen._08NichtLineareDatenstrukturen._08ComparableContent._07ComparableString.ComparableString;
import resources._01NRW._01Datenstrukturklassen._01Linear.List;
import resources._01NRW._01Datenstrukturklassen._02Baum.BinarySearchTree;

public class MainApp {
    BinarySearchTree<ComparableString> meinBST = new BinarySearchTree<>();
    List<ComparableString> meineListePreorder = new List<>();
    List<ComparableString> meineListeInorder = new List<>();
    List<ComparableString> meineListePostorder = new List<>();

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
        listeAusgeben(meineListePreorder);

        System.out.println("\n\nInorder:");
        inorder(meinBST);
        listeAusgeben(meineListeInorder);

        System.out.println("\n\nPostorder:");
        postorder(meinBST);
        listeAusgeben(meineListePostorder);

        // Vervollständige die folgenden Methoden!
    }

    private void preorder(BinarySearchTree<ComparableString> pBaum) {

    }

    private void inorder(BinarySearchTree<ComparableString> pBaum) {

    }

    private void postorder(BinarySearchTree<ComparableString> pBaum) {

    }

    private void listeAusgeben(List<ComparableString> pListe) {

    }
}

