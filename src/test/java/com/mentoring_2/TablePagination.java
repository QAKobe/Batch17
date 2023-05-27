package com.mentoring_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
        Thread.sleep(4000);
        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));


        for (int i = 0; i < allNames.size(); i++) {
            TreeMap<String, String> map = new TreeMap<>();
            map.put(allNames.get(i).getText(), allEmails.get(i).getText());
            System.out.println(map);
        }


    }

    @Test()
    public void TC_02() {
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


        for (int i = 0; i < allNames.size(); i++) {
            TreeMap<String, Long> treeMap = new TreeMap<>();
            treeMap.put(allNames.get(i).getText(), Long.valueOf(allNumbers.get(i).getText().replace("-", "").trim()));

            System.out.println(treeMap);

        }


    }

}
