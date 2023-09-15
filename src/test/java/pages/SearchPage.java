package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utils.constants.SearchBoxConstants.SEARCH_WORD;

public class SearchPage extends BasePage {
    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    // ***** Elements *****
    private final By searchBox = By.id("com.ttech.android.onlineislem:id/editTextSearchBox");


    // ***** Methods *****
    public void setSearchTextBox() {
        setTextWithWait(searchBox, SEARCH_WORD);
    }

    public void clickEnterKey() {
        driver.getKeyboard().pressKey(Keys.ENTER);
    }
}
