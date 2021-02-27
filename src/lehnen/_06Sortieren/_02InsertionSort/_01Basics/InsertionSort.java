package lehnen._06Sortieren._02InsertionSort._01Basics;

import resources._01NRW._01Datenstrukturklassen._01Linear.List;

public class InsertionSort {
    private List<Integer> liste = new List<>();


    public InsertionSort() {
        liste.append(7);
        liste.append(13);
        liste.append(2);
        liste.append(36);
        liste.append(203);
        liste.append(8);
        liste.append(12);
    }

    public void insertionSort() {
        List<Integer> sortierteListe = new List<Integer>();
        while (!liste.isEmpty()) {
            liste.toFirst();
            int akt = liste.getContent();

            sortierteListe.toFirst();
            while (sortierteListe.hasAccess() && sortierteListe.getContent() < akt) {
                sortierteListe.next();
            }
            if (sortierteListe.hasAccess()) {
                sortierteListe.insert(akt); // sortierteListe ist nicht leer und es muss hinten angefügt werden; das kann insert nicht!
            } else {
                sortierteListe.append(akt); // daher muss append aufgerufen werden
            }
            liste.remove();
        }
        liste = sortierteListe;
    }

    private void drucken() {
        liste.toFirst(); // damit ist hasAccess == true
        while (liste.hasAccess()) {
            System.out.print(liste.getContent() + " | ");
            liste.next();
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.drucken();
        insertionSort.insertionSort();
        System.out.println("\n");
        insertionSort.drucken();
    }
}
