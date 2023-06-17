package com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SingleProductPage {

    public SingleProductPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[@id='cart']")
    WebElement cartButton;

    @FindBy(xpath = "//a[contains(@href,'route=checkout/checkout')]")
    WebElement checkoutBtn;

    public void checkOutFunction(){

        addToCartBtn.click();

        cartButton.click();

        checkoutBtn.click();
    }






}
