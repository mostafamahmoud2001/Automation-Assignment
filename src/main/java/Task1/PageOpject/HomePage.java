package Task1.PageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver ;
    String homePageURL= "https://www.amazon.com/";
    @FindBy(name = "site-search")
    WebElement searchBox;
    @FindBy(id = "nav-search-submit-text")
    WebElement searchButton;
    @FindBy(xpath = "//a[@href=\"/gp/goldbox?ref_=nav_cs_gb\"]")
    WebElement todayDeals;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void openHomePage(){
        driver.get(homePageURL);
    }
    public void search(String item){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))).sendKeys(item);
        searchButton.click();
    }
    public void goTOTodayDeals(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath("//input[@data-action-type=\"DISMISS\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Today's Deals"))).click();
    }

}
