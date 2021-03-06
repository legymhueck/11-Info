package lehnen._05Rekursion._11Wuerfelspiel;

import java.util.Random;

public class Wuerfel {
    public int wuerfeln() {
        return new Random().nextInt(6) + 1;
    }
}