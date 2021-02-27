package lehnen._02Queue._01QueueOhnePrioritaet_1Queue;

import resources._01NRW._01Datenstrukturklassen._01Linear.Queue;

public class Arztpraxis {
    private Queue<Patient> warteSchlange;

    public Arztpraxis() {
        warteSchlange = new Queue<>();
    }

    public void patient_anmelden(String pVorname, String pNachname, int pPrioritaet) {
        Patient p = new Patient(pVorname, pNachname, pPrioritaet);
        warteSchlange.enqueue(p);
    }

    public Patient patient_aufrufen() {
        Patient p = null;
        if (!warteSchlange.isEmpty()) {
            p = warteSchlange.front();
            warteSchlange.dequeue();
        }
        return p;
    }

    public void print() {
        Queue<Patient> tmp = new Queue<>();
        // Queue leeren und in temp-Queue kopieren
        while (!warteSchlange.isEmpty()) {
            // Patient speichern
            Patient p = warteSchlange.front();
            // Patient vorne entfernen
            warteSchlange.dequeue();
            // Patient ausdrucken
            System.out.println(p.toString());
            // Patient in die temporäre Warteschlange einfügen.
            tmp.enqueue(p);
        }
        /*
         * Nach der while-Schleife ist die Original-Queue leer und die tmp-Queue voll
         * Die tmp-Queue wird wieder zurück in die leere Original-Queue kopiert
         *
         */
        while (!tmp.isEmpty()) {
            Patient p = tmp.front();
            tmp.dequeue();
            warteSchlange.enqueue(p);
        }
    }

    public static void main(String[] args) {
        new Arztpraxis().start();
    }

    public void start() {
        patient_anmelden("Buhl", "Dorina", 1);
        patient_anmelden("Krekelberg", "Arnold", 2);
        patient_anmelden("Sanders-Edel", "Gundi", 3);
        patient_anmelden("Schneider", "Felix", 1);

        System.out.println("Die Warteschlange:");
        print();

        Patient p = patient_aufrufen();
        System.out.println("\nDer nächste bitte: " + p.toString());
    }
}

