package lehnen._03PriorityQueue._04a_Arztpraxis_LV;

public class PriorityQueue<ContentType extends PriorityObject> {

    /**
     * Eine Liste (PriorityQueue) wird deklariert.
     */
    public List<ContentType> liste;

    /**
     * Die PriorityQueue wird als neue (leere) Liste initialisiert.
     */
    public PriorityQueue() {
        liste = new List<ContentType>();
    }

    /**
     * Das als Parameter übergebene PriorityObject wird in die PriorityQueue eingefügt.<br><br>
     * Dabei gilt:<br>
     * Falls die PriorityQueue leer ist, wird das PriorityObject eingefügt.<br>
     * Falls die PriorityQueue nicht leer ist, wird das PriorityObject<br>
     * entsprechend der Ordnungs-Relation der PriorityObject-Klasse eingefügt.
     *
     * @param "Content": Das einzufügende PriorityObject.
     */
    public void insert(ContentType pPriorityObject) {

        if (liste.isEmpty() || pPriorityObject == null) {
            liste.insert(pPriorityObject);
        } else {
            liste.toFirst();
            while (liste.hasAccess() && !pPriorityObject.isLess(liste.getContent())) {
                liste.next();
            }
            if (liste.hasAccess()) {
                liste.insert(pPriorityObject);
            } else {
                liste.append(pPriorityObject);
            }
        }
    }

    /**
     * Die Anfrage liefert das erste Objekt der PriorityQueue.<br>
     * Die PriorityQueue bleibt unverändert.<br>
     * Falls die PriorityQueue leer ist, wird null zurückgegeben.
     *
     * @return das PriorityObject am Kopf der PriorityQueue
     */
    public ContentType front() {
        liste.toFirst();
        return liste.getContent();
    }

    /**
     * Das erste Objekt wird aus der PriorityQueue entfernt.<br>
     * Falls die PriorityQueue leer ist, wird sie nicht verändert.
     */
    public void dequeue() {
        if (!liste.isEmpty()) {
            liste.toFirst();
            liste.remove();
        }
    }

    /**
     * Wenn die PriorityQueue leer ist, liefert diese Anfrage true, sonst false.<br>
     *
     * @return true, falls die PriorityQueue leer ist, sonst false
     */
    public boolean isEmpty() {
        return liste.isEmpty();
    }

    /**
     * ********************************************************************************
     * Die als Parameter übergebene PriorityQueue wird in diese Queue eingefügt.<br>  *
     * Nach dem Einfügen ist die übergebene PriorityQueue leer.                       *
     *                                                                                *
     * @param dieAndereQueue wird in diese PriorityQueue eingefügt.                   *
     * ********************************************************************************
     */
    public void concat(PriorityQueue<ContentType> dieAndereQueue) {
        if (dieAndereQueue != null) {
            while (!dieAndereQueue.isEmpty()) {
                this.insert(dieAndereQueue.front());
                dieAndereQueue.dequeue();
            }
        }
    }

    /**
     * @return tmp - die aktuelle PriorityQueue (Prioritäten-Liste)
     */
    public PriorityQueue<ContentType> getQueue() {
        PriorityQueue<ContentType> temp = new PriorityQueue();

        liste.toFirst();

        while (!liste.isEmpty() && liste.hasAccess()) {
            ContentType ct = liste.getContent();
            temp.insert(ct);
            liste.next();
        }
        return temp;
    }
}
