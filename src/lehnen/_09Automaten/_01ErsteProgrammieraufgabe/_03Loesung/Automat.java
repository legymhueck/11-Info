package lehnen._09Automaten._01ErsteProgrammieraufgabe._03Loesung;

import java.util.Scanner;

public class Automat {
    private int zustand;

    public Automat() {
        zustand = 0;
    }

    // Implementation mit verschachtelten switch ... case
    private void naechsterZustand(char pEingabe) {
        switch (zustand) {
            case 0: {
                switch (pEingabe) {
                    case 'a':
                        zustand = 1;
                        break;
                    case 'b':
                        zustand = 3;
                        break;
                }
            }
            break;

            case 1: {
                switch (pEingabe) {
                    case 'a':
                        zustand = 2;
                        break;
                    case 'b':
                        zustand = 0;
                        break;
                }
            }
            break;

            case 2: {
                switch (pEingabe) {
                    case 'a':
                        zustand = 3;
                        break;
                    case 'b':
                        zustand = 1;
                        break;
                }
            }
            break;

            case 3: {
                switch (pEingabe) {
                    case 'a':
                        zustand = 0;
                        break;
                    case 'b':
                        zustand = 2;
                        break;
                }
            }
            break;
            default:
                throw new IllegalStateException("Nicht erwartete Eingabe: " + zustand);
        }
    }

    // Implementation mit verschachtelter if-Abfrage
    private void naechsterZustandIf(char pEingabe) {
        if (zustand == 0) {
            if (pEingabe == 'a') {
                zustand = 1;
            } else if (pEingabe == 'b') {
                zustand = 3;
            }
        } else if (zustand == 1) {
            if (pEingabe == 'a') {
                zustand = 2;
            } else if (pEingabe == 'b') {
                zustand = 0;
            }
        } else if (zustand == 2) {
            if (pEingabe == 'a') {
                zustand = 3;
            } else if (pEingabe == 'b') {
                zustand = 1;
            }
        } else if (zustand == 3) {
            if (pEingabe == 'a') {
                zustand = 0;
            } else if (pEingabe == 'b') {
                zustand = 2;
            }
        }
    }

    public boolean pruefeEingabe(String pEingabe) {
        boolean akzeptiert = false;
        // Auf Startzustand zurück
        zustand = 0;

        for (int i = 0; i < pEingabe.length(); i++) {
            naechsterZustandIf(pEingabe.charAt(i));
        }
        // Prüfung: ist der Endzustand erreicht?
        if (zustand == 3) {
            akzeptiert = true;
        }
        return akzeptiert;
    }

    public static void main(String[] args) {
        System.out.print("Welches Eingabe möchten Sie prüfen? ");
        String zuPruefendesWort = new Scanner(System.in).nextLine();

        if (new Automat().pruefeEingabe(zuPruefendesWort)) {
            System.out.println("Die Eingabe wurde akzeptiert");
        } else {
            System.out.println("Die Eingabe wurde NICHT akzeptiert");
        }
    }
}

