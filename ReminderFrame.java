package reminder;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

public class ReminderFrame extends JFrame {

    private String filePathEng = "D:\\Agnieszka\\Documents\\englishWords.txt"; // path to file with english words
    private String filePathPol = "D:\\Agnieszka\\Documents\\polishWords.txt"; // path to file with polish translation

    private List<String> listEng , listPol;

    public boolean used[] = new boolean[1000];

    private Cell[][] cells = new Cell[4][3];

    public ReminderFrame() throws Exception {

        JPanel panel = new JPanel(new GridLayout(4, 3, 0, 0));
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++){
                panel.add(cells[i][j] = new Cell());
            }
        panel.setBorder(new LineBorder(Color.BLACK, 2));
        add(panel, BorderLayout.CENTER);
    }

    //CELL CLASS
    public class Cell extends JPanel implements MouseListener {
        private JTextArea textArea = new JTextArea(6,16);
        JScrollPane scroll = new JScrollPane(textArea);
        int wordNr;

        public Cell() throws Exception {
            Random rand = new Random();
            listEng = getList(filePathEng);
            listPol = getList(filePathPol);
            do{
                wordNr = rand.nextInt(listEng.size());
            }while(used[wordNr]);
            used[wordNr]=true;
            textArea.setText(listEng.get(wordNr));
            textArea.addMouseListener(this);
            textArea.setFont(new Font("Arial", 1, 15));
            textArea.setLineWrap(true);
            textArea.setEditable(false);
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            textArea.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));//creating borders and margins
            textArea.setWrapStyleWord(true);
            add(scroll,BorderLayout.CENTER);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            textArea.setText(listPol.get(wordNr));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            textArea.setText(listEng.get(wordNr));
        }
    }

    public List<String> getList(String filePath) {
        FileManager fileManager = new FileManager(filePath);
        return fileManager.readFileInList();
    }
}
