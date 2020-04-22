package lehnen._08NichtLineareDatenstrukturen._00BaumKlasse;

public class Baum<Integer> { // Ein Baum, der Integer verwaltet
    private Integer inhaltsObjekt; // contentType
    private Baum linkerTeilbaum;   // left
    private Baum rechterTeilbaum;  // right

    /** Es werden 3 unterschiedliche Konstruktoren benötigt.
     *   1. Einen leeren Baum
     *   2. Einen Baum mit Inhaltsobjekt und zwei leeren Teilbäumen
     *   3. Einen Baum mit Inhaltsobjekt und zwei weiteren Teilbäumen, wobei entweder
     *      - beide Teilbäume voll sind
     *      - der linke Teilbaum leer ist
     *      - der rechte Teilbaum leer ist
     *
     *  Die Signatur einer Methode ist
     *    - ihr NAME
     *    - die ANZAHL, der TYP und die REIHENFOLGE der PARAMETER
     *
     *  Die Signatur ist NICHT:
     *    - der Name der formalen Parameter (= Bezeichner, der in einer Methode verwendet wird, um einen Wert
     *      aufzunehmen, der an die Methode vom Aufrufer übergeben wird.
     *      (aktueller Parameter = tatsächlicher Wert, der an die Methode durch den Aufrufer übergeben wird.
     *    - der Rückgabetyp der Methode
     *
     *  Die 3 Konstruktoren unterscheiden sich in ihrer Signatur, da
     *    - der 1. Konstruktor KEINEN Parameter
     *    - der 2. Konstruktor EINEN Parameter
     *    - der 3. Konstruktor DREI Parameter hat.
     *
     */

    // 1. Konstruktor -> für einen leeren Baum
    public Baum() { // Der Konstruktor bekommt keine < > (Diamant-Operator)
        inhaltsObjekt = null;
        linkerTeilbaum = null;
        rechterTeilbaum = null;
    }

    // 2. Konstruktor -> für ein Blatt
    public Baum(Integer pInhalt) {
        inhaltsObjekt = pInhalt;
        linkerTeilbaum = null;
        rechterTeilbaum = null;
    }

    // 3. Konstruktor -> für einen inneren Knoten
    public Baum(Integer pInhalt, Baum pLinkerTeilbaum, Baum pRechterTeilbaum) {
        inhaltsObjekt = pInhalt;
        linkerTeilbaum = pLinkerTeilbaum;
        rechterTeilbaum = pRechterTeilbaum;
    }

    // Getter
    public Integer getInhalt() {
        return inhaltsObjekt;
    }

    public Baum getLinkerTeilbaum() {
        return linkerTeilbaum;
    }

    public Baum getRechterTeilbaum() {
        return rechterTeilbaum;
    }

    public boolean isEmpty() {
        return inhaltsObjekt == null;
    }
}
