package lehnen._05Rekursion._10Musikverwaltung;

public class Musiktitel {
    private String titel;
    private String interpret;
    private String genre;

    public Musiktitel(String pTitel, String pInterpret, String pGenre) {
        titel = pTitel;
        interpret = pInterpret;
        genre = pGenre;
    }

    public String getTitel() {
        return titel;
    }

    public String getInterpret() {
        return interpret;
    }

    public String getGenre() {
        return genre;
    }

}
