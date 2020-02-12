package lehnen._04Stack._03_Bahnhof_GUI_modified;

public class Gleis {

    private Stack<Wagon> gleis;

    private String name;

    public Gleis(String pName) {
        gleis = new Stack<>();
        name = pName;
    }

    public void loeschen() {
        while (!gleis.isEmpty()){
            gleis.pop();
        }
    }

    public boolean istLeer() {
        return gleis.isEmpty();
    }

    public int getErsteWagonNummer(){
        if (!gleis.isEmpty()) {
            Wagon wagon = gleis.top();
            return wagon.getNummer();
        } else {
            return -1;
        }
    }

    public Wagon wagonHolen(){
        Wagon wagon = null;

        if (!gleis.isEmpty()) {
            wagon = gleis.top();
            gleis.pop();
        }
        return wagon;
    }

    public void wagonAbstellen(Wagon pWagon){
        gleis.push(pWagon);
    }

}
