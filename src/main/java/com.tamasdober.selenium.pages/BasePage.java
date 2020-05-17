package com.tamasdober.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

// The class has a variable of type WebDriver.
public class BasePage {

  protected static WebDriver webDriver;

  private final By linkTo48Fitness = By.partialLinkText("48 Fitness");

  private final By firstDropDOwn = By.className("selectize-input");


  public void setWebDriver(WebDriver driver) {
    BasePage.webDriver = driver;
  }


  public MumbaiLokhandwala48FitnessPage clickOn48FitnessLink() {
    // What you can see on the web page: the text '48 Fitness'
    final WebElement element48Fitness = webDriver.findElement(linkTo48Fitness);

 /*   final WebElement element48Fitness = new WebDriverWait(webDriver, 10)
        .until(ExpectedConditions.elementToBeClickable(linkTo48Fitness));
*/
    // to avoid ElementClickInterceptedException: element click intercepted: Element is not clickable at point .
    // Other element would receive the click. See https://www.edureka.co/community/2050/getting-this-error-element-is-not-clickable-at-point
    // It happens only when running the whole test class
    Actions actions = new Actions(webDriver);
    actions.moveToElement(element48Fitness).click().perform();
    // element48Fitness.click();
    return new MumbaiLokhandwala48FitnessPage();
  }

  public void getFirstDropDownAndClick() {
    final WebElement webElement = webDriver.findElement(firstDropDOwn);
    clickOnWebElement(webElement);
  }

  private void clickOnWebElement(WebElement webElement) {
    webElement.click();
  }

  public void scrollDownToTheBottomOfThePage() {
    ((JavascriptExecutor) webDriver)
        .executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }
}
