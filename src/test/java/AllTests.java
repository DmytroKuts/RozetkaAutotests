import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class AllTests extends MainTest{
    @Before
    public  void BeforeMethod() {
        open("https://rozetka.com.ua/");
        Configuration.holdBrowserOpen = true;
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
