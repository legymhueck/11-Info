package lehnen._04Stack._01Bahnhof_Konsole;

public class RangierBahnhof {
    private Gleis gleisA;
    private Gleis gleisB;
    private Gleis gleisC;

    public RangierBahnhof(){
        gleisA = new Gleis("A");
        gleisB = new Gleis("B");
        gleisC = new Gleis("C");

        initialize();
    }

    private void initialize(){
        gleisA.wagonAbstellen(new Wagon(16));
        gleisA.wagonAbstellen(new Wagon(11));
        gleisA.wagonAbstellen(new Wagon(15));
        gleisA.wagonAbstellen(new Wagon(14));
    }

    public void rangieren(){
        print();

        while (!(gleisA.istLeer() && gleisC.istLeer())) {
            if (!gleisA.istLeer() &&
                    (gleisB.istLeer() || gleisA.getFirstWagonNumber() > gleisB.getFirstWagonNumber()) &&
                    (gleisC.istLeer() || gleisA.getFirstWagonNumber() < gleisC.getFirstWagonNumber())) {
                rangiereWagon(gleisA, gleisB);
            } else if (!gleisC.istLeer() &&
                    (gleisA.istLeer() || gleisC.getFirstWagonNumber() < gleisA.getFirstWagonNumber()) &&
                    (gleisB.istLeer() || gleisC.getFirstWagonNumber() > gleisB.getFirstWagonNumber())) {
                rangiereWagon(gleisC, gleisB);
            } else if (!gleisB.istLeer() &&
                    (!gleisA.istLeer() && gleisB.getFirstWagonNumber() > gleisA.getFirstWagonNumber())) {
                rangiereWagon(gleisB, gleisC);
            } else if (!gleisA.istLeer()){
                rangiereWagon(gleisA, gleisC);
            } else {
                System.out.println("Ups! Da haben wir wohl was vergessen!");
            }
        }
        print();
    }

    public void rangiereWagon(Gleis source, Gleis destination){
        Wagon w = source.wagonHolen();
        destination.wagonAbstellen(w);

        System.out.println("Rangiere Wagon Nr. " + w.getNumber() + " from " + source.getName() + " to " + destination.getName());
    }

    private void print(){
        System.out.println("\n");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(gleisA.toString());
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(gleisB.toString());
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(gleisC.toString());
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        RangierBahnhof bhf = new RangierBahnhof();
        bhf.rangieren();
    }
}
