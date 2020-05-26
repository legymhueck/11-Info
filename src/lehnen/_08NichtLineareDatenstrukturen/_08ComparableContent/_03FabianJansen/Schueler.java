package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._03FabianJansen;

import resources._01NRW._01Datenstrukturklassen._02Baum.ComparableContent;

public class Schueler implements ComparableContent<Schueler> {

    private String vorname;
    private String nachname;
    private String klasse;


    public Schueler(String pVorname, String pKlasse, String pNachname) {
        vorname = pVorname;
        nachname = pNachname;
        klasse = pKlasse;
    }

    @Override
    public boolean isGreater(Schueler pContent) {
        if (nachname.compareTo(pContent.nachname) > 0) {
            return true;
        }
        if (nachname.equals(pContent.nachname) && vorname.compareTo(pContent.vorname) > 0) {
            return true;
        }
        if (nachname.equals(pContent.nachname) && vorname.equals(pContent.vorname) && klasse.compareTo(pContent.klasse) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEqual(Schueler pContent) {
        if (nachname.equals(pContent.nachname) && vorname.equals(pContent.vorname) && klasse.equals(pContent.klasse)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isLess(Schueler pContent) {
        if (nachname.compareTo(pContent.nachname) < 0) {
            return true;
        }
        if (nachname.equals(pContent.nachname) && vorname.compareTo(pContent.vorname) < 0) {
            return true;
        }
        if (nachname.equals(pContent.nachname) && vorname.equals(pContent.vorname) && klasse.compareTo(pContent.klasse) < 0) {
            return true;
        }
        return false;
    }

    public String getVorname() {
        return vorname;
    }

    public String getKlasse() {
        return klasse;
    }

    public String getNachname() {
        return nachname;
    }
}
