package _02Queue._04Marius_OhnePrioritaet_2Queue;


import _00NRW.Queue;

public class Arztpraxis {
    private Queue<Patient> warteSchlange1;
    private Queue<Patient> warteSchlange2;

    public Arztpraxis() {
        warteSchlange1 = new Queue<>();
        warteSchlange2 = new Queue<>();

    }

    public void patient_anmelden(String pVorname, String pNachname, int pPrioritaet) {
        Patient p = new Patient(pVorname, pNachname, pPrioritaet);
        warteSchlange1.enqueue(p);
    }

    public Patient patient_aufrufen() {
        Patient p = null;
        if (!warteSchlange1.isEmpty()) {
            p = warteSchlange1.front();
            warteSchlange2.enqueue(p);
            warteSchlange1.dequeue();
        }
        return p;
    }

    public void ausdrucken(Patient pPatient) {
        System.out.println(pPatient.toString());
        warteSchlange1.enqueue(pPatient);
        warteSchlange2.dequeue();
    }

    public void test(Patient pPatient) {
        System.out.println(pPatient);
    }

    public static void main(String[] args) {
        Arztpraxis a = new Arztpraxis();
        a.patient_anmelden("Marius", "Boehm", 3);
        a.patient_anmelden("Max", "Stepanov", 2);
        a.patient_anmelden("Fabian", "Jansen", 1);
        a.patient_anmelden("Michael", "Lehnen", 3);
        a.ausdrucken(a.patient_aufrufen());
        a.ausdrucken(a.patient_aufrufen());
        a.ausdrucken(a.patient_aufrufen());
        a.ausdrucken(a.patient_aufrufen());
    }
}
