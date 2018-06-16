package com.spbstu.org.homework3;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtons;

    @FindBy(css = "div.colors select")
    private SelenideElement colorMenu;

    @FindBy(id = "#mCSB_1")
    private SelenideElement leftSection;

    @FindBy(id = "#mCSB_2")
    private SelenideElement rightSection;


    @FindBy(css = "button[name='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "input[value='Button']")
    private SelenideElement button;

    @FindBy(css = "ul.panel-body-list.logs")
    private SelenideElement log;

    public DifferentElementsPage() {
        Selenide.page(this);
    }


    @Step("Test checkboxes and radiobuttons")
    public void testElements(int numberOfCheckboxes, int numberOfRadiobuttons) {
        leftSection.shouldBe(visible);
        rightSection.shouldBe(visible);
        checkboxes.shouldHaveSize(numberOfCheckboxes);

        for (SelenideElement checkbox : checkboxes)
            checkbox.shouldBe(visible);

        for (SelenideElement radio : radioButtons)
            radio.shouldBe(visible);
        radioButtons.shouldHaveSize(numberOfRadiobuttons);

        colorMenu.shouldBe(visible);

        button.shouldBe(visible);
        defaultButton.shouldBe(visible);
    }

    @Step("Select checkboxes")
    public void selectCheckbox(String checkboxName) {
        checkboxes.find(text(checkboxName)).$("[type=checkbox]").setSelected(true);
        checkboxes.find(text(checkboxName)).$("[type=checkbox]").shouldBe(checked);
    }

    @Step("Select dropdown menu element")
    public void selectDropdown(String dropownName) {
        colorMenu.selectOption(dropownName);
    }

    @Step("Unselect checkbox")
    public void unselectCheckbox(String checkboxName) {
        checkboxes.find(text(checkboxName)).$("[type=checkbox]").setSelected(false);
        checkboxes.find(text(checkboxName)).$("[type=checkbox]").shouldNotBe(checked);
    }

    @Step("Select radiobutton")
    public void selectRadioButton(String radioButtonName) {
        radioButtons.find(text(radioButtonName)).$("[type=radio]").setSelected(true);
        radioButtons.find(text(radioButtonName)).$("[type=radio]").shouldBe(selected);
    }

    @Step("Test checkbox in log")
    public void testCheckboxInLog(String conditionValue, Boolean status) {
        log.shouldHave(text(String.format("%s: condition changed to %s",conditionValue,status.toString())));
    }

    @Step("Test radiobutton in log")
    public void testRadioInLog(String metalValue) {
        log.shouldHave(text(String.format("metal: value changed to %s", metalValue)));
    }

    @Step("Test dropdown select in log")
    public void testDropdownInLog(String colorValue) {
        log.shouldHave(text(String.format("Colors: value changed to %s", colorValue)));
    }
}