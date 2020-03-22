package lehnen._05Rekursion._07Theseus._Loesung;

public class Rekursion {
    private MainView mainView;
    private Board board;

    public Rekursion(MainView pMainview) {
        mainView = pMainview;
        board = pMainview.getBoard();
    }

    public boolean findWay(int pX, int pY) {

        if (board.isStopped()) {
            return false;
        }

        board.setState(pX, pY, State.POSSIBLE); // den Weg zurück blockieren
        mainView.drawCell(pX, pY);

        try {
            Thread.sleep(Integer.parseInt(mainView.getTf_speed().getText()));
        } catch (Exception ex) {

        }

        if (board.isTargetFound(pX, pY)) {
            return true;
        } else if ((board.stepPossible(pX + 1, pY) && findWay(pX + 1, pY)) ||   /* rechts */
                (board.stepPossible(pX, pY + 1) && findWay(pX, pY + 1)) ||      /* unten */
                (board.stepPossible(pX - 1, pY) && findWay(pX - 1, pY)) ||      /* links */
                (board.stepPossible(pX, pY - 1) && findWay(pX, pY - 1))) {      /* oben */
            return true;

        } else {
            if (!board.isStopped()) {
                board.setState(pX, pY, State.IMPOSSIBLE);
                mainView.drawCell(pX, pY);
            }
            return false;
        }
    }
}
