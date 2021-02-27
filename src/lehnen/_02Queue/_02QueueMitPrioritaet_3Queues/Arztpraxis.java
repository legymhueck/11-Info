package lehnen._02Queue._02QueueMitPrioritaet_3Queues;

import resources._01NRW._01Datenstrukturklassen._01Linear.Queue;

public class Arztpraxis {
    private Queue<Patient> warteSchlange1;
    private Queue<Patient> warteSchlange2;
    private Queue<Patient> warteSchlange3;

    public Arztpraxis() {
        warteSchlange1 = new Queue<>();
        warteSchlange2 = new Queue<>();
        warteSchlange3 = new Queue<>();
    }

    public void test() {
        patient_anmelden("Buhl", "Dorina", 1);
        patient_anmelden("Krekelberg", "Arnold", 2);
        patient_anmelden("Sanders-Edel", "Gundi", 3);
        patient_anmelden("Schneider", "Felix", 1);

        System.out.println("Die Warteschlange:\n");
        print();

        Patient p = patient_aufrufen();
        System.out.println("\nDer nächste bitte: " + p.toString());
    }

    public void patient_anmelden(String pVorname, String pNachname, int pPrioritaet) {
        Patient p = new Patient(pVorname, pNachname, pPrioritaet);
        switch (pPrioritaet) {
            case 1:
                warteSchlange1.enqueue(p);
                break;
            case 2:
                warteSchlange2.enqueue(p);
                break;
            default:
                warteSchlange3.enqueue(p);
        }
    }

    public Patient patient_aufrufen() {
        Patient p;
        if (!warteSchlange1.isEmpty()) {
            p = warteSchlange1.front();
            warteSchlange1.dequeue();
        } else if (!warteSchlange2.isEmpty()) {
            p = warteSchlange2.front();
            warteSchlange2.dequeue();
        } else {
            p = warteSchlange3.front();
            warteSchlange3.dequeue();
        }
        return p;
    }

    public void print(){
        System.out.println("Patienten der Priorität 1:");
        printQueue(warteSchlange1);

        System.out.println("\nPatienten der Priorität 2:");
        printQueue(warteSchlange2);

        System.out.println("\nPatienten der Priorität 3:");
        printQueue(warteSchlange3);
    }

    private void printQueue(Queue<Patient> pQueue) {
        Queue<Patient> tmp = new Queue<>();
        // Queue leeren und in temp-Queue kopieren
        while (!pQueue.isEmpty()) {
            Patient p = pQueue.front();
            pQueue.dequeue();

            System.out.println(p.toString());

            tmp.enqueue(p);
        }
        // tmp-Queue wieder zurück in die leere Originalqueue kopieren
        while (!tmp.isEmpty()) {
            Patient p = tmp.front();
            tmp.dequeue();
            pQueue.enqueue(p);
        }
    }

    public static void main(String[] args) {
        Arztpraxis arztpraxis = new Arztpraxis();
        arztpraxis.test();
    }
}
