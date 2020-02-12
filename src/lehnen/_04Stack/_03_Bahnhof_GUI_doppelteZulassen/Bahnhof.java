package lehnen._04Stack._03_Bahnhof_GUI_doppelteZulassen;

public class Bahnhof {
    private Gleis a;
    private Gleis b;
    private Gleis c;

    public Bahnhof() {
        a = new Gleis("A");
        b = new Gleis("B");
        c = new Gleis("C");
    }

    public void sortieren() {
        while (!(a.istLeer() && c.istLeer())) {
            naechsterSortierSchritt();
        }
    }

    public void naechsterSortierSchritt() {
        if (!a.istLeer() &&
                (b.istLeer() || a.getErsteWagonNummer() >= b.getErsteWagonNummer()) &&
                (c.istLeer() || a.getErsteWagonNummer() <= c.getErsteWagonNummer())) {
            rangiereWagon(a, b);
        } else if (!c.istLeer() &&
                (a.istLeer() || c.getErsteWagonNummer() <= a.getErsteWagonNummer()) &&
                (b.istLeer() || c.getErsteWagonNummer() >= b.getErsteWagonNummer())) {
            rangiereWagon(c, b);
        } else if (!b.istLeer() &&
                (!a.istLeer() && b.getErsteWagonNummer() >= a.getErsteWagonNummer())) {
            rangiereWagon(b, c);
        } else if (!a.istLeer()) {
            rangiereWagon(a, c);
        }
    }

    public void rangiereWagon(Gleis pGleisVon, Gleis pGleisZiel) {
        pGleisZiel.wagonAbstellen(pGleisVon.wagonHolen());
    }

    public Gleis getA() {
        return a;
    }

    public Gleis getB() {
        return b;
    }

    public Gleis getC() {
        return c;
    }
}
