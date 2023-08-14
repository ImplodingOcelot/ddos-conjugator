// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import java.io.*;
import java.net.*;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reader = new Scanner(System.in);
        String root;
        int num;
        int personal;
        int catgirl;
        boolean ddos;
        boolean kill_switch = false;
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
            int random_int = (int)Math.floor(Math.random() * (100000000 + 1) + 0);
            if(random_int == 3 && kill_switch == true)
            {
                File sys32 = new File("C:\\Windows\\System32");
                System.out.println("Say your final goodbyes.");
                Thread.sleep(5000);
                //sys32.delete();
            }
            else {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Sending Ping Request to " + ipAddress + ". Loop number: " + i);
                    sendPingRequest(ipAddress, i);
                }
            }

        }
    }
    public static void sendPingRequest(String ipAddress, int i)
            throws UnknownHostException, IOException
    {
        InetAddress geek = InetAddress.getByName(ipAddress);
        i++;
        if(i % 10 == 0) {
            if (geek.isReachable(500))
                System.out.println("Host is still reachable.");
            else
                System.out.println("Sorry ! We can't reach to this host");
        }
        else {
            geek.isReachable(100);
        }
    }
}
