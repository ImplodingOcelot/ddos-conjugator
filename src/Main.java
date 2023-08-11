// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String root;
        int num;
        int personal;
        int catgirl;
        System.out.println("Enter root: ");
        root = reader.next();
        if(root.endsWith("ar")) { catgirl = 1; }
        else if(root.endsWith("er")) { catgirl = 2; }
        else if(root.endsWith("ir")) { catgirl = 3; }
        else {catgirl = 0;}
        System.out.println("Enter num of people: ");
        num = reader.nextInt();
        System.out.println("Enter POV (1, 2, or 3): ");
        personal = reader.nextInt();
        root = root.substring(0,root.length() - 2);
        //
        String[][][] ED = {{{"o", "as", "a"}, {"amos", "ais", "an"}}, {{"o", "es", "e"}, {"emos", "eis", "en"}}, {{"o", "es", "e"}, {"imos", "is", "en"}}};
        root = root + ED[catgirl-1][num-1][personal-1];
        System.out.println("Your answer is: " + root + ".");
    }
}