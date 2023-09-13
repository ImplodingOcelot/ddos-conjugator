import jdk.jshell.JShell;

import javax.script.ScriptException;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ScriptException {
        Scanner reader = new Scanner(System.in);
        killMeIWantToDie fuck = new killMeIWantToDie();
        String root;
        int area;
        boolean kill_switch = false;
        System.out.println("Enter program selection: ");
        root = reader.next();
        if (root.equals("ddos")) {
            String ipAddress;
            System.out.println("What IP would you like to ping?");
            ipAddress = reader.next();
            for (int i = 0; i < 100; i++) {
                System.out.println("Sending Ping Request to " + ipAddress + "; Loop number: " + i);
                sendPingRequest(ipAddress, i);
            }
        } else if (root.equals("calc")) {
            calculatorio();
        } else if (root.equals("randint1000")) {
            killMeIWantToDie.randint();
            killMeIWantToDie.randint();
            killMeIWantToDie.randint();
        } else if (root.equals("max3")) {
            int a, b, c;
            System.out.println("Type in the 3 numbers you want to find the max of:");
            a = reader.nextInt();
            b = reader.nextInt();
            c = reader.nextInt();
            System.out.println("The max number is: " + fuck.FUCKMEAHHHHHHHHHHHHHHHHHHHHHHH(a, b, c));
        } else if (root.equals("pone")) {
            System.out.println("What phone number would you like added up? Use the format XXX-XXX-XXXX");
            String bob = reader.next();
            System.out.println("The result is: " + (int) (Integer.parseInt(bob.substring(0, 3)) + Integer.parseInt(bob.substring(4, 7)) + Integer.parseInt(bob.substring(8, 12))));
        } else if (root.equals("piglatin")) {
            System.out.println("What word would you like to translate?");
            String bob = reader.next();
            //System.out.println("Your result is: " + bob.substring(bob.length() - 1) + bob.substring(1, bob.length() - 1) + bob.substring(0, 1));
            if (bob.substring(0, 1).equals(bob.substring(bob.length() - 1))) {
                System.out.println("They are the same");
            } else {
                System.out.println("They are not the same");
            }
        } else if (root.equals("conj")) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new windowgen(1);
                }
            });
        } else if (root.equals("madlib")) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new windowgen(2);
                }
            });
        }
    }

    public static void sendPingRequest(String ipAddress, int i)
            throws UnknownHostException, IOException {
        InetAddress geek = InetAddress.getByName(ipAddress);
        i++;
        if (i % 10 == 0) {
            if (geek.isReachable(500))
                System.out.println("Host is still reachable.");
            else
                System.out.println("Sorry ! We can't reach to this host");
        } else {
            geek.isReachable(100);
        }
    }

    public static void calculatorio() throws ScriptException, IOException {
        try (JShell js = JShell.create(); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            js.onSnippetEvent(snip -> {
                if (snip.status() == jdk.jshell.Snippet.Status.VALID) {
                    System.out.println("➜ " + snip.value());
                }
            });

            System.out.print("> ");
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                js.eval(js.sourceCodeAnalysis().analyzeCompletion(line).source());
                System.out.print("> ");
            }
        }
    }


}

class killMeIWantToDie {
    public int FUCKMEAHHHHHHHHHHHHHHHHHHHHHHH(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void randint() {
        System.out.println(new Random().nextInt(1, 1000));
    }
}

/*
class Scratch {
    public static void main(String[] args) {

    }
}
class Tweet {
    String message;
    int retweets;
    int likes;

    public void constructor(String message_, int likes_, int retweets_) {
        this.message = message_;
        this.likes = likes_;
        this.retweets = retweets_;
    }
    public void addLike(int addLike) {
        this.likes += addLike;
    }
    public void addRetweet(int addedRetweets) {
        this.retweets += addedRetweets;
    }
    public boolean notLiked() {
        return this.likes < 10;
    }
    public boolean kindaLiked() {
        return this.likes < this.retweets;
    }
    public boolean isTrending() {
        return this.likes + this.retweets > 75;
    }
    public String ToString()
    {
        return "Message: " + this.message + " Likes: " + this.likes + " Retweets: " + this.retweets;
    }
}
 */