package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestOtomation {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public String baseURL;

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        baseURL = "https://www.e-bebek.com/";
    }



@Test
    public void OtomationTest() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(3000);
        WebElement searchButton = driver.findElement(By.tagName("input"));
        searchButton.sendKeys("Kaşık maması");
        Thread.sleep(10000);
        searchButton.sendKeys(Keys.RETURN);
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js.executeScript("scroll(0, 1250);");
        Thread.sleep(10000);
        js.executeScript("scroll(1250, 2500);");
        Thread.sleep(10000);
        js.executeScript("scroll(2500, 3750);");
        Thread.sleep(10000);
        js.executeScript("scroll(3750, 5000);");
        Thread.sleep(10000);
        js.executeScript("scroll(5000, 5500);");
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElements(By.id("addToCartBtn")).get(42).click();
        Thread.sleep(10000);
        driver.findElement(By.id("btnShowCart")).click();
        String control= driver.getTitle();
        Assert.assertEquals(control,"Ara Kaşık maması - ebebek");
        Thread.sleep(8000);
        driver.findElement(By.id("btnGoToShippingAddress")).click();
        Thread.sleep(20000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String end= driver.getTitle();
        Assert.assertEquals(end,"Giriş Yap");
        Thread.sleep(5000);
        driver.quit();

    }}
