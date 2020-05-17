package com.tamasdober.selenium.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import com.tamasdober.selenium.pages.MumbaiLokhandwala48FitnessPage;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

// No tests need to touch the WebDriver.
public class DropDownTests extends BaseTest {

  @Test
  public void testTitle() {
    webDriver.manage().window().setSize(new Dimension(375, 812));
    assertEquals(
        "Find Gyms, Yoga, Pilates, Zumba and Fitness Classes Mumbai | Fitternity",
        webDriver.getTitle());
    assertThat(webDriver.getTitle(),
        containsString("Mumbai"));
    // webDriver.close();
  }

  @Test
  public void findListOfWebElements() {
    final List<WebElement> elements = webDriver.findElements(
        By.cssSelector("body > div.home > div.fitternity-live.section-seperator > div > div"));
    System.out.println(elements.size());
    for (WebElement element : elements) {
      System.out.println(element.getText());
    }
    System.out.println(elements.size());
  }

  @Test
  public void scrollDownFindByLinkText() {
    basePage.scrollDownToTheBottomOfThePage();
    MumbaiLokhandwala48FitnessPage mumbaiLokhandwala48FitnessPage = basePage.clickOn48FitnessLink();
    final String text = mumbaiLokhandwala48FitnessPage.findTextForFirstComment().getText();
    assertEquals("Swapnil Lal", text);
  }

  @Test
  public void firstDropDrown() {
    // basePage.scrollDownToTheBottomOfThePage();
    WebElement firstDropDown = basePage.getFirstDropDown();
    firstDropDown.click();
    System.out.println("found");

  }

  @Test
  public void coxTest() {
    String location = "Juhu";
    String category = "Fitness Studios";
    By searchContainer = By.xpath("//div[contains(@class,'sectionsearchcontainer')]");
    By inputLocation = By.xpath(".//div[contains(@class,'location')]//input");
    By locationItem = By.xpath(
        ".//div[contains(@class,'location')][not(contains(@style,'display: none'))]//div[normalize-space(text())='"
            + location + "']");
    By inputCategory = By.xpath(".//div[contains(@class,'category')]//input");
    By categoryItem = By.xpath(
        ".//div[contains(@class,'category')][not(contains(@style,'display: none'))]//span[normalize-space(text())='"
            + category + "']");

    WebElement searchElement = webDriver.findElement(searchContainer);
    searchElement.findElement(inputLocation).click();
    searchElement.findElement(locationItem).click();
    searchElement.findElement(inputCategory).click();
    searchElement.findElement(categoryItem).click();
  }

}
