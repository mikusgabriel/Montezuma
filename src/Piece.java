
public class Piece{
    private final String nbLignes;
    private final String nbColonnes;
    private final String[][] donnees;

    private final Character lettre;

    Piece(String nbLignes, String nbColonnes,String[][] donnees,Character lettre){
        this.nbLignes=nbLignes;
        this.nbColonnes= nbColonnes;
        this.donnees=donnees;
        this.lettre=lettre;




    }
    public String getNbLignes() {
        return nbLignes;
    }

    public String getNbColonnes() {
        return nbColonnes;
    }

    public String[][] getDonnees() {
        return donnees;
    }

    public Character getLettre() {
        return lettre;
    }
}

