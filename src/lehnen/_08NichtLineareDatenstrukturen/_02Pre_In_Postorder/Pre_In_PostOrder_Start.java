package lehnen._08NichtLineareDatenstrukturen._02Pre_In_Postorder;

import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.BaumBauer_3Ebenen;
import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.Baum;

public class Pre_In_PostOrder_Start {
    private Baum wurzel;

    public Pre_In_PostOrder_Start() {
        BaumBauer_3Ebenen baumBauer_3Ebenen = new BaumBauer_3Ebenen();
        wurzel = baumBauer_3Ebenen.getWurzel();

        Pre_In_PostOrder traversierungen = new Pre_In_PostOrder();

        System.out.print("Preorder:\t");
        traversierungen.preorder(wurzel);

        System.out.print("\n\nInorder:\t");
        traversierungen.inorder(wurzel);

        System.out.print("\n\nPostorder:\t");
        traversierungen.postorder(wurzel);
    }

    public static void main(String[] args) {
        new Pre_In_PostOrder_Start();
    }

}
