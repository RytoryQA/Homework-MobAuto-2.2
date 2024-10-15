package ru.netology.testing.uiautomator;public class HomeworkAppium {
}
// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client
import io.appium.java_client.remote.options.BaseOptions;
        import io.appium.java_client.android.AndroidDriver;
        import java.net.URL;
        import java.time.Duration;
        import java.util.Arrays;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.*;

public class SampleTest {

    private AndroidDriver driver;

    @Before
    public void setUp() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:deviceName", "Pixel_6_Pro_API_33")
                .amend("appium:appPackage", "ru.netology.testing.uiautomator")
                .amend("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity")
                .amend("appium:automationName", "uiautomator2")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        private URL getUrl() {
            try {
                return new URL("http://127.0.0.1:4723");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        driver = new AndroidDriver(this.getUrl(), options);
    }

    @Test
    public void sampleTest() {
        var el8 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/userInput"));
        el8.sendKeys("netology");
        var el9 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/buttonActivity"));
        el9.click();
        var el10 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/text"));
        Assert.assertEquals("netology", el10.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
