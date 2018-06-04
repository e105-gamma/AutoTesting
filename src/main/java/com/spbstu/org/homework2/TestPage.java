package com.spbstu.org.homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TestPage {

  public WebDriver driver;

  @FindBy(css = "form .btn-login")
  WebElement loginButton;

  @FindBy(css = "#Login")
  WebElement loginTextBox;

  @FindBy(css = "#Password")
  WebElement passwordTextBox;

  @FindBy(css = ".logout")
  WebElement logoutButton;

  @FindBy(css = ".main-txt")
  WebElement mainText;

  @FindBy(css = ".main-title")
  WebElement mainTitle;

  @FindBy(css = ".icons-benefit")
  List<WebElement> icons;

  @FindBy(css = ".benefit-txt")
  List<WebElement> benefitTexts;

  @FindBy(css = ".profile-photo")
  WebElement profileIcon;

  public TestPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getUsername() {
    return profileIcon.getText();
  }

  public int getIconsNumber() {
    return icons.size();
  }

  // not used
  public String getBenefitText(int i) {
    return benefitTexts.get(i).getText();
  }

  public List<String> getBenefitTexts() {
    List<String> list = new ArrayList<>();
    for (WebElement benefitText : benefitTexts) list.add(benefitText.getText());
    return list;
  }

  public String getMainTitle() {
    return mainTitle.getText();
  }

  public String getMainText() {
    return mainText.getText();
  }

  public String getUrl() {
    return driver.getCurrentUrl();
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void login(String login, String password) {
    profileIcon.click();
    loginTextBox.sendKeys(login);
    passwordTextBox.sendKeys(password);
    loginButton.click();
  }

  public void openPage(String URL) {
    driver.navigate().to(URL);
  }
}
