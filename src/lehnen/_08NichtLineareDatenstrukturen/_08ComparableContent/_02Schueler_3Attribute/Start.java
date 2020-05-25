package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._02Schueler_3Attribute;

public class Start {

    public Start() {

    }

    public static void main(String[] args) {
        Schueler michael = new Schueler("Tim", "Mälzer", "Q1");
        Schueler andrea = new Schueler("Heinz", "Becker", "EF");
        System.out.println(michael.toString() + "\tisLess\t\t" + andrea.toString() + ":\t" + michael.isLess(andrea));
        System.out.println(michael.toString() + "\tisEqual\t\t" + andrea.toString() + ":\t" + michael.isEqual(andrea));
        System.out.println(michael.toString() + "\tisGreater\t" + andrea.toString() + ":\t" + michael.isGreater(andrea));
    }
}
