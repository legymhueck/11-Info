package lehnen._00Allgemeines.Switch;

/*
    Dieses Programm testet, was passiert, wenn ein switch-Anweisung
     - ohne eine break-Anweisung ausgeführt wird
     - wenn es keine default-Anweisung gibt

    Eine switch-Anweisung wird nur dann verlassen, wenn
     - der Fall mit einer break-Anweisung abgeschlossen wird oder wenn kein weiterer Fall mehr folgt

    Ansonsten
     - werden auch die Anweisungen der nächsten Fälle (ggf. incl. default) ausgeführt, bis der "fall-through"
       nach unten entweder durch eine break-Anweisung gestoppt wird oder die switch-Anweisung endet.

    Das bedeutet:
     - trifft eine switch-Anweisung zu und folgt danach KEINE break-Anweisung, werden auch alle folgenden Anweisungen
       ausgeführt, auch wenn diese case-Fälle nicht zutreffen.

 */

class SwitchTestWithoutBreak {
    private void testSwitch(char pChar) {
        switch (pChar) {
            case 'a':
                System.out.println("a");
            case 'b':
                System.out.println("b");
            case 'c':
                System.out.println("c");
        }
    }
    public static void main(String[] args) {
        new SwitchTestWithoutBreak().start();

    }

    private void start() {
        System.out.println("Test mit 'a'");
        testSwitch('a');
        System.out.println("Begründung: 'a' ist true und ab diesem 'case' wird alles Weitere ausgeführt.\n\n");

        System.out.println("Test mit 'b'");
        testSwitch('b');
        System.out.println("Begründung: 'b' ist true und ab diesem 'case' wird alles Weitere ausgeführt.\n\n");

        System.out.println("Test mit 'c'");
        testSwitch('c');
        System.out.println("Begründung: 'c' ist true und ab diesem 'case' wird alles Weitere ausgeführt.\n\n");
    }
}

