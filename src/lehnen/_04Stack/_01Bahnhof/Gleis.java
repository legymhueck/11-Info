package lehnen._04Stack._01Bahnhof;

public class Gleis {

    private Stack<Wagon> gleis;

    private String name;

    public Gleis(String pName) {
        gleis = new Stack<>();
        name = pName;
    }

    public Stack<Wagon> getGleis() {
        return gleis;
    }

    public String getName() {
        return name;
    }
}
