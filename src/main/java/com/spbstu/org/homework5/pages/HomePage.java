package com.spbstu.org.homework5.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.spbstu.org.homework5.forms.LoginForm;
import com.spbstu.org.homework5.utils.UserStruct;

//import static com.spbstu.org.homework5.pages.HomePage;
//import static com.spbstu.org.homework5.pages.metalsAndColorsPage;


@JPage(url = "/index.htm", title = "Index Page")
public class HomePage extends WebPage {
    private LoginForm loginForm;

    @JFindBy(css = ".uui-navigation a[href='page2.htm']")
    private Button metalsAndColors;

    @JFindBy(css = ".profile-photo")
    private Button LoginFormButton;//it is not profileIcon!

    public void login(UserStruct user) {
        LoginFormButton.click();
        loginForm.loginAs(user);
    }

    public void openMetalsAndColorsPage() {
        metalsAndColors.click();
    }

}
