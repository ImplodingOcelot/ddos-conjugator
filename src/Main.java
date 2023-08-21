// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reader = new Scanner(System.in);
        String root;
        int area;
        boolean kill_switch = false;
        System.out.println("Enter program selection: ");
        root = reader.next();
        if (root.equals("ddos")) {
            area = 1;
        } else {
            area = 2;
        }
        if(area == 1)
        {
            String ipAddress;
            System.out.println("What IP would you like to ping?");
            ipAddress = reader.next();
                for (int i = 0; i < 100; i++) {
                    System.out.println("Sending Ping Request to " + ipAddress + ". Loop number: " + i);
                    sendPingRequest(ipAddress, i);
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
        private JComboBox<String> dropdown;

        public VariableDisplaySwing() {
            JFrame frame = new JFrame("Variable Display Window");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 2, 10, 10));

            variable1Field = new JTextField();
            variable2Field = new JTextField();
            variable3Field = new JTextField();
            displayButton = new JButton("Display");
            resultLabel = new JLabel();
            dropdown = new JComboBox<>(new String[]{"Spanish", "French"});

            panel.add(new JLabel("Select Option:"));
            panel.add(dropdown);
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
            String selectedOption = (String) dropdown.getSelectedItem();
            Scanner reader = new Scanner(System.in);
            try {
                int personal = Integer.parseInt(variable2Field.getText());
                int num = Integer.parseInt(variable3Field.getText());
            } catch (Exception ex) {
                resultLabel.setText("An error occurred: " + ex.getMessage() + "; try again.");
            }

            try {
            if (!variable1Field.getText().isEmpty() && !variable2Field.getText().isEmpty() && !variable3Field.getText().isEmpty() && selectedOption.equals("Spanish")) {
                selectedValue = spanishConjugation(Integer.parseInt(variable2Field.getText()),Integer.parseInt(variable3Field.getText()),variable1Field.getText());
                System.out.println("a");
            } else if (!variable1Field.getText().isEmpty() && !variable2Field.getText().isEmpty() && !variable3Field.getText().isEmpty() && selectedOption.equals("French")) {
                selectedValue = frenchConjugation(Integer.parseInt(variable2Field.getText()),Integer.parseInt(variable3Field.getText()),variable1Field.getText());
            } else {
                selectedValue = "Fill in all fields!";
            }
            } catch (Exception ex)
            {
                resultLabel.setText("An error occurred: " + ex.getMessage() + "; try again.");
            };
            resultLabel.setText("Selected variable: " + selectedValue);
        }
    }
    public static String spanishConjugation(int personal, int num, String root) {
        int catgirl;
        Scanner reader = new Scanner(System.in);
        if (root.endsWith("ar")) {
            catgirl = 1;
        } else if (root.endsWith("er")) {
            catgirl = 2;
        } else if (root.endsWith("ir")) {
            catgirl = 3;
        } else {
            catgirl = 0;
        }
        String[][][] ED = {{{"o", "as", "a"}, {"amos", "ais", "an"}}, {{"o", "es", "e"}, {"emos", "eis", "en"}}, {{"o", "es", "e"}, {"imos", "is", "en"}}};
        // {{"ser"}}, {{"soy", "eres", "es"}, {"somos", "sois", "son"}} example for irreg format
        String[][][] IrregVerbs = {{{"ser"}}, {{"soy", "eres", "es"}, {"somos", "sois", "son"}}};
        String tester;
        boolean i = false;
        int b = 0;
        for(int k = 0; k < IrregVerbs.length/2; k++)
        {
            String s = IrregVerbs[k*2][0][0];

            if (root.equals(s))
            {
                i = true;
                b=k;
            }
        }
        if(i)
        {
            if (num > 2) {
                num = 2;
            }
            root = IrregVerbs[b+1][num - 1][personal - 1];
            System.out.println("spn IRRG conj out: " + root + ".");
        }
        else {
            root = root.substring(0, root.length() - 2);
            if (num > 2) {
                num = 2;
            }
            root = root + ED[catgirl - 1][num - 1][personal - 1];
            System.out.println("spn conj out: " + root + ".");
        }
        return root;
    }
    public static String frenchConjugation(int personal, int num, String root) {
        int catgirl;
        Scanner reader = new Scanner(System.in);
        if (root.endsWith("er")) {
            catgirl = 1;
        } else if (root.endsWith("ir")) {
            catgirl = 2;
        } else if (root.endsWith("re")) {
            catgirl = 3;
        } else {
            catgirl = 0;
        }
        root = root.substring(0, root.length() - 2);
        if (num > 2) {
            num = 2;
        }
        String[][][] ED = {{{"e", "es", "e"}, {"ons", "ez", "ent"}}, {{"is", "is", "it"}, {"issons", "issez", "issent"}}, {{"s", "s", ""}, {"ons", "ez", "ent"}}};
        root = root + ED[catgirl - 1][num - 1][personal - 1];
        return root;
    }
}