package lehnen._08NichtLineareDatenstrukturen._02Pre_In_Postorder;

import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.Baum;

/**
 * Unser Baum:
 *
 *       20
 *   10      30
 *  5  15  25  35
 * 1
 *
 */

/**
 * preoder:
 *
 * 20 | 10 | 5 | 1 | 15 | 30 | 25 | 35 |
 *
 * 1. Bedingung ist true -> ausdrucken: 20
 * 2. Bedingung ist true -> Rekursion -> 1. Bedingung ist true -> ausdrucken: 10
 * 2. Bedingung ist true -> Rekursion -> 1. Bedingung ist true -> ausdrucken: 5
 * 2. Bedingung ist true -> Rekursion -> 1. Bedingung ist true -> ausdrucken: 1
 * 2. Bedingung ist false -> 3. Bedingung ist true -> Rekursion
 *    -> 1. Bedingung ist true -> ausdrucken: 15
 * 2. Bedingung ist false -> 3. Bedingung ist true -> Rekursion
 *    -> 1. Bedingung ist true -> ausdrucken: 30
 * 2. Bedingung ist true -> Rekursion -> 1. Bedingung ist true -> ausdrucken: 25
 * 2. Bedingung ist false -> 3. Bedingung ist true -> Rekursion
 *    -> 1. Bedingung ist true -> ausdrucken: 35
 *
 */
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
