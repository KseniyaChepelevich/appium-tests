package ru.netology.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.pages.MainActivityPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ActivityTest {
    private AppiumDriver driver;

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 4a API 30");
        desiredCapabilities.setCapability("appium:app", "C:\\Studies\\QAmid\\Mobil_testing\\mqa-homeworks-main\\mqa-homeworks-main\\2.2 UI Automator\\sample\\app\\build\\outputs\\apk\\release\\app-release-unsigned.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver(remoteUrl, desiredCapabilities);
    }

   /* @Test
    public void dontSetEmptyString() {
        MobileElement el1 = (MobileElement) driver.findElementById("userInput");
        el1.click();

        el1.sendKeys(" ");
        MobileElement el2 = (MobileElement) driver.findElementById("buttonChange");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("textToBeChanged");

        Assertions.assertEquals("Hello UiAutomator!", el3.getText());
    }

    @Test
    public void activityTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("userInput");
        el1.click();
        el1.sendKeys(" test");
        MobileElement el4 = (MobileElement) driver.findElementById("buttonActivity");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.TextView");

        Assertions.assertEquals(" test", el5.getText());
    }*/



    @Test
    public void dontSetEmptyString() {
        MainActivityPage page = new MainActivityPage(driver);
        page.userInput.sendKeys(" ");
        page.buttonChange.click();
        Assertions.assertEquals("Hello UiAutomator!", page.textToBeChanged.getText());

    }

    @Test
    public void activityTest() {
        MainActivityPage page = new MainActivityPage(driver);
        page.userInput.sendKeys("test");
        page.buttonActivity.click();
        Assertions.assertEquals("test", page.activityText.getText());

    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}




