package lehnen._05Rekursion._10Musikverwaltung;

import lehnen._00Material._01NRW.List;

public class Musikverwaltungsprogramm {
    private List<Musiktitel> liste;
    private int[] a = new int[2];

    public Musikverwaltungsprogramm() {
        listeMitMusiktitelnErzeugen();

        titelVorhandenAusgeben();

        System.out.println("\n\n");

        System.out.println("Titel mit Genre 'Pop': \n");
        popGenreAusgeben();
    }

    private void titelVorhandenAusgeben() {
        System.out.print("Titel: Weeknd, Blinding Lights vorhanden?:\t\t");
        System.out.print(titelVorhanden("Weeknd", "Blinding Lights"));

        System.out.println();

        System.out.print("Titel: Strangelove, Depeche Mode vorhanden?:\t");
        System.out.print(titelVorhanden("Strangelove", "Depeche Mode"));
    }

    private void popGenreAusgeben() {
        List<Musiktitel> meinePOPListe = methode1("Pop");
        meinePOPListe.toFirst();
        while (meinePOPListe.hasAccess()) {
            System.out.println(meinePOPListe.getContent().getTitel() + "\t"
                    + meinePOPListe.getContent().getInterpret() + "\t"
                    + meinePOPListe.getContent().getGenre()
            );
            meinePOPListe.next();
        }
    }

    private List<Musiktitel> listeMitMusiktitelnErzeugen() {
        liste = new List<Musiktitel>();
        liste.append(new Musiktitel("La Isla Bonita", "Madonna", "Pop"));
        liste.append(new Musiktitel("Strangelove", "Depeche Mode", "Pop"));
        return liste;
    }

    public boolean titelVorhanden(String pTitel, String pInterpret) {
        boolean gefunden = false;
        liste.toFirst();
        while (liste.hasAccess() && gefunden == false) {
            Musiktitel mt = liste.getContent();
            if (mt.getTitel().equals(pTitel) && mt.getInterpret().equals(pInterpret)) {
                gefunden = true;
            }
            liste.next();
        }
        return gefunden;
    }

    public List<Musiktitel> methode1(String pGenre) {
        List<Musiktitel> liste2 = new List<Musiktitel>();
        liste.toFirst();
        while (liste.hasAccess()) {
            Musiktitel mt = liste.getContent();
            if (mt.getGenre().equals(pGenre)) {
                liste2.append(mt);
            }
            liste.next();
        }
        return liste2;
    }

    public static void main(String[] args) {
        new Musikverwaltungsprogramm();

    }
}
