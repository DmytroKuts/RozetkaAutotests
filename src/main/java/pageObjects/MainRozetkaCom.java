package pageObjects;

import Actions.MainActions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class MainRozetkaCom {
    private SelenideElement ruLocation =  $x("//*[@id='language-switcher']//span[text()='ru']");
    private SelenideElement telephoneAndElectronics =  $x("//a[@class='menu-categories__link' and text() = 'Смартфоны, ТВ и электроника']");
    private SelenideElement telephones =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Телефоны']");
    private SelenideElement smartphones =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Смартфоны']");
    private ElementsCollection nameModels = $$x("//div[@class='g-i-tile-i-title clearfix']");
    private SelenideElement householdProduct =  $x("//a[@class='menu-categories__link' and text() = 'Товары для дома']");
    private SelenideElement householdChemicals =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Бытовая химия']");
    private SelenideElement powder =  $x("//a[text()='Порошок']");
    private ElementsCollection namePowder =  $$x("//div[@name='catalog_item_block']//div[@class='g-price-uah' and ( number(text()) > 100 and number(text()) < 300 )]/ancestor::div[3]/preceding-sibling::div[@class='g-i-tile-i-title clearfix']");
    private ElementsCollection pricePowder =  $$x("//div[@name='catalog_item_block']//div[@class='g-price-uah' and ( number(text()) > 100 and number(text()) < 300 )]");
    private String page = "page";

    public  void openSmartphonesMenu(){
        ruLocation.waitUntil(Condition.visible,5000,5000).click();
        telephoneAndElectronics.shouldBe(Condition.enabled).click();
        telephones.shouldBe(Condition.enabled).click();
        smartphones.shouldBe(Condition.enabled).click();
    }

    public void writeToFileNameModels(int countPages, String nameFiles) {
        MainActions mainActions = new MainActions();
        mainActions.writeToFileNameModels(page, countPages, nameModels, nameFiles);
    }

    public void openPowderMenu(){
        ruLocation.waitUntil(Condition.enabled,5000).click();
        householdProduct.shouldBe(Condition.enabled).click();
        householdChemicals.shouldBe(Condition.enabled).click();
        powder.shouldBe(Condition.enabled).click();
    }

    public void insernDataElementsCollectionToDB() {
        MainActions mainActions = new MainActions();
        mainActions.insertElementsCollectionToDB(page, 5, pricePowder, namePowder);
    }
}
