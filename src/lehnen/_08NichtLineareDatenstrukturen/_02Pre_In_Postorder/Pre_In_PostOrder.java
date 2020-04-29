package lehnen._08NichtLineareDatenstrukturen._02Pre_In_Postorder;

import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.Baum;

public class Pre_In_PostOrder {

    public void preorder(Baum<Integer> pBaum) { // WLR

        if (pBaum.getInhalt() != null) { // W
            System.out.print(pBaum.getInhalt() + " | ");
        }
        if (pBaum.getLinkerTeilbaum() != null) { // L
            preorder(pBaum.getLinkerTeilbaum());
        }
        if (pBaum.getRechterTeilbaum() != null) { // R
            preorder(pBaum.getRechterTeilbaum());
        }
    }

    public void inorder(Baum<Integer> pBaum) { // LWR
        if (pBaum.getLinkerTeilbaum() != null) { // L
            inorder(pBaum.getLinkerTeilbaum());
        }
        if (pBaum.getInhalt() != null) { // W
            System.out.print(pBaum.getInhalt() + " | ");
        }
        if (pBaum.getRechterTeilbaum() != null) { // R
            inorder(pBaum.getRechterTeilbaum());
        }
    }

    public void postorder(Baum<Integer> pBaum) { //LRW
        if (pBaum.getLinkerTeilbaum() != null) { // L
            postorder(pBaum.getLinkerTeilbaum());
        }
        if (pBaum.getRechterTeilbaum() != null) { // R
            postorder(pBaum.getRechterTeilbaum());
        }
        if (pBaum.getInhalt() != null) { // W
            System.out.print(pBaum.getInhalt() + " | ");
        }
    }
}
