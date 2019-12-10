package lehnen._04Stack._02Bahnhof_GUI;

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

    public void loeschen() {
        while (gleis.top() != null){
            gleis.pop();
        }
    }
}
