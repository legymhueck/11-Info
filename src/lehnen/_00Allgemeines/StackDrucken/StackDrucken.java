package lehnen._00Allgemeines.StackDrucken;

import resources._01NRW._01Datenstrukturklassen._01Linear.Stack;

public class StackDrucken {
    private final Stack<String> meinStack = new Stack<>();

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
        new StackDrucken().start();
    }

    private void start() {
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
