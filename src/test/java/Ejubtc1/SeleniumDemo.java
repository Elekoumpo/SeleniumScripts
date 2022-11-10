package Ejubtc1;

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

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class SeleniumDemo {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;
    @BeforeTest
        public void open_browser(){
        wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();

    }

    @Test (priority = 0)
        public void login(){
        driver.get("https://www.saucedemo.com");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
    }

    @Test (priority = 1)
        public void products(){
        WebElement product = driver.findElement(By.className("header_secondary_container"));
        Assert.assertTrue(product.isDisplayed());
        WebElement shopping_cart=driver.findElement(By.className("shopping_cart_link"));
        Assert.assertTrue(shopping_cart.isDisplayed());
    }
    @Test (priority = 2)
    public void links(){
        WebElement twitter=driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']"));
        Assert.assertTrue(twitter.isDisplayed());
        WebElement facebook=driver.findElement(By.xpath("//a[@href='https://www.facebook.com/saucelabs']"));
        Assert.assertTrue(facebook.isDisplayed());
        WebElement linkedin=driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']"));
        Assert.assertTrue(linkedin.isDisplayed());
    }

    @Test (priority = 3)
    public void burger(){
        WebElement burger_menu= driver.findElement(By.className("bm-burger-button"));
        Assert.assertTrue(burger_menu.isDisplayed());
    }


    @Test (priority = 4)
    public void logout(){
        WebElement burger_menu=driver.findElement(By.className("bm-burger-button"));
        burger_menu.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        WebElement logout_button=driver.findElement(By.id("logout_sidebar_link"));
        logout_button.click();

    }

  @AfterTest
        public void close_browser(){
        driver.quit();
    }
}
