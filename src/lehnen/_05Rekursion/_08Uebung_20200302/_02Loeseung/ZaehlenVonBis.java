package lehnen._05Rekursion._08Uebung_20200302._02Loeseung;

public class ZaehlenVonBis {
    public static void main(String[] args) {
        ZaehlenVonBis zaehlenVonBis = new ZaehlenVonBis();
        System.out.println("Iterativ: " + zaehlenVonBis.summeIterativ(1, 5));
        System.out.println("Rekursiv_FJ: " + zaehlenVonBis.summeRekursiv_FelixJansen(1, 5));
        System.out.println("Rekursiv_ML: " + zaehlenVonBis.summeRekursiv_Lehnen(1, 5));
    }

    public int summeIterativ(int pAnfang, int pEnde) {
        int summe = 0;
        for (int i = pAnfang; i < pEnde + 1; i++) {
            summe = summe + i;
        }
        return summe;
    }

    public int summeRekursiv_FelixJansen(int pAnfang, int pEnde) {
        int zahl = pEnde;
        int summe;
        if (zahl == pAnfang) {
            summe = pAnfang;
        } else {
            summe = summeRekursiv_FelixJansen(pAnfang, pEnde - 1) + pEnde;
        }
        return summe;
    }

    public int summeRekursiv_Lehnen(int pAnfang, int pEnde) {
        if (pAnfang == pEnde) {
            return pEnde;
        } else {
            return pAnfang + summeRekursiv_Lehnen(pAnfang + 1, pEnde);
        }
    }
}
