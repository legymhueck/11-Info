package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._04Suchen_Einfuegen_Loeschen;

import resources._01NRW._01Datenstrukturklassen._02Baum.BinaryTree;
import lehnen._08NichtLineareDatenstrukturen._08ComparableContent._02Schueler_3Attribute.Schueler;

public class Methoden {

    public void einfuegen(BinaryTree<Schueler> pSuchbaum, Schueler pSchueler) {

    }

    public Schueler suchen(BinaryTree<Schueler> pSuchbaum, Schueler pSchueler) {
        Schueler zuSuchenderSchueler = null;
        if (!pSuchbaum.isEmpty()) {
            Schueler tempSchueler = pSuchbaum.getContent();
            if (pSchueler.isLess(tempSchueler)) {
                // im linken Teilbaum weiter suchen
                zuSuchenderSchueler = suchen(pSuchbaum.getLeftTree(), pSchueler);
            } else if (pSchueler.isGreater(tempSchueler)) {
                // im rechten Teilbaum weiter suchen
                zuSuchenderSchueler = suchen(pSuchbaum.getRightTree(), pSchueler);
            } else if (pSchueler.isEqual(tempSchueler)) {
                // Schüler wurde gefunden
                zuSuchenderSchueler = tempSchueler;
            }
        }
        return zuSuchenderSchueler;
    }


    public BinaryTree<Schueler> loeschen(BinaryTree<Schueler> pSuchbaum, Schueler pSchueler) {
        return null; // Bitte anpassen
    }


    private BinaryTree<Schueler> findeKleinstenNachfolger(BinaryTree<Schueler> pSuchbaum) {
        return null; // Bitte anpassen
    }

    private boolean istBlatt(BinaryTree<Schueler> pSuchbaum) {
        return false; // Bitte anpassen
    }
}

