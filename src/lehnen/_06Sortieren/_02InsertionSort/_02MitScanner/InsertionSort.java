package lehnen._06Sortieren._02InsertionSort._02MitScanner;

import resources._01NRW._01Datenstrukturklassen._01Linear.List;

import java.util.Scanner;

public class InsertionSort {
    private List<Integer> meineliste;

    public InsertionSort() {
        meineliste = new List<>();
        listeMitBenutzereingabeFuellen();
        System.out.println("Unsortierte Liste:");
        drucken(meineliste);
        insertionSort();
        System.out.println("\n\nSortierte Liste:");
        drucken(meineliste);

    }

    private void listeMitBenutzereingabeFuellen() {
        System.out.print("Füllen Sie die Liste mit Integern. Abbruch mit 'e'\n");
        Scanner scanner = new Scanner(System.in);
        int zahl = 1;
        while (true) {
            System.out.print(zahl + ". Zahl: ");
            if (scanner.hasNextInt()) {
                meineliste.append(scanner.nextInt());
                zahl++;
            }
            if (scanner.nextLine().equalsIgnoreCase("e")) {
                break;
            }
        }
        scanner.close();
    }

    public void insertionSort() {
        List<Integer> sortierteListe = new List<Integer>();
        while (!meineliste.isEmpty()) {
            meineliste.toFirst();
            int akt = meineliste.getContent();

            sortierteListe.toFirst();
            while (sortierteListe.hasAccess() && sortierteListe.getContent() < akt) {
                sortierteListe.next();
            }
            if (sortierteListe.hasAccess()) {
                sortierteListe.insert(akt); // sortierteListe ist nicht leer und es muss hinten angefügt werden; das kann insert nicht!
            } else {
                sortierteListe.append(akt); // daher muss append aufgerufen werden
            }
            meineliste.remove();
        }
        meineliste = sortierteListe;
    }


    private void drucken(List<Integer> pListe) {
        pListe.toFirst(); // damit ist hasAccess == true
        while (pListe.hasAccess()) {
            System.out.print(pListe.getContent() + " ");
            pListe.next();
        }
    }

    public static void main(String[] args) {
        new InsertionSort();
    }
}