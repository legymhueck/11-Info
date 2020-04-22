package lehnen._08NichtLineareDatenstrukturen._01BaumErstellen;

public class Baum<ContentType> {
    private ContentType inhaltsObjekt;
    private Baum linkerTeilbaum;
    private Baum rechterTeilbaum;


    // Dies ist ein Blatt; es hat 2 leere (unsichtbare Teilbäume)
    public Baum(ContentType pInhalt) {
        inhaltsObjekt = pInhalt;   // Inhaltsobjekt (ContentType)
        linkerTeilbaum = null;     // linker (leerer) Teilbaum
        rechterTeilbaum = null;    // rechter (leerer) Teilbaum
    }

    // Dies ist ein Baum, der weitere Teilbäume als Kinder hat
    public Baum(ContentType pInhalt, Baum pLinkerBaum, Baum pRechterBaum) {
        inhaltsObjekt = pInhalt;        // Inhaltsobjekt (ContentType)
        linkerTeilbaum = pLinkerBaum;   // linker Teilbaum
        rechterTeilbaum = pRechterBaum; // rechter Teilbaum
    }

    public ContentType gibInhalt() {
        return inhaltsObjekt;
    }

    public Baum gibLinkerBaum() {
        return linkerTeilbaum;
    }

    public Baum gibRechterBaum() {
        return rechterTeilbaum;
    }

    public void setzeLinkerBaum(Baum pBaum) {
        linkerTeilbaum = pBaum;
    }

    public void setzeRechterBaum(Baum pBaum) {
        rechterTeilbaum = pBaum;
    }
}