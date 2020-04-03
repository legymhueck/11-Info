package lehnen._06Sortieren._03Objekte;

public class ObjekteSortieren {
    private Auto[] meineAutos;


    public ObjekteSortieren() {
        meineAutos = new Auto[6]; // Array anlegen; Alle Indices werden mit null bei Objekten belegt

        meineAutos[0] = new Auto("BMW X5", 2155);
        meineAutos[1] = new Auto("Nissan Pathfinder", 2155);
        meineAutos[2] = new Auto("Land Rover Discovery", 2155);
        meineAutos[3] = new Auto("Mitsubishi Pajero", 2155);
        meineAutos[4] = new Auto("Audi Q7", 2190);
        meineAutos[5] = new Auto("Mercedes Benz G-Klasse", 2190);

        ausgeben();
        System.out.println();
        bubbleSortAutos(meineAutos);
        ausgeben();
    }

    public static void main(String[] args) {
        new ObjekteSortieren();
    }

    public void bubbleSortAutos(Auto[] pAuto) {
        boolean swapped;
        for (int i = 0; i < pAuto.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < pAuto.length - i - 1; j++) {

                if ((pAuto[j].getGewicht() > pAuto[j + 1].getGewicht())) {
                    Auto temp = pAuto[j];
                    pAuto[j] = pAuto[j + 1];
                    pAuto[j + 1] = temp;

                } else if (pAuto[j].getGewicht() == pAuto[j + 1].getGewicht()) {
                    if (pAuto[j].getMarke().compareTo(pAuto[j + 1].getMarke()) > 0) {
                        Auto temp = pAuto[j + 1];
                        pAuto[j + 1] = pAuto[j];
                        pAuto[j] = temp;
                    }
                    swapped = true;
                }
            }
            // IF no two elements were swapped by inner loop, then break
            if (swapped == false) {
                break;
            }
        }
    }

    public void ausgeben() {
        for (int i = 0; i < meineAutos.length; i++) {
            System.out.println(meineAutos[i].getGewicht() + ", " + meineAutos[i].getMarke());
        }
    }
}
