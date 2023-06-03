package com.mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {

    // Lambda Alerts

    @Test()
    public void TC_05() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(.,'Javascript Alerts')]")).click();

        WebElement jsAlert = driver.findElement(By.xpath("//p[contains(.,'JS Alert')]//following-sibling::button"));
        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        WebElement confirmBtn = driver.findElement(By.xpath("//p[contains(.,'Confirm')]//following-sibling::button"));
        confirmBtn.click();

        System.out.println("alert.getText() = " + alert.getText());
        alert.dismiss();
        Thread.sleep(2000);
        WebElement promptBox = driver.findElement(By.xpath("//p[contains(.,'Prompt')]//following-sibling::button"));
        promptBox.click();

        System.out.println("alert.getText() = " + alert.getText());
        alert.sendKeys("test test");
        alert.accept();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(300, 300).build().perform();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//p[contains(.,'You have entered')]"));
        System.out.println("text = " + text.getText());



    }
}
