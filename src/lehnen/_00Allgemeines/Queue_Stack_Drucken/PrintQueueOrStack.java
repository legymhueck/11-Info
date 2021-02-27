package lehnen._00Allgemeines.Queue_Stack_Drucken;

import resources._01NRW._01Datenstrukturklassen._01Linear.Queue;
import resources._01NRW._01Datenstrukturklassen._01Linear.Stack;

public class PrintQueueOrStack {
    private Queue<String> meineQueue = new Queue<>();
    private Stack<String> meinStack = new Stack<>();


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

    private void printStack(Stack<String> pStack) {
        Stack<String> tmp = new Stack<>();
        // Queue leeren und in temp-Queue kopieren
        while (!pStack.isEmpty()) {
            String tmpString = pStack.top();
            pStack.pop();

            System.out.println(tmpString);

            tmp.push(tmpString);
        }
        // tmpStack wieder zurück in die leere Original-Stack kopieren
        while (!tmp.isEmpty()) {
            String tmpString = tmp.top();
            tmp.pop();
            pStack.push(tmpString);
        }
    }

    public static void main(String[] args) {
        new PrintQueueOrStack().start();
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

        System.out.println("-----------------------");
        System.out.println("Stack VOR push:");
        printStack(meinStack);
        System.out.println("Stack NACH push:");
        meinStack.push("Eric");
        meinStack.push("Eray");
        meinStack.push("Felix");
        printStack(meinStack);

    }
}
