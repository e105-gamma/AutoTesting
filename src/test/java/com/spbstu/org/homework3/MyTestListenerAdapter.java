package com.spbstu.org.homework3;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MyTestListenerAdapter extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        makeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        makeScreenshot();
    }

    @Attachment(value = "Something goes wrong...", type = "image/png")
    public byte[] makeScreenshot() {
        byte[] array = {1};
        try {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }


}