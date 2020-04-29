package lehnen._08NichtLineareDatenstrukturen._00BaumKlasse;

public class BaumBauer_3Ebenen {
    private Baum<Integer> wurzel;

    public BaumBauer_3Ebenen() {
        /* Beginn 3. Ebene*/
        Baum<Integer> wLLL = new Baum<>(1); // linker Teilbaum zu Wurzel 5
        Baum<Integer> wLLR = new Baum<>(); // leerer rechter Teilbaum

        /* Beginn 2. Ebene */
        // Linke Blaetter (die versteckte leere Baume links und rechts haben)
        Baum<Integer> wLL = new Baum<>(5, wLLL, wLLR); // Kind mit 2 leeren (unsichtbaren) Teilbäumen
        Baum<Integer> wLR = new Baum<>(15); // Kind mit 2 leeren (unsichtbaren) Teilbäumen

        // Rechte Blaetter (die versteckte leere Baume links und rechts haben)
        Baum<Integer> wRL = new Baum<>(25); // Kind mit 2 leeren (unsichtbaren) Teilbäumen
        Baum<Integer> wRR = new Baum<>(35); // Kind mit 2 leeren (unsichtbaren) Teilbäumen

        /* Ende 2. Ebene */


        // 1. Ebene: Linker und rechter Teilbaum
        Baum<Integer> wL = new Baum<>(10, wLL, wLR);
        Baum<Integer> wR = new Baum<>(30, wRL, wRR);

        // Wurzel
        wurzel = new Baum<>(20, wL, wR);

        System.out.println("      " + wurzel.getInhalt());

        System.out.print("  " + wL.getInhalt());
        System.out.println("      " + wR.getInhalt());

        System.out.print(" " + wLL.getInhalt());
        System.out.print("  " + wLR.getInhalt());
        System.out.print("  " + wRL.getInhalt());
        System.out.println("  " + wRR.getInhalt());

        System.out.println(wLLL.getInhalt());
    }

    public Baum<Integer> getWurzel() {
        return wurzel;
    }

    public static void main(String[] args) {
        new BaumBauer_3Ebenen();
    }
}
