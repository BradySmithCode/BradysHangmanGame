import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GameSounds {

    private static String BACKGROUND_SOUNDS = "src/Music/background.wav";
    private static String CLICK_SOUNDS = "src/Music/select.wav";
    private static String LOSE_SOUNDS = "src/Music/death.wav";
    private static String WIN_SOUNDS = "src/Music/win.wav";

    private static File file;
    private static AudioInputStream audioStream;
    private static AudioSystem getAudioStream;
    private static Clip clip;

    public static void backgroundMusic() {
        try {

            file = new File(BACKGROUND_SOUNDS);
            audioStream = getAudioStream.getAudioInputStream(file);
            clip = getAudioStream.getClip();
            clip.open(audioStream);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickSound() {
        try {

            file = new File(CLICK_SOUNDS);
            audioStream = getAudioStream.getAudioInputStream(file);
            clip = getAudioStream.getClip();
            clip.open(audioStream);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loseSound() {
        try {

            file = new File(LOSE_SOUNDS);
            audioStream = getAudioStream.getAudioInputStream(file);
            clip = getAudioStream.getClip();
            clip.open(audioStream);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void winSound() {
        try {

            file = new File(WIN_SOUNDS);
            audioStream = getAudioStream.getAudioInputStream(file);
            clip = getAudioStream.getClip();
            clip.open(audioStream);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
