package com.tamasdober.selenium.tests;

import com.tamasdober.selenium.pages.BasePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Create a base test class which defines a WebDriver object, instantiates it, and then
// sets it in a base page. Subsequent page classes then inherit from the base page,
// thus automatically having access to the driver.
public class BaseTest {

  static WebDriver webDriver;
  // So that all test will inherit the basePage
  protected static BasePage basePage;

  private static final String APP_URL = "https://www.fitternity.com/";

  // The code marked @BeforeClass is run as static initializer, therefore it will run
  // before the class instance of your test fixture is created.
  @BeforeClass
  public static void launchApplication() {
    setChromeDriverProperty();
    /*ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--disable-notifications");
    ChromeDriver webDriver = new ChromeDriver(chromeOptions);*/
    webDriver = new ChromeDriver();
    webDriver.get(APP_URL);
    basePage = new BasePage();
    basePage.setWebDriver(webDriver);
  }

  @AfterClass
  public static void closeBrowser() {
    webDriver.quit();
  }

  private static void setChromeDriverProperty() {
    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
  }
}
