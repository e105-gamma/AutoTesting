package com.spbstu.org.homework3;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {




    @FindBy(css = ".profile-photo")
    SelenideElement profilePhoto;

    @FindBy(css = "form .btn-login")
    SelenideElement loginButton;

    @FindBy(css = "#Login")
    SelenideElement loginTextBox;

    @FindBy(css = "#Password")
    SelenideElement passwordTextBox;

    @FindBy(css = ".logout")
    SelenideElement logoutButton;

    @FindBy(css = ".main-txt")
    SelenideElement mainText;

    @FindBy(css = ".main-title")
    SelenideElement mainTitle;

    @FindBy(css = ".icons-benefit")
    ElementsCollection icons;

    @FindBy(css = ".benefit-txt")
    ElementsCollection benefitTexts;

    @FindBy(css = ".profile-photo")
    SelenideElement userName;//it is not profileIcon!

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement serviceUp;

    //@FindBy(css = ".sub-menu")
    @FindBy(css = ".sub-menu a[href='page1.htm']")
    private SelenideElement serviceLeft;

    @FindBy(css = "ul.dropdown-menu")
    private SelenideElement menuServiceUp;

    @FindBy(css = "ul.sub")
    private SelenideElement menuServiceLeft;

    //Я ЗАБЫЛ ЧТО ЭТО НАДО СДЕЛАТЬ И ИСКАЛ БАГ ЦЕЛЫЙ ЧАС
    HomePage(){
        Selenide.page(this);
    }

    @Step("Open page")
    public void openPage(String Url) {

        Selenide.open(Url);
    }

    @Step("Login")
    public void login(String login, String password) {
        userName.click();
        loginTextBox.setValue(login);
        passwordTextBox.setValue(password);
        loginButton.click();

    }

    @Step("Test username")
    public void testUserName(String username){
        userName.shouldBe(visible);
        userName.shouldHave(text(username));
    }

    @Step("Test benefit texts")
    public void testBenefitTexts(List<String> texts) {
        benefitTexts.shouldHaveSize(texts.size());
        for(int i=0;i<texts.size();++i){
            benefitTexts.get(i).shouldBe(visible);
            benefitTexts.get(i).shouldBe(text(texts.get(i)));
        }
    }

    @Step("Test icons")
    public void testIcons(int numberOfIcons){
        icons.shouldHaveSize(numberOfIcons);
        for(int i=0;i<numberOfIcons;i++){
            icons.get(i).shouldBe(visible);
        }
    }

    @Step("Test main title")
    public  void testMainTitle(String MainTitleToTest) {
        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text(MainTitleToTest));
    }

    @Step("Test main text")
    public void testMainText(String MainTextToTest) {
        mainText.shouldBe(visible);
        mainText.shouldHave(text(MainTextToTest));
    }

    @Step("Test up service menu")
    public void testServiceUp(List<String> serviceMenuTexts){
        serviceUp.click();
        for(int i=0;i<serviceMenuTexts.size();++i){
            menuServiceUp.shouldHave(text(serviceMenuTexts.get(i)));
        }
        serviceUp.click();
    }


    @Step("Test left service menu")
    public void testServiceLeft(List<String> serviceMenuTexts){
        serviceLeft.click();
        for(int i=0;i<serviceMenuTexts.size();++i){
            menuServiceLeft.shouldHave(text(serviceMenuTexts.get(i)));
        }
        serviceLeft.click();
    }

    @Step("Test title")
    public void testTitle(String title) {
        Assert.assertEquals(Selenide.title(),title);
    }

    @Step("Go to different elements page")
    public DifferentElementsPage goToDiffrentElementsPage() throws InterruptedException {
        serviceLeft.click();
        //я решил не выносить одну эту кнопку в мембер класса
        $( "#mCSB_1_container > ul > li.sub-menu > ul > li:nth-child(6) > a > p > span").click();
        return new DifferentElementsPage();
    }

    @Step("Go to dates page")
    public DatesPage goToDatesPage() throws InterruptedException {
        serviceLeft.click();
        Thread.sleep(1000);// менюшечка должна открыться, а что то таймаут не срабатывал селинидовский
        // я решил не выносить одну эту кнопку в мембер класса
        //$(".dropdown-menu | [href=\\\"page4.htm\\\"]").click();
        $("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(2) > a > p > span").click();
        return new DatesPage();
    }






}
