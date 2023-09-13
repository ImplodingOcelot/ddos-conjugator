import javax.swing.*;
import java.util.Random;

public class madLibs {
    JTextField variable1Field;
    JLabel resultLabel;

    public madLibs(JTextField variable1Field, JLabel resultLabel) {
        this.variable1Field = variable1Field;
        this.resultLabel = resultLabel;
    }

    void madLibFiller() {
        String[] nouns = {"cow", "barn", "you", "Mr. Gardener", "catgirl", "tgirl", "femboy", "madLibs", "shop", "circus", "folder", "Elgritch, the leader of the Underworld", "your dad"};
        String[] verbs = {"ran", "climbed", "thought", "felt", "conjugated", "coded", "wasted", "typed", "fucked", "transitioned"};
        String[] adjectives = {"fatass", "fucked", "smart", "tall", "short", "large", "fast", "motherly", "stupid", "fucked"};
        String[] wordsSplitUp = variable1Field.getText().split(" ");
        StringBuilder finalArea = new StringBuilder();
        for (String s : wordsSplitUp) {
            switch (s) {
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
                    finalArea.append(s);
                }
            }
            finalArea.append(" ");
        }
        for (int i = 0; i < wordsSplitUp.length; i++) {
            System.out.println(wordsSplitUp[i]);
        }
        resultLabel.setText(finalArea.toString());
    }

    String SentenceFiller() {
        // [article] [adj] [noun] [verb] [to] [article] [adj] [verb].
        // [article] [adj] [noun] [verb].
        // [article] [noun] [verb] alot.
        // [noun].firstLetterCaps, the destroyer of worlds, commands you: become a [adjective] [noun] now.
        // The primary directive of this mission is simple. You must [verb] a [noun], [adjtively]ly.
        // [article] [noun] [verb] to [article] [adjective] [noun].
        // [article] [noun] [verb] to [article] [noun].
        // It was the last time [noun] [verb] [adjective]ly.
        String[] article = {"A ", "The "};
        String[] nouns = {"cow ", "barn ", "you ", "Mr. Gardener ", "catgirl ", "tgirl ", "femboy ", "madLibs ", "shop ", "circus ", "folder ", "Elgritch, the leader of the Underworld ", "ur dad "};
        String[] verbs = {"ran ", "climbed ", "thought ", "feel ", "conjugated ", "coded ", "wasted ", "typed ", "fucked ", "transitioned "};
        String[] adjectives = {"fatass ", "fucked ", "smart ", "tall ", "short ", "large ", "fast ", "motherly ", "stupid ", "fucked "};
        int random = (int) (Math.random() * 8 + 1); // will return 1 - 8
        System.out.println(random);
        if (random == 1) {
            return article[new Random().nextInt(0, article.length)] + nouns[new Random().nextInt(0, nouns.length)] + verbs[new Random().nextInt(0, verbs.length)] + "to " + article[new Random().nextInt(0, article.length)].toLowerCase() + adjectives[new Random().nextInt(0, adjectives.length)] + nouns[new Random().nextInt(0, nouns.length)] + ".";
        } else if (random == 2) {
            return article[new Random().nextInt(0, article.length)] + nouns[new Random().nextInt(0, nouns.length)] + verbs[new Random().nextInt(0, verbs.length)] + "alot.";
        } else if (random == 3) {
            int random2 = new Random().nextInt(0, verbs.length);
            return article[new Random().nextInt(0, article.length)] + nouns[new Random().nextInt(0, nouns.length)] + verbs[random2].replace(" ", "") + ".";
        } else if (random == 4) {
            String namething = nouns[new Random().nextInt(0, nouns.length)];
            String cap = namething.substring(0, 1).toUpperCase() + namething.substring(1, namething.length() - 1);
            return cap + ", the destroyer of worlds, commands you: become a " + adjectives[new Random().nextInt(0, adjectives.length)] + nouns[new Random().nextInt(0, nouns.length)] + "now.";
        } else if (random == 5) {
            String namething = adjectives[new Random().nextInt(0, adjectives.length)];
            namething = namething.substring(0, namething.length() - 1);
            return "The primary directive of this mission is simple. You must " + verbs[new Random().nextInt(0, verbs.length)] + article[new Random().nextInt(0, article.length)].toLowerCase() + nouns[new Random().nextInt(0, nouns.length)] + namething + ".";
        } else if (random == 6) {
            return article[new Random().nextInt(0, article.length)] + nouns[new Random().nextInt(0, nouns.length)] + verbs[new Random().nextInt(0, verbs.length)] + "to " + article[new Random().nextInt(0, article.length)].toLowerCase() + adjectives[new Random().nextInt(0, adjectives.length)] + nouns[new Random().nextInt(0, nouns.length)] + "now.";
        } else if (random == 7) {
            return article[new Random().nextInt(0, article.length)] + nouns[new Random().nextInt(0, nouns.length)] + verbs[new Random().nextInt(0, verbs.length)] + "to " + article[new Random().nextInt(0, article.length)].toLowerCase() + nouns[new Random().nextInt(0, nouns.length)] + "now.";
        } else if (random == 8) {
            String namething = adjectives[new Random().nextInt(0, adjectives.length)];
            namething = namething.substring(0, namething.length() - 1);
            return "It was the last time " + nouns[new Random().nextInt(0, nouns.length)] + verbs[new Random().nextInt(0, verbs.length)] + namething + ".";
        } else {
            return "Error";
        }
    }

}
