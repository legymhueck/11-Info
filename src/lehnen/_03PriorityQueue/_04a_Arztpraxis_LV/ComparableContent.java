package lehnen._03PriorityQueue._04a_Arztpraxis_LV;

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2017.
 * </p>
 * <p>
 * Generisches Interface (Schnittstelle) ComparableContent<ContentType>
 * </p>
 * <p>
 * <p>Das generische Interface ComparableContent<ContentType> legt die Methoden
 * fest, über die Objekte verfügen müssen, die in einen binären Suchbaum
 * (BinarySearchTree) eingefügt werden sollen. Die Ordnungsrelation wird in
 * Klassen, die ComparableContent implementieren durch Überschreiben der drei
 * implizit abstrakten Methoden isGreater, isEqual und isLess festgelegt.
 * </p>
 * </p>
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - <br>
 * Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version Generisch_02 2014-03-01
 */
public interface ComparableContent<ContentType> {

    /**
     * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
     * wird, bzgl. der gewuenschten Ordnungsrelation groesser als das Objekt
     * pContent ist, wird true geliefert. Sonst wird false geliefert.
     *
     * @param pContent das mit dem aufrufenden Objekt zu vergleichende Objekt vom
     *                 Typ ContentType
     * @return true, wenn das aufrufende Objekt groesser ist als das Objekt
     * pContent, sonst false
     */
    public boolean isGreater(ContentType pContent);

    /**
     * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
     * wird, bzgl. der gewuenschten Ordnungsrelation gleich gross wie das Objekt
     * pContent ist, wird true geliefert. Sonst wird false geliefert.
     *
     * @param pContent das mit dem aufrufenden Objekt zu vergleichende Objekt vom
     *                 Typ ContentType
     * @return true, wenn das aufrufende Objekt gleich gross ist wie das Objekt
     * pContent, sonst false
     */
    public boolean isEqual(ContentType pContent);

    /**
     * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
     * wird, bzgl. der gewuenschten Ordnungsrelation kleiner als das Objekt
     * pContent ist, wird true geliefert. Sonst wird false geliefert.
     *
     * @param pContent das mit dem aufrufenden Objekt zu vergleichende Objekt vom
     *                 Typ ContentType
     * @return true, wenn das aufrufende Objekt kleiner ist als das Objekt
     * pContent, sonst false
     */
    public boolean isLess(ContentType pContent);

}

