package com.spbstu.org.homework5;

import com.spbstu.org.homework5.pages.HomePage;
import com.spbstu.org.homework5.pages.MetalsAndColorsPage;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
//System.getProperty("homePage") не получилось, нужна константа


@JSite("https://jdi-framework.github.io/tests/")
public class epamSite extends WebSite {
    static HomePage homePage;
    static MetalsAndColorsPage metalsAndColorsPage;
}