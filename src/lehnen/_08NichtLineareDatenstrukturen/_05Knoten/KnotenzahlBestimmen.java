package lehnen._08NichtLineareDatenstrukturen._05Knoten;

import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.Baum;
import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.BaumBauer_3Ebenen;

public class KnotenzahlBestimmen {
    private Baum<Integer> wurzel;

    public KnotenzahlBestimmen() {
        BaumBauer_3Ebenen baumBauer_3Ebenen = new BaumBauer_3Ebenen();
        wurzel = baumBauer_3Ebenen.getWurzel();

        System.out.println("Anzahl Knoten: " + bestimmeKnotenZahl(wurzel));

    }

    private int bestimmeKnotenZahl(Baum<Integer> pBaum) {
        int knotenzahl = 0;
        if (pBaum == null || pBaum.isEmpty()) {
            return knotenzahl;
        }
        int knotenLinks = bestimmeKnotenZahl(pBaum.getLinkerTeilbaum());
        int knotenRechts = bestimmeKnotenZahl(pBaum.getRechterTeilbaum());
        int wurzel = 1;
        knotenzahl = wurzel + knotenLinks + knotenRechts;

        return knotenzahl;
    }

    public static void main(String[] args) {
        new KnotenzahlBestimmen();
    }
}
