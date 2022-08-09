import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class WordPicker {
    public static String pickWord() {
        // Initialize ArrayList for words
        ArrayList<String> words = new ArrayList<String>();

        //Initialize random object to get random index number
        Random randomObject = new Random();
        int randomNumber = 0;


        // Grab information from the file and add them to the words list
        try {
            File wordFile = new File("src/wordbank.txt");
            Scanner reader = new Scanner(wordFile);
            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                words.add(word);
            }

            //Get random number for index
            randomNumber = randomObject.nextInt(words.size());


        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return random word
        return words.get(randomNumber);
    }

}
