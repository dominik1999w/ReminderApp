package reminder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileManager {
    private String fileName;
    public FileManager (String fileName){
        this.fileName = fileName;
    }
    public List<String> readFileInList()
    {

        List<String> lines = Collections.emptyList();
        try
        {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            System.out.println("reading failed");
            e.printStackTrace();
        }
        return lines;
    }
}
