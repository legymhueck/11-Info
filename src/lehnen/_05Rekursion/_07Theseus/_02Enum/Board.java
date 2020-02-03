package lehnen._05Rekursion._07Theseus._02Enum;

import java.util.Scanner;

public class Board {
    private State[][] boardState;

    public Board() {
        boardState = new State[4][4];
    }

    public void populateBoardState(double pPercent) {
        for (int x = 0; x < boardState.length; x++) {
            for (int y = 0; y < boardState[x].length; y++) {
                if (Math.random() < (pPercent / 100)) {
                    boardState[x][y] = State.BLOCKED;
                }
            }
        }
    }

    public void printBoardState() {
        for (int x = 0; x < boardState.length; x++) {
            System.out.println();
            for (int y = 0; y < boardState[x].length; y++) {

                System.out.print(boardState[x][y] + "\t\t");
            }
        }
    }

    private double prozentzahlEinlesen() {
        return new Scanner(System.in).nextDouble();

    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.print("Percent BLOCKED?: ");

        board.populateBoardState((board.prozentzahlEinlesen()));
        board.printBoardState();
    }
}
