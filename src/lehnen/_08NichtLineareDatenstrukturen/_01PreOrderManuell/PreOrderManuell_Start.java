package lehnen._08NichtLineareDatenstrukturen._01PreOrderManuell;
import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.Baum;

/**
 * Abkürzunden
 * tbL - Teilbaum links
 * tbR - Teilbaum rechts
 * kLLNN - Kind linker Teilbaum, linker Teilbaum mit leerem Teilbaum links und leerem Teilbaum rechts
 * kLRNN - Kind linker Teilbaum, rechter Teilbaum mit leerem Teilbaum links und leerem Teilbaum rechts
 */
public class PreOrderManuell_Start {
    private Baum<Integer> wurzel;
    private Baum<Integer> lTb; // linker Teilbaum
    private Baum<Integer> rTb; // rechter Teilbaum
    private Baum<Integer> w_lTb_lTB_null_null; // Wurzel, linker Teilbaum, linker Tailbaum, beide leeren Teilbäume
    private Baum<Integer> w_lTb_rTb_null_null; // Wurzel, linker Teilbaum, rechter Tailbaum, beide leeren Teilbäume
    private Baum<Integer> w_rTb_lTb_null_null; // Wurzel, rechter Teilbaum, linker Tailbaum, beide leeren Teilbäume
    private Baum<Integer> w_rTb_rTb_null_null; // Wurzel, rechter Teilbaum, rechter Tailbaum, beide leeren Teilbäume


    public PreOrderManuell_Start() {
        erzeugeBaum();
        ausgebenPreorderManuell();
    }

    /**
     * Wichtig:
     * - Baum VON UNTEN NACH OBEN aufbauen
     * - wenn man von oben nach unten aufbaut, hätte man noch keine Teilbäume und Kinder, die man anfügen könnte
     */
    private void erzeugeBaum() {

        // Linke Blätter (die unsichtbare leere Bäme - links und rechts - haben)
        w_lTb_lTB_null_null = new Baum<>(5); // Wurzel mit 2 leeren (unsichtbaren) Teilbäumen
        w_lTb_rTb_null_null = new Baum<>(15); // Wurzel mit 2 leeren (unsichtbaren) Teilbäumen

        // Rechte Blätter (die unsichtbare leere Bäume - links und rechts - haben)
        w_rTb_lTb_null_null = new Baum<>(25); // Wurzel mit 2 leeren (unsichtbaren) Teilbäumen
        w_rTb_rTb_null_null = new Baum<>(35); // Wurzel mit 2 leeren (unsichtbaren) Teilbäumen

        // Linker und rechter Teilbaum
        lTb = new Baum<>(10, w_lTb_lTB_null_null, w_lTb_rTb_null_null);
        rTb = new Baum<>(30, w_rTb_lTb_null_null, w_rTb_rTb_null_null);

        // Wurzel
        wurzel = new Baum<>(20, lTb, rTb);
    }

    private void ausgebenPreorderManuell() {
        System.out.print("Pre-Order-Ausgabe manuell: ");
        System.out.print(wurzel.getInhalt() + " ");

        // Linker Teilbaum
        System.out.print(lTb.getInhalt() + " "); // teilbaum links
        System.out.print(w_lTb_lTB_null_null.getInhalt() + " ");
        System.out.print(w_lTb_rTb_null_null.getInhalt() + " ");

        // Rechter Teilbaum
        System.out.print(rTb.getInhalt() + " "); // teilbaum lechts
        System.out.print(w_rTb_lTb_null_null.getInhalt() + " ");
        System.out.print(w_rTb_rTb_null_null.getInhalt() + " ");
    }

    public static void main(String[] args) {
        new PreOrderManuell_Start();
    }
}
