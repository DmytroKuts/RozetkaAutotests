import com.codeborne.selenide.Configuration;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;

public class AllTests extends MainTest {
    @Before
    public void BeforeMethod() {
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua/");
    }

    @Test
    public void testScript_1() {
        mainRozetkaCom.openSmartphonesMenu();
        mainRozetkaCom.writeToFileNameModels(3, "files\\nameModels.txt");
        mainActions.sendToEmail("files\\nameModels.txt");
    }

    @Test
    public void testScript_2() {
        mainRozetkaCom.openPowderMenu();
        mainRozetkaCom.insernDataElementsCollectionToDB();
    }

    @Test
    public void testScript_3() {
        mainRozetkaCom.openSmartphonesMenu();
        List<Pair<String, Integer>> nameModelPriceSmartphones = mainRozetkaCom.chooseNameModelPriceSmartphones();  // Get a pair name models and price smartphones
        mainActions.sortPairsList(nameModelPriceSmartphones);
        recordToExcel.recordToExcel(nameModelPriceSmartphones);
        mainActions.sendToEmail("files\\SmartphonesNamePrice.xls");
    }
}
