package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.driver.DriverManager;

public class S002_SearchBoxTest_CheckProductName extends BaseSteps {

    public S002_SearchBoxTest_CheckProductName() {}

    @Before
    public void setUpPage() {
        setUpPages(DriverManager.getDriver());
    }

    @When("I click SearchBox")
    public void clickSearchBox() {
        pasajPage.clickSearchTextBox();
    }

    @When("I fills TextBox")
    public void setSearchBox() {
        searchPage.setSearchTextBox();
    }

    @And("I tap Enter on Keyboard")
    public void clickEnterKeyOnKeyboard() {
        searchPage.clickEnterKey();
    }

    @Then("I wait until Search Results loaded")
    public void waitUntilSearchResultsVisible() {
        searchResultPage.waitUntilProductsVisible();
    }

    @When("I see all Product Names on the Screen")
    public void getProductNamesAfterSearch() {
        searchResultPage.getProductNamesSearchResult();
    }

    @Then("I check Product Names is relevant to Search Text")
    public void checkProductNamesIsRelevant() {
        searchResultPage.verifyProductNamesAfterSearch();
    }
}
