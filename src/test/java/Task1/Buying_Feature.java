package Task1;

import Task1.PageOpject.HomePage;
import Task1.PageOpject.SearchPage;
import Task1.PageOpject.ShoppingCart;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Buying_Feature {
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    ShoppingCart shoppingCart;
    @BeforeMethod
    public void init(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1024, 768));
        homePage = new HomePage(driver);
        searchPage= new SearchPage(driver);
        shoppingCart=new ShoppingCart(driver);
// Submit solution back to the website
    }
    @Test
    public void happyScenarioTC(){

        homePage.openHomePage();
        homePage.search("car accessories");
        String itemName= searchPage.addFirstItemToCard();
        searchPage.clickOnCartIcon();
        boolean isExist = shoppingCart.checkTheItem(itemName);
        Assert.assertTrue(isExist);
    }
    @AfterMethod
    public void closing(){
        driver.quit();
    }
}
