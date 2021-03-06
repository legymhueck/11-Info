package lehnen._05Rekursion._11Wuerfelspiel;

import resources._01NRW._01Datenstrukturklassen._02Baum.ComparableContent;

public class Wurfergebnis implements ComparableContent<Wurfergebnis> {
    private int ergebnis;

    public Wurfergebnis(int pIntValue) {
        ergebnis = pIntValue;
    }

    public int getErgebnis() {
        return ergebnis;
    }

    @Override
    public boolean isGreater(Wurfergebnis pContent) {
        //return ergebnis.compareTo(pContent.ergebnis) > 0;
        return ergebnis > pContent.getErgebnis();

    }

    @Override
    public boolean isEqual(Wurfergebnis pContent) {
        //return ergebnis.compareTo(pContent.ergebnis) == 0;
        //return ergebnis == pContent.getErgebnis();
        return false;  // damit gleiche Werte in den Baum eingefügt werden können.
    }

    @Override
    public boolean isLess(Wurfergebnis pContent) {
        // return ergebnis.compareTo(pContent.ergebnis) <= 0;
        // return ergebnis < pContent.getErgebnis();
        return ergebnis <= pContent.getErgebnis(); // <= damit mehrere gleiche Werte eingefügt werden können.
    }
}

