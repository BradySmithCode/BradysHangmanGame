import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        GameSounds.backgroundMusic();
        String word = "";
        ArrayList<String> wordsUsed = new ArrayList<>();

        //Sets whether user is playing or not to a default of false
        boolean play = false;

        while(true) {
            //Asks user whether they want to play hangman or not
            System.out.println("Would you like to play hangman? Y/N");
            Scanner input = new Scanner(System.in);
            String response = input.nextLine();

            // If yes then queue a click sound and set playing to true
            if (response.equalsIgnoreCase("Y")) {
                GameSounds.clickSound();
                play = true;
                break;
            } else {
                //end game
                System.out.println("Was nice knowing ya!");
                break;
            }
        }

        //If user says yes, start game sequence
        while (play) {
            int lives = 3;
            int difficulty = 0;
            while (difficulty == 0) {
                Scanner difficultyInput = new Scanner(System.in);
                System.out.println("Welcome to Bradys Hangman!");
                System.out.println("Please pick a difficulty");
                System.out.println("1. Easy");
                System.out.println("2. Medium");
                System.out.println("3. Hard");
                String difficultyResponse = difficultyInput.nextLine();
                if (difficultyResponse.equals("1")) {
                    GameSounds.clickSound();
                    difficulty = 1;
                    word = WordPicker.pickWord(1, wordsUsed);
                    if (word.equals("noWords")) {
                        System.out.println("No more words for this difficulty");
                    } else {
                        wordsUsed.add(word);
                        break;

                    }
                } else if (difficultyResponse.equals("2")) {
                    GameSounds.clickSound();
                    difficulty = 2;
                    word = WordPicker.pickWord(2, wordsUsed);
                    if (word.equals("noWords")) {
                        System.out.println("No more words for this difficulty");
                    } else {
                        wordsUsed.add(word);
                        break;

                    }
                } else if (difficultyResponse.equals("3")) {
                    GameSounds.clickSound();
                    difficulty = 3;
                    word = WordPicker.pickWord(3, wordsUsed);
                    if (word.equals("noWords")) {
                        System.out.println("No more words for this difficulty");
                    } else {
                        wordsUsed.add(word);
                        break;

                    }

                }
                else {
                    GameSounds.clickSound();
                    System.out.println("Incorrect input please try again.");
                }




            }
            String wordGuessLayout = "";
            for (int i = 0; i < word.length(); i++) {
                wordGuessLayout += " _";


            }
            while (lives != 0) {
                System.out.println("Lives left: " + lives);
                System.out.println(LivesDrawer.livesOutput(lives));
                System.out.println(wordGuessLayout);

                Scanner guessInput = new Scanner(System.in);
                String guess = guessInput.nextLine();
                GameSounds.clickSound();
            }
            if(WordPicker.pickWord(3, wordsUsed).equals("noWords") & WordPicker.pickWord(2, wordsUsed).equals("noWords") & WordPicker.pickWord(1, wordsUsed).equals("noWords")) {
                System.out.println("No words left, please restart game.");
                System.exit(1);
            }





        }
    }
}
