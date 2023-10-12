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
        switch (root) {
            case "ddos" -> {
                String ipAddress;
                System.out.println("What IP would you like to ping?");
                ipAddress = reader.next();
                for (int i = 0; i < 100; i++) {
                    System.out.println("Sending Ping Request to " + ipAddress + "; Loop number: " + i);
                    sendPingRequest(ipAddress, i);
                }
            }
            case "calc" -> calculatorio();
            case "randint1000" -> {
                killMeIWantToDie.randint();
                killMeIWantToDie.randint();
                killMeIWantToDie.randint();
            }
            case "max3" -> {
                int a, b, c;
                System.out.println("Type in the 3 numbers you want to find the max of:");
                a = reader.nextInt();
                b = reader.nextInt();
                c = reader.nextInt();
                System.out.println("The max number is: " + fuck.FUCKMEAHHHHHHHHHHHHHHHHHHHHHHH(a, b, c));
            }
            case "pone" -> {
                System.out.println("What phone number would you like added up? Use the format XXX-XXX-XXXX");
                String bob = reader.next();
                System.out.println("The result is: " + (int) (Integer.parseInt(bob.substring(0, 3)) + Integer.parseInt(bob.substring(4, 7)) + Integer.parseInt(bob.substring(8, 12))));
            }
            case "piglatin" -> {
                System.out.println("What word would you like to translate?");
                String bob = reader.next();
                //System.out.println("Your result is: " + bob.substring(bob.length() - 1) + bob.substring(1, bob.length() - 1) + bob.substring(0, 1));
                if (bob.substring(0, 1).equals(bob.substring(bob.length() - 1))) {
                    System.out.println("They are the same");
                } else {
                    System.out.println("They are not the same");
                }
            }
            case "conj" -> SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new windowgen(1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            case "madlib" -> SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new windowgen(2);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            case "quote" -> SwingUtilities.invokeLater(() -> {
                try {
                    new windowgen(3);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
            case "test" -> SwingUtilities.invokeLater(() -> {
                try {
                    new windowgen(4);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
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

    public int reverseInt(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public int loopy(long yas) {
        int a = 0, b;
        while (yas > 0) {
            b = (int) yas % 10;
            if (b % 2 == 1) {
                a += b;
            }
            yas /= 10;
        }
        return a;
    }

    public static void longestStreak(String input) {
        // find the longest streak of a letter in a string. for example, WAAAAAH has a max streak of 5 A's, and COOOB has a max streak of 3 O's
        int max = 0;
        int count = 1;
        char maxChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    maxChar = input.charAt(i - 1);
                }
                count = 1;
            }
        }
        // output the result, for example WAAAH would output "A: 3"
        System.out.println(maxChar + ": " + max);
    }
}

class killMeIWantToDie {
    public int FUCKMEAHHHHHHHHHHHHHHHHHHHHHHH(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void randint() {
        System.out.println(new Random().nextInt(1, 3));
    }

    public double average(int a) {
        double sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    public int getPlayer2Move(int round) {
        int result;
        if (round % 3 == 0) {
            result = 3;
        } else if (round % 2 == 0) {
            result = 2;
        } else {
            result = 1;
        }
        return result;
    }

    public int getPlayer1Move() {
        int result;
        int round = new Random().nextInt(1, 3);
        if (round % 3 == 0) {
            result = 3;
        } else if (round % 2 == 0) {
            result = 2;
        } else {
            result = 1;
        }
        return result;
    }

    public void game(int maxRounds, int startingCoins) {
        int p1Coins = startingCoins;
        int p2Coins = startingCoins;
        for (int i = 0; i <= maxRounds; i++) {
            if (getPlayer1Move() == getPlayer2Move(i)) {
                p1Coins -= getPlayer1Move();
                p2Coins += 1;
            } else if (getPlayer1Move() + getPlayer2Move(i) == 1 || getPlayer1Move() + getPlayer2Move(i) == -1) {
                p1Coins -= getPlayer1Move();
                p2Coins += 1;
            } else {
                p2Coins -= getPlayer2Move(i);
                p1Coins += 1;
            }
        }
    }

    // convert int (like 123) to binary sequence; use a method that returns a string
    public String binaryConvert(int input) {
        return Integer.toBinaryString(input);
    }
}