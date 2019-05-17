package Actions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainActions {
    private static SendMail tlsSender = new SendMail("tester235386@gmail.com", "zaq`12wsx");

    public void writerFile(String numberPage, ElementsCollection nameModel, String nameFile) {
        //WebDriverWait wait = new WebDriverWait(getWebDriver(), 20);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile, true));
            writer.write(numberPage + ": " + nameModel.texts() + "\n");
            writer.flush();
            writer.close();
        } catch (
                IOException ex) {
        }
    }

    public SelenideElement returnUpdXpath(String st1, Integer st2, String st3) {
        return $x(st1 + st2 + st3);
    }

    public SelenideElement returnId(String st, Integer in) {
        return $(By.id(st + in));
    }

    public void scrollToElement(SelenideElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void writeToFileNameModels(String page, int countPages, ElementsCollection nameModels, String nameFile) {
        for (int i = 1; i <= countPages; i++) {
            if (i != 1) {
                scrollToElement(returnId(page, i));
                returnId(page, i).click();
                sleep(4000);
                writerFile(page + i + " ", nameModels, nameFile);
            } else {
                sleep(4000);
                writerFile(page + i + " ", nameModels, nameFile);
            }
        }
    }

    public void insertElementsCollectionToDB(String page, int countPages, ElementsCollection price, ElementsCollection nameModels) {
        RecordToDB recordToDB =new RecordToDB();

        for (int i = 1; i <= countPages; i++) {
            if (i != 1) {
                scrollToElement(returnId(page, i));
                returnId(page, i).click();
                sleep(4000);
                for (int c = 0; c < price.size(); c++) {
                    recordToDB.insertDBNamemodelsPrice(
                            price.get(c).getText(), nameModels.get(c).getText());
                }
            } else {
                sleep(4000);
                for (int c = 0; c < price.size(); c++) {
                    recordToDB.insertDBNamemodelsPrice(
                            price.get(c).getText(),nameModels.get(c).getText());
                }
            }
        }
    }

    public void sendToEmail() {
        ParserFiles parserFiles = new ParserFiles();
        List<String> listOfLines = parserFiles.parser();
        for (int i = 0; i < listOfLines.size(); i++) {
            tlsSender.send("This is Subject", "Hello!!!!", "tester235386@gmail.com", listOfLines.get(i), "files\\nameModels.txt");

        }
    }

    public  List<String> joinList(){
        List<java.lang.String> listOfLines = new ArrayList<>();

        return listOfLines;
    }
}
