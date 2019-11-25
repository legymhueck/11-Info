package lehnen._03PriorityQueue._04a_Arztpraxis_LV;

public class Patient extends PriorityObject {
    String name;

    public Patient(int pPriority, String pName) {
        super(pPriority);
        name = pName;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return(name + "\n " + "Priorität: " + getPriority());
    }
}
