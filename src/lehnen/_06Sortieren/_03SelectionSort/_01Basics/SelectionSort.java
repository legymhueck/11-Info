package lehnen._06Sortieren._03SelectionSort._01Basics;

import lehnen._00Material._01NRW.List;

public class SelectionSort {
    private List<Integer> liste = new List<>();

    public SelectionSort() {
        liste.append(7);
        liste.append(13);
        liste.append(2);
        liste.append(36);
        liste.append(203);
        liste.append(8);
        liste.append(12);
    }

    public void selectionSort() {
        List<Integer> hilfsListeSortiert = new List<Integer>();
        while (!liste.isEmpty()) {
            // kleinstes Element in unsortierter Liste heraussuchen
            liste.toFirst();
            int kleinstes = liste.getContent(); // Zunächst annehmen, dass das 1. Element das kleinste ist
            liste.next();
            while (liste.hasAccess()) {
                int aktuelles = liste.getContent();
                if (aktuelles < kleinstes) {
                    kleinstes = aktuelles;
                }
                liste.next();
            }
            // kleinstes Element aus Liste löschen
            liste.toFirst();
            boolean gefunden = false;
            while (liste.hasAccess() && gefunden == false) {
                if (liste.getContent() == kleinstes) {
                    liste.remove();
                    gefunden = true;
                }
                liste.next();
            }
            hilfsListeSortiert.append(kleinstes);
        }
        liste = hilfsListeSortiert; // da die Originalliste leer ist, die Hilfsliste in die Originalliste speichern
    }

    private void drucken() {
        liste.toFirst(); // damit ist hasAccess == true
        while (liste.hasAccess()) {
            System.out.print(liste.getContent() + " | ");
            liste.next();
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.drucken();
        selectionSort.selectionSort();
        System.out.println("\n");
        selectionSort.drucken();
    }
}