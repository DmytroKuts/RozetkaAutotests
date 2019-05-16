package pageObjects;

import Actions.MainActions;
import Actions.ParserFiles;
import Actions.SendMail;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MainRozetkaCom {
    private SelenideElement telephoneAndElectronics =  $x("//a[@class='menu-categories__link' and text() = 'Смартфоны, ТВ и электроника']");
    private SelenideElement telephones =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Телефоны']");
    private SelenideElement smartphones =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Смартфоны']");
    private ElementsCollection nameModels = $$x("//div[@class='g-i-tile-i-title clearfix']");
    private SelenideElement logo = $x("//h1[@itemprop='name']");

    private String page = "page";

    public  MainRozetkaCom openSmartphonesMenu(){
        telephoneAndElectronics.shouldBe(Condition.enabled).click();
        telephones.shouldBe(Condition.enabled).click();
        smartphones.shouldBe(Condition.enabled).click();
        return new MainRozetkaCom();
    }

    public void writeToFileNameModels(int countPages, String nameFiles) {
        MainActions mainActions = new MainActions();
        mainActions.writeToFileNameModels(page, countPages, nameModels, nameFiles);
    }
}
