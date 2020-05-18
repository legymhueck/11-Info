package lehnen._08NichtLineareDatenstrukturen._07Morsebaum._03GesamterMorsebaum;

import resources._01NRW._01Datenstrukturklassen._02Baum.BinaryTree;

public class MorseToLetter {
    private BinaryTree<String> wurzel;

    public MorseToLetter(BinaryTree<String> pWurzel) {
        wurzel = pWurzel;
    }

    // Nicht rekursiv
    public String morseCodeToLetter(String pMorseCode) {
        BinaryTree<String> baum = wurzel;
        String klartext = "";

        for (int i = 0; i < pMorseCode.length(); i++) {
            if (pMorseCode.charAt(i) == '/') {
                klartext += baum.getContent();
                baum = wurzel;
            } else if (pMorseCode.charAt(i) == '.') {
                baum = baum.getLeftTree();
            } else if (pMorseCode.charAt(i) == '-') {
                baum = baum.getRightTree();
            }
        }
        return klartext;
    }
}
