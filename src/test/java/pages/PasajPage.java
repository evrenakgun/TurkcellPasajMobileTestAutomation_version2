package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import model.FirstProductNameOfBestSellers;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasajPage extends BasePage {
    public PasajPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    private FirstProductNameOfBestSellers firstProductNameOfBestSellers;

    // ***** Elements *****
    private final By pasajTextButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.View[2]");
    private final By nameOfBestSellersFirstProduct = By.xpath("//android.widget.TextView[@content-desc=\"ÇOK SATANLAR\"]/parent::android.view.ViewGroup//androidx.recyclerview.widget.RecyclerView[2]//androidx.cardview.widget.CardView[1]//android.view.ViewGroup[1]//android.widget.TextView[@resource-id=\"com.ttech.android.onlineislem:id/textViewPrductTitle\"]"); // Örnek: "Lenovo Lecoo EW302 Kablosuz Kulaklık"
    private final By searchTextBox = By.id("com.ttech.android.onlineislem:id/linearLayoutSearch");


    // ***** Methods *****
    public void verifyPasajPageOpen() {
        waitUntilVisibilityOfElement(pasajTextButton);
    }
    public void scrollDownUntilVisibleFirstProductName() {
        scrollDownUntilElementVisible(nameOfBestSellersFirstProduct);
    }
    public String getNameOfBestSellersFirstProduct() {
        return getText(nameOfBestSellersFirstProduct);
    }

    public void getProductNameInMemory() {
        String productNameInMemory = getNameOfBestSellersFirstProduct();
        firstProductNameOfBestSellers = new FirstProductNameOfBestSellers(productNameInMemory);
    }

    public FirstProductNameOfBestSellers getFirstProductNameOfBestSellers() {
        return firstProductNameOfBestSellers;
    }

    public void clickFirstProductOfBestSellers() {
        click(nameOfBestSellersFirstProduct);
    }

    public void clickSearchTextBox() {
        clickWithWait(searchTextBox);
    }

}
