/*
 * In der Klasse DatabaseConnector muss die Zeile: Class.forName("com.mysql.jdbc.Driver");
 * um cj erweitert werden, sodass sie so aussieht:
 * Class.forName("com.mysql.cj.jdbc.Driver");
 */
package lehnen._10Datenbanken._01MySQL;

import resources._01NRW._02Datenbankklassen.MySQL.DatabaseConnector;

public class Beispiel_MySQL {
    public static void main(String[] args) {
  /* Ein Objekt der Klasse DatabaseConnector wird erstellt.
     MySQL funktioniert mit XAMPP.
     pIP ist entweder der lokale Rechner, auf dem XAMPP läuft, also 127.0.0.1 oder ein entfernter Rechner, dessen
     ip in Windows mit ipconfig im Terminal nachgeschaut werden kann.
     Der pPort steht im "XAMPP Control Panel" unter Port(s).
     pDatabase ist der Datenbankname
     Unsere Datenbank hat zwei Benutzernamen:
       (1) root für Editieraufgaben. Das Passwort ist mein Nachname, klein geschrieben.
       (2) schueler für Datenbankabfragen nur mit Leserechten, PW 'gymhueck'
  */
        DatabaseConnector meinConnector = new DatabaseConnector("127.0.0.1", 3306, "schoeningh", "schueler", "gymhueck");

  /*
  Eine SQL-Anweisung wird ausgeführt.
  */
        meinConnector.executeStatement("select * from film");
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


