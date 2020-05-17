package com.tamasdober.selenium.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import com.tamasdober.selenium.pages.MumbaiLokhandwala48FitnessPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

// No tests need to touch the WebDriver.
public class DropDownTests extends BaseTest {

  @Test
  public void testTitleBasePage() {
    webDriver.manage().window().setSize(new Dimension(375, 812));
    assertEquals(
        "48 Fitness Lokhandwala Membership Fees, Prices, Cost, Charges, Reviews - Mumbai - Live Classes | Fitternity",
        webDriver.getTitle());
    assertThat(webDriver.getTitle(),
        containsString("Mumbai"));
    // webDriver.close();
  }

  @Test
  public void scrollDownFindByLinkText() {
    basePage.scrollDownToTheBottomOfThePage();
    MumbaiLokhandwala48FitnessPage mumbaiLokhandwala48FitnessPage = basePage.clickOn48FitnessLink();
    assertEquals("Swapnil Lal", mumbaiLokhandwala48FitnessPage.getFirstReviewText());
  }

  @Test
  public void firstDropDrown() {
    basePage.getFirstDropDownAndClick();
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

 /*   WebElement searchElement = webDriver.findElement(searchContainer);
    searchElement.findElement(inputLocation).click();
    searchElement.findElement(locationItem).click();
    searchElement.findElement(inputCategory).click();
    searchElement.findElement(categoryItem).click();*/
  }

}
