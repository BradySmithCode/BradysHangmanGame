import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GameSounds {
    public static void backgroundMusic() {
        try {
            Scanner scanner = new Scanner(System.in);

            File background = new File("src/Music/background.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(background);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

            String response = scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        backgroundMusic();
    }
}
