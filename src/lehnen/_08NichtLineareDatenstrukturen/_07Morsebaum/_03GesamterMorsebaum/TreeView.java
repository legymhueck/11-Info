package lehnen._08NichtLineareDatenstrukturen._07Morsebaum._03GesamterMorsebaum;

import java.awt.*;
import javax.swing.*;
import resources._01NRW._01Datenstrukturklassen._02Baum.BinaryTree;
/**
 * Eine grafische Darstellung von Binaerbaeumen auf einer Canvas
 */
public class TreeView extends JFrame{
    private int breite;
    private int hoehe;
    private BinaryTree baum;
    private final int vertikalerAbstand = 50;

    /**
     * Konstruktor für Objekte der Klasse TreeView
     *
     * @param pBreite die Breite der Canvas
     * @param pHoehe  die Hoehe der Canvas
     * @baum der darzustellende Baum
     */
    public TreeView(int pBreite, int pHoehe, BinaryTree pBaum) {
        // Instanzvariable initialisieren
        breite = pBreite;
        hoehe = pHoehe;
        baum = pBaum;
    }

    /**
     * Die Canvas wird neu gezeichnet.
     *
     * @param g der "Stift"
     */
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.clearRect(0, 0, breite, hoehe);
        Object wurzel = baum.getContent();
        g.setColor(Color.black);
        if (!baum.isEmpty()) {
            zeichneBaum(g, baum, breite / 2, vertikalerAbstand, 2);
        }
    }

    /**
     * Es wird ein Teilbaum gezeichnet.
     *
     * @param g   der "Stift"
     * @param b   der zu zeichnende Teilbaum
     * @param x   die x-Koordinate der Wurzel des Teilbaums
     * @param y   die y-Koordinate des Wurzel des Teilbaums
     * @param anz maximale Anzahl der Teilbaeume fuer das folgende Level
     */
    private void zeichneBaum(Graphics g, BinaryTree b, int x, int y, int anz) {
        Object wurzel = b.getContent();
        g.fillOval(x - 2, y - 2, 4, 4);
        g.drawString(wurzel.toString(), x + 4, y + 2);

        BinaryTree links = b.getLeftTree();
        if (!links.isEmpty()) {
            int xNeu = x - (int) (breite / Math.pow(2, anz));
            int yNeu = y + vertikalerAbstand;
            g.drawLine(x, y, xNeu, yNeu);
            zeichneBaum(g, links, xNeu, yNeu, anz + 1);
        }

        BinaryTree rechts = b.getRightTree();
        if (!rechts.isEmpty()) {
            int xNeu = x + (int) (breite / Math.pow(2, anz));
            int yNeu = y + vertikalerAbstand;
            g.drawLine(x, y, xNeu, yNeu);
            zeichneBaum(g, rechts, xNeu, yNeu, anz + 1);
        }
    }
}