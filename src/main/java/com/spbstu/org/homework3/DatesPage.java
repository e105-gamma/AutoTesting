package com.spbstu.org.homework3;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class DatesPage {

//    @FindBy(css = "(//div[@jdi-type='IRange']/a[@href='#'])[1]")
//    private SelenideElement leftSlider;
//
//    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > form > div:nth-child(4) > div:nth-child(2) > div > a:nth-child(3)")
//    private SelenideElement rightSlider;

    @FindBy(xpath = "(//div[@jdi-type='IRange']/a[@href='#'])[2]")
    public SelenideElement rightSliderButton;

    @FindBy(xpath = "(//div[@jdi-type='IRange']/a[@href='#'])[1]")
    public SelenideElement leftSliderButton;


    public DatesPage() {
        Selenide.page(this);
    }

    public void moveRightSliderTo(int value) {
        //держим
        Selenide.actions().clickAndHold(rightSliderButton).perform();

        //int offset = Integer.parseInt(rightSliderButton.getText());
        //двигаем влево\вправо
        while (value > Integer.valueOf(rightSliderButton.getText())) {
            Selenide.actions().moveByOffset(1, 0).perform();
        }

        while (value < Integer.valueOf(rightSliderButton.getText())){
            Selenide.actions().moveByOffset(-1, 0).perform();
        }
        //отпускаем
        Selenide.actions().release().perform();
    }

    public void moveLeftSliderTo(int value) {
        Selenide.actions().clickAndHold(leftSliderButton).perform();

        //int offset = Integer.parseInt(rightSliderButton.getText());

        while (value > Integer.valueOf(leftSliderButton.getText())) {
            Selenide.actions().moveByOffset(1, 0).perform();
        }

        while (value < Integer.valueOf(leftSliderButton.getText())){
            Selenide.actions().moveByOffset(-1, 0).perform();
        }

        Selenide.actions().release().perform();
    }

    public void testSlidersValue(int expectedleftValue, int expectedRightValue){
        leftSliderButton.shouldHave(text(String.valueOf(expectedleftValue)));
        rightSliderButton.shouldHave(text(String.valueOf(expectedRightValue)));
    }

}
