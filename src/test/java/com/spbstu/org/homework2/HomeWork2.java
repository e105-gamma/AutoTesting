package com.spbstu.org.homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork2 {

    WebDriver driver;
    public static TestPage testPage;

    @BeforeMethod
    public void init() {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        testPage = PageFactory.initElements(driver, TestPage.class);
  }



    @Test
    public void testHomePage() {

        // go to URL
        testPage.openPage(TestData.TARGET_URL);

        // test title
        Assert.assertEquals(TestData.WEBSITE_TITLE, testPage.getTitle(), "Title doesn't match.");

        // login in
        testPage.login(TestData.LOGIN, TestData.PASSWORD);

        // test user name
        Assert.assertEquals(testPage.getUsername(), TestData.USERNAME);

        // test title again
        Assert.assertEquals(testPage.getTitle(), TestData.WEBSITE_TITLE);


        // test 4 display images
        Assert.assertEquals(
            testPage.getIconsNumber(),
            TestData.NUMBER_OF_IMAGES,
            "The number of images does not match the target.");

        // test 4 texts
        List<String> benefitsList = testPage.getBenefitTexts();

        Assert.assertEquals(
            benefitsList.size(),
            TestData.NUMBER_OF_TEXTS,
            String.format(
                "The number of texts does not match the target.",
                benefitsList.size(),
                TestData.NUMBER_OF_TEXTS));
        benefitsList.forEach(
            textIterator ->
                Assert.assertTrue(TestData.BENEFITS_TEXTS.contains(textIterator.toString())));

        // test main header
        Assert.assertEquals(testPage.getMainTitle(), TestData.MAIN_HEADER);
        Assert.assertEquals(testPage.getMainText(), TestData.HEADERS);
    }
}
