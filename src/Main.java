// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import java.io.*;
import java.net.*;
import static java.lang.System.exit;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reader = new Scanner(System.in);
        String root;
        int num;
        int personal;
        int catgirl;
        int area = 0;
        boolean kill_switch = false;
        System.out.println("Enter root: ");
        root = reader.next();
        if (root.equals("ddos")) {
            area = 1;
        } else if (root.equals("WINDOW")){
            area = 2;
        }
        else {
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
            if(root.length() < 2)
            {
                System.out.print("not long enough LMAO");
                exit(12);
            }
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
        if(area == 1)
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
        if(area == 2)
        {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new VariableDisplaySwing();
                }
            });
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
    public static class VariableDisplaySwing {

        private JTextField variable1Field, variable2Field, variable3Field;
        private JButton displayButton;
        private JLabel resultLabel;

        public VariableDisplaySwing() {
            JFrame frame = new JFrame("Variable Display Window");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 2, 10, 10));

            variable1Field = new JTextField();
            variable2Field = new JTextField();
            variable3Field = new JTextField();
            displayButton = new JButton("Display");
            resultLabel = new JLabel();

            panel.add(new JLabel("Root:"));
            panel.add(variable1Field);
            panel.add(new JLabel("Personal (int):"));
            panel.add(variable2Field);
            panel.add(new JLabel("Number of People (int):"));
            panel.add(variable3Field);
            panel.add(displayButton);
            panel.add(resultLabel);

            displayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displaySelectedVariable();
                }
            });

            frame.add(panel);
            frame.setVisible(true);
        }

        private void displaySelectedVariable() {
            String selectedValue = "";
            int catgirl;
            Scanner reader = new Scanner(System.in);
            int personal = Integer.parseInt(variable2Field.getText());
            int num = Integer.parseInt(variable3Field.getText());
            if (!variable1Field.getText().isEmpty() && !variable2Field.getText().isEmpty() && !variable3Field.getText().isEmpty()) {


                    if (variable1Field.getText().endsWith("ar")) {
                        catgirl = 1;
                    } else if (variable1Field.getText().endsWith("er")) {
                        catgirl = 2;
                    } else if (variable1Field.getText().endsWith("ir")) {
                        catgirl = 3;
                    } else {
                        catgirl = 0;
                    }
                    if(variable1Field.getText().length() < 2)
                    {
                        System.out.print("not long enough LMAO");
                        exit(12);
                    }
                    String helpMe = variable1Field.getText().substring(0, variable1Field.getText().length() - 2);
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
                    helpMe = helpMe + ED[catgirl - 1][num - 1][personal - 1];
                    System.out.println("Your answer is: " + helpMe + ".");
                    selectedValue = helpMe;
            } else {
                selectedValue = "Fill in all variables!";
            }

            resultLabel.setText("Selected variable: " + selectedValue);
        }
    }
}
