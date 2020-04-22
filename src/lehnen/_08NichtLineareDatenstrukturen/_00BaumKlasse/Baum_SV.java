package lehnen._08NichtLineareDatenstrukturen._00BaumKlasse;

public class Baum_SV<Integer> { // Ein Baum, der Integer verwaltet
    private Integer inhaltsObjekt; // contentType
    private Baum linkerTeilbaum;   // left
    private Baum rechterTeilbaum;  // right

    /** Es werden 3 unterschiedliche Konstruktoren benötigt.
     *   1. Ein leerer Baum
     *   2. Ein Baum mit Inhaltsobjekt und zwei leeren Teilbäumen
     *   3. Ein Baum mit Inhaltsobjekt und zwei weiteren Teilbäumen, wobei entweder
     *      - beide Teilbäume voll sind
     *      - der linke Teilbaum leer ist
     *      - der rechte Teilbaum leer ist
     *
     *  Die 3 Konstruktoren unterscheiden sich in ihrer Signatur, da
     *    - der 1. Konstruktor KEINEN Parameter
     *    - der 2. Konstruktor EINEN Parameter
     *    - der 3. Konstruktor DREI Parameter hat.
     *
     *  Die Signatur einer Methode ist:
     *    - ihr NAME
     *    - die ANZAHL, der TYP und die REIHENFOLGE der PARAMETER
     *
     *  Die Signatur ist NICHT:
     *    - der Name der formalen Parameter (= Bezeichner, der in einer Methode verwendet
     *      wird, um einen Wert aufzunehmen, der an die Methode vom Aufrufer übergeben wird.
     *      (aktueller Parameter = tatsächlicher Wert, der an die Methode durch den Aufrufer
     *      übergeben wird.
     *    - der Rückgabetyp der Methode
     *
     */

    // 1. Konstruktor -> für einen leeren Baum
    public Baum_SV() { // Der Konstruktor bekommt keine < > (Diamant-Operator)

    }

    // 2. Konstruktor -> für ein Blatt
    public Baum_SV(Integer pInhalt) {

    }

    // 3. Konstruktor -> für einen inneren Knoten
    public Baum_SV(Integer pInhalt, Baum pLinkerTeilbaum, Baum pRechterTeilbaum) {

    }

    // Getter
    public Integer getInhalt() {
        return null; // bitte anpassen
    }

    public Baum getLinkerTeilbaum() {
        return null; // bitte anpassen
    }

    public Baum getRechterTeilbaum() {
        return null; // bitte anpassen
    }

    public boolean isEmpty() {
        return false; // bitte anpassen;
    }
}