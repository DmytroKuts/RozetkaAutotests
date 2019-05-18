import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class AllTests extends MainTest{
    @Before
    public  void BeforeMethod() {
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen = true;
        open("https://rozetka.com.ua/");



        mainRozetkaCom.openSmartphonesMenu();
        mainRozetkaCom.joinNamePrice();
    }

    @Test
    public void testScript_1() {
        mainRozetkaCom.openSmartphonesMenu();
        mainRozetkaCom.writeToFileNameModels(3, "files\\nameModels.txt");
        mainActions.sendToEmail();
    }

    @Test
    public void testScript_2() {
        mainRozetkaCom.openPowderMenu();
        mainRozetkaCom.insernDataElementsCollectionToDB();
    }
}
