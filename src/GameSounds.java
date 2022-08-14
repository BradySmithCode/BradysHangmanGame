import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GameSounds {
    public static void backgroundMusic() {
        try {

            File background = new File("src/Music/background.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(background);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickSound() {
        try {

            File background = new File("src/Music/select.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(background);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loseSound() {
        try {

            File background = new File("src/Music/death.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(background);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void winSound() {
        try {

            File background = new File("src/Music/win.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(background);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
