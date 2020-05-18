package lehnen._08NichtLineareDatenstrukturen._07Morsebaum._03GesamterMorsebaum;

import resources._01NRW._01Datenstrukturklassen._02Baum.BinaryTree;

public class LetterToMorse {
    private BinaryTree<String> wurzel;


    public LetterToMorse(BinaryTree<String> pWurzel) {
        wurzel = pWurzel;
    }

    // Rekursion
    private String letterToMorseCode(String pZeichen, BinaryTree<String> pBaum, String pTeilcode) {
        if (pBaum.isEmpty()) {
            return "";
        }
        String ergebnis = "";
        if (pBaum.getContent().equals(pZeichen)) {
            ergebnis = pTeilcode;
        } else {
            ergebnis = letterToMorseCode(pZeichen, pBaum.getLeftTree(), pTeilcode + ".") +
                    letterToMorseCode(pZeichen, pBaum.getRightTree(), pTeilcode + "-");
        }
        return ergebnis;
    }

    public String encodeText(String pText) {
        pText = pText.toUpperCase();
        String code = "";
        for (int i = 0; i < pText.length() ; i++) {
            String zeichen = String.valueOf(pText.charAt(i));
            code += letterToMorseCode(zeichen, wurzel, "");
            code += "/";
        }
        return code;
    }
}
