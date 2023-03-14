import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    //░
    //█
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {

        MainMethod();


    }
    public static String FileInUse(){
        int counter=10;
        String fileInUse="niveau"+counter+".txt";
        counter++;
        return fileInUse;

    }






    public static void MainMethod(){

            afficherIntro();
            String nomfichier=FileInUse();
            Piece[] a=CreationPiecesNiveaux(nomfichier);
         for (Piece s: a){
             System.out.println(s);

        }
         afficherPlan(a[a.length-1]);



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

        affichageFinJeuWIN();
        affichageFinJeuLOSE();
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
    public static void afficherPlan(Piece niveau){

            String[] puzzle=new String[Integer.parseInt(niveau.getNbLignes())];
            for (int i=0;i<Integer.parseInt(niveau.getNbLignes());i++){
                String ligne="";
                for (int j=0;j<Integer.parseInt(niveau.getNbColones());j++){
                    if(niveau.getDonnees()[i][j].compareTo("0")==0){
                        ligne+="░";
                    }else {

                        ligne += "█";

                    }
                }
                puzzle[i]=ligne;

            }

            for(String s:puzzle){
                System.out.println(s);
            }




    }
    static Piece[] CreationPiecesNiveaux(String nomfichier) {
        try {
            //nb de pieces
            BufferedReader fichier=new BufferedReader(new FileReader(nomfichier));
            String read;
            int nbPiece=-1;
            while ((read= fichier.readLine()) != null) {
                nbPiece++;
            }
            Piece[] tableauPieces =new Piece[nbPiece+1];
            int temp=0;
            String lire;
            BufferedReader fichier2=new BufferedReader(new FileReader(nomfichier));
            while ((lire= fichier2.readLine()) != null){
                validationLigne(lire);
                System.out.println(lire);
                String[] tab = (lire.split("\\|"));
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
                    //figure out how to use continue;

                }else if (tab[0].equals("G")){
                    Piece a=new Piece(L,C,tabDonnees);
                    tableauPieces[tableauPieces.length-1]=a;



                }
            }
            return tableauPieces;


        }catch(IOException e){
            throw new RuntimeException(e);
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
}