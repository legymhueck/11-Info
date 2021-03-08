package lehnen._05Rekursion._12MaxAusListeBestimmen;

import resources._01NRW._01Datenstrukturklassen._01Linear.List;

public class MainApp {
    List<Integer> meineIntListe = new List<>();

    public MainApp() {
        meineIntListe.append(-12);
        meineIntListe.append(-1);
        meineIntListe.append(-8);
    }

    public static void main(String[] args) {
        new MainApp().start();
    }

    private int get_max_from_list_rek() {
        if ( !meineIntListe.hasAccess() ) {
            // Dies ist der base-Case.
            return Integer.MIN_VALUE; // alle anderen Werte können nur gleich oder größer sein
        } else {
            int value = meineIntListe.getContent();
            meineIntListe.next();
            int max = get_max_from_list_rek();
            System.out.println("Math.max (" + value + "," + max + ")");
            return Math.max(max, value);
        }
    }

    private void start() {
        meineIntListe.toFirst(); // damit die Liste access hat.
        System.out.println("Stack wird abgearbeitet ...");
        System.out.println(get_max_from_list_rek());
    }
}
