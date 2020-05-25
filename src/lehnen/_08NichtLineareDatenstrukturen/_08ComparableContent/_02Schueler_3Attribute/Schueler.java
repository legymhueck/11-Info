package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._02Schueler_3Attribute;

import resources._01NRW._01Datenstrukturklassen._02Baum.ComparableContent;

public class Schueler implements ComparableContent<Schueler> {

    private String strNachname;
    private String strVorname;
    private String strKlasse;

    public Schueler(String pNachname, String pVorname, String pKlasse) {
        strNachname = pNachname;
        strVorname = pVorname;
        strKlasse = pKlasse;
    }

    @Override
    public boolean isGreater(Schueler pContent) {

        if (strNachname.compareTo(pContent.strNachname) > 0) {
            return true;
        }

        if (strNachname.equals(pContent.strNachname) && (strVorname.compareTo(pContent.strVorname) > 0)) {
            return true;
        }

        if (strNachname.equals(pContent.strNachname) && strVorname.equals(pContent.strVorname) && (strKlasse.compareTo(pContent.strKlasse) > 0)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEqual(Schueler pContent) {
        return (strNachname.equals(pContent.strNachname) && strVorname.equals(pContent.strVorname) && strKlasse.equals(pContent.strKlasse));
    }

    @Override
    public boolean isLess(Schueler pContent) {
        if (strNachname.compareTo(pContent.strNachname) < 0) {
            return true;
        }

        if (strNachname.equals(pContent.strNachname) && (strVorname.compareTo(pContent.strVorname) < 0)) {
            return true;
        }

        if (strNachname.equals(pContent.strNachname) && strVorname.equals(pContent.strVorname) && (strKlasse.compareTo(pContent.strKlasse) < 0)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return strNachname + ", " + strVorname + " (" + strKlasse + ")";
    }
}
