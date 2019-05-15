package Actions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ParserFiles {

    public ArrayList<String> parser() {
        try (
                FileReader fr = new FileReader("files\\recipientsEmails.txt");
                Scanner scan = new Scanner(fr)
        ) {

            ArrayList<String> listOfLines = new ArrayList<>();
            int i = 1;
            while (scan.hasNextLine()) {
                listOfLines.add(scan.nextLine());
                System.out.println(listOfLines);
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


//String[] fields = line.split(",");
