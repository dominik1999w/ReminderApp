package reminder;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class SoundClipTest extends JFrame {

    // Constructor

    public SoundClipTest() throws Exception {
            // Open an audio input stream.
            File soundFile = new File("C:\\Users\\DELL\\Desktop\\sms-alert-3-daniel_simon.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
    }

}