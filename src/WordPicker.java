import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class WordPicker {
    public static String pickWord(int difficulty, ArrayList<String> wordsUsed) {
        // Initialize ArrayList for words
        ArrayList<String> wordsEasy = new ArrayList<String>();
        ArrayList<String> wordsMedium = new ArrayList<String>();
        ArrayList<String> wordsHard = new ArrayList<String>();

        boolean noWords = false;

        //Initialize random object to get random index number
        Random randomObject = new Random();
        int randomNumberEasy = 0;
        int randomNumberMedium = 0;
        int randomNumberHard = 0;


        // Grab information from the file and add them to the words list
        try {
            File wordFile = new File("src/wordbank.txt");
            Scanner reader = new Scanner(wordFile);
            while (reader.hasNextLine()) {

                String word = reader.nextLine();
                if (!wordsUsed.contains(word)) {
                    if (word.length() <= 3) {
                        wordsEasy.add(word);
                    } else if (word.length() > 3 & word.length() < 6) {
                        wordsMedium.add(word);
                    } else {
                        wordsHard.add(word);
                    }
                }

            }

            //Get random number for index

            if (wordsEasy.size() != 0) {
                randomNumberEasy = randomObject.nextInt(wordsEasy.size());
            }
            if (wordsMedium.size() != 0) {
                randomNumberMedium = randomObject.nextInt(wordsMedium.size());
            }
            if (wordsHard.size() != 0) {
                randomNumberHard = randomObject.nextInt(wordsHard.size());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return random word
        if (difficulty == 1) {
            if (wordsEasy.size() == 0) {
                return "noWords";
            } else {
                return wordsEasy.get(randomNumberEasy);
            }
        } else if (difficulty == 2) {
            if (wordsMedium.size() == 0) {
                return "noWords";
            } else {
                return wordsMedium.get(randomNumberMedium);
            }
        } else {
            if (wordsHard.size() == 0) {
                return "noWords";
            } else {
                return wordsHard.get(randomNumberHard);
            }
        }
    }

}
