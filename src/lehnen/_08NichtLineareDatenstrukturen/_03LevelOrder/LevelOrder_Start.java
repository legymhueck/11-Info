package lehnen._08NichtLineareDatenstrukturen._03LevelOrder;

import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.BaumBauer_3Ebenen;
import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.Baum;
import resources._01NRW._01Datenstrukturklassen._01Linear.List;

public class LevelOrder_Start {
    private Baum wurzel;
    private List<Integer> meineListe;

    public LevelOrder_Start() {
        BaumBauer_3Ebenen baumBauer_3Ebenen = new BaumBauer_3Ebenen();
        wurzel = baumBauer_3Ebenen.getWurzel();

        meineListe = new List<>();
        LevelOrder levelOrder = new LevelOrder<>();

        levelOrder.levelorder(wurzel, meineListe);
        System.out.print("Level Order: ");
        listeDrucken();
    }

    private void listeDrucken() {
        System.out.print("|");
        meineListe.toFirst();
        while (meineListe.hasAccess()) {
            System.out.print(meineListe.getContent() + " | ");
            meineListe.next();
        }
    }

    public static void main(String[] args) {
        new LevelOrder_Start();
    }
}
