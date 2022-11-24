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
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //js.executeScript("scroll(0, 250);");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"searchContent\"]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/div[1]/div[1]/h3[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("addToCartBtn")).click();
        Thread.sleep(4000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("btnShowCart")).click();
        Thread.sleep(8000);
        driver.findElement(By.id("btnGoToShippingAddress")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("btnSubmit")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.quit();//btnSubmitLoginüyegirişikontrol

    }}
