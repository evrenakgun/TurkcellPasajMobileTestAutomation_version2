package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitUntilVisibilityOfElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }

    public void waitUntilElementClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(By element) {
        driver.findElement(element).click();
    }

    public void clickWithWait(By element) {
        waitUntilElementClickable(element);
        driver.findElement(element).click();
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    public String getTextWithWait(By element) {
        waitUntilVisibilityOfElement(element);
        return driver.findElement(element).getText();
    }

    public void setText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public void setTextWithWait(By element, String text) {
        waitUntilElementClickable(element);
        driver.findElement(element).sendKeys(text);
    }

    public void clearText(By element) {
        driver.findElement(element).clear();
    }

    public void clearTextWithWait(By element) {
        waitUntilVisibilityOfElement(element);
        driver.findElement(element).clear();
    }

    public void scrollDownUntilElementVisible(By element) {

        while (true) {
            try {
                // Sayfanın boyutunu alın
                Dimension size = driver.manage().window().getSize();

                // Kaydırma işlemi için başlangıç ve bitiş noktalarını belirleyin
                int startY = (int) (size.height * 0.7); // Ekranın altından başla
                int endY = (int) (size.height * 0.5); // Ekranın üstüne kaydır

                // Kaydırma işlemini başlatın
                TouchAction action = new TouchAction(driver);
                action.press(PointOption.point(size.width / 2, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))) // Bekleme süresi
                        .moveTo(PointOption.point(size.width / 2, endY))
                        .release()
                        .perform();

                if (driver.findElement(element).isDisplayed()) {
                    break;
                }

            } catch (NoSuchElementException e) {
                scrollDownUntilElementVisible(element);
            }
            finally {
                driver.findElement(element).isDisplayed();
                break;
            }
        }
    }

    public void scrollUpUntilElementVisible(By element) {
        while (true) {
            try {
                // Sayfanın boyutunu alın
                Dimension size = driver.manage().window().getSize();

                // Kaydırma işlemi için başlangıç ve bitiş noktalarını belirleyin
                int startY = (int) (size.height * 0.5); // Ekranın altından başla
                int endY = (int) (size.height * 0.6); // Ekranın üstüne kaydır

                // Kaydırma işlemini başlatın
                TouchAction action = new TouchAction(driver);
                action.press(PointOption.point(size.width / 2, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))) // Bekleme süresi
                        .moveTo(PointOption.point(size.width / 2, endY))
                        .release()
                        .perform();

                if (driver.findElement(element).isDisplayed()) {
                    break;
                }

            } catch (NoSuchElementException e) {
                scrollUpUntilElementVisible(element);
            }
            finally {
                driver.findElement(element).isDisplayed();
            }
        }
    }

    public void compareTextsEquality(String actualText, String expectedText) {
        Assert.assertEquals(actualText.trim(), expectedText.trim());
    }

    public void compareTextsContains(String actualText, String searchText) {
        Assert.assertTrue(StringUtils.containsIgnoreCase(actualText, searchText));
    }
}
