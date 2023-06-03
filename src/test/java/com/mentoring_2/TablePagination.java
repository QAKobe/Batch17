package com.mentoring_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TablePagination {

    @Test()
    public void TC_01() throws InterruptedException {

        // Get each name with email as a key and value
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();
        WebElement dropDown = driver.findElement(By.cssSelector("select[id='maxRows']"));
        BrowserUtils.selectBy(dropDown, "0", "index");
        Thread.sleep(4000);
        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));

        // if we declare TreeMap inside loop it Ascending order won't matter
        TreeMap<String, String> map = new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {

            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));

        }

        System.out.println(map);


    }

    @Test()
    public void TC_02() {

        // Get each name with their phone number as a key - value
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();
        WebElement dropDown = driver.findElement(By.cssSelector("select[id='maxRows']"));
        BrowserUtils.selectBy(dropDown, "5000", "value");
        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allNumbers = driver.findElements(By.xpath("//tr//td[4]"));

        // If TreeMap is declared inside loop ascending order will not work
        TreeMap<String, Long> map = new TreeMap();
        for (int i = 0; i < allNames.size(); i++) {

            map.put(BrowserUtils.getText(allNames.get(i)), Long.valueOf(BrowserUtils.getText(allNumbers.get(i)).replace("-", "")));

        }
        System.out.println(map);

    }





}
