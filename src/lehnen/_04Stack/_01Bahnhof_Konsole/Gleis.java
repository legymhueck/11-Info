package lehnen._04Stack._01Bahnhof_Konsole;

public class Gleis {
    private Stack<Wagon> gleis;
    private String name;

    public Gleis(String pName){
        gleis = new Stack<Wagon>();
        name = pName;
    }

    public boolean istLeer(){
        return gleis.isEmpty();
    }

    public String getName(){
        return name;
    }

    public Wagon wagonHolen(){
        Wagon wagon =  gleis.top();
        gleis.pop();
        return wagon;
    }

    public int getFirstWagonNumber(){
        if (!gleis.isEmpty()) {
            Wagon wagon = gleis.top();
            return wagon.getNumber();
        } else {
            return -1;
        }
    }

    @Override
    public String toString(){
        // 1. Stack temporär in umgekehrter Reihenfolge zwischenspeichern
        Stack<Wagon> temp = new Stack<Wagon>();
        while (!gleis.isEmpty()){
            Wagon w = gleis.top();
            gleis.pop();
            temp.push(w);
        }

        // 2. Stack wieder zurückschreiben und dabei die einzelnen Wagons ausgeben
        String strGleis = "| " + name + " | ";
        while (!temp.isEmpty()){
            Wagon w = temp.top();
            temp.pop();
            gleis.push(w);

            strGleis += w.getNumber() + " ";
        }

        return strGleis;
    }

    public void wagonAbstellen(Wagon pWagon){
        gleis.push(pWagon);
    }
}
