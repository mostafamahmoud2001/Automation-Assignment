package Task1.PageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    WebDriver driver ;
    String addedItem;
    @FindBy(xpath = "//button[text()=\"Add to cart\"]/parent::span/parent::span/parent::div/parent::span/parent::div/parent::div/parent::div/parent::div/parent::div")
    List<WebElement> items;
    By cartButton = By.xpath("//a[@href=\"/gp/cart/view.html?ref_=nav_cart\"]");
    public SearchPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String addFirstItemToCard(){
        String addedItem = items.get(0).findElement(By.xpath(".//div[@data-cy=\"title-recipe\"]/h2")).getText();
        WebElement addToCartButton = items.get(0).findElement(By.xpath(".//button[text()='Add to cart']"));
        addToCartButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return addedItem;
    }
    public void clickOnCartIcon(){
        driver.findElement(cartButton).click();
    }

}
