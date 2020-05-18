package lehnen._08NichtLineareDatenstrukturen._07Morsebaum._03GesamterMorsebaum;

import resources._01NRW._01Datenstrukturklassen._02Baum.BinaryTree;

public class MorseTree {

    /**
     * Den Baum von unten her aufbauen
     * Auf der 3. Ebene den linken und rechten Teilbaum hinzufügen (Kleinbuchstaben)
     *
     * @return der MorseBaum
     */
    public BinaryTree<String> baumBauen() {
        // 4. Ebene
        BinaryTree<String> h = new BinaryTree<String>("H");
        BinaryTree<String> v = new BinaryTree<String>("V");
        BinaryTree<String> f = new BinaryTree<String>("F");
        //BinaryTree<String> ue = new BinaryTree<String>("Ü");
        BinaryTree<String> l = new BinaryTree<String>("L");
        //BinaryTree<String> ae = new BinaryTree<String>("Ä");
        BinaryTree<String> p = new BinaryTree<String>("P");
        BinaryTree<String> j = new BinaryTree<String>("J");
        BinaryTree<String> b = new BinaryTree<String>("B");
        BinaryTree<String> x = new BinaryTree<String>("X");
        BinaryTree<String> c = new BinaryTree<String>("C");
        BinaryTree<String> y = new BinaryTree<String>("Y");
        BinaryTree<String> q = new BinaryTree<String>("Q");
        BinaryTree<String> z = new BinaryTree<String>("Z");
        //BinaryTree<String> oe = new BinaryTree<String>("Ö");
        BinaryTree<String> ch = new BinaryTree<String>("CH");

        // 3. Ebene
        BinaryTree<String> s = new BinaryTree<String>("S", h, v);
        BinaryTree<String> u = new BinaryTree<String>("U", f, null);
        BinaryTree<String> r = new BinaryTree<String>("R", l, null);
        BinaryTree<String> w = new BinaryTree<String>("W", p, j);
        BinaryTree<String> d = new BinaryTree<String>("D", b, x);
        BinaryTree<String> k = new BinaryTree<String>("K", c, y);
        BinaryTree<String> g = new BinaryTree<String>("G", q, z);
        BinaryTree<String> o = new BinaryTree<String>("O", null, null);


        // 2. Ebene
        BinaryTree<String> i = new BinaryTree<String>("I", s, u);
        BinaryTree<String> a = new BinaryTree<String>("A", r, w);
        BinaryTree<String> n = new BinaryTree<String>("N", d, k);
        BinaryTree<String> m = new BinaryTree<String>("M", g, o);

        // 1. Ebene
        BinaryTree<String> e = new BinaryTree<String>("E", i, a);
        BinaryTree<String> t = new BinaryTree<String>("T", n, m);

        // Wurzel
        return new BinaryTree<String>("/", e, t);
    }
}
