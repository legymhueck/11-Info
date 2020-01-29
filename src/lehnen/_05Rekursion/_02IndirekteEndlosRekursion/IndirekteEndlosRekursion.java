package lehnen._05Rekursion._02IndirekteEndlosRekursion;

/**
 * Bei einer indirekten Endlosrekursion rufen sich zwei Methoden im Wechsel auf.
 */
public class IndirekteEndlosRekursion {

    public static void main(String[] args) {
        IndirekteEndlosRekursion ier = new IndirekteEndlosRekursion();
        ier.ersteMethode();
    }

    public void ersteMethode() {
        System.out.println("Ich bin die erste Methode.");
        zweiteMethode();
    }

    public void zweiteMethode() {
        System.out.println("Ich bin die zweite Methode.");
        ersteMethode();
    }
}
