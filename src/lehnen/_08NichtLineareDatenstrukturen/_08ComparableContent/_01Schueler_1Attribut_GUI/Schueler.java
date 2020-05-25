package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._01Schueler_1Attribut_GUI;

import resources._01NRW._01Datenstrukturklassen._02Baum.ComparableContent;

public class Schueler implements ComparableContent<Schueler> {
    private String name;

    public Schueler(String pName) {
        name = pName;
    }

    @Override
    public boolean isGreater(Schueler pContent) {
        return name.compareTo(pContent.name) > 0;
    }

    @Override
    public boolean isEqual(Schueler pContent) {
        return name.compareTo(pContent.name) == 0;
    }

    @Override
    public boolean isLess(Schueler pContent) {
        return name.compareTo(pContent.name) < 0;
    }
}
