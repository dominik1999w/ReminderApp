package reminder;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.*;

public class ReminderFrame extends JFrame {

    private Cell[][] cells = new Cell[5][3];

    public ReminderFrame() throws Exception {
        JPanel panel = new JPanel(new GridLayout(5, 3, 0, 0));
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 3; j++)
                panel.add(cells[i][j] = new Cell());
        panel.setBorder(new LineBorder(Color.BLACK, 2));
        add(panel, BorderLayout.CENTER);
    }

    //CELL CLASS
    public class Cell extends JPanel {
        public Cell() throws Exception {
            JTextArea textArea = new JTextArea("AAAAAA",4,12);
            //String data = readFileAsString();
            //textArea.setText(data);
            textArea.setFont(new Font("Arial", 1, 20));
            textArea.setLineWrap(true);
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            textArea.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));//creating borders and margins
            textArea.setWrapStyleWord(true);
            add(textArea,BorderLayout.CENTER);
        }
        /*public String readFileAsString() throws IOException{
            StringBuilder contentBuilder = new StringBuilder();
            Stream<String> stream = Files.lines(Paths.get("C:\\Users\\DELL\\Desktop\\launch4j.log"),StandardCharsets.UTF_8);
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
            return contentBuilder.toString();
        }*/
    }

}
