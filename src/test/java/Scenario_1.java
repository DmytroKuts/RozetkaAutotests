import Actions.ParserFiles;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import pageObjects.MainRozetkaCom;

import static com.codeborne.selenide.Selenide.open;



public class Scenario_1 {
    @BeforeClass
    public static void BeforeClass() {
        ParserFiles p = new ParserFiles();
        p.parser();
        //System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        open("https://rozetka.com.ua/");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void testScenario1() {
        MainRozetkaCom mainRozetkaCom = new MainRozetkaCom();
        mainRozetkaCom.openSmartphonesMenu();
    }
}
