package com.spbstu.org.homework3;

import com.codeborne.selenide.Configuration;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Date;

@Listeners(MyTestListenerAdapter.class)
public class HomeWork3 {

    public HomePage homePage;

    @BeforeSuite(description = "init browser")
    public void beforeSuite() {
        Configuration.timeout = 5000;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        //я кстати думаю, а нельзя ли эти классы сделать статическими
    }

    @Test
    public void test1() throws InterruptedException {

        //TODO: open from pom!
        homePage = new HomePage();
        homePage.openPage(System.getProperty("homePage"));


        homePage.testTitle(TestData.WEBSITE_TITLE);
        homePage.login(TestData.LOGIN,TestData.PASSWORD);
        homePage.testUserName(TestData.USERNAME);
        homePage.testIcons(TestData.NUMBER_OF_IMAGES);
        homePage.testBenefitTexts(TestData.BENEFITS_TEXTS);
        homePage.testMainTitle(TestData.MAIN_HEADER);
        homePage.testMainText(TestData.HEADERS);

        homePage.testServiceUp(TestData.SERVICE_TEXTS);
        homePage.testServiceLeft(TestData.SERVICE_TEXTS);
        Thread.sleep(1000);// менюшечка должна открыться, а что то таймаут не срабатывал селинидовский
        DifferentElementsPage diffPage = homePage.goToDiffrentElementsPage();

        diffPage.selectCheckbox(DifferentElementsData.CHECKBOX_1);
        diffPage.selectCheckbox(DifferentElementsData.CHECKBOX_3);

        diffPage.selectRadioButton(DifferentElementsData.RADIOBUTTON_4);

        diffPage.selectDropdown(DifferentElementsData.DROPDOWN_MENU_ELEMENT_4);


        diffPage.testRadioInLog(DifferentElementsData.RADIOBUTTON_4);
        diffPage.testDropdownInLog(DifferentElementsData.DROPDOWN_MENU_ELEMENT_4);
        diffPage.testCheckboxInLog(DifferentElementsData.CHECKBOX_1, Boolean.TRUE);
        diffPage.testCheckboxInLog(DifferentElementsData.CHECKBOX_3, Boolean.TRUE);

        diffPage.unselectCheckbox(DifferentElementsData.CHECKBOX_1);
        diffPage.unselectCheckbox(DifferentElementsData.CHECKBOX_3);

        diffPage.testCheckboxInLog(DifferentElementsData.CHECKBOX_1, Boolean.FALSE);
        diffPage.testCheckboxInLog(DifferentElementsData.CHECKBOX_3, Boolean.FALSE);
    }

    /*
    Test case 2

    Perform login
    Assert User name in the left-top side of screen that user is loggined
    Open Service -> Dates
    Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
    set left - 0, right - 100
    exepected MAX range is set. Check sliders values.
    Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
    set left - 0, right - 0
    expected MIN-left range is set

    Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
    set  left - 100, right - 100
    expected MAX-right range is set
    Using drag-and-drop set Range sliders.
    set left - 30, right - 70
    expected
    Range is set. Check sliders values.
     */

    @Test
    public void test2() throws InterruptedException {
        homePage = new HomePage();
        homePage.openPage(System.getProperty("homePage"));
       // homePage.login(TestData.LOGIN,TestData.PASSWORD);
       // homePage.testUserName(TestData.USERNAME);
        DatesPage datesPage = new DatesPage();
        datesPage = homePage.goToDatesPage();

        datesPage.moveLeftSliderTo(DatesData.MIN_SLIDER_VALUE);
        datesPage.moveRightSliderTo(DatesData.MAX_SLIDER_VALUE);
        datesPage.testSlidersValue(DatesData.MIN_SLIDER_VALUE,DatesData.MAX_SLIDER_VALUE);

        datesPage.moveRightSliderTo(DatesData.MAX_SLIDER_VALUE);
        datesPage.moveLeftSliderTo(DatesData.MAX_SLIDER_VALUE);
        datesPage.testSlidersValue(DatesData.MAX_SLIDER_VALUE,DatesData.MAX_SLIDER_VALUE);

        datesPage.moveLeftSliderTo(DatesData.LEFT_SLIDER_VALUE_FOR_TEST);
        datesPage.moveRightSliderTo(DatesData.RIGHT_SLIDER_VALUE_FOR_TEST);
        datesPage.testSlidersValue(DatesData.LEFT_SLIDER_VALUE_FOR_TEST,DatesData.RIGHT_SLIDER_VALUE_FOR_TEST);
    }


}
