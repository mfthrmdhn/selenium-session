import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Login {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("http://52.77.161.168/#/login");


        //cari element username fields
        driver.findElement(By.xpath("//form/div[1]/input")).sendKeys("adli.lantai3@gmail.com");
//        cari element password fields
        driver.findElement(By.id("pass")).sendKeys("12345678");
        //click login button
        driver.findElement(By.xpath("//form/button")).click();
        //nunggu url page nya jadi url home screen
        wait.until(ExpectedConditions.urlContains("http://52.77.161.168/#/homes"));
        //actualnya, body ada text logout -> logoutText must contain LogOut
        String logoutText = driver.findElement(By.tagName("body")).getText();
        System.out.println(logoutText);
//        assertThat(logoutText, not(containsString("Log Out")));
        assertThat(logoutText, containsString("Log Out"));

    }
}
