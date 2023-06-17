package com.qa_fox.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class Base {

    public WebDriver driver;

    @BeforeMethod
    public void StartUp() {

        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("qaFoxURL"));
    }

    @AfterMethod
    public void TearDown(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            BrowserUtils.getScreenShot(driver, "QaFoxFailedTest");
        }

        if (iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver, "passTestCases");
        }

        driver.quit();
    }
}
