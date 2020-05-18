/**
 * Der hier verwendete Baum sieht so aus:
 *
 *      /
 *    E   T
 */
package lehnen._08NichtLineareDatenstrukturen._07Morsebaum._01EineEbene;

import resources._01NRW._01Datenstrukturklassen._02Baum.BinaryTree;

public class EinTeilbaum {
    private BinaryTree<String> wurzel;

    public EinTeilbaum() {


        /**
         * Baum von unten her bauen
         */

        // linker Teilbaum
        BinaryTree<String> e = new BinaryTree<>("E");

        // rechter Teilbaum
        BinaryTree<String> t = new BinaryTree<>("T");

        // Wurzel mit linkem und rechtem Teilbaum
        wurzel = new BinaryTree<>("/", e, t);

        /**
         * Einen Buchstaben in Morsezeichen umwandeln
         */
        String erg = encode("E", wurzel, "");
        System.out.println(erg);

    }

    public static void main(String[] args) {
        new EinTeilbaum();
    }

    private String encode(String pBuchstabe, BinaryTree<String> pBaum, String pTeilCode) {
        if (pBaum.isEmpty()) { // prevent NullPointer
            return "";
        }
        String ergebnis = "";

        if (pBaum.getContent().equals(pBuchstabe)) {
            ergebnis = pTeilCode;
        } else {
            ergebnis = encode(pBuchstabe, pBaum.getLeftTree(), pTeilCode + ".") +
                    encode(pBuchstabe, pBaum.getRightTree(), pTeilCode + "-");
        }
        return ergebnis;
    }
}
