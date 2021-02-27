package lehnen._02Queue._05Marius_MitPrioritaet_3Queues;


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

    public void patient_anmelden(String pVorname, String pNachname, int pPrioritaet) {
        Patient p = new Patient(pVorname, pNachname, pPrioritaet);
        switch (pPrioritaet) {
            case 1:
                warteSchlange1.enqueue(p);
                break;
            case 2:
                warteSchlange2.enqueue(p);
                break;
            case 3:
                warteSchlange3.enqueue(p);
                break;
        }
    }

    public Patient patient_aufrufen() {
        Patient p = null;
        if (!warteSchlange1.isEmpty()) {
            p = warteSchlange1.front();
            warteSchlange1.dequeue();
        } else if (!warteSchlange2.isEmpty()) {
            p = warteSchlange2.front();
            warteSchlange2.dequeue();
        } else if (!warteSchlange3.isEmpty()) {
            p = warteSchlange3.front();
            warteSchlange3.dequeue();
        }
        return p;
    }

    public void ausdrucken(Patient pPatient) {
        System.out.println(pPatient.toString());
    }

    public void test() {
        patient_anmelden("Marius", "Boehm", 1);
        patient_anmelden("Max", "Stepanov", 2);
        patient_anmelden("Fabian", "Jansen", 3);
        patient_anmelden("Michael", "Lehnen", 1);
        ausdrucken(patient_aufrufen());
        ausdrucken(patient_aufrufen());
        ausdrucken(patient_aufrufen());
        ausdrucken(patient_aufrufen());
    }

    public static void main(String[] args) {
        Arztpraxis a = new Arztpraxis();
        a.test();
    }
}
