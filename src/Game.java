import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    public static void main(String[] args) {
        Pattern isLetter = Pattern.compile("[a-zA-Z]+$");
        GameSounds.backgroundMusic();
        ArrayList<String> wordsUsed = new ArrayList<>();

        //Sets whether user is playing or not to a default of false

        //If user says yes, start game sequence
        while (true) {
            int allWords = 0;
            int lives = 5;
            String word = "noWords";
            int difficulty = 0;
            while (difficulty == 0 & word.equals("noWords")) {
                Scanner difficultyInput = new Scanner(System.in);
                System.out.println("-------------------------");
                System.out.println("Welcome to Bradys Hangman!");
                System.out.println("Please pick a difficulty");
                System.out.println("1. Easy");
                System.out.println("2. Medium");
                System.out.println("3. Hard");
                System.out.println("4. Quit");
                System.out.println("-------------------------");
                String difficultyResponse = difficultyInput.nextLine();
                if (difficultyResponse.equals("1")) {
                    GameSounds.clickSound();
                    difficulty = 1;
                    word = WordPicker.pickWord(1, wordsUsed);
                    if (word.equals("noWords")) {
                        difficulty = 0;
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
                        difficulty = 0;
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
                        difficulty = 0;
                        System.out.println("No more words for this difficulty");
                    }
                    else {
                        wordsUsed.add(word);
                        break;
                    }

                }  else if (difficultyResponse.equals("4")) {
                    System.exit(1);
                }
                else {
                    GameSounds.clickSound();
                    System.out.println("Incorrect input please try again.");
                }
            }
            HashMap<Character, Boolean> wordGuessLayout = new HashMap<Character, Boolean>();
            ArrayList<String> lettersUsed = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                wordGuessLayout.put(word.charAt(i), false);
            }

            while (lives != 0) {
                boolean wordCheck = false;
                String letterLayout = "";
                System.out.println("-------------------------");
                System.out.println("Lives left: " + lives);
                System.out.println(LivesDrawer.livesOutput(lives));

                System.out.println(lettersUsed);

                for (int i = 0; i < wordGuessLayout.size(); i++) {
                    char letter = word.charAt(i);
                    if (wordGuessLayout.get(letter) == false) {
                        letterLayout += "_";

                    } else {
                        letterLayout += letter;
                    }
                }
                System.out.println(letterLayout);

                while(true) {
                        Scanner guessInput = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("Type a letter to guess!");
                        String guess = guessInput.nextLine();
                        Matcher matchIsLetter = isLetter.matcher(guess);
                        GameSounds.clickSound();

                        if (!matchIsLetter.find()) {

                            System.out.println("Please enter valid input");
                        }
                        else if (lettersUsed.contains(guess.toLowerCase())) {
                            System.out.println("Letter already used try again");
                        } else if (guess.length() > 1 | guess.length() == 0) {
                            System.out.println("Please enter 1 letter");
                        } else {
                            for (int j = 0; j < wordGuessLayout.size(); j++) {
                                Character letter = word.charAt(j);

                                if (guess.equalsIgnoreCase(letter.toString()) & wordGuessLayout.get(letter) == false) {
                                    wordGuessLayout.replace(letter, false, true);
                                    wordCheck = true;
                                    allWords += 1;
                                }
                            }
                            lettersUsed.add(guess.toLowerCase());
                            break;
                        }

                }
                if (!wordCheck && lives != 0) {
                    GameSounds.loseSound();
                    System.out.println("Letter is not in word. Try again");
                    lives -= 1;
                } else {
                    GameSounds.winSound();
                }

                if (allWords == wordGuessLayout.size()) {
                    break;
                }
            }
            if (lives == 0) {
                System.out.println("-------------------------");
                System.out.println(LivesDrawer.livesOutput(lives));
                System.out.println("YOU LOST");
            } else {
                GameSounds.winSound();
                System.out.println("You won!");
            }
            if(WordPicker.pickWord(3, wordsUsed).equals("noWords") & WordPicker.pickWord(2, wordsUsed).equals("noWords") & WordPicker.pickWord(1, wordsUsed).equals("noWords")) {
                System.out.println("No words left, please restart game.");
                System.exit(1);
            }





        }
    }
}
