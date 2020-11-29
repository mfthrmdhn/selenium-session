import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginCMS {
    WebDriver driver;
    WebDriverWait wait;
    File file = new File("data/image/aingmart.jpg");


    @BeforeTest
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://52.77.161.168:8081/dist/velo-cms/#/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginCMS(){
        driver.findElement(By.xpath("//input[@formcontrolname='userId']")).sendKeys("adli.lantai3.10@gmail.com");
        driver.findElement(By.xpath("//input[@formcontrolname='pass']")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test
    public void createNewUser() throws InterruptedException {
        loginCMS();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#/recruiters']")));
        driver.findElement(By.xpath("//a[@href='#/recruiters']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Create User')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Create User')]")).click();
        wait.until(ExpectedConditions.urlContains("/recruiters/add"));
        driver.findElement(By.id("upload-file-all")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath("//div/mat-select[@formcontrolname='roleCode']")).click();
        List<WebElement> myElements = driver.findElements(By.xpath("//span[@class='mat-option-text']"));
        myElements.get(1).click();
        Thread.sleep(10000);

    }
}
