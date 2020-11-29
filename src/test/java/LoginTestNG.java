import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTestNG {
    WebDriver driver;
    WebDriverWait wait;
    String menuxpath = "(//a[@class='nav-link']/child::*)[6]";

    @BeforeTest
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://52.77.161.168/#/login");
        driver.manage().window().maximize();
    }
    @AfterTest
    public void TearDown(){
        driver.quit();
    }
    @Test
    public void LoginMicrosite() throws InterruptedException {
        driver.findElement(By.xpath("//form/div[1]/input")).sendKeys("adli.lantai3.02@gmail.com");
//        cari element password fields
        driver.findElement(By.id("pass")).sendKeys("P@ssw0rd");
        //click login button
        driver.findElement(By.xpath("//form/button")).click();
        Thread.sleep(10000);
        //bagus code
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@ng-reflect-router-link='/my-profile']")));
//        WebElement element = driver.findElement(By.xpath("//a[@ng-reflect-router-link='/campaign-management']"));
//        Assert.assertFalse(driver.findElement(By.xpath("//a[@ng-reflect-router-link='/campaign-management']")).isDisplayed());
//        List<WebElement> campaignMenu = driver.findElements(By.xpath("//a[@ng-reflect-router-link='/campaign-management']"));
//        Assert.assertFalse(campaignMenu.isEmpty());
//        Assert.assertTrue(driver.findElements(By.xpath("//a[@ng-reflect-router-link='/campaign-management']")).isEmpty());
        //bertie code
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div[4]/b")));
        //actual: form contains Invalid Username or Password
//        String actualAlertMsg = driver.findElement(By.xpath("//form/div[4]/b")).getText();
//        //verify invalid credentials; expected: form must contains Invalid Username or Password
//        String alertMsg = "Invalid Username or Password";
//        Assert.assertEquals(actualAlertMsg, alertMsg);
        Assert.assertTrue(driver.findElements(By.xpath(menuxpath)).isEmpty());

        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println(bodyText);
    }
}
