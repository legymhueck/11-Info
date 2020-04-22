package lehnen._08NichtLineareDatenstrukturen._00BaumKlasse;

public class BaumBauer_1Ebene {
    private Baum<Integer> wurzel;

    public BaumBauer_1Ebene() {
        Baum<Integer> linkerTeilBaum = new Baum<>(1);
        Baum<Integer> rechterTeilbaum = new Baum<>(3);

        wurzel = new Baum<>(2, linkerTeilBaum, rechterTeilbaum);

        System.out.println("  " + wurzel.getInhalt());
        System.out.print("" + linkerTeilBaum.getInhalt());
        System.out.println("   " + rechterTeilbaum.getInhalt());
    }

    public Baum<Integer> getWurzel() {
        return wurzel;
    }

    public static void main(String[] args) {
        new BaumBauer_1Ebene();
    }
}
