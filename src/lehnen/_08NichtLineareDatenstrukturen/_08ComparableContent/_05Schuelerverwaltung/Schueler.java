package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._05Schuelerverwaltung;

import resources._01NRW._01Datenstrukturklassen._02Baum.ComparableContent;

public class Schueler implements ComparableContent<Schueler> {
    private String vorname;
    private String nachname;
    private String email;


    public Schueler(String pVorname, String pNachname, String pEmail) {
        vorname = pVorname;
        nachname = pNachname;
        email = pEmail;
    }

    @Override
    public boolean isGreater(Schueler pContent) {

        if (nachname.compareTo(pContent.nachname) > 0) {
            return true;
        }

        if (nachname.equals(pContent.nachname) && (vorname.compareTo(pContent.vorname) > 0)) {
            return true;
        }

        if (nachname.equals(pContent.nachname) && vorname.equals(pContent.vorname) && (email.compareTo(pContent.email) > 0)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEqual(Schueler pContent) {
        return (nachname.equals(pContent.nachname) && vorname.equals(pContent.vorname) && email.equals(pContent.email));
    }

    @Override
    public boolean isLess(Schueler pContent) {
        if (nachname.compareTo(pContent.nachname) < 0) {
            return true;
        }

        if (nachname.equals(pContent.nachname) && (vorname.compareTo(pContent.vorname) < 0)) {
            return true;
        }

        if (nachname.equals(pContent.nachname) && vorname.equals(pContent.vorname) && (email.compareTo(pContent.email) < 0)) {
            return true;
        }
        return false;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getEmail() {
        return email;
    }
}
