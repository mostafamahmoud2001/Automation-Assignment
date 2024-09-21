package Task1;

import Task1.PageOpject.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TodayDeals_Feature {
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    ShoppingCart shoppingCart;
    TodayDeals todayDeals;
    ItemPage itemPage;
    @BeforeMethod
    public void init(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1024, 768));
        homePage = new HomePage(driver);
        searchPage= new SearchPage(driver);
        shoppingCart=new ShoppingCart(driver);
        todayDeals = new TodayDeals(driver);
        itemPage=new ItemPage(driver);
    }
    @Test
    public void happyScenarioTC(){
        homePage.openHomePage();
        homePage.goTOTodayDeals();
        todayDeals.getTheItems();
        todayDeals.selectItem(4);
        itemPage.addToCart();
        String message = itemPage.getMessageAfterAdding();
        boolean assertBoolean= false;
        if(message.contains("Added to Cart"))
            assertBoolean = true;
        Assert.assertTrue(assertBoolean);
    }
    @AfterMethod
    public void closing(){

        //driver.quit();
    }
}
