package _02Queue._03Marius_OhnePrioritaet_1Queue;


import _00NRW.Queue;

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

    public void ausdrucken(Patient pPatient) {
        System.out.println(pPatient.toString());
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
        a.test(a.patient_aufrufen()); //testrun
    }
}
