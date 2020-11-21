package lehnen._10Datenbanken._01SQLite;

import resources._01NRW._02Datenbankklassen.SQLite.DatabaseConnector;

public class Beispiel_SQLite {
    public static void main(String[] args) {
  /* Ein Objekt der Klasse DatabaseConnector wird erstellt.
  SQLite verlangt als einzige Angabe den Namen der Datei!
  Die anderen Angaben sind irrelevant.
  */
        DatabaseConnector meinConnector = new DatabaseConnector("", 0, "src/resources/MySQLite_Datenbanken/Schuelerdaten.db", "", "");

  /*
  Eine SQL-Anweisung wird ausgeführt.
  */
        meinConnector.executeStatement("select * from Schueler");
  /*
  Zur Sicherheit sollten wir sehr häufig die Fehlermeldungen prüfen.
  */
        System.out.println(meinConnector.getErrorMessage());

  /*
  Das Ergebnis wird in der Konsole angezeigt.
  */
        for (int i = 0; i < meinConnector.getCurrentQueryResult().getRowCount(); i = i + 1) {

            for (int j = 0; j < meinConnector.getCurrentQueryResult().getColumnCount(); j = j + 1) {
                System.out.print(meinConnector.getCurrentQueryResult().getData()[i][j] + " ");
            }

            System.out.println();
        }

    }

}