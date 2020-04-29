package lehnen._08NichtLineareDatenstrukturen._02Traversierungen;

import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.BaumBauer_3Ebenen;
import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.Baum;

public class Traversierungen_Start {
    private Baum wurzel;

    public Traversierungen_Start() {
        BaumBauer_3Ebenen baumBauer_3Ebenen = new BaumBauer_3Ebenen();
        wurzel = baumBauer_3Ebenen.getWurzel();

        Traversierungen traversierungen = new Traversierungen();

        System.out.print("Preorder:\t");
        traversierungen.preorder(wurzel);

        System.out.print("\n\nInorder:\t");
        traversierungen.inorder(wurzel);

        System.out.print("\n\nPostorder:\t");
        traversierungen.postorder(wurzel);
    }

    public static void main(String[] args) {
        new Traversierungen_Start();
    }

}
