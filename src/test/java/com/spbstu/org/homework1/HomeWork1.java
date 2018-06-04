package com.spbstu.org.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/*
   Данные по тесту читаем из статического класса TestData
   (собственно я делал ее до того, как вы нам рассказали про быструю инициализацию
   enum'ов).
   Не уверен, подгрузиться ли у вас драйвер, но вроде должен.

*/

public class HomeWork1 {




    WebDriver driver;

    @BeforeMethod
    public void testInit() {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testHomePage() {

        // go to URL
        driver.navigate().to(TestData.TARGET_URL);
        // test title
        Assert.assertEquals(TestData.WEBSITE_TITLE, driver.getTitle(), "Title doesn't match.");

        // signing in
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("Login")).sendKeys(TestData.LOGIN);
        driver.findElement(By.id("Password")).sendKeys(TestData.PASSWORD);
        driver.findElement(By.cssSelector("*[class^='uui-button dark-blue btn-login']")).click();

        // test user name
        Assert.assertEquals(
            driver.findElement(By.cssSelector(".profile-photo")).getText(), TestData.USERNAME);

        // test title again
        Assert.assertEquals(TestData.WEBSITE_TITLE, driver.getTitle());

        // test 4 display images
        List<WebElement> imagesList = driver.findElements(By.cssSelector(".icons-benefit"));
        Assert.assertEquals(
            imagesList.size(),
            TestData.NUMBER_OF_IMAGES,
            "The number of images does not match the target.");
        imagesList.forEach(
            imgIterator ->
                Assert.assertEquals(
                    imgIterator.isDisplayed(), true, imgIterator.getAttribute("className")));

        // test 4 texts
        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit-txt"));
        Assert.assertEquals(
            texts.size(),
            TestData.NUMBER_OF_TEXTS,
            String.format(
                "The number of texts does not match the target.",
                texts.size(),
                TestData.NUMBER_OF_TEXTS));
        texts.forEach(
            textIterator ->
                Assert.assertTrue(TestData.BENEFITS_TEXTS.contains(textIterator.getText())));

        // test main header
        WebElement mainHeaderText = driver.findElement(By.cssSelector(".main-title"));
        WebElement headerText = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertTrue(mainHeaderText.isDisplayed(), "Main header text isn\'t displayed.");
        Assert.assertTrue(headerText.isDisplayed(), "Header text isn\'t displayed.");
        Assert.assertEquals(mainHeaderText.getAttribute("innerText"), TestData.MAIN_HEADER);
        Assert.assertEquals(headerText.getAttribute("innerText"), TestData.HEADERS);


    }
}
