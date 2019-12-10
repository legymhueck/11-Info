package lehnen._04Stack._02Bahnhof_GUI;

public class Bahnhof {

    private Gleis a;
    private Gleis b;
    private Gleis c;
    private Gleis d;

    public Bahnhof() {
        a = new Gleis("A");
        b = new Gleis("B");
        c = new Gleis("C");
        d = new Gleis("D");
    }

    public void sortieren() {
        if (b.getGleis().isEmpty()) {
            rangieren(a, b);
        } else if (a.getGleis().isEmpty()) {
            rangieren(c, b);
        } else if (a.getGleis().top().getNummer() == b.getGleis().top().getNummer()) {
            rangieren(a, b);
        } else if (a.getGleis().top().getNummer() < b.getGleis().top().getNummer()) {
            rangieren(b, c);
        } else if (a.getGleis().top().getNummer() > b.getGleis().top().getNummer()) {
            if (c.getGleis().isEmpty()) {
                rangieren(a, c);
            } else if (a.getGleis().top().getNummer() < c.getGleis().top().getNummer()) {
                rangieren(a, c);
            } else if (a.getGleis().top().getNummer() > c.getGleis().top().getNummer()) {
                rangieren(c, b);
            }
        }
    }

    public void rangieren(Gleis pG1, Gleis pG2) {
        pG2.getGleis().push(pG1.getGleis().top());
        pG1.getGleis().pop();
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

    public Gleis getD() {
        return d;
    }
}
