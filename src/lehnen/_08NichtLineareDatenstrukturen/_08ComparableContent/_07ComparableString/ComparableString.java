package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._07ComparableString;

import resources._01NRW._01Datenstrukturklassen._02Baum.ComparableContent;

public class ComparableString implements ComparableContent<ComparableString> {

    private final String meinComparableString;

    public ComparableString(String pString) {
        meinComparableString = pString;
    }

    @Override
    public boolean isGreater(ComparableString pContent) {
        return meinComparableString.compareTo(pContent.getMeinComparableString()) > 0;
    }

    @Override
    public boolean isEqual(ComparableString pContent) {
        return meinComparableString.compareTo(pContent.getMeinComparableString()) == 0;
    }

    @Override
    public boolean isLess(ComparableString pContent) {
        return meinComparableString.compareTo(pContent.getMeinComparableString()) < 0;
    }

    public String getMeinComparableString() {
        return meinComparableString;
    }
}