package lehnen._03PriorityQueue._03b_InterfaceImplementieren_LV;

public abstract class PriorityObject
        implements ComparableContent<PriorityObject>{

    private int priority;

    public PriorityObject(int pPriority) {
        priority = pPriority;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isEqual(PriorityObject pPriority) {
        return (priority == pPriority.priority);
    }

    public boolean isGreater(PriorityObject pPriority) {
        return (priority > pPriority.priority);
    }

    public boolean isLess(PriorityObject pPriority) {
        return (priority < pPriority.priority);
    }
}
