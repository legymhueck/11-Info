package lehnen._05Rekursion._01Palindrom;

public class TestStringMethoden {

    public TestStringMethoden() {

    }

    public static void main(String[] args) {
        TestStringMethoden testStringMethoden = new TestStringMethoden();
        testStringMethoden.testSubstring();
    }

    private void testSubstring() {
        String wort = "RENTNER";
        System.out.println(wort.substring(1, wort.length() - 1)); // vom 1. bis vorletzten Buchstaben
        System.out.println(wort.charAt(0));
        System.out.println(wort.substring(1, wort.length()) + wort.charAt(0));
        System.out.println(wort.substring(1));  // same as 1st AND last
    }
}
