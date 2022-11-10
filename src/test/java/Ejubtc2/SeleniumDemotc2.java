package Ejubtc2;

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

public class SeleniumDemotc2 {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;
    @BeforeTest
    public void open_browser(){
            wait= new WebDriverWait(driver, Duration.ofSeconds(3));
            driver.manage().window().maximize(); }

    @Test (priority = 0)
    public void login(){
        driver.get("https://www.saucedemo.com");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
    }

    @Test (priority = 1)
    public void sauce_labs_backpack() {
        WebElement backpack_item=driver.findElement(By.className("inventory_item_name"));
        backpack_item.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_container")));
        String title=driver.findElement(By.className("inventory_details_name")).getText();
        Assert.assertEquals(title,"Sauce Labs Backpack");
        String description=driver.findElement(By.className("inventory_details_desc")).getText();
        Assert.assertEquals(description,"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        String price=driver.findElement(By.className("inventory_details_price")).getText();
        Assert.assertEquals(price,"$29.99");
        WebElement add_to_cart=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        add_to_cart.click();

    }
    @Test (priority = 2)
    public void back_to_products() {
        WebElement back_to_products= driver.findElement(By.className("left_component"));
        back_to_products.click();
    }

    @Test(priority = 3)
    public void addFleeceJacketToCart(){
        driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    @Test(priority = 4)
    public void openShoppingCartPage(){
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Test(priority = 5)
    public void clickOnCheckout(){
        driver.findElement(By.name("checkout")).click();}



    @Test(priority = 6)
    public void fillInputFields(){
        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement postalCode = driver.findElement(By.name("postalCode"));
        firstName.sendKeys("Firstname");
        lastName.sendKeys("Lastname");
        postalCode.sendKeys("Zipcode");}



    @Test(priority = 7)
    public void clickContinueButton(){
        driver.findElement(By.name("continue")).click();}



    @Test(priority = 8)
    public void clickOnFinish(){
        driver.findElement(By.name("finish")).click();}



    @Test(priority = 9)
    public void checkPageResponse(){
        String title = driver.findElement(By.className("complete-header")).getText();
        assertEquals("THANK YOU FOR YOUR ORDER",title);}



    @Test(priority = 10)
    public void logout(){
        WebElement burgerMenu = driver.findElement(By.className("bm-burger-button"));
        burgerMenu.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();}


    @AfterTest
    public void close_browser(){
        driver.quit();
        }


}
