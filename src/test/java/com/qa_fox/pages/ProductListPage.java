package com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.BrowserUtils;

public class ProductListPage {

    public ProductListPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortDropDown;

    @FindBy(xpath = "//p[contains(.,'Stop')]//..//following-sibling::div")
    WebElement addLaptopHP;



    public void chooseHP(){

        BrowserUtils.selectBy(sortDropDown, "Price (Low > High)", "text");
        addLaptopHP.click();
    }

}
