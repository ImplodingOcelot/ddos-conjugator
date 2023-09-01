import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class windowgen {

    private JTextField variable1Field, variable2Field, variable3Field;
    private JButton displayButton;
    private JLabel resultLabel;
    private JComboBox<String> dropdown;

    public windowgen(int windowchoice) {
        if (windowchoice == 1) {
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
            dropdown = new JComboBox<>(new String[]{"Spanish", "French", "Italian"});

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
        } else if (windowchoice == 2) {
            JFrame frame = new JFrame("Madlibs");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 1, 10, 10));
            variable1Field = new JTextField();
            // rows
            panel.add(new JLabel("Type the story you want to. Replace all adjectives, nouns, and verbs with [adj], [noun], [verb] respectively."));
            panel.add(variable1Field);
            displayButton = new JButton("Fill In");
            panel.add(new JLabel("Root:"));
            panel.add(resultLabel);
        }
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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

    private void madLibFiller() {
        String[] nouns = {"a"};
        String[] verbs = {"a"};
        String[] adjectives = {"a"};
        String[] wordsSplitUp = variable1Field.toString().split(" ");
        String finalArea = "";
        for (int i = 0; i < wordsSplitUp.length; i++) {
            switch (wordsSplitUp[i]) {
                case "[adj]" -> {
                    finalArea = finalArea + adjectives[new Random().nextInt(1, adjectives.length)];
                }
                case "[noun]" -> {
                    finalArea = finalArea + (nouns[new Random().nextInt(1, adjectives.length)]);
                }
                case "[verb]" -> {
                    finalArea = finalArea + (verbs[new Random().nextInt(1, adjectives.length)]);
                }
                default -> {
                    finalArea = finalArea + (wordsSplitUp[i]);
                }
            }
        }
        resultLabel.setText(finalArea);
    }
}
