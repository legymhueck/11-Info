package lehnen._05Rekursion._01DirekteEndlosrekursion;

public class Main {

    public Main() {

    }

    public static void main(String[] args) {
        Main main = new Main();
        main.direkteRekursion();
    }

    /**
     * Unter direkter Rekursion versteht man eine Methode, die sich immer wieder selbst aufruft.
     *
     * Was passiert also bei einer Methode, die sich immer wieder selbst aufruft?
     *
     * Dazu muss man verstehen, dass JAVA seine Methoden und ihre Variablen beim Aufruf auf einen Stack ablegt.
     * Elemente auf diesem Stack verbrauchen Speicherplatz.
     * Ab einem bestimmten Punkt, d. h. der zuvor im JAVA-Programm definierten Stack-Größe, passt auf diesen
     * Stack kein weiteres Element und der JAVA meldet einen "StackOverflowError".
     */
    public void direkteRekursion() {
        System.out.println("Ich rufe mich immer wieder selbst auf.");
        direkteRekursion();
    }

}
