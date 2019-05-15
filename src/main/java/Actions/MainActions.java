package Actions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.JavascriptExecutor;

import java.io.*;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainActions {
    public void writerFile( String numberPage,ElementsCollection nameModel, String nameFile) {
        //WebDriverWait wait = new WebDriverWait(getWebDriver(), 20);

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile, true));
            writer.write(numberPage + ": " +nameModel.texts() + "\n");
            writer.flush();
            writer.close();
        } catch (
                IOException ex) {

        }
    }
    public SelenideElement returnUpdXpath(String st1, Integer st2, String st3){
        return $x(st1+st2+st3);
    }

    public void scrollToElement(SelenideElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }
}
