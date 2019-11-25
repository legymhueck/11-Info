/**
 * Implementiere das Interface Auto!
 * Schreibe dazu hinter BMW das Schlüsselwort 'implements'
 *
 * IntelliJ meldet nun einen Fehler.
 * Folge den Anweisungen und lasse IntelliJ automatisch die notwendigen Methoden implementieren.
 *
 * Deklariere nun ein privates Attribut kilomenterstand.
 * Die Methode fahre(int pKilometer) verändert das Attribut.
 * Schreibe zudem eine get-Funktion für den Kilometerstand.
 *
 */
package lehnen._03PriorityQueue._01b_Auto_implements_LV.Auto;

public class BMW implements Auto {
    private int kilometerstand;

    @Override
    public void fahre(int pKilometer) {
        kilometerstand += pKilometer;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }
}
