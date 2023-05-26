package com.lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class InputFields {

    @Test()
    public void TC_01(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(.,'Input Form Submit')]")).click();

        WebElement inputName = driver.findElement(By.cssSelector("input[id='name']"));
        inputName.sendKeys("Kuba");

        // css preceding sibling
        WebElement inputEmail = driver.findElement(By.cssSelector("label~input[name='email']"));
        inputEmail.sendKeys("test@test.com");

        // css preceding sibling
        WebElement passwordField = driver.findElement(By.cssSelector("label~input[name='password']"));
        passwordField.sendKeys("1234567890");

        WebElement companyField = driver.findElement(By.cssSelector("label~input[name='company']"));
        companyField.sendKeys("TestCompany");

        WebElement websiteField = driver.findElement(By.cssSelector("label~input[name='website']"));
        websiteField.sendKeys("www.google.com");

        WebElement cityField = driver.findElement(By.cssSelector("label~input[name='city']"));
        cityField.sendKeys("Chitwon");

        WebElement address1 = driver.findElement(By.cssSelector("#inputAddress1"));
        address1.sendKeys("test st 1");

        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("test st 2");

        WebElement stateField = driver.findElement(By.xpath("//input[@id='inputState']"));
        stateField.sendKeys("IL");

        WebElement zipCodeField = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipCodeField.sendKeys("60656");

        List<WebElement> allButtons = driver.findElements(By.xpath("//button[@type='submit']"));

        for (int i = 0; i < allButtons.size(); i++) {

            if (allButtons.get(i).getText().equalsIgnoreCase("submit")){
                System.out.println(allButtons.get(i).getText());
                allButtons.get(i).click();
            }

        }

        List<WebElement> allMessages = driver.findElements(By.xpath("//p"));

        for (int i = 0; i < allMessages.size(); i++) {

            if (allMessages.get(i).getText().contains("Thanks")){
                System.out.println(allMessages.get(i).getText());
                Assert.assertTrue(allMessages.get(i).isDisplayed());
            }

        }

    }


}
