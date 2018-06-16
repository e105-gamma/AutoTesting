package com.spbstu.org.homework5.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;

public class LoginForm extends Form<UserStruct> {
    @JFindBy(css = "form .btn-login")
    Button loginButton;

    @JFindBy(css = "#Login")
    TextField username;//раньше был текстбокс

    @JFindBy(css = "#Password")
    TextField password;
}
