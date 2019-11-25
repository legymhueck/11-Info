/**
 *  Die Klasse BMW ist eine Kindsklasse der Klasse Auto, d. h. sie erweitert die Klasse Auto.
 *  Dies wird druch das Schlüsselwort extends verdeutlicht.
 *
 *  Mache die Klasse BMW zu einer Kindsklasse der Klasse Auto.
 *  IntelliJ meldet nun einen Fehler. Versuche, diesen zu beheben.
 *
 *  Notiere, wie IntelliJ den Code vervollständigt.
 *  Implementiere die Methode fahre(), indem du auf der Konsole etwas Sinnvolles ausdruckst.
 *  Erzeuge ein Objekt der Klasse in der Main-Methode.
 */
package lehnen._03PriorityQueue._02b_Auto_extends_LV;

public class BMW extends Auto {

    @Override
    void fahre() {
        System.out.println("Der BMW fährt 240 km/h. Yeah!");
    }

    public static void main(String[] args) {
        BMW bmw = new BMW();
        bmw.fahre();
    }
}
