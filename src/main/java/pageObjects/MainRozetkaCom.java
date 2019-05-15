package pageObjects;

import Actions.MainActions;
import Actions.SendMail;
import com.codeborne.selenide.Condition;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainRozetkaCom {
    private SelenideElement telephoneAndElectronics =  $x("//a[@class='menu-categories__link' and text() = 'Смартфоны, ТВ и электроника']");
    private SelenideElement telephones =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Телефоны']");
    private SelenideElement smartphones =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Смартфоны']");
    private ElementsCollection nameModels = $$x("//div[@class='g-i-tile-i-title clearfix']");
    private SelenideElement page2 =  $(By.id("page2"));
    private SelenideElement page3 =  $(By.id("page3"));
    private SelenideElement logo = $x("//h1[@itemprop='name']");
    private static SendMail tlsSender = new SendMail("tester235386@gmail.com", "zaq`12wsx");

    public  MainRozetkaCom openSmartphonesMenu(){
        MainActions mainActions = new MainActions();
        tlsSender.send("This is Subject", "TLS: This is text!", "support@devcolibri.com", "tester235386@gmail.com");

        telephoneAndElectronics.shouldBe(Condition.enabled).click();
        telephones.shouldBe(Condition.enabled).click();
        smartphones.shouldBe(Condition.enabled).click();
        mainActions.writerFile(  "Page1 ", nameModels, "nameModels.txt");
        mainActions.scrollToElement(page2);

        page2.click();
        sleep(4000);
        mainActions.writerFile("Page2 ",nameModels, "nameModels.txt");
        mainActions.scrollToElement(page3);

        page3.click();
        sleep(4000);
        mainActions.writerFile("Page3 ",nameModels, "nameModels.txt");

        return new MainRozetkaCom();
    }


}
