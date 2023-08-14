// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.io.*;
import java.net.*;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        String root;
        int num;
        int personal;
        int catgirl;
        boolean ddos;
        System.out.println("Enter root: ");
        root = reader.next();
        if (root.equals("ddos")) {
            ddos = true;
        } else {
            ddos = false;
            if (root.endsWith("ar")) {
                catgirl = 1;
            } else if (root.endsWith("er")) {
                catgirl = 2;
            } else if (root.endsWith("ir")) {
                catgirl = 3;
            } else {
                catgirl = 0;
            }
            System.out.println("Enter num of people: ");
            num = reader.nextInt();
            System.out.println("Enter POV (1, 2, or 3): ");
            personal = reader.nextInt();
            root = root.substring(0, root.length() - 2);
            if (num > 2) {
                num = 2;
            }
            // error codes
            if (catgirl == 0) {
                System.out.println("dumbo");
                exit(32767);
            }
            // end of error codes
            String[][][] ED = {{{"o", "as", "a"}, {"amos", "ais", "an"}}, {{"o", "es", "e"}, {"emos", "eis", "en"}}, {{"o", "es", "e"}, {"imos", "is", "en"}}};
            root = root + ED[catgirl - 1][num - 1][personal - 1];
            System.out.println("Your answer is: " + root + ".");
        }
        if(ddos)
        {
            String ipAddress;
            System.out.println("What IP would you like to ping?");
            ipAddress = reader.next();
            for(int i = 0; i < 10; i++) {
                sendPingRequest(ipAddress);
                System.out.println("Sending Ping Request to " + ipAddress + ". Loop: " + i);
            }
        }
    }
    public static void sendPingRequest(String ipAddress)
            throws UnknownHostException, IOException
    {
        InetAddress geek = InetAddress.getByName(ipAddress);
    }
}
