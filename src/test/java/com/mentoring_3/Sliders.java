package com.mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Sliders {

    // Single slide
    @Test()
    public void TC_04() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(.,'Drag & Drop Sliders')]")).click();

        WebElement singleSlide = driver.findElement(By.xpath("//input[@value='5']"));
        WebElement singleSlideOutPut = driver.findElement(By.xpath(" //output[@id='range']"));
        System.out.println(singleSlide.getText());
        while (!singleSlideOutPut.getText().equals("99")) {
            singleSlide.sendKeys(Keys.ARROW_RIGHT);
        }

    }



    @Test()
    public void TC_03() throws InterruptedException {

        // This test case will slide all sliders
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(.,'Drag & Drop Sliders')]")).click();

        List<WebElement> allInputs = driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement> allOutPut = driver.findElements(By.cssSelector("output"));

        // This loop slide all the sliders until 85
        for (int i = 0; i < allInputs.size(); i++) {

            while (!allOutPut.get(i).getText().equals("85")) {
                if (allOutPut.get(i).getText().equals("85")) {
                    break;
                } else {
                    allInputs.get(i).sendKeys(Keys.ARROW_RIGHT);
                }
            }

        }


    }

}
