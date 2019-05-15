package Actions;

import com.codeborne.selenide.SelenideElement;

import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;

public class MainActions {
    public void writerFile(SelenideElement nameFile) {
        try {
            FileWriter writer = new FileWriter("nameModels.txt", true);
            writer.flush();
            writer.write(nameFile.getText() + "\n");
            writer.close();
        } catch (
                IOException ex) {
        }
    }
    public SelenideElement returnUpdXpath(String st1, String st2, String st3){
        return $x(st1+st2+st3);
    }
}
