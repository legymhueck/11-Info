package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._06ComparableInteger;

import resources._01NRW._01Datenstrukturklassen._02Baum.ComparableContent;

public class ComparableInteger implements ComparableContent<ComparableInteger> {
    private final int meinCI;

    public ComparableInteger(int pInt) {
        meinCI = pInt;
    }

    @Override
    public boolean isGreater(ComparableInteger pContent) {
        return meinCI > pContent.getMeinCI();
    }

    @Override
    public boolean isEqual(ComparableInteger pContent) {
        return meinCI == pContent.getMeinCI();
    }

    @Override
    public boolean isLess(ComparableInteger pContent) {
        return meinCI < pContent.getMeinCI();
    }

    public int getMeinCI() {
        return meinCI;
    }
}