import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

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
        boolean isBattu=false;
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
                String nomfichier = FileInUse(compteurNiveau);
                System.out.println("Niveau " + compteurNiveau);
                System.out.println();
                Piece[] pieces = CreationPiecesNiveaux(nomfichier);
                Piece[] piecesFINAL = transformationBinChar(pieces);
                String[] puzzle = afficherPlan(piecesFINAL[piecesFINAL.length - 1]);
                String[] FINALPUZZLE = affichagePiece(puzzle, piecesFINAL);
                affichageFINAL(FINALPUZZLE);

                if (isBattu) {
                    compteurNiveau++;
                }


            }while (!isWon&&!isLost);
            if (isWon){
                affichageFinJeuWIN();

            } else if (isLost) {
                affichageFinJeuLOSE();

            }

        }





        /*} catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas ete trouver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */


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
        System.out.println("You died");
        System.out.println(
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⢀⡤⠖⠛⣻⣿⣻⣿⣿⣶⠶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠶⣦⡀⠀⠀⠀⠀⠀⠀⢀⡴⢋⣤⠶⣟⣛⣿⡿⠿⣿⣿⣷⡾⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣇⣤⣿⡇⠀⠀⠀⠀⠀⢀⡞⣦⣨⣿⡳⠉⢛⣋⣤⣤⣘⣷⣿⡇⣼⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠉⣿⣭⡇⠀⠀⠀⠀⠀⢸⡁⣿⡟⠉⠉⠓⠻⠿⠿⠟⠛⠉⠀⠀⠉⢫⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠈⠀⠇⠀⠀⠀⠀⠀⢸⡿⠷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣦⣤⡿⣂⠀⠀⠀⠀⠀⠘⣿⣿⡶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡇⠙⠋⢸⠀⠀⠀⠀⠀⢀⢿⣿⠁⠀⢀⣀⣤⣀⣀⠆⠀⣀⣤⣴⣶⣾⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠤⣿⠀⠀⢸⣀⣀⡀⠀⠀⣿⣻⣻⡂⠚⣫⣽⠿⣻⠟⢁⠀⣿⠛⠛⠹⠛⢿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢀⡇⠀⣾⠀⠀⠸⣇⣈⢹⣤⣄⠻⡿⡝⣇⠀⠀⠀⠈⠉⠀⠘⠚⣷⣄⠀⠀⠀⠘⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣼⠟⠛⣿⠀⠀⠙⢯⠉⠳⣿⠾⣷⡿⣷⢮⢷⡀⠀⠀⣠⠦⣗⠀⣹⣽⣆⠀⠀⢠⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢀⡞⠉⡇⢸⡟⣆⠀⠀⠀⠀⠀⡤⢧⡈⡇⠈⠻⣆⠙⢤⣼⣯⣀⣈⣛⣿⠿⣯⡗⢀⣾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⣿⠛⠀⡇⢶⠀⠸⡄⠀⠀⠀⢸⠁⠀⢹⡇⠀⣰⣿⣄⠈⠃⠙⢿⣦⣤⡴⣾⢿⠇⢸⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠹⡀⢰⡇⠀⠀⠀⢻⠀⠀⠀⢸⡆⠀⠀⣷⣾⣿⣿⠈⢳⡀⠀⠀⠹⣷⣮⡵⠟⠀⣼⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠐⠂⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣧⡀⠘⠳⣄⠀⠀⠀⠀⢀⡴⣻⠀⠀⠰⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠹⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣦⡀⠈⠙⠒⠒⣺⣿⣶⣿⣿⣿⣶⣽⣿⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠈⠓⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣯⢳⣀⠀⢀⣼⣷⣤⣞⣛⠿⣿⠈⠀⢹⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠳⢄⣀⡀⠀⠀⠀⠄⢰⡿⢿⣿⣿⣿⣿⣿⣿⣧⡻⣿⡿⠁⠈⠛⢿⣛⣻⣿⠀⠀⠀⢿⣿⣿⣿⣿⡀⠀⣀⣀⣤⣤⣴⣶⡾⠿⠿⣿⡄⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⣿⠀⠀⣀⣤⠖⠋⣠⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⢹⠿⢛⣦⣀⣀⣨⣿⣿⣿⣿⣿⡿⢻⣿⣻⣭⣭⣤⣤⣄⠀⣿⣇⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡿⠟⠛⠉⠁⣀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⣀⣠⣤⣴⣿⣶⡿⠿⠿⠛⠛⢩⣭⢻⣷⣿⣿⡿⠿⠈⣿⣿⠉⠻⣿⡆⠸⣿⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠠⣎⣁⣠⣴⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠛⠋⣙⣽⣦⣄⠀⢿⣷⡀⠀⢸⣿⠘⣿⣧⠀⠀⠀⠀⢹⣿⣶⣾⣿⣇⠀⣿⣆⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⢿⡛⣿⣯⣭⣴⣾⣿⠁⠀⠀⢰⣿⡟⠛⢿⣷⠈⢿⣧⠀⢸⣿⠀⢹⣿⣿⠿⠇⠀⠘⣿⡏⠉⢹⣿⡄⢸⣿⠀\n" +
                "⠀⠀⠀⢀⣀⣀⣤⣤⣶⣾⡿⠿⢿⠻⠛⠋⣽⣅⠀⠀⢠⣿⣇⠸⣿⡟⠋⠉⠁⠀⠀⠀⠘⣿⡇⠀⠸⣿⡆⠈⢿⣷⣸⣿⠀⠘⣿⣇⢀⣀⣀⡄⢹⣿⡄⠈⠿⠷⠘⣿⡆\n" +
                "⠰⣶⡿⠿⠛⣛⣫⣉⠉⠀⢠⣾⣿⣿⣷⡄⢸⣿⣷⣤⣾⣿⣿⠀⣿⣷⣤⣶⣦⠀⠀⠀⠀⢿⣿⠀⠀⣿⣧⠀⠈⢿⣿⣿⠀⠀⢿⣿⠿⠿⠛⠃⢈⣋⣤⣤⣴⣶⣶⡿⠇\n" +
                "⠀⣿⣇⠀⣼⣿⠿⢿⣿⣆⣿⣿⠀⠈⢿⣷⠈⣿⡏⢿⣿⠉⣿⡇⢸⣿⡏⠉⠁⠀⠀⠀⠀⠘⢿⣷⣶⣿⠏⠀⠀⠈⠛⢃⣀⣀⣤⣴⣶⣾⠿⠿⠿⠛⠋⠉⠉⠀⠀⠀⠀\n" +
                "⠀⠸⣿⠀⢿⣿⠀⠀⢙⣃⠘⣿⣷⣶⣾⣿⡆⢻⣿⠀⠀⠀⢻⣿⠈⣿⣷⣶⣶⣿⠇⠀⠀⠀⢀⣈⣉⣤⣴⣶⣶⠿⠿⠟⠛⠋⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⣿⡇⢸⣿⡆⢸⣿⣿⡀⢿⣿⠉⠈⣿⣧⠸⣿⣧⠀⠀⠘⠿⡃⢘⣉⣡⣤⣤⣴⣾⠿⠿⠟⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⢸⣿⠀⢿⣷⣤⣼⣿⠀⠸⣿⠆⠀⠘⣛⣀⣩⣥⣤⣶⣶⣿⠿⠟⠛⠛⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠈⣿⡇⠀⠉⠛⣋⣡⣤⣤⣶⣶⣶⠿⠟⠛⠛⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⢻⣿⣾⠿⠿⠟⠛⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");

    }
    public static void affichageFinJeuWIN(){
        System.out.println("");System.out.println("");System.out.println("");
        System.out.println("You finally beat all the levels!! You then find a chest and try to open it..");
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
        System.out.println("You found a diamond!!!!");
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
    public static String[] afficherPlan(Piece piece){

            String[] puzzle=new String[Integer.parseInt(piece.getNbLignes())+3];
            int counter=1;
            char charCounter= 'A';
            for (int i=0;i<Integer.parseInt(piece.getNbLignes());i++){
                String ligne="";
                //mettre un numero devant la ligne si tu peux placer une piece sinon ca print un espace
                boolean isPlayable=false;
                for(int k=0;k<Integer.parseInt(piece.getNbColones());k++){
                    if(piece.getDonnees()[i][0].charAt(k)=='0'){
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
                    for(int g=0;g<Integer.parseInt(piece.getNbColones());g++){

                        isPlayable=false;
                        for(int k=0;k<Integer.parseInt(piece.getNbLignes());k++){
                            if(piece.getDonnees()[k][0].charAt(g)=='0'){
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
                    puzzle[0]= charLigne;
                }
                //ajouter les bordures du debut
                String ligneBordureTopBot=" ";
                for(int p=0;p<Integer.parseInt(piece.getNbColones())+2;p++){
                    ligneBordureTopBot+="█";
                }
                puzzle[1]=ligneBordureTopBot;
                puzzle[puzzle.length-1]=ligneBordureTopBot;
                ligne+="█";
                // transformer 0 et 1 en caracteres speciaux
                for (int j=0;j<Integer.parseInt(piece.getNbColones());j++){

                    if(piece.getDonnees()[i][0].charAt(j)=='0'){
                        ligne+="░";
                    }else {
                        ligne += "█";
                    }

                }
                ligne+="█";
                puzzle[i+2]=ligne;

            }


            return puzzle;
    }
    public static String[] affichagePiece(String[] puzzle,Piece[] pieces){
        boolean isComplete=false;
        int counter=0;
        int stringCounter=0;
        int longestPiece=0;
        for(Piece p:pieces){
            int temp=0;
            temp= Integer.parseInt(p.getNbLignes());
            if(temp>longestPiece){
                longestPiece=temp;
            }
        }



        puzzle[counter]+="    Pieces:   ";
        int[] whenNull=new int[pieces.length-1];
        while(!isComplete){
            counter++;
            puzzle[counter]+="              ";
            int whenNullCounter=0;
            for(int i=0;i< pieces.length-1;i++){
                if(stringCounter<Integer.parseInt(pieces[i].getNbLignes())){
                    puzzle[counter]+=pieces[i].getDonnees()[stringCounter][0];
                    whenNull[i]=pieces[i].getDonnees()[stringCounter][0].length();
                }else{
                    String string="";
                    for(int j=0;j<whenNull[whenNullCounter];j++){
                        string+=" ";
                    }
                    puzzle[counter]+=string;
                }
                whenNullCounter++;
                puzzle[counter]+=" ";

            }
            stringCounter++;

            if(counter==longestPiece){
                isComplete=true;

            }
        }
        return puzzle;
    }
    public static void affichageFINAL(String[] puzzle){
        for(String s:puzzle){
            System.out.println(s);
        }

    }

    public static Piece[] transformationBinChar(Piece[] pieces){
        char lettre='z';
        boolean isUsed=false;

        for (int k=0;k< pieces.length-1;k++){
            for(int i=0;i< Integer.parseInt(pieces[k].getNbLignes());i++){
                for (int j=0;j<pieces[k].getDonnees()[i][0].length();j++){
                    if(pieces[k].getDonnees()[i][0].charAt(j)=='0'){
                        pieces[k].getDonnees()[i][0]=pieces[k].getDonnees()[i][0].replace('0','░');
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
        return pieces;

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
            String lire;
            BufferedReader fichier2 = new BufferedReader(new FileReader(nomfichier));
            while ((lire = fichier2.readLine()) != null) {
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
                    tableauPieces[temp] = new Piece(L, C, tabDonnees);
                    temp++;
                    nb1+=nombreChar(donnees);
                    nb0+=donnees.length()-nb1;
                    System.out.println(nb1+" "+nb0);

                } else if (tab[0].equals("G")) {
                    niveauPresent=true;
                    Piece a = new Piece(L, C, tabDonnees);
                    tableauPieces[tableauPieces.length - 1] = a;


                    }
                }
            if (!niveauPresent){
                System.err.println("ERREUR: puzzle n'est pas présent dans le fichier");
                throw new IllegalArgumentException();
            }
            if(nb1!=nb0){
                System.err.println("ERREUR: "+nomfichier+"ne peut pas etre resolu" );
                throw new IllegalArgumentException();

            }

            return tableauPieces;


            }
            catch (IOException e) {
                throw new RuntimeException(e);
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
}