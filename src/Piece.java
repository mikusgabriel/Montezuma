
public class Piece{
    private String nbLignes;
    private String nbColones;
    private String[][] donnees;
    Piece(String nbLignes, String nbColones,String[][] donnees){
        this.nbLignes=nbLignes;
        this.nbColones= nbColones;
        this.donnees=donnees;




    }
    public String getNbLignes() {
        return nbLignes;
    }

    public String getNbColones() {
        return nbColones;
    }

    public String[][] getDonnees() {
        return donnees;
    }
}

