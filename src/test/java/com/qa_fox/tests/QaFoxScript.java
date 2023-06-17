package com.qa_fox.tests;

import com.qa_fox.pages.CheckOutPage;
import com.qa_fox.pages.MainPage;
import com.qa_fox.pages.ProductListPage;
import com.qa_fox.pages.SingleProductPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class QaFoxScript extends Base {

    @Parameters({"firstName", "lastName", "email", "cell", "company", "address1", "address2", "city", "zipCode", "message"})
    @Test()
    public void TC_01(String firstName, String lastName, String email, String cell, String company, String address1,
                      String address2, String city, String zipCode, String message) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnDesktops();
        Thread.sleep(2000);

        ProductListPage page = new ProductListPage(driver);
        page.chooseHP();
        SingleProductPage productPage = new SingleProductPage(driver);

        productPage.checkOutFunction();

        CheckOutPage outPage = new CheckOutPage(driver);

        outPage.setAllInputFields(firstName, lastName, email,cell, company, address1, address2, city, zipCode, message);

    }

    @Test()
    public void testMethod(){

        driver.get(ConfigReader.readProperty("testURl"));

    }
}
