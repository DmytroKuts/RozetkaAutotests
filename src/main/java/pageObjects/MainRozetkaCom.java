package pageObjects;

import Actions.MainActions;
import com.codeborne.selenide.Condition;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainRozetkaCom {
    private SelenideElement telephoneAndElectronics =  $x("//a[@class='menu-categories__link' and text() = 'Смартфоны, ТВ и электроника']");
    private SelenideElement telephones =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Телефоны']");
    private SelenideElement smartphones =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Смартфоны']");
    private ElementsCollection nameModels = $$x("//div[@class='g-i-tile-i-title clearfix']");
    private SelenideElement page2 =  $(By.id("page2"));
    private SelenideElement page3 =  $(By.id("page3"));
    private SelenideElement logo = $x("//div[@class='logo']");
    private ElementsCollection nameModels2;

    public  MainRozetkaCom openSmartphonesMenu(){
        MainActions mainActions = new MainActions();

        telephoneAndElectronics.shouldBe(Condition.enabled).click();
        telephones.shouldBe(Condition.enabled).click();
        smartphones.shouldBe(Condition.enabled).click();
        mainActions.writerFile(  "Page1 ", nameModels, "nameModels.txt");
        mainActions.scrollToElement(page2);
        nameModels2.addAll(nameModels);
        page2.click();
        logo.waitUntil(Condition.visible, 4000);
        mainActions.writerFile("Page2 ",nameModels, "nameModels.txt");
        mainActions.scrollToElement(page3);
        page3.click();
        logo.waitUntil(Condition.enabled, 4000);
        mainActions.writerFile("Page3 ",nameModels, "nameModels.txt");

        return new MainRozetkaCom();
    }


}
