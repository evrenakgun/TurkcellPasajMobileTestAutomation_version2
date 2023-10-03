package utils.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public static AppiumDriver driver;

    public static AppiumDriver startDriver() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Pixel 2 API 30");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:platformVersion", "11.0");
        capabilities.setCapability("appium:appPackage", "com.ttech.android.onlineislem");
        capabilities.setCapability("appium:appActivity", "com.ttech.android.onlineislem.ui.splash.SplashActivity");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:skipUnlock", "true");
        capabilities.setCapability("appium:noReset", "false");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(2000);

        return getDriver();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void killDriver() {
        driver.quit();
    }

}
