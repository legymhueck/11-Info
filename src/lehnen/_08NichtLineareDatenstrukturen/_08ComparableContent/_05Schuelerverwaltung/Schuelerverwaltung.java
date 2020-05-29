package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._05Schuelerverwaltung;

import resources._01NRW._01Datenstrukturklassen._02Baum.BinarySearchTree;

public class Schuelerverwaltung {
    private BinarySearchTree<Schueler> schuelerBinarySearchTree;

    public Schuelerverwaltung() {
        schuelerBinarySearchTree = new BinarySearchTree<>();
    }

    public void neuenNutzerAnlegen(String pVorname, String pNachname, String pEmail) {
        Schueler schueler = new Schueler(pVorname, pNachname, pEmail);
        schuelerBinarySearchTree.insert(schueler);
    }

    public void nutzerLoeschen(String pVorname, String pNachname, String pEmail) {
        Schueler schueler = new Schueler(pVorname, pNachname, pEmail);
        schuelerBinarySearchTree.remove(schueler);
    }

    public boolean profilVorhanden(String pVorname, String pNachname, String pEmail) {
        Schueler schueler = new Schueler(pVorname, pNachname, pEmail);
        Schueler gefundenerSchueler = schuelerBinarySearchTree.search(schueler);
        return gefundenerSchueler != null;
    }

    public Schueler profilSchuelerVorhanden(String pVorname, String pNachname, String pEmail) {
        Schueler schueler = new Schueler(pVorname, pNachname, pEmail);
        Schueler gefundenesSchuelerprofil = schuelerBinarySearchTree.search(schueler);
        return gefundenesSchuelerprofil;
    }

    public BinarySearchTree<Schueler> getSchuelerBinarySearchTree() {
        return schuelerBinarySearchTree;
    }
}