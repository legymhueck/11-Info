package lehnen._05Rekursion._07Theseus._20200226_Hausaufgabe;

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

        // Programmiere hier den Basisfall
        // Falls der Weg gefunden wurde, true zurückgeben
        if (board.isTargetFound(pX, pY)) {
            return true;
        /* Andernfalls,
            rechts testen, ob frei ist (und man im Board ist), und die Methode rekursiv für rechts aufrufen
            ODER
            unten testen, ob frei ist (und man im Board ist), und die Methode rekursiv für unten aufrufen
            ODER
            links testen, ob frei ist (und man im Board ist), und die Methode rekursiv für links aufrufen
            ODER
            oben testen, ob frei ist (und man im Board ist) und die Methode rekursiv für oben aufrufen
         */
        } else if (true) { // true im Klammern natürlich ändern
            return true;

            // Andernfalls, falls nichts funktionierte...,
            // falls das board noch nicht gestoppt wurde
            // die Zelle(n) auf State.IMPOSSIBLE setzen
            // und die Zelle rot färben: mainView.drawCell(pX, pY);
        } else {

        }
        return false;
    }
}
