package pageObjects;

import Actions.MainActions;
import com.codeborne.selenide.Condition;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainRozetkaCom {
    private SelenideElement telephoneAndElectronics =  $x("//a[@class='menu-categories__link' and text() = 'Смартфоны, ТВ и электроника']");
    private SelenideElement telephones =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Телефоны']");
    private SelenideElement smartphones =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Смартфоны']");
    //private SelenideElement nameModel = $x(String.format("(//div[@class='g-i-tile-i-title clearfix'])[%s]"));


    public MainRozetkaCom openSmartphonesMenu(){
        MainActions mainActions = new MainActions();
        SelenideElement nameModel = mainActions.returnUpdXpath("(//div[@class='g-i-tile-i-title clearfix'])[", "1","]");

        telephoneAndElectronics.shouldBe(Condition.visible).click();
        telephones.shouldBe(Condition.visible).click();
        smartphones.shouldBe(Condition.visible).click();
        nameModel.shouldBe(Condition.visible);
        mainActions.writerFile(nameModel);

        return new MainRozetkaCom();
    }


}
