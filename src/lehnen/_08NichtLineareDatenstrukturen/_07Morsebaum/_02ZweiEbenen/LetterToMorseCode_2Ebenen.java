package lehnen._08NichtLineareDatenstrukturen._07Morsebaum._02ZweiEbenen;

import resources._01NRW._01Datenstrukturklassen._02Baum.BinaryTree;

public class LetterToMorseCode_2Ebenen {
    private BinaryTree<String> wurzel;

    public LetterToMorseCode_2Ebenen() {

        /**
         * Morsebaum mit Buchstaben bauen
         */
        // 2. Ebene
        BinaryTree<String> i = new BinaryTree<String>("I");
        BinaryTree<String> a = new BinaryTree<String>("A");
        BinaryTree<String> n = new BinaryTree<String>("N");
        BinaryTree<String> m = new BinaryTree<String>("M");

        // 1. Ebene
        BinaryTree<String> e = new BinaryTree<String>("E", i, a);
        BinaryTree<String> t = new BinaryTree<String>("T", n, m);

        // Wurzel
        wurzel = new BinaryTree<String>("/", e, t);

        /**
         * Buchstaben in Morsezeichen umwandeln
         */
        String morsecode = letterToMorseCode("A", wurzel, "");
        System.out.println(morsecode);
    }

    private String letterToMorseCode(String pBuchstabe, BinaryTree<String> pBaum, String pTeilCode) {
        if (pBaum.isEmpty()) { // prevent NullPointer
            return "";
        }

        String ergebnis = "";

        if (pBaum.getContent().equals(pBuchstabe)) {
            ergebnis = pTeilCode;
        } else {
            ergebnis = letterToMorseCode(pBuchstabe, pBaum.getLeftTree(), pTeilCode + ".") +
                    letterToMorseCode(pBuchstabe, pBaum.getRightTree(), pTeilCode + "-");
        }
        return ergebnis;
    }


    public static void main(String[] args) {
        new LetterToMorseCode_2Ebenen();
    }
}