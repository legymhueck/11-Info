package lehnen._08NichtLineareDatenstrukturen._04Tiefe;
import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.Baum;
import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.BaumBauer_3Ebenen;

public class TiefeBestimmen {
    private Baum<Integer> wurzel;

    public TiefeBestimmen() {
        BaumBauer_3Ebenen baumBauer_3Ebenen = new BaumBauer_3Ebenen();
        wurzel = baumBauer_3Ebenen.getWurzel();

        System.out.println("Tiefes des Baumes: " + tiefe(wurzel));
    }

    public int tiefe(Baum<Integer> pBaum) {
        int tiefe = -1;

        if (pBaum == null || pBaum.isEmpty()) {
            return tiefe;
        }

        int tiefeLinks = tiefe(pBaum.getLinkerTeilbaum());
        int tiefeRechts = tiefe(pBaum.getRechterTeilbaum());
        tiefe = tiefeLinks;
        if (tiefe < tiefeRechts) {
            tiefe = tiefeRechts;
        }
        tiefe++;

        return tiefe;
    }

    public static void main(String[] args) {
        new TiefeBestimmen();
    }

}