package steps;

import io.appium.java_client.AppiumDriver;
import pages.*;

public class BaseSteps {
    protected MainPage mainPage;
    protected PasajPage pasajPage;
    protected FirstProductOfBestSellersPage firstProductOfBestSellersPage;
    protected SearchPage searchPage;
    protected SearchResultPage searchResultPage;

    public void setUpPages(AppiumDriver driver) {
        mainPage = new MainPage(driver);
        pasajPage = new PasajPage(driver);
        firstProductOfBestSellersPage = new FirstProductOfBestSellersPage(driver);
        searchPage = new SearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

}
