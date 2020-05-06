package lehnen._08NichtLineareDatenstrukturen._06Blattzahl;

import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.Baum;
import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.BaumBauer_3Ebenen;
import resources._01NRW._01Datenstrukturklassen._01Linear.List;

public class BlattzahlBestimmen {
    private Baum<Integer> wurzel;

    public BlattzahlBestimmen() {
        BaumBauer_3Ebenen baumBauer_3Ebenen = new BaumBauer_3Ebenen();
        wurzel = baumBauer_3Ebenen.getWurzel();
        listeAusgeben(gibBlaetterAusBaum(wurzel));
    }

    private void listeAusgeben(List<Integer> pList) {
        pList.toFirst();
        while (pList.hasAccess()) {
            System.out.print(pList.getContent() + " ");
            pList.next();
        }
    }

    private List<Integer> gibBlaetterAusBaum(Baum<Integer> pBaum) {
        List<Integer> ergebnis = new List<>();

        if (pBaum.isEmpty() || pBaum == null) {
            return ergebnis;
        }

        if ((pBaum.getLinkerTeilbaum() == null || pBaum.getLinkerTeilbaum().isEmpty())
                && (pBaum.getRechterTeilbaum() == null || pBaum.getRechterTeilbaum().isEmpty())) {
            ergebnis.append(pBaum.getInhalt());
            return ergebnis;
        }
        List<Integer> linksErgebnis = gibBlaetterAusBaum(pBaum.getLinkerTeilbaum());
        List<Integer> rechtsErgebis = gibBlaetterAusBaum(pBaum.getRechterTeilbaum());
        ergebnis.concat(linksErgebnis);
        ergebnis.concat(rechtsErgebis);

        return ergebnis;
    }

    public static void main(String[] args) {
        new BlattzahlBestimmen();
    }
}
