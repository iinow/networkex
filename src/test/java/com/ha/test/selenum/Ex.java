package com.ha.test.selenum;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ex {
    @Before
    public void before(){
        System.setProperty("webdriver.gecko.driver", "D:\\git\\intellij\\networkex\\drivers\\geckodriver.exe");
    }

    @Test
    public void start() throws IOException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://memberssl.auction.co.kr/Authenticate/?url=http%3a%2f%2fwww.auction.co.kr%2f&return_value=0");
        WebElement id = driver.findElement(By.id("id"));
        id.clear();
        id.sendKeys("joonha0323");
        WebElement pw = driver.findElement(By.id("password"));
        pw.clear();
        pw.sendKeys("dlwnsgk2");
        WebElement button = driver.findElement(By.id("Image1"));
        button.submit();

        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://memberssl.auction.co.kr/Authenticate/Popup/PasswrodChange.aspx?uiMode=G&nxt_url=http%3a%2f%2fwww.auction.co.kr%2f%3fredirect%3d1"));

        driver.get("http://itempage3.auction.co.kr/DetailView.aspx?itemno=B671674336");
        driver.findElement(By.linkText("토일공휴일은 발송불가/발송후반송불가")).submit();

        System.out.println(driver.getPageSource());
        driver.quit();

//        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File("D:\\screenshot.png"));
//        Files.write(new Path())
    }
}
