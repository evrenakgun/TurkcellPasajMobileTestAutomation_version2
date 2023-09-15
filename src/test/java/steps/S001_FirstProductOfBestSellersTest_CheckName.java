package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.FirstProductNameOfBestSellers;
import utils.driver.DriverManager;

public class S001_FirstProductOfBestSellersTest_CheckName extends BaseSteps {

    public S001_FirstProductOfBestSellersTest_CheckName(){
    }
    @Before
    public void setUpPage() {
        setUpPages(DriverManager.getDriver());
    }

    @When("I scroll down until First Product Name of Best Sellers visible")
    public void scrollDownUntilSeeFirstProductName() {
        pasajPage.scrollDownUntilVisibleFirstProductName();
    }

    @When("I get Product Name in Pasaj Screen")
    public void getProductNameInPasajScreen() {
        pasajPage.getProductNameInMemory();
    }

    @Then("I click First Product of Best Sellers")
    public void clickFirstProductOfBestSellers() {
        pasajPage.clickFirstProductOfBestSellers();
    }

    @Then("I scroll up until Name of Product visible")
    public void scrollUpUntilSeeProductName() {
        firstProductOfBestSellersPage.scrollUpUntilVisibleProductName();
    }

    @Then("I compare Product Name between Pasaj Screen and First Product of Best Sellers Product Screen")
    public void compareProductNames() {
        FirstProductNameOfBestSellers productName = pasajPage.getFirstProductNameOfBestSellers();
        firstProductOfBestSellersPage.verifyProductName(productName);
    }
}
