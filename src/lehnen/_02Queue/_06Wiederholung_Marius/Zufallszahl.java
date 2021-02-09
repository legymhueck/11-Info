package lehnen._02Queue._06Wiederholung_Marius;

import java.util.Random;

public class Zufallszahl {

    public int zufallszahl1(int pMinZeit, int pMaxZeit) {
        return (int) (Math.random() * (pMaxZeit - pMinZeit + 1) + pMinZeit);
    }

    public int zufallszahl2(int pMinZeit, int pMaxZeit) {
        Random random = new Random();
        return random.nextInt(pMaxZeit + 1 - pMinZeit) + pMinZeit;
    }
}
