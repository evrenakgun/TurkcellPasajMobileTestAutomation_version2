package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.driver.DriverManager;

public class S000_MainSteps extends BaseSteps {

    public S000_MainSteps() {}

    @Before
    public void setUpPage() {
        setUpPages(DriverManager.getDriver());
    }

    @Given("I click Discover Pasaj Button")
    public void clickDiscoverPasajButton() {
        mainPage.clickDiscoverPasajButtonWithWait();
    }

    @Then("I should see Pasaj Page")
    public void checkPasajPage() {
        pasajPage.verifyPasajPageOpen();
    }
}
