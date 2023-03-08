import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class App {
    //░
    //█
    public static void main(String[] args) {
        afficherIntro();
        MainMethod();


    }

    public static void MainMethod(){
        try {

            BufferedReader a = new BufferedReader(new FileReader("niveau1.txt"));
            BufferedReader b = new BufferedReader(new FileReader("niveau2.txt"));
            BufferedReader c = new BufferedReader(new FileReader("niveau3.txt"));
            BufferedReader d = new BufferedReader(new FileReader("niveau4.txt"));
            BufferedReader e = new BufferedReader(new FileReader("niveau5.txt"));
            BufferedReader f = new BufferedReader(new FileReader("niveau6.txt"));
            BufferedReader g = new BufferedReader(new FileReader("niveau7.txt"));
            BufferedReader h = new BufferedReader(new FileReader("niveau8.txt"));
            BufferedReader i = new BufferedReader(new FileReader("niveau8.txt"));
            BufferedReader j = new BufferedReader(new FileReader("niveau9.txt"));
            BufferedReader k = new BufferedReader(new FileReader("niveau10.txt"));
            int nbpieceA=nbPieces(a);
            int nbpieceB=nbPieces(b);
            int nbpieceC=nbPieces(c);
            int nbpieceD=nbPieces(d);
            int nbpieceE=nbPieces(e);
            int nbpieceF=nbPieces(f);
            int nbpieceG=nbPieces(g);
            int nbpieceH=nbPieces(h);
            int nbpieceI=nbPieces(i);
            int nbpieceJ=nbPieces(j);
            int nbpieceK=nbPieces(k);
            BufferedReader a2 = new BufferedReader(new FileReader("niveau1.txt"));
            BufferedReader b2 = new BufferedReader(new FileReader("niveau2.txt"));
            BufferedReader c2 = new BufferedReader(new FileReader("niveau3.txt"));
            BufferedReader d2 = new BufferedReader(new FileReader("niveau4.txt"));
            BufferedReader e2 = new BufferedReader(new FileReader("niveau5.txt"));
            BufferedReader f2 = new BufferedReader(new FileReader("niveau6.txt"));
            BufferedReader g2 = new BufferedReader(new FileReader("niveau7.txt"));
            BufferedReader h2 = new BufferedReader(new FileReader("niveau8.txt"));
            BufferedReader i2 = new BufferedReader(new FileReader("niveau8.txt"));
            BufferedReader j2 = new BufferedReader(new FileReader("niveau9.txt"));
            BufferedReader k2 = new BufferedReader(new FileReader("niveau10.txt"));
            CreationPiecesNiveaux(a2,nbpieceA);
            /*CreationPiecesNiveaux(b2,nbpieceB);
            CreationPiecesNiveaux(c2,nbpieceC);
            CreationPiecesNiveaux(d2,nbpieceD);
            CreationPiecesNiveaux(e2,nbpieceE);
            CreationPiecesNiveaux(f2,nbpieceF);
            CreationPiecesNiveaux(g2,nbpieceG);
            CreationPiecesNiveaux(h2,nbpieceH);
            CreationPiecesNiveaux(i2,nbpieceI);
            CreationPiecesNiveaux(j2,nbpieceJ);
            CreationPiecesNiveaux(k2,nbpieceK);


             */

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas ete trouver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static int nbPieces(BufferedReader reader) throws IOException {
        String read;
        int nbPiece=-1;
        while ((read= reader.readLine()) != null) {
            nbPiece++;
        }
        return nbPiece;
    }
    public static void afficherIntro(){
        System.out.println("© Gabriel Mikus" + "\u001B[32m");
        System.out.println("\n" +
                " ███▄ ▄███▓ ▒█████   ███▄    █ ▄▄▄█████▓▓█████ ▒███████▒ █    ██  ███▄ ▄███▓ ▄▄▄      \n" +
                "▓██▒▀█▀ ██▒▒██▒  ██▒ ██ ▀█   █ ▓  ██▒ ▓▒▓█   ▀ ▒ ▒ ▒ ▄▀░ ██  ▓██▒▓██▒▀█▀ ██▒▒████▄    \n" +
                "▓██    ▓██░▒██░  ██▒▓██  ▀█ ██▒▒ ▓██░ ▒░▒███   ░ ▒ ▄▀▒░ ▓██  ▒██░▓██    ▓██░▒██  ▀█▄  \n" +
                "▒██    ▒██ ▒██   ██░▓██▒  ▐▌██▒░ ▓██▓ ░ ▒▓█  ▄   ▄▀▒   ░▓▓█  ░██░▒██    ▒██ ░██▄▄▄▄██ \n" +
                "▒██▒   ░██▒░ ████▓▒░▒██░   ▓██░  ▒██▒ ░ ░▒████▒▒███████▒▒▒█████▓ ▒██▒   ░██▒ ▓█   ▓██▒\n" +
                "░ ▒░   ░  ░░ ▒░▒░▒░ ░ ▒░   ▒ ▒   ▒ ░░   ░░ ▒░ ░░▒▒ ▓░▒░▒░▒▓▒ ▒ ▒ ░ ▒░   ░  ░ ▒▒   ▓▒█░\n" +
                "░  ░      ░  ░ ▒ ▒░ ░ ░░   ░ ▒░    ░     ░ ░  ░░░▒ ▒ ░ ▒░░▒░ ░ ░ ░  ░      ░  ▒   ▒▒ ░\n" +
                "░      ░   ░ ░ ░ ▒     ░   ░ ░   ░         ░   ░ ░ ░ ░ ░ ░░░ ░ ░ ░      ░     ░   ▒   \n" +
                "       ░       ░ ░           ░             ░  ░  ░ ░       ░            ░         ░  ░\n" +
                "                                               ░                                      \n");
        System.out.println("En pleine jungle aztèque, vous cherchez un trésor ");
        System.out.println("Vous arrivez devant un rocher ayant une inscription mystérieuse...");
        System.out.println("[Au fond des ruines Aztecs vous trouverez ce que vous cherchez. Gare à vous, l'aventure ne vas pas être si facile...]");
        System.out.println("[Je vous conseille de.. 陰茎だいすきです]");
        System.out.println("Le reste du texte est illisible, donc vous continuez  plus profondément dans la jungle.");

        System.out.println();
    }
    public static void afficherPlan(){

    }
    static void CreationPiecesNiveaux(BufferedReader reader,int nbPieces) {
        try {
            Piece[] tableauPieces =new Piece[nbPieces];
            int temp=0;
            String read;
            while ((read= reader.readLine()) != null){
                String[] tab = (read.split("\\|"));
                String[] tabLC=tab[1].split(",");
                String L= tabLC[0];
                String C= tabLC[1];
                String donnees= tab[2];
                String[][] tabDonnees=new String[Integer.parseInt(L)][Integer.parseInt(C)];
                int counter=0;
                for (int i=0;i< Integer.parseInt(L);i++){
                    for (int j=0;j<Integer.parseInt(C);j++){
                        tabDonnees[i][j]= String.valueOf(donnees.charAt(counter));
                        counter++;
                    }

                }
                for(String[] s:tabDonnees){
                    System.out.println(Arrays.toString(s));
                }
                System.out.println(donnees);

                if(tab[0].equals("P")) {
                    tableauPieces[temp]=new Piece(L,C,tabDonnees);
                    temp++;

                }else if (tab[0].equals("G")){
                    Niveau a=new Niveau(L,C,tabDonnees);

                }



            }




        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}