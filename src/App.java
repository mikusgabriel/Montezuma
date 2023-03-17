import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* ce quil faut faire demain


-arranger un bug ou les pieces ne saffichent pas sur le plan
-mettre les erreurs
-jeux dessais
-javadocs












 */








public class App {
    //░
    //█

    static Scanner sc=new Scanner(System.in);


    public static void main(String[] args) {

        MainMethod();


    }
    public static String FileInUse(int counter){
        String fileInUse="niveau"+counter+".txt";
        return fileInUse;

    }
    public static void MainMethod(){
        boolean constat=false;
        boolean isWon=false;
        boolean isLost=false;
        int compteurNiveau=1;
        afficherIntro();
        System.out.println();
        System.out.println("Appuyez sur la touche enter pour continuer");
        System.out.println();
        String readString = sc.nextLine();
        if (readString.equals("")){
            do {
                String[][] puzzle;
                String[][] piece;
                String nomfichier = FileInUse(compteurNiveau);
                System.out.println("Niveau " + compteurNiveau);
                System.out.println();
                Piece[] pieces = CreationPiecesNiveaux(nomfichier);
                puzzle= new String[Integer.parseInt(pieces[pieces.length - 1].getNbLignes()) + 3][1];

                //trouver la longueur du tab piece
                int longestPiece=0;
                for(Piece p:pieces){
                    int temp=0;
                    temp= Integer.parseInt(p.getNbLignes());
                    if(temp>=longestPiece){
                        longestPiece=temp;
                    }
                }
                piece=new String[longestPiece+2][1];
                constat=secondaryGameplayLoop(puzzle,pieces,piece,compteurNiveau);


                if (!constat) {
                    compteurNiveau++;
                    if (compteurNiveau>10){
                        isWon=true;
                    }
                }else if(constat){
                    isLost=true;
                }
            }while (!isWon&&!isLost);
            if (isWon){
                affichageFinJeuWIN();

            } else if (isLost) {
                affichageFinJeuLOSE();
            }
        }
    }

    public static boolean secondaryGameplayLoop(String[][] puzzle, Piece[] pieces,String[][] piece,int nb){

            int constat=0;
            boolean fin=false;
            boolean isInput=true;
            String command = "";
            int numOfPiecePlaced = 0;

            try{
                piece = affichagePiece(piece, pieces);
                puzzle = afficherPlan(puzzle, pieces);
                affichageFINAL(puzzle,piece);
                System.out.println("(! pour quitter)>>>");

                do {

                    command = sc.next();
                    if (command.charAt(0) == '<') {
                        isInput = false;
                        String lire = "";
                        String substring = command.substring(1);
                        BufferedReader fichier = new BufferedReader(new FileReader("cmd/" + substring));
                        while ((lire = fichier.readLine()) != null &&numOfPiecePlaced != pieces.length - 1) {
                            command = lire;
                            if (Character.isLetter(command.charAt(0))) {
                                if (1 == command.length()) {
                                    retraitPiece(command.toLowerCase().charAt(0), puzzle);
                                    System.out.println(command);
                                    numOfPiecePlaced--;
                                } else if (Character.isDigit(command.charAt(2)) && Character.isLetter(command.charAt(1))) {
                                    char temp = 'z';
                                    char temp2 = 'a';
                                    int counter = 0;
                                    int counter2 = 1;
                                    while (temp != command.toLowerCase().charAt(0)) {
                                        temp--;
                                        counter++;




                                    }
                                    while (temp2 != command.charAt(1)) {
                                        temp2++;
                                        counter2++;


                                    }
                                    System.out.println(temp+""+temp2+""+command.charAt(2));
                                    int isThere;
                                    isThere=ajoutPiece(counter2, Integer.parseInt(String.valueOf(command.charAt(2))), pieces[counter], puzzle);
                                    if (isThere==2){
                                        numOfPiecePlaced++;
                                    }
                                }

                                affichageFINAL(puzzle, piece);
                            } else if (command.charAt(0) == '!') {
                                constat = 1;
                            }
                        }

                    }
                    if (isInput) {
                        if (Character.isLetter(command.charAt(0))) {
                            if (1 == command.length()) {
                                retraitPiece(command.toLowerCase().charAt(0), puzzle);
                                numOfPiecePlaced--;
                            } else if (Character.isDigit(command.charAt(2)) && Character.isLetter(command.charAt(1))) {
                                char temp = 'z';
                                char temp2 = 'a';
                                int counter = 0;
                                int counter2 = 1;
                                while (temp != command.toLowerCase().charAt(0)) {
                                    temp--;
                                    counter++;



                                }
                                while (temp2 != command.charAt(1)) {
                                    temp2++;
                                    counter2++;


                                }
                                int isThere;

                                isThere=ajoutPiece(counter2, Integer.parseInt(String.valueOf(command.charAt(2))), pieces[counter], puzzle);

                                if (isThere==2){
                                    numOfPiecePlaced++;
                                }



                            }

                            affichageFINAL(puzzle, piece);
                            System.out.println("(! pour quitter)>>>");

                        } else if (command.charAt(0) == '!') {
                            constat = 1;
                        }
                    }


                    if (numOfPiecePlaced == pieces.length - 1) {
                        boolean quitter=false;
                        System.out.println("Vous avez reussi le niveau!!");
                        System.out.println("(! pour quitter)>>>");
                        sc.nextLine();
                        String readString;
                        do {
                            readString = sc.nextLine();
                            if (readString.equals("")) {
                                constat = 2;

                            }else if(readString.charAt(0)=='!'){
                                quitter=true;
                                constat=1;

                            }

                        } while (!readString.equals("")&&!quitter);

                    }



                } while (constat==0);

            } catch (FileNotFoundException e) {
                System.err.println("ERREUR: Fichier(s) introuvable(s) " + e.getMessage());
                System.exit(120);
             } catch (IOException e) {
                System.err.println("ERREUR: Lecture du fichier interrompue " + e.getMessage());
                System.exit(121);
            }
            if(constat==2)fin=false;
            else if (constat==1)fin=true;
        return fin ;
    }

    /*public static InputType getInputType(String entree, String[][] puzzle, Piece[] pieces) {

        if(entree == null)
        {
            return InputType.INVALID;
        }
        if(entree.isEmpty())
        {
            return InputType.INVALID;
        }
        if(entree.charAt(0) == '!') //Quitter
        {
            return InputType.EXIT;
        }
        if(entree.charAt(0) == '<') //Charger ficher
        {
            return InputType.LOAD_FILE;
        }
        if (entree.length() != 1 && entree.length() != 3)
        {
            return InputType.INVALID;
        }
        if(!Character.isLetter(entree.charAt(0)))
        {
            return InputType.INVALID;
        }
        int associatedLetter = 90 - entree.charAt(0);

        if (entree.length() == 1) //Enlever pièce
        {
            if(associatedLetter > pieces.length || associatedLetter < 0)
            {
                return InputType.INVALID;
            }
            if(!pieces.isActive)
            {
                return InputType.INVALID;
            }
            return InputType.REMOVE;
        }
        else //Ajouter pièce
        {
            if (!Character.isLetter(entree.charAt(1)) && !Character.isDigit(entree.charAt(2)))
            {
                return InputType.INVALID;
            }
            int xOfInput = entree.charAt(2) - 49, yOfInput = entree.charAt(1) - 65;
            System.out.println(entree);
            System.out.println(associatedLetter);
            System.out.println(yOfInput + " " + xOfInput);

            if (associatedLetter > pieces.length || associatedLetter < 0)
            {
                return InputType.INVALID;
            }
            if (xOfInput + pieces[associatedLetter].rowSpan == 0
                    && yOfInput + pieces[associatedLetter].columnSpan == 0
                    && xOfInput + pieces[associatedLetter].rowSpan > gameBoard.length
                    && yOfInput + pieces[associatedLetter].columnSpan > gameBoard[0].length)
            {
                return InputType.INVALID;
            }
            if (pieces[associatedLetter].isActive)
            {
                return InputType.INVALID;
            }
            char[][] piece = pieces[associatedLetter].toMatrix();
            for( int x = 0 ; x < piece.length ; x++)
                for( int y = 0 ; y < piece[x].length ; y++)
                    if (piece[x][y] != ' ' && puzzle[x + xOfInput][y + yOfInput] != ' ')
                    {
                        return InputType.INVALID;
                    }
            return InputType.ADD;
        }
    }



     */
    public static void actions(String entree){
        while (!entree.isBlank()) {
            System.err.println("Veuillez entrer une commande valide!");
            entree = sc.nextLine();
        }

    }
    public static void afficherIntro(){
        System.out.println("©2023 Gabriel Mikus" + "\u001B[32m");
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
    }
    public static void affichageFinJeuLOSE(){
        System.out.println("Vous etes tombé dans un piège");
        System.out.println(" ▄▄▄▄▄▄▄ ▄▄▄▄▄▄ ▄▄   ▄▄ ▄▄▄▄▄▄▄    ▄▄▄▄▄▄▄ ▄▄   ▄▄ ▄▄▄▄▄▄▄ ▄▄▄▄▄▄   \n" +
                            "█       █      █  █▄█  █       █  █       █  █ █  █       █   ▄  █  \n" +
                            "█   ▄▄▄▄█  ▄   █       █    ▄▄▄█  █   ▄   █  █▄█  █    ▄▄▄█  █ █ █  \n" +
                            "█  █  ▄▄█ █▄█  █       █   █▄▄▄   █  █ █  █       █   █▄▄▄█   █▄▄█▄ \n" +
                            "█  █ █  █      █       █    ▄▄▄█  █  █▄█  █       █    ▄▄▄█    ▄▄  █\n" +
                            "█  █▄▄█ █  ▄   █ ██▄██ █   █▄▄▄   █       ██     ██   █▄▄▄█   █  █ █\n" +
                            "█▄▄▄▄▄▄▄█▄█ █▄▄█▄█   █▄█▄▄▄▄▄▄▄█  █▄▄▄▄▄▄▄█ █▄▄▄█ █▄▄▄▄▄▄▄█▄▄▄█  █▄█\n");

    }
    public static void affichageFinJeuWIN(){
        System.out.println("");System.out.println("");System.out.println("");
        System.out.println("Vous avez enfin trouvé le trésor!! Il y a quelquechose caché dedans...");
        System.out.println("");
        System.out.println("");
        System.out.println("\n" +
                "                   ,╓@@╖╖╖,.___\n" +
                "                  ╓▓▓▓▒▒▓▓▓▓▓▓▓▓▄▄@╖╓,,._\n" +
                "                 ╓▓██▓▓▓▓▓▓╣▒▒▒▓▓▓╣▒╫▓▓▓▓▓╬▓╣▒╖╖╖,,,,__\n" +
                "                ,▓██▓▓▓████▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒░▒▒▒▒▓▓▓▓╖ß@µ╖╖╖╖_\n" +
                "                ╟██▓▓▓▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓@@▒╢▒▒╢▓▓▓▓▓▓@_\n" +
                "               ]██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒╢▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓H\n" +
                "              ┌▓█▓▓▓▓▓▓▓▓▓▓▓╢╢╢╢╢╢╢╢╣╣╣╢╢╢╢╢╢▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓╜╙\n" +
                "             _╫█▓▓▓▓▓▓▓▓▓╣╣╣▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒╢╢╢╢╢╢▓▓▓▓▓▓▓▓▓▓▓▓╜\n" +
                "             ╓▓▓▓▓▓▓▓▓▓▓▓╣╢╣▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒╢╢╢╢╢╢▓▓▓▓▓▓Ñ╜\n" +
                "            _╫▓▓▓▓▓▓▓▓╣╣▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░▒▒╢╢╢╢╣▓▓▓╜`\n" +
                "            ╟▓▓▓▓▓▓▓▓▓▓╣╢▒▒▒▒▒▒░░░░░____  __░░░░░▒▒╢╢╣╣╜\n" +
                "           ]▓▓█▓▓▓▓▓▓▓▓▓╣▓▓▓▓▓▓▓▓▓▓▓▓╬Ñ@@ppp╖▒▒▒▒▒╢╢▒▒,,_,___________\n" +
                "           ╠▓▓▓███████▓▓▓▓▓▓▓███████▓▓▓████▓▓▓▓▓▓▓▓▓╢╬▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒\n" +
                "           ╠▓██████████▓▓▓▓██████▓▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓▓▓▓▒\n" +
                "           ╙▓██████████▓▓▓▓█████████▓╣▓████▓▓▓███▓▒╢▒▒▓███▓▓▓██████▓▓▒\n" +
                "            ▓██████████▓▓▓▓█████████▓▓▓▓██▓▓▓▓▓██▓╣▒▒╫▓▓▓▓▓▓▓▓▓▓▓▓▓▓╣\n" +
                "            ▓██████████▓▓▓██████████▓▓▓████████▓▓▓███▓▓▓█▓▓▓▓██████▓▒\n" +
                "            ▐█████▓▓███▓▓▓███████████▓▓█████████▓▓████████▓▓███████▓▒\n" +
                "            ╟██████████▓▓▓███████████▓▓████▓▓▓▓▓▓▓███▓▓▓▓▓▓▓▓▓▓▓███▓▒\n" +
                "            ]▓█████████▓▓▓█████████████████████████████████████████▓░\n" +
                "            ]▓█████████▓▓▓████████████████████████████████████████▓▓\n" +
                "            ]▓█████████▓▓▓▓██████████████████████████████████████▓▓▒\n" +
                "            ┌▓▓████████▓╣╢▓█████████████████████████████████████▓╢╣▒\n" +
                "          ___╙▓▓▓▓████▓▓╢╢╣╣▓████████████████████▓▓▓▓▓▓▓▓▓▓▓▒╢╢▓▓╣╣▒\n" +
                "               ''╙╜╢▓▓▓▓╣▒╢╢╢╢╢╣▓▓▓▓▓▓╢╢╣╣╬▓▓▓▓╣ÑÑ╨╜╜╜╜╜╙╙\"`'`\n" +
                "                     '╙▓╣╣╨╨╜╜╜╜╜╜╙╙╙`'``");

        System.out.println("");System.out.println("");
        System.out.println("WOW un diamand!!!! Vous êtes riche!!!");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("                              _\n" +
                "                _,æ@H▒▒░%@@@HH▒▒▒░░__,╓╥╗╖,_░░▒▒HHHH@@@@NHH∩▒░_\n" +
                "              ,╥▒░░░░░░░░_╙▒▒▒▒░░╖╥▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒╖\n" +
                "            ,@╣▒▒▒░░░░░░_  ,▄▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░ _▒▄▒▒▒▒▒░░░░░░░╟▓╖_\n" +
                "          ╓╣▒▒▒▒▒░░░░░░,╓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░░░░_ ,╥▒▒╙▓▓▓▒░░░░░░░░_▓╣▓╖_\n" +
                "       _╓╣▒▒▒▒▒▒▒░▒░░╥▓╣╢╣▓▓▓▓▓╣╣▒░░░░░░░░░_  ╓@╣▒▒▒░╟╣╢╢╣╣╖░░░__ ╙╣╢╢@▒_\n" +
                "     _╓▒▒░▒▒▒▒▒▒░▒▒▒╢╣╢╣▓╢▓▓▓▓╣╢╣╣▒▒░░░░_░░_g▓╣╣▒▒▒▒░░╫▒▒▒▒▒▒▒▒,  _╫╣▒▒╢░░_\n" +
                "   _░░░░░░░░▒╨▒░▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓╣╣▒▒▒▒░░ _,▄▓▓╣╢╣▒▒▒▒░░ ╢▒▒▒▒▒░░░░   ╢▒▒▒▒▒░░_\n" +
                "  ╥╖╥▒░░░'__   `\"\"\"╙╙╙``  ╙▀▀▀╜╜╜╜╜╜▒░░▒▒▀▀▀▀▓▓╢╢▒▒▒µ@║╢╢╢@@╥╥╥╥╥φ@▓▓▓▓@@@▓▓▄▄╖\n" +
                "  ▀██▄▒▒▒▒▒▒▒╖        ___╟▓▓▓▓▓▓▓▓╢╢╢╣▒▒╫▓▓╣╣▒▒▒▒░░░   ▒░░░░░░░░___▒░░░░, _║▒╝`\n" +
                "    ▀█▓▒▒▒░░▒░▓_   ____░░░▓▓▓▓▓▓╢╢╣▒▒▒▒▒]╣╢╣▒▒▒▒▒░░_  ║▒▒░░░░░░░░╓▓░░░░░░╓╢╜\n" +
                "      ▀▓▓▒░░░░░▓@_____░░░░▒▓▓▓╣╢╢╣▒▒▒▒░░_▓╣╢╣▒▒▒▒░░░ ╓▒▒▒▒▒▒▒░░░▓▌▒▒░░░░▒▒`\n" +
                "        ╙▓@░░░░░╟▓╖░░░░░░▒▒▒▓╢╣╣▒▒▒▒▒░░_ ╟╣╢▒▒▒▒░░░░_╣▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒░▒`\n" +
                "          ╨▓╖░░░░╠╣▓░░▒▒▒▒▒▒▒╣▒▒▒▒▒░░░ _░░▓╣▒▒▒▒░░░_╢▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒`\n" +
                "            ╨▓░░░░╙╣╣▒▒▒▒▒▒▒▒▒▒▒▒▒░░░ _░░░▓╣▒▒▒▒░░░╟╣▒▒▒▒▒▒╫╣╣▒▒▒▒╜▒`\n" +
                "              ╨@_ _╙╣╣▒▒▒▒▒▒╢╢▒▒░░░   ░░░░]╣▒▒▒▒░░╠╣╣╢╣▒▒╢╢╢╢╢╣╢╣░`\n" +
                "                ║╖  '╢▒▒▒╢╣╢╢╢▓░░░   _░░░░░╢▒▒▒▒░░▓╢╢╣╢╣╢╢╣╢╢╢▓╜\n" +
                "                 `], `║▒▒▒▒╫╢╢╢@     ░░░░░░╢▒▒▒▒░▓╣╣╣╣▒▒╢╣╫╣▓╜\n" +
                "                   `H_ ║▒▒▒▒╫▓▓▓U    ▒░░░░░▒▒▒▒▒▓▓▓▓▒▒▒▒╣▓▓▓\n" +
                "                     `░ ▒▒░▒▒░▓▓▓_  ]▒▒░░░▒▒▒▒▒╟▓▓▓▒▒▒▒▒▓▓╜\n" +
                "                         ╙▒░░░░╙▓▌  ▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▓▀  _\n" +
                "                          '░░░░░░▀▌,▒▒▒▒▒▒▒▒▒▒▓░▒▒▒▒▒▒▓\n" +
                "                           `░░░░_░╙║▒▒▒▒▒▒▒▒▒╜▒▒▒▒▒▒╜`\n" +
                "                              ░     ╢▒▒▒▒▒▒▒▒░░░░▒▒`\n" +
                "                                    └▒▒▒▒▒▒╣░░░░▒`\n" +
                "                                     ╟▒▒▒▒╢░░░░`\n" +
                "                                      ╫▒▒▒╜_░░\n" +
                "                                       ╢▒╣_\n" +
                "                                       ╙╢`\n" +
                "                                        `");
    }
    public static String[][] afficherPlan(String[][] puzzle, Piece[] pieces){


            int counter=1;
            char charCounter= 'A';
            for (int i=0;i<Integer.parseInt(pieces[pieces.length-1].getNbLignes());i++){
                String ligne="";
                //mettre un numero devant la ligne si tu peux placer une piece sinon ca print un espace
                boolean isPlayable=false;
                for(int k=0;k<Integer.parseInt(pieces[pieces.length-1].getNbColonnes());k++){
                    if(pieces[pieces.length-1].getDonnees()[i][0].charAt(k)=='0'){
                        isPlayable=true;
                    }

                }
                if(isPlayable){
                    ligne+=counter;
                    counter++;
                }else{
                    ligne+="";
                }

                //mettre un abc selon les truc jouables
                if(i==0){
                    String charLigne="  ";
                    for(int g=0;g<Integer.parseInt(pieces[pieces.length-1].getNbColonnes());g++){

                        isPlayable=false;
                        for(int k=0;k<Integer.parseInt(pieces[pieces.length-1].getNbLignes());k++){
                            if(pieces[pieces.length-1].getDonnees()[k][0].charAt(g)=='0'){
                                isPlayable=true;
                            }
                        }
                        if(isPlayable){
                            charLigne+=charCounter;
                            charCounter++;
                        }else{
                            charLigne+=("");
                        }
                    }
                    puzzle[i][0]= charLigne;
                }
                //ajouter les bordures du debut
                String ligneBordureTopBot=" ";
                for(int p=0;p<Integer.parseInt(pieces[pieces.length-1].getNbColonnes())+2;p++){
                    ligneBordureTopBot+="█";
                }
                puzzle[1][0]=ligneBordureTopBot;
                puzzle[puzzle.length-1][0]=ligneBordureTopBot;
                ligne+="█";
                // transformer 0 et 1 en caracteres speciaux
                for (int j=0;j<Integer.parseInt(pieces[pieces.length-1].getNbColonnes());j++){

                    if(pieces[pieces.length-1].getDonnees()[i][0].charAt(j)=='0'){
                        ligne+="░";
                    }else {
                        ligne += "█";
                    }

                }
                ligne+="█";
                puzzle[i+2][0]=ligne;

            }
            return puzzle;
    }
    public static String[][] affichagePiece(String[][] piece,Piece[] pieces){
        boolean isComplete=false;
        int counter=0;
        int stringCounter=0;
        transformationBinChar(pieces);



        piece[counter][0]="";
        piece[counter][0]+="    Pieces:   ";
        int[] whenNull=new int[pieces.length-1];
        while(!isComplete){
            counter++;
            piece[counter][0]="";
            piece[counter][0]+="              ";
            int whenNullCounter=0;
            for(int i=0;i< pieces.length-1;i++){
                if(stringCounter<Integer.parseInt(pieces[i].getNbLignes())){
                    piece[counter][0]+=pieces[i].getDonnees()[stringCounter][0];
                    whenNull[i]=pieces[i].getDonnees()[stringCounter][0].length();
                }else{
                    String string="";
                    for(int j=0;j<whenNull[whenNullCounter];j++){
                        string+=" ";
                    }

                    piece[counter][0]+=string;
                }
                whenNullCounter++;
                piece[counter][0]+=" ";

            }
            stringCounter++;
            if(stringCounter== piece.length-1){
                isComplete=true;
            }
        }

        return piece;

    }
    public static void affichageFINAL(String[][] puzzle,String[][] pieces){
        for(int i=0;i<puzzle.length;i++){
            if(i<= pieces.length-1){
                System.out.println(puzzle[i][0]+""+pieces[i][0]);

            }else{
                System.out.println(puzzle[i][0]);
            }

        }

    }


    public static int nombreChar(String ligne){
        int qtt=0;
        for (int i=0;i<ligne.length();i++){
            if(ligne.charAt(i)=='1'){
                qtt++;
            }
        }

        return qtt;

    }
    public static void transformationBinChar(Piece[] pieces){


        boolean isUsed=false;

        char lettre='z';
        char special='░';

        for (int k=0;k< pieces.length-1;k++){



            for(int i=0;i< Integer.parseInt(pieces[k].getNbLignes());i++){
                for (int j=0;j<pieces[k].getDonnees()[i][0].length();j++){
                    if(pieces[k].getDonnees()[i][0].charAt(j)=='0'){
                        pieces[k].getDonnees()[i][0]=pieces[k].getDonnees()[i][0].replace('0',special);
                    }else{
                        pieces[k].getDonnees()[i][0]=pieces[k].getDonnees()[i][0].replace('1',lettre);
                        isUsed=true;
                    }
                }
            }
            if (isUsed){
                lettre--;
            }
        }


    }
    public static Piece[] CreationPiecesNiveaux(String nomfichier) {
        try {
            boolean niveauPresent=false;
           int nb1=0;
           int nb0=0;
            //nb de pieces
            BufferedReader fichier = new BufferedReader(new FileReader(nomfichier));
            String read;
            int nbPiece = -1;
            while ((read = fichier.readLine()) != null) {
                nbPiece++;
            }
            Piece[] tableauPieces = new Piece[nbPiece + 1];
            int temp = 0;
            char lettreAssigner='z';
            String lire;
            BufferedReader fichier2 = new BufferedReader(new FileReader(nomfichier));
            while ((lire = fichier2.readLine()) != null) {
                 nb1=0;
                 nb0=0;

                validationLigne(lire);
                String[] tab = (lire.split("\\|"));
                String[] tabLC = tab[1].split(",");
                String L = tabLC[0];
                String C = tabLC[1];
                String donnees = tab[2];
                String[][] tabDonnees = new String[Integer.parseInt(L)][1];
                int charCounter=0;
                for (int i = 0; i < Integer.parseInt(L); i++) {
                    String extraTemp="";
                    for (int j = 0; j < Integer.parseInt(C); j++) {
                        extraTemp+= donnees.charAt(charCounter);
                        charCounter++;
                        tabDonnees[i][0]=extraTemp;
                    }
                }


                if (tab[0].equals("P")) {
                    tableauPieces[temp] = new Piece(L, C, tabDonnees,lettreAssigner);
                    temp++;
                    nb1+=nombreChar(donnees);
                    nb0+=donnees.length()-nb1;
                    lettreAssigner--;

                } else if (tab[0].equals("G")) {
                    niveauPresent=true;
                    Piece a = new Piece(L, C, tabDonnees,null);
                    tableauPieces[tableauPieces.length - 1] = a;


                    }

                }
            if (!niveauPresent){
                System.err.println("ERREUR: puzzle n'est pas présent dans le fichier");
                throw new IllegalArgumentException();
            }
            if(nb1!=nb0){
                System.err.println("ERREUR: "+nomfichier+" ne peut pas etre resolu" );
                throw new IllegalArgumentException();

            }

            return tableauPieces;


            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public static int ajoutPiece(int xInput,int yInput,Piece piece,String[][] puzzle){
        int nbLettre=0;
        boolean isThere=false;
        int isPlaced=0;
        for(int ligne=0; ligne<Integer.parseInt(piece.getNbLignes());ligne++){
            for (int colonne=0;colonne<Integer.parseInt(piece.getNbColonnes());colonne++) {
                if (piece.getDonnees()[ligne][0].charAt(colonne)== piece.getLettre()){
                    nbLettre++;
                }
            }
        }
        int nbTrou=0;
        for(int ligne=0; ligne<Integer.parseInt(piece.getNbLignes());ligne++){
            for (int colonne=0;colonne<Integer.parseInt(piece.getNbColonnes());colonne++){
                if(piece.getDonnees()[ligne][0].charAt(colonne)!='░'){
                if(puzzle[yInput+1+ligne][0].charAt(xInput+1+colonne)=='░'){
                    nbTrou++;
                if (puzzle[yInput+1+ligne][0].charAt(xInput+1+colonne)==piece.getLettre()){
                    isThere=true;
                }
                }}
            }
        }
        if (nbTrou==nbLettre&&!isThere){
            isPlaced=2;
            for(int ligne=0; ligne<Integer.parseInt(piece.getNbLignes());ligne++) {
                for (int colonne = 0; colonne < Integer.parseInt(piece.getNbColonnes()); colonne++) {
                    if(piece.getDonnees()[ligne][0].charAt(colonne)!='░'){
                        char[] temp= puzzle[yInput + 1 + ligne][0].toCharArray();
                        temp[colonne+1+xInput]=piece.getLettre();
                        puzzle[yInput + 1 + ligne][0]= String.valueOf(temp);


                    }

                }
            }

        }else{
            isPlaced=1;
        }
        return isPlaced;


    }
    public static void retraitPiece(char letter,String[][] puzzle) {
        for (int i = 0; i < puzzle.length; i++)
            for (int j = 0; j < puzzle[i][0].length(); j++)
                if (puzzle[i][0].charAt(j) == letter) {
                    puzzle[i][0] = puzzle[i][0].replace(letter, '░');
                    ;

                }

    }

    // A REFORMATTER
    public static void validationLigne(String line){

        if(line.charAt(0) != 'P' && line.charAt(0) != 'G')
        {
            System.err.println("ERREUR: Syntaxe incorrecte dans un des fichiers de niveau");
            throw new IllegalArgumentException();
        }
        if(line.charAt(1) != '|' && line.charAt(5) != '|')
        {
            System.err.println("ERREUR: Syntaxe incorrecte dans un des fichiers de niveau");
            throw new IllegalArgumentException();
        }
        if(line.split("\\|").length != 3)
        {
            System.err.println("ERREUR: Syntaxe incorrecte dans un des fichiers de niveau");
            throw new IllegalArgumentException();
        }
        if((line.charAt(2) - 48 < 1 && line.charAt(2) - 48 > 9) && (line.charAt(4) - 48 < 1 && line.charAt(4) - 48 > 9))
        {
            System.err.println("ERREUR: Syntaxe incorrecte dans un des fichiers de niveau");
            throw new IllegalArgumentException();
        }
        if((line.charAt(2) - 48) * (line.charAt(4) - 48) != line.length() - 6 )
        {
            System.err.println("ERREUR: Syntaxe incorrecte dans un des fichiers de niveau");
            throw new IllegalArgumentException();
        }
        for(int i = 6; i < line.length(); i++) {
            if(line.charAt(i) != '0' && line.charAt(i) != '1')
            {
                System.err.println("ERREUR: Syntaxe incorrecte dans un des fichiers de niveau");
                throw new IllegalArgumentException();
            }
        }

    }
    enum InputType {
        INVALID,
        EXIT,
        ADD,
        REMOVE,
        LOAD_FILE
    }
}
