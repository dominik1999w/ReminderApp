package reminder;

import javax.swing.*;
import java.awt.*;

public class Reminder {

    public static void main(String[] arg) throws Exception {
        new SoundClipTest();
        ReminderFrame reminderframe = new ReminderFrame();
        reminderframe.setTitle("REMINDER");
        reminderframe.setPreferredSize(new Dimension(800,700));
        reminderframe.getContentPane().setSize(800,700);
        reminderframe.pack();
        reminderframe.setVisible(true);
        reminderframe.setResizable(false);
        reminderframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
