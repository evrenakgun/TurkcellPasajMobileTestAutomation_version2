package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    // ***** Elements *****
    private final By discoverPasajButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.Button");


    // ***** Methods *****
    public void clickDiscoverPasajButtonWithWait() {
        clickWithWait(discoverPasajButton);
    }

}
