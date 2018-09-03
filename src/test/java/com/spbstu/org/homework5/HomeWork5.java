package com.spbstu.org.homework5;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;

import com.spbstu.org.homework5.dataProvider.DataSet;
import com.spbstu.org.homework5.dataProvider.Provider;
import com.spbstu.org.homework5.utils.Users;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.spbstu.org.homework5.epamSite.metalsAndColorsPage;
import static com.spbstu.org.homework5.epamSite.homePage;


public class HomeWork5 extends TestNGBase {

    @BeforeSuite
    public void beforeSuite() {
        //
        driverFactory.setDriverPath("/home/e105-gamma/");
        WebSite.init(epamSite.class);
        driverFactory.getDriver();
        WebSite.open();
        homePage.login(Users.EPAM);
        homePage.openMetalsAndColorsPage();
        metalsAndColorsPage.vegetables.select("Salad");
    }

    @Test(dataProvider = "provider", dataProviderClass = Provider.class)
    public void Test(DataSet testValues) {
        metalsAndColorsPage.setValuesByDataSet(testValues);
        metalsAndColorsPage.testValueByDataSet(testValues);
        metalsAndColorsPage.uncheckValues(testValues);
    }
}
