package lehnen._02Queue._06Wiederholung_Marius;
import resources._01NRW._01Datenstrukturklassen._01Linear.Queue;

public class Buero {

    private Queue<Person> warteschlange;
    private final int maxZeit;
    private final int minZeit;

    public Buero() {
        warteschlange = new Queue<>();
        maxZeit = 60;
        minZeit = 10;
    }

    public static void main(String[] args) {
        Buero b = new Buero();
        b.hintenAnstellen(new Person("Marius"));
        b.warteschlangeAnzeigen();
        b.einlassen();
        b.einlassen();
        b.hintenAnstellen(new Person("Lehnen"));
        b.hintenAnstellen(new Person("Max"));
        b.warteschlangeAnzeigen();
        b.einlassen();
        b.sprechstundeBeenden();
    }

    public void hintenAnstellen(Person pPerson) {
        warteschlange.enqueue(pPerson);
        System.out.println(pPerson.getName() + " stellt sich hinten an.");
    }

    public void einlassen() {
        if (!warteschlange.isEmpty()) {
            Person p = warteschlange.front();
            warteschlange.dequeue();
            System.out.println(p.getName() + " ist jetzt dran. Der Arzt brauchte " + zufallszahl() + " Minuten für den/die Patient/-in.");
        } else {
            System.out.println("Niemand da");
        }
    }

    public void sprechstundeBeenden() {
        while (!warteschlange.isEmpty()) {
            Person p = warteschlange.front();
            System.out.println(p.getName() + " wurde heute nicht behandelt.");
            warteschlange.dequeue();
        }
        System.out.println("Ist die Warteschlange leer: " + warteschlange.isEmpty());
    }

    public void warteschlangeAnzeigen() {
        Queue<Person> warteschlange2 = new Queue<>();
        if (!warteschlange.isEmpty()) {
            System.out.print("In der Warteschlange sind: ");
            while (!warteschlange.isEmpty()) {
                Person p = warteschlange.front();
                System.out.print(p.getName() + ", ");
                warteschlange2.enqueue(p);
                warteschlange.dequeue();
            }
            System.out.println("\n");
            warteschlange = warteschlange2;
        }
    }

    public int zufallszahl() {
        return (int) (Math.random() * (maxZeit - minZeit + 1)) + minZeit;
    }
}
