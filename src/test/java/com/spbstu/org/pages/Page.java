package com.spbstu.org.pages;

import org.openqa.selenium.WebDriver;

/** Abstract class representation of a Page in the UI. Page object pattern */
abstract class Page {

  private final WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   *
   * @param webDriver
   */
  Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }
}
