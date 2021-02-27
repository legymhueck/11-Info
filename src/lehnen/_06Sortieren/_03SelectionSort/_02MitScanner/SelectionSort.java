package lehnen._06Sortieren._03SelectionSort._02MitScanner;

import resources._01NRW._01Datenstrukturklassen._01Linear.List;

import java.util.Scanner;

public class SelectionSort {
    private List<Integer> meineliste;

    public SelectionSort() {
        meineliste = new List<>();
        listeMitBenutzereingabeFuellen();
        System.out.println("Unsortierte Liste:");
        drucken(meineliste);
        selectionSort();
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

    public void selectionSort() {
        List<Integer> hilfsListeSortiert = new List<Integer>();
        while (!meineliste.isEmpty()) {
            // kleinstes Element in unsortierter Liste heraussuchen
            meineliste.toFirst();
            int kleinstes = meineliste.getContent(); // Zunächst annehmen, dass das 1. Element das kleinste ist
            meineliste.next();
            while (meineliste.hasAccess()) {
                int aktuelles = meineliste.getContent();
                if (aktuelles < kleinstes) {
                    kleinstes = aktuelles;
                }
                meineliste.next();
            }
            // kleinstes Element aus Liste löschen
            meineliste.toFirst();
            boolean gefunden = false;
            while (meineliste.hasAccess() && gefunden == false) {
                if (meineliste.getContent() == kleinstes) {
                    meineliste.remove();
                    gefunden = true;
                }
                meineliste.next();
            }
            hilfsListeSortiert.append(kleinstes);
        }
        meineliste = hilfsListeSortiert; // da die Originalliste leer ist, die Hilfsliste in die Originalliste speichern
    }


    private void drucken(List<Integer> pListe) {
        pListe.toFirst(); // damit ist hasAccess == true
        while (pListe.hasAccess()) {
            System.out.print(pListe.getContent() + " ");
            pListe.next();
        }
    }

    public static void main(String[] args) {
        new SelectionSort();
    }
}