import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class windowgen {

    private JTextField variable1Field, variable2Field, variable3Field;
    private JButton displayButton;
    private JButton displayButton2;
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
            resultLabel = new JLabel();
            displayButton = new JButton("Display");
            displayButton2 = new JButton("Generate Random Sentence");
            // rows
            panel.add(new JLabel("Type the story you want to. Replace all adjectives, nouns, and verbs with [a], [n], [v] respectively."));
            panel.add(variable1Field);
            panel.add(displayButton);
            panel.add(displayButton2);
            panel.add(new JLabel("Result:"));
            panel.add(resultLabel);
            displayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    madLibFiller();
                }
            });
            displayButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resultLabel.setText(SentenceFiller());
                }
            });
            frame.add(panel);
            frame.setVisible(true);
        }
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
        String[] nouns = {"cow", "barn", "you", "Mr. Gardener", "catgirl", "tgirl", "femboy", "madLibs", "shop", "circus", "folder", "Elgritch, the leader of the Underworld", "your dad"};
        String[] verbs = {"ran", "climbed", "thought", "felt", "conjugated", "coded", "wasted", "typed", "fucked", "transitioned"};
        String[] adjectives = {"fatass", "fucked", "smart", "tall", "short", "large", "fast", "motherly", "stupid", "fucked"};
        String[] wordsSplitUp = variable1Field.getText().split(" ");
        StringBuilder finalArea = new StringBuilder();
        int random;
        for (int i = 0; i < wordsSplitUp.length; i++) {
            switch (wordsSplitUp[i]) {
                case "[a]" -> {
                    finalArea.append(adjectives[new Random().nextInt(0, adjectives.length)]);
                }
                case "[n]" -> {
                    finalArea.append(nouns[new Random().nextInt(0, nouns.length)]);
                }
                case "[v]" -> {
                    finalArea.append(verbs[new Random().nextInt(0, verbs.length)]);
                }
                default -> {
                    finalArea.append(wordsSplitUp[i]);
                }
            }
            finalArea.append(" ");
        }
        for (int i = 0; i < wordsSplitUp.length; i++) {
            System.out.println(wordsSplitUp[i]);
        }
        resultLabel.setText(finalArea.toString());
    }

    private String SentenceFiller() {
        // [article] [adj] [noun] [verb] [to] [article] [adj] [verb].
        // [article] [adj] [noun] [verb].
        // [article] [noun] [verb] alot.
        String[] article = {"A ", "The "};
        String[] nouns = {"cow ", "barn ", "you ", "Mr. Gardener ", "catgirl ", "tgirl ", "femboy ", "madLibs ", "shop ", "circus ", "folder ", "Elgritch, the leader of the Underworld ", "your dad "};
        String[] verbs = {"ran ", "climbed ", "thought ", "felt ", "conjugated ", "coded ", "wasted ", "typed ", "fucked ", "transitioned "};
        String[] adjectives = {"fatass ", "fucked ", "smart ", "tall ", "short ", "large ", "fast ", "motherly ", "stupid ", "fucked "};
        int random = (int) (Math.random() * 3 + 1); // will return either 1, 2, 3
        if (random == 2) {
            return article[new Random().nextInt(0, article.length)] + nouns[new Random().nextInt(0, nouns.length)] + verbs[new Random().nextInt(0, verbs.length)] + "to " + article[new Random().nextInt(0, article.length)].toLowerCase() + adjectives[new Random().nextInt(0, adjectives.length)] + nouns[new Random().nextInt(0, nouns.length)] + ".";
        }
        if (random == 1) {
            return article[new Random().nextInt(0, article.length)] + nouns[new Random().nextInt(0, nouns.length)] + verbs[new Random().nextInt(0, verbs.length)] + "alot.";
        } else {
            int random2 = new Random().nextInt(0, verbs.length);
            return article[new Random().nextInt(0, article.length)] + nouns[new Random().nextInt(0, nouns.length)] + verbs[random2].substring(0, verbs[random2].length() - 1) + ".";
        }
    }
}
