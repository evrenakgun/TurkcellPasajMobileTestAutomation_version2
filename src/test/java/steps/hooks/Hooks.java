package steps.hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import utils.driver.DriverManager;

import java.net.MalformedURLException;

import static utils.driver.DriverManager.driver;

public class Hooks {
    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        DriverManager.startDriver();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        //validate if scenario has failed
        if (scenario.isFailed()) {
            final byte[] screenshot = (driver.getScreenshotAs(OutputType.BYTES));
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @AfterClass
    public void tearDown() {
        DriverManager.killDriver();
    }

}
