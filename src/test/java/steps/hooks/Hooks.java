package steps.hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import utils.driver.DriverManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            final byte[] screenshotByteType = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotByteType, "image/png", scenario.getName());

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("d-MMM-YY HH-mm-ss");
            String currentDate = dateFormat.format(date);

            String fileName = "screenshot_" + currentDate + ".png";
            String screenShotFolder = System.getProperty("user.dir") + "/Reports/Screenshots/";

            try {
                FileOutputStream outputStream = new FileOutputStream(screenShotFolder + fileName);
                outputStream.write(screenshotByteType);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        DriverManager.killDriver();
    }

}
