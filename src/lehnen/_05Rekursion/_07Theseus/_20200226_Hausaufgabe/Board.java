package lehnen._05Rekursion._07Theseus._20200226_Hausaufgabe;

public class Board {
    private final int boardWidth;
    private final int boardHeight;
    private State[][] board;
    private int activeX;
    private int activeY;
    private boolean bStop;

    public Board(int pWidth, int pHeight) {
        boardWidth = pWidth;
        boardHeight = pHeight;
        board = new State[boardWidth][boardHeight];
        activeX = -1;       // outside board
        activeY = -1;       // outside board
        bStop = false;

        clear();
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public void stop() {
        bStop = true;
    }

    public boolean isStopped() {
        return bStop;
    }

    public void clear() {
        for (int x = 0; x < getBoardWidth(); x++) {
            for (int y = 0; y < getBoardHeight(); y++) {
                setState(x, y, State.FREE);
            }
        }
    }

    public void reset() {
        bStop = false;

        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardHeight; y++) {
                if ((board[x][y] == State.POSSIBLE) || (board[x][y] == State.IMPOSSIBLE)) {
                    board[x][y] = State.FREE;
                }
            }
        }
    }

    public void generateBlockedCells(double pPercent) {
        clear();
        for (int i = 0; i < getBoardWidth(); i++) {
            for (int j = 0; j < getBoardHeight(); j++) {

                if ((i == 0 && j == 0) || (i == getBoardWidth() - 1 && j == getBoardHeight() - 1)) {
                    // oben links oder unten rechts ist immer frei
                    setState(i, j, State.FREE);
                } else if (Math.random() < pPercent / 100) {
                    setState(i, j, State.BLOCKED);
                }
            }
        }
    }

    // State FREE:       (weiß)    noch nicht besucht
    // State POSSIBLE:   (grün)    besucht, möglicherweise richtig
    // State IMPOSSIBLE: (rot)     besucht und ausgeschlossen
    // State BLOCKED:    (schwarz) blockiert
    public void setState(int pX, int pY, State pStatus) {
        if (insideBoard(pX, pY)) {
            board[pX][pY] = pStatus;
        }
    }

    public boolean insideBoard(int pX, int pY) {
        return (pX >= 0 && pX < boardWidth) && (pY >= 0 && pY < boardHeight);
    }

    public boolean isTargetFound(int pX, int pY) {
        return (pX == boardWidth - 1) && (pY == boardHeight - 1);
    }

    public State getState(int pX, int pY) {
        return insideBoard(pX, pY) ? board[pX][pY] : State.BLOCKED;
    }

    public boolean stepPossible(int pX, int pY) {
        return insideBoard(pX, pY) && (getState(pX, pY) == State.FREE);
    }
}