package lehnen._05Rekursion._09Uebung_20200309._01Aufgabe;

public class Cell {
    private int value;
    private boolean bIsSystemValue;

    public Cell(){
        value = 0;
        bIsSystemValue = false;
    }

    public int getValue(){
        return value;
    }

    public boolean isSystemValue(){
        return bIsSystemValue;
    }

    public void setValue(int pValue, boolean pIsSystemValue){
        value = pValue;
        bIsSystemValue = pIsSystemValue;
    }
}
