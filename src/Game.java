import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

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
        if (play) {
            System.out.println("Welcome to Bradys Hangman!");
            String word = WordPicker.pickWord();
            System.out.println("Word is:" + word);
            GameSounds.backgroundMusic();
        }
        while (play) {

        }
    }
}
