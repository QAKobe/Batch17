package com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    @FindBy(xpath = "//a[contains(.,'Desktops')]")
    List<WebElement> desktop;

    public void clickOnDesktops() throws InterruptedException {

        for (int i = 0; i < desktop.size(); i++) {

            desktop.get(i).click();
            Thread.sleep(2000);

        }

    }


}
