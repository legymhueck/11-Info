package lehnen._00Allgemeines.QueueMitListeDrucken;

import resources._01NRW._01Datenstrukturklassen._01Linear.List;
import resources._01NRW._01Datenstrukturklassen._01Linear.Queue;

public class QueueMitListeDrucken {
    Queue<String> meineQueue = new Queue<>();
    List<String> meineDruckListe = new List<>();

    private void writeQueueToList(Queue<String> pQueue, List<String> pList) {
        Queue<String> tmp = new Queue<>();
        // Queue leeren und in temp-Queue kopieren
        while (!pQueue.isEmpty()) {
            String tmpString = pQueue.front();
            pList.append(tmpString);
            pQueue.dequeue();

            tmp.enqueue(tmpString);
        }
        // tmpQueue wieder zurück in die leere Original-Queue kopieren
        while (!tmp.isEmpty()) {
            String tmpString = tmp.front();
            tmp.dequeue();
            pQueue.enqueue(tmpString);
        }
    }

    private void printList(List<String> pList) {
        pList.toFirst();
        while (pList.hasAccess()) {
            System.out.println(pList.getContent());
            pList.next();
        }
    }

    public static void main(String[] args) {
        new QueueMitListeDrucken().start();
    }

    private void start() {
        meineQueue.enqueue("Jan");
        meineQueue.enqueue("Max");
        meineQueue.enqueue("Eric");
        writeQueueToList(meineQueue, meineDruckListe);
        printList(meineDruckListe);
    }
}
