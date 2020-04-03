package lehnen._06Sortieren._03Objekte;

public class Auto {
    private String marke;
    private int gewicht;

    public String getMarke() {
        return marke;
    }

    public Auto(String pMarke, int pGewicht) {
        marke = pMarke;
        gewicht = pGewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int pGewicht) {
        gewicht = pGewicht;
    }
}
