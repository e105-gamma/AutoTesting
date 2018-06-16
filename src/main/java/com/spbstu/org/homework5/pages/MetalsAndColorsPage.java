package com.spbstu.org.homework5.pages;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.web.matcher.testng.Assert;
import com.spbstu.org.homework5.dataProvider.DataSet;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page2.htm", title = "Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @JFindBy(css = ".radio")
    RadioButtons radioButtons;

    @JFindBy(css = "#submit-button")
    Button submitButton;

    @JFindBy(css = ".panel-body-list.results li")
    TextList log;


    //я думал везде надо JFindBy!
    @JComboBox(root = @FindBy(css = "#salad-dropdown"),
        expand = @FindBy(css = ".caret"),
        list = @FindBy(css = "li"),
        value = @FindBy(css = "button"))
    public ComboBox vegetables;

    @JComboBox(root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = "input[type='text']"))
    ComboBox metalsDropdown;

    //todo: чето дроплисты только так заработали

    @JFindBy(css = "#elements-checklist .checkbox label")
    CheckList elementsCheckList;

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"))
    Dropdown colorsDropdown;

    public void testValueByDataSet(DataSet dataSet){
        Assert.assertContains(log.getValue(),"Color: " + dataSet.getColor());
        Assert.assertContains(log.getValue(), "Metal: " + dataSet.getMetal());

        StringBuilder elementsString = new StringBuilder("Elements: ");
        for (String element : dataSet.getElements())
            elementsString.append(element).append(", ");
        elementsString = new StringBuilder(elementsString.substring(0, elementsString.length() - 2));
        Assert.assertContains(log.getValue(), elementsString.toString());

        StringBuilder vegetablesString = new StringBuilder("Vegetables: ");
        for (String vegetable : dataSet.getVegetables())
            vegetablesString.append(vegetable).append(", ");
        vegetablesString = new StringBuilder(vegetablesString.substring(0, vegetablesString.length() - 2));
        Assert.assertContains(log.getValue(), vegetablesString.toString());

        Assert.assertContains(log.getValue(), "Summary: " + String.valueOf(dataSet.getSummary()[0] + dataSet.getSummary()[1]));

    }

    public void setValuesByDataSet(DataSet dataSet){
        metalsDropdown.select(dataSet.getMetal());
        colorsDropdown.select(dataSet.getColor());
        elementsCheckList.select(dataSet.getElements());
        radioButtons.select(String.valueOf(dataSet.getSummary()[0]));
        radioButtons.select(String.valueOf(dataSet.getSummary()[1]));
        for (String vegetable : dataSet.getVegetables()) {
            vegetables.select(vegetable);
        }
        submitButton.click();
    }

  public void uncheckValues(DataSet dataSet) {

        for (String vegetables_ : dataSet.getVegetables()) {
          vegetables.select(vegetables_);
        }

        elementsCheckList.select(dataSet.getElements());
    }

    }
