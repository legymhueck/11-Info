package lehnen._02Queue._03Marius_OhnePrioritaet_1Queue;

public class Patient {
    private String vorname;
    private String nachname;
    private int prioritaet;

    public Patient(String pVorname, String pNachname, int pPrioritaet) {
        vorname = pVorname;
        nachname = pNachname;
        prioritaet = pPrioritaet;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getPrioritaet() {
        return prioritaet;
    }

    public String toString() {
        return vorname + ", " + nachname + " (" + prioritaet + ")";
    }


}
