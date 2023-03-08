
public class Piece extends Niveau{

    Piece(String nbLignes, String nbColones,String[][] donnees){
        super(nbLignes,nbColones, donnees);

    }
    void sex(){
        System.out.println("sex");
        System.out.println(nbColones);
    }
}
