package lehnen._05Rekursion._04Fibonacci;

import java.util.Scanner;

/**
 * Die Fibonacci-Folge ist die unendliche Folge von natürlichen Zahlen.
 * Sie beginnt mit zweimal der Zahl 1.
 * Häufig - in moderner Schreibweise - zusätzlich mit einer führenden Zahl 0.
 *
 * Die darauf folgende Zahl ergibt sich aus der Summe BEIDER vorangehenden Fibonacci-Zahlen.
 *
 * Fibinacci-Folge: {0}, 1,   1,    2,    3,   5,   8,   13,   21,    34...
 * Berechnung                0+1   1+1   1+2  2+3  3+5   5+8   8+13   13+21
 *
 * Fibonacci von:    0   1    2     3     4    5    6     7     8      9
 *
 * Hieraus ergibt sich: fib(n) = fib(n - 1) + fin(n -2)
 *
 * Damit lässt sich einfach der Basisfall und der rekursive Aufruf ableiten:
 *
 * Falls n == 1 oder n == 2 ist, dann soll 1 zurückgegeben werden.
 *
 * Ansonsten sollen die beiden vorangehenden Berechnungen der Fibonacci-Folge addiert werden.
 * Es ist also nur möglich, die aktuelle Fibonacci-Zahl zu erhalten, wenn man die beiden
 * vorangehenden Fibonacci-Zahlen ermittelt hat, also:
 * fib(n - 1) und fib(n - 2)!
 */
public class Fibonacci {
    private int zahl;

    public int fibonacciRekursiv(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacciRekursiv(n - 1) + fibonacciRekursiv(n - 2);
        }
    }

    public int eingabeZahl() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ihre Zahl für die Fibonacci-Berechnung: ");
        zahl = scanner.nextInt();
        scanner.close();
        return zahl;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.zahl = f.eingabeZahl();
        System.out.println("Fibonacci von " + f.zahl + " ist " + f.fibonacciRekursiv(f.zahl));
    }
}
