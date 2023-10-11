import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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
            JTextArea authorDisc = new JTextArea();
            authorDisc.setEditable(false);
            authorDisc.setWrapStyleWord(true);
            authorDisc.setLineWrap(true);
            authorDisc.setOpaque(false);
            JTextArea Quote = new JTextArea();
            Quote.setWrapStyleWord(true);
            Quote.setEditable(false);
            Quote.setOpaque(false);
            Quote.setWrapStyleWord(true);
            Quote.setLineWrap(true);
            //JTextArea QuoteBy = new JTextArea();
            //QuoteBy.setEditable(false);
            //QuoteBy.setWrapStyleWord(true);
            //QuoteBy.setLineWrap(true);
            JTextArea title = new JTextArea("Quote Generator");
            title.setEditable(false);
            title.setWrapStyleWord(true);
            title.setLineWrap(true);
            title.setOpaque(false);
            JTextArea title2 = new JTextArea("Author Description");
            title2.setEditable(false);
            title2.setLineWrap(true);
            title2.setOpaque(false);
            title2.setWrapStyleWord(true);

            imagegen catgirl = new imagegen();

            inspirationAPI inspirationAPI = new inspirationAPI();
            inspirationAPI.inspirationAPImain();
            authorDisc.setText(inspirationAPI.getAuthorDisc());
            //QuoteBy.setText(inspirationAPI.getQuoteBy());
            Quote.setText(inspirationAPI.getQuote());
            catgirl.imagegenmain("Image of " + inspirationAPI.getQuoteBy());
            ImageIcon image = new ImageIcon("C:\\Users\\ottzj\\Documents\\image.jpg");

            JLabel imageLabel = new JLabel(image);

            JPanel imageLabelPanel = new JPanel();
            JPanel titleLabelPanel = new JPanel();
            //JPanel quoteByLabelPanel = new JPanel();
            JPanel quoteLabelPanel = new JPanel();
            JPanel title2LabelPanel = new JPanel();
            JPanel authorDiscLabelPanel = new JPanel();
            JScrollPane scrPane = new JScrollPane(authorDisc);
            imageLabelPanel.setPreferredSize(new Dimension(500, 600));
            titleLabelPanel.setPreferredSize(new Dimension(500, 100));
            //quoteByLabelPanel.setPreferredSize(new Dimension(500, 100));
            authorDiscLabelPanel.setPreferredSize(new Dimension(500, 200));
            quoteLabelPanel.setPreferredSize(new Dimension(500, 600));
            title2LabelPanel.setPreferredSize(new Dimension(500, 200));
            imageLabel.setSize(500, 600);
            title.setSize(100, 100);
            Quote.setSize(500, 600);
            authorDisc.setSize(1000, 200);
            title2.setSize(500, 200);
            imageLabelPanel.add(imageLabel);
            titleLabelPanel.add(title);
            quoteLabelPanel.add(Quote);
            authorDiscLabelPanel.add(scrPane);
            title2LabelPanel.add(title2);

            frame.add(imageLabelPanel, BorderLayout.CENTER);
            frame.add(titleLabelPanel, BorderLayout.NORTH);
            frame.add(quoteLabelPanel, BorderLayout.WEST);
            frame.add(title2LabelPanel, BorderLayout.SOUTH);
            frame.add(authorDiscLabelPanel, BorderLayout.SOUTH);

            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
        } else if (windowchoice == 4) {
            JFrame frame = new JFrame("Weather Forecaster");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 700);
            weatherFore forecast = new weatherFore();
            ArrayList<String> alerts;
            JComboBox alertChoice = new JComboBox<>();
            // alert format [state, alert, alert description, alert area disc, severity]
            JTextField state = new JTextField();
            JTextArea disc = new JTextArea();
            disc.setEditable(false);
            disc.setWrapStyleWord(true);
            disc.setLineWrap(true);
            disc.setOpaque(false);
            ArrayList<String> alertList = new ArrayList<>();
            JButton displayButton = new JButton("Update");
            displayButton.addActionListener(e -> {
                alertList.clear();
                alertChoice.removeAllItems();
                for (int i = 0; i < forecast.getCount(state.getText()); i++) {
                    System.out.println(i + ": " + forecast.getAlert(state.getText(), i).get(1) + ", in: " + forecast.getAlert(state.getText(), i).get(3));
                    alertList.add(i + ": " + forecast.getAlert(state.getText(), i).get(1) + ", in: " + forecast.getAlert(state.getText(), i).get(3));
                    alertChoice.addItem(alertList.get(i));
                }
                disc.setText(forecast.getAlert(state.getText(), 0).get(2));
                disc.setText(disc.getText().replace("...", ":").replace("*", "\n"));
            });
            alertChoice.addActionListener(e -> {
                disc.setText(forecast.getAlert(state.getText(), alertChoice.getSelectedIndex()).get(2));
                disc.setText(disc.getText().replace("...", ":").replace("*", "\n"));
            });
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 1, 10, 10));
            panel.add(state);
            panel.add(displayButton);
            panel.add(alertChoice);
            panel.add(disc);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
}
/**/