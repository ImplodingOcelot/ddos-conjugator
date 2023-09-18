import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class windowgen {

    private JTextField variable1Field, variable2Field, variable3Field;
    private JButton displayButton;
    private JButton displayButton2;
    private JLabel resultLabel;
    private JComboBox<String> dropdown;

    public windowgen(int windowchoice) throws IOException, InterruptedException {
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
                    conjugators conjugators = new conjugators(variable1Field, variable2Field, variable3Field, resultLabel, dropdown);
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
            madLibs madLibs = new madLibs(variable1Field, resultLabel);
            displayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    madLibs.madLibFiller();
                }
            });
            displayButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resultLabel.setText(madLibs.SentenceFiller());
                }
            });
            frame.add(panel);
            frame.setVisible(true);
        } else if (windowchoice == 3) {
            JFrame frame = new JFrame("Inspirational Quote Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 1000);
            displayButton = new JButton("New quote");
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2, 10, 10));
            JLabel authorDisc = new JLabel();
            JLabel Quote = new JLabel();
            JLabel QuoteBy = new JLabel();
            JLabel title = new JLabel("Quote Generator");
            JLabel title2 = new JLabel("Author Description");
            imagegen catgirl = new imagegen();

            //title.setPreferredSize(new Dimension(500, 100));
            //QuoteBy.setPreferredSize(new Dimension(500, 100));
            //authorDisc.setPreferredSize(new Dimension(500, 200));
//            Quote.setPreferredSize(new Dimension(500, 600));
//            title2.setPreferredSize(new Dimension(500, 200));


            inspirationAPI inspirationAPI = new inspirationAPI();
            inspirationAPI.inspirationAPImain();
            authorDisc.setText(inspirationAPI.getAuthorDisc());
            QuoteBy.setText(inspirationAPI.getQuoteBy());
            Quote.setText(inspirationAPI.getQuote());
            catgirl.imagegenmain("Image of " + inspirationAPI.getQuoteBy());
            ImageIcon image = new ImageIcon("C:\\Users\\ottzj\\Documents\\image.jpg");

            JLabel imageLabel = new JLabel(image);

            imageLabel.setSize(new Dimension(500, 600));
            title.setSize(new Dimension(500, 100));
            QuoteBy.setSize(new Dimension(500, 100));
            authorDisc.setSize(new Dimension(500, 200));
            Quote.setSize(new Dimension(500, 600));
            title2.setSize(new Dimension(500, 200));

            panel.add(title);
            panel.add(QuoteBy);
            panel.add(imageLabel);
            panel.add(Quote);
            panel.add(title2);
            panel.add(authorDisc);
            frame.add(panel);
            frame.setVisible(true);
        }
    }

}
