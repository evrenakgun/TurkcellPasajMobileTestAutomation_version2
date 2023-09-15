package pages;

import io.appium.java_client.AppiumDriver;
import model.FirstProductNameOfBestSellers;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstProductOfBestSellersPage extends BasePage {
    public FirstProductOfBestSellersPage(AppiumDriver driver) {
        super(driver);
    }

    // ***** Elements *****
    // Örnek: "Lenovo Lecoo EW302 Kablosuz Kulaklık"
    private final By nameOfBestSellersFirstProduct = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]");


    // ***** Methods *****
    public void scrollUpUntilVisibleProductName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfBestSellersFirstProduct));
        scrollUpUntilElementVisible(nameOfBestSellersFirstProduct);
    }
    public String getCurrentProductName() {
        return getText(nameOfBestSellersFirstProduct);
    }

    public void verifyProductName(FirstProductNameOfBestSellers productName) {
        String currentProductName = getCurrentProductName();
        String memoryProductName = productName.getProductName();
        compareTextsEquality(memoryProductName, currentProductName);
    }
}
