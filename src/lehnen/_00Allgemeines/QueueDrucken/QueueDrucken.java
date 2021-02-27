package lehnen._00Allgemeines.QueueDrucken;

import resources._01NRW._01Datenstrukturklassen._01Linear.Queue;

public class QueueDrucken {
    private final Queue<String> meineQueue = new Queue<>();

    private void printQueue(Queue<String> pQueue) {
        Queue<String> tmp = new Queue<>();
        // Queue leeren und in temp-Queue kopieren
        while (!pQueue.isEmpty()) {
            String tmpString = pQueue.front();
            pQueue.dequeue();

            System.out.println(tmpString);

            tmp.enqueue(tmpString);
        }
        // tmpQueue wieder zurück in die leere Original-Queue kopieren
        while (!tmp.isEmpty()) {
            String tmpString = tmp.front();
            tmp.dequeue();
            pQueue.enqueue(tmpString);
        }
    }

    public static void main(String[] args) {
        new QueueDrucken().start();
    }

    private void start() {
        System.out.println("Queue VOR enqueue:");
        printQueue(meineQueue);
        System.out.println("Queue NACH enqueue:");
        meineQueue.enqueue("Jan");
        meineQueue.enqueue("Marius");
        meineQueue.enqueue("Fabian");
        meineQueue.enqueue("Angelika");
        printQueue(meineQueue);
    }
}

