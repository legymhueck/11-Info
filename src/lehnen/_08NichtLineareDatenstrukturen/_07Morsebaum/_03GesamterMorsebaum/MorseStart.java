package lehnen._08NichtLineareDatenstrukturen._07Morsebaum._03GesamterMorsebaum;

import resources._01NRW._01Datenstrukturklassen._02Baum.BinaryTree;

public class MorseStart {

    private BinaryTree<String> wurzel;

    public MorseStart() {
        MorseTree  morseTree = new MorseTree();
        wurzel = morseTree.baumBauen();
        /**
         * Convert MorseCode to String
         * Jedes Zeichen des Morsecodes muss mit '/' abschließen
         */
        MorseToLetter morseToLetter = new MorseToLetter(wurzel);
        String decode_text = morseToLetter.morseCodeToLetter("--/../-.-./..../.-/./.-../");
        System.out.println(decode_text);

        /**
         * Convert a String to MorseCode
         */
        LetterToMorse letterToMorse = new LetterToMorse(wurzel);
        String encode_text = letterToMorse.encodeText("Lehnen");
        System.out.println(encode_text);

        // Den erzeugten Morsebaum anzeigen
        new TreeView(1000, 500, wurzel).setVisible(true);
    }

    public BinaryTree<String> getWurzel() {
        return wurzel;
    }

    public static void main(String[] args) {
        new MorseStart();
    }
}
