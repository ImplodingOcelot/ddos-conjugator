import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.Scanner;

public class conjugators {
    private JTextField variable1Field, variable2Field, variable3Field;
    private JLabel resultLabel;
    private JComboBox<String> dropdown;

    public conjugators(JTextField variable1Field, JTextField variable2Field, JTextField variable3Field, JLabel resultLabel, JComboBox<String> dropdown) {
        this.variable1Field = variable1Field;
        this.variable2Field = variable2Field;
        this.variable3Field = variable3Field;
        this.resultLabel = resultLabel;
        this.dropdown = dropdown;
        displaySelectedVariable();
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
                selectedValue = conjugators.spanishConjugation(Integer.parseInt(variable2Field.getText()), Integer.parseInt(variable3Field.getText()), variable1Field.getText());
                System.out.println("a");
            } else if (!variable1Field.getText().isEmpty() && !variable2Field.getText().isEmpty() && !variable3Field.getText().isEmpty() && selectedOption.equals("French")) {
                selectedValue = conjugators.frenchConjugation(Integer.parseInt(variable2Field.getText()), Integer.parseInt(variable3Field.getText()), variable1Field.getText());
            } else if (!variable1Field.getText().isEmpty() && !variable2Field.getText().isEmpty() && !variable3Field.getText().isEmpty() && selectedOption.equals("Italian")) {
                selectedValue = conjugators.pizzaConjugation(Integer.parseInt(variable2Field.getText()), Integer.parseInt(variable3Field.getText()), variable1Field.getText());
            } else {
                selectedValue = "Fill in all fields!";
            }
        } catch (Exception ex) {
            resultLabel.setText("An error occurred: " + ex.getMessage() + "; try again.");
        }
        ;
        resultLabel.setText("Selected variable: " + selectedValue);
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
        for (int k = 0; k < IrregVerbs.length / 2; k++) {
            String s = IrregVerbs[k * 2][0][0];

            if (root.equals(s)) {
                i = true;
                b = k;
            }
        }
        if (i) {
            if (num > 2) {
                num = 2;
            }
            root = IrregVerbs[b + 1][num - 1][personal - 1];
            System.out.println("spn IRRG conj out: " + root + ".");
        } else {
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

    public static String pizzaConjugation(int personal, int num, String root) throws IOException, URISyntaxException {
        int catgirl;
        Scanner reader = new Scanner(System.in);
        if (root.equals("pizza")) {
            if (Desktop.isDesktopSupported()) {
                int randomized = new Random().nextInt(1, 10);
                Desktop desktop = Desktop.getDesktop();
                URI uri = URI.create("about:blank");
                switch (randomized) {
                    case 1:
                        uri = new URI("https://www.lilriccispizza.com//");
                        break;
                    case 2:
                        uri = new URI("https://parryspizza.com/locations/");
                        break;
                    case 3:
                        uri = new URI("https://littlecaesars.com/");
                        break;
                    case 4:
                        uri = new URI("https://www.papajohns.com/");
                        break;
                    case 5:
                        uri = new URI("https://blackjackpizza.com/blackjack-locations/");
                        break;
                    case 6:
                        uri = new URI("https://www.papamurphys.com/");
                        break;
                    case 7:
                        uri = new URI("https://modpizza.com/menu/");
                        break;
                    case 8:
                        uri = new URI("https://www.colonnaspizza.com/");
                        break;
                    case 9:
                        uri = new URI("https://www.dominos.com/en/");
                        break;
                    case 10:
                        uri = new URI("https://www.miciitalian.com/");
                        break;
                }
                desktop.browse(uri);
            }
            return "Mamma mia dats allota PIZZA!";
        }
        if (root.endsWith("are")) {
            catgirl = 1;
        } else if (root.endsWith("ere")) {
            catgirl = 2;
        } else if (root.endsWith("ire")) {
            catgirl = 3;
        } else {
            catgirl = 0;
        }
        root = root.substring(0, root.length() - 3);
        if (num > 2) {
            num = 2;
        }
        String[][][] ED = {{{"o", "i", "a"}, {"iamo", "ate", "ano"}}, {{"o", "i", "e"}, {"iamo", "ete", "ono"}}, {{"o", "i", "e"}, {"iamo", "ite", "ono"}}};
        root = root + ED[catgirl - 1][num - 1][personal - 1];
        return root;
    }
}
