package Actions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ParserFiles {
    public List<String> parser() {
        List<String> listOfLines = new ArrayList<>();
        try (
                FileReader fr = new FileReader("files\\recipientsEmails.txt");
                Scanner scan = new Scanner(fr)
        ) {
            int i = 1;
            while (scan.hasNextLine()) {
                listOfLines.add(scan.nextLine());
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfLines;
    }
}



