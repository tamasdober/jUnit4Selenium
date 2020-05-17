package com.tamasdober.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MumbaiLokhandwala48FitnessPage extends BasePage {

  private final By firstReview = By.cssSelector(
      "#scrolltoratings > div > div.rating-review-block > div.container-info.customer-review-container > div:nth-child(2) > div.align-rating > div > div > div.mui-col-xs-7.customer-name > span.reviewer-name");

  public WebElement findTextForFirstComment() {
    return webDriver.findElement(firstReview);
  }
}
