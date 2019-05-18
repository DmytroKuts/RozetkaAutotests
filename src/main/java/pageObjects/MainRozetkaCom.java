package pageObjects;

import Actions.MainActions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import javafx.util.Pair;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class MainRozetkaCom {
    private SelenideElement ruLocation =  $x("//li[@class='header-topline__language-item']//span[text()=' RU ']");
    private SelenideElement telephoneAndElectronicsMenu =  $x("//a[@class='menu-categories__link' and text() = 'Смартфоны, ТВ и электроника']");
    private SelenideElement telephonesMenu =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Телефоны']");
    private SelenideElement smartphonesMenu =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Смартфоны']");
    private ElementsCollection nameModelsSmartphones = $$x("//div[@class='g-i-tile-i-title clearfix']");
    private SelenideElement householdProduct =  $x("//a[@class='menu-categories__link' and text() = 'Товары для дома']");
    private SelenideElement householdChemicals =  $x("//a[@class='m-cat-l-i-title-link' and text() = 'Бытовая химия']");
    private SelenideElement powder =  $x("//a[text()='Порошок']");
    private ElementsCollection namePowder =  $$x("//div[@name='catalog_item_block']//div[@class='g-price-uah' and ( number(text()) > 100 and number(text()) < 300 )]/ancestor::div[3]/preceding-sibling::div[@class='g-i-tile-i-title clearfix']");
    private ElementsCollection pricePowder =  $$x("//div[@name='catalog_item_block']//div[@class='g-price-uah' and ( number(text()) > 100 and number(text()) < 300 )]");
    private ElementsCollection nameModelsSmartphonesTopSales = $$x("//i[@class='g-tag-icon-small-popularity g-tag-i sprite']/ancestor::div[3]/following-sibling::div[@class='g-i-tile-i-title clearfix']");
    private ElementsCollection priceSmartphonesTopSales =  $$x("//i[@class='g-tag-icon-small-popularity g-tag-i sprite']/ancestor::div[3]/following-sibling::div[@name='prices_active_element_original']//div[@class='g-price-uah']");
    private String page = "page";
    private ElementsCollection priceSmatrphones =  $$x("//div[@class='g-i-tile-i-box-desc']//div[@name='price']//div[@class='g-price-uah' and ( number(translate(text(), ' ', '')) >3000 and number(translate(text(), ' ', '')) <6000)]");
    private ElementsCollection nameModelSmatrphones =  $$x("//div[@class='g-i-tile-i-box-desc']//div[@name='price']//div[@class='g-price-uah' and ( number(translate(text(), ' ', '')) >3000 and number(translate(text(), ' ', '')) <6000)]/ancestor::div[3]/preceding-sibling::div[@class='g-i-tile-i-title clearfix']");


    public  void openSmartphonesMenu(){
        ruLocation.waitUntil(Condition.enabled,50,50).click();
        telephoneAndElectronicsMenu.shouldBe(Condition.enabled).click();
        telephonesMenu.shouldBe(Condition.enabled).click();
        smartphonesMenu.shouldBe(Condition.enabled).click();
    }

    public void writeToFileNameModels(int countPages, String nameFiles) {
        MainActions mainActions = new MainActions();
        mainActions.writeToFileNameModels(page, countPages, nameModelsSmartphones, nameFiles);
    }

    public void openPowderMenu(){
        ruLocation.waitUntil(Condition.enabled,5000,5000).click();
        householdProduct.shouldBe(Condition.enabled).click();
        householdChemicals.shouldBe(Condition.enabled).click();
        powder.shouldBe(Condition.enabled).click();
    }

    public void insernDataElementsCollectionToDB() {
        MainActions mainActions = new MainActions();
        mainActions.insertElementsCollectionToDB(page, 5, pricePowder, namePowder);
    }

    public List<Pair<String, Integer>>  chooseNameModelPriceSmartphones(){
        MainActions mainActions = new MainActions();
        List<Pair<String, Integer>> listPairs1 ;
        List<Pair<String, Integer>> listPairs2 ;

        listPairs1 = mainActions.joinList(3, priceSmartphonesTopSales, nameModelsSmartphonesTopSales);
        listPairs2 = mainActions.joinList(5, priceSmatrphones, nameModelSmatrphones);

        listPairs1.addAll(listPairs2);
        return listPairs1 ;

        }
}
